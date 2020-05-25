package br.com.joacirjunior.apimovies.communication.handler.impl;

import br.com.joacirjunior.apimovies.communication.handler.ClientHandler;
import br.com.joacirjunior.apimovies.communication.parser.ClientParser;
import br.com.joacirjunior.apimovies.dto.ApiMoviesRequest;
import br.com.joacirjunior.apimovies.dto.ApiMoviesResponse;
import br.com.joacirjunior.apimovies.enumeration.EnumApiMoviesException;
import br.com.joacirjunior.apimovies.exception.ApiMoviesException;
import br.com.joacirjunior.apimovies.external.imdb.communication.ImdbCommunication;
import br.com.joacirjunior.apimovies.external.imdb.dto.ImdbResponse;
import br.com.joacirjunior.apimovies.util.ApiMoviesConfig;
import br.com.joacirjunior.apimovies.validation.InputCommunicationValidate;
import br.com.joacirjunior.apimovies.validation.OutputCommunicationValidate;
import com.google.inject.Inject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Optional;

public class ClientHandlerImpl implements ClientHandler {

    private ClientParser clientParser;
    private ImdbCommunication imdbCommunication;
    private Socket clientSocket;

    @Inject
    public ClientHandlerImpl(ClientParser clientParser,
                             ImdbCommunication imdbCommunication,
                             Socket clientSocket) {
        this.clientParser = clientParser;
        this.imdbCommunication = imdbCommunication;
        this.clientSocket = clientSocket;
    }

    @Inject
    public void setClientSocket(Socket clientSocket){
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {

        String content = "";
        PrintWriter output = null;
        BufferedReader input = null;

        try {

            output = new PrintWriter(clientSocket.getOutputStream(), true);
            input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            // while receive message
            while ((content = input.readLine()) != null) {
                System.out.printf("Sent from the client %s : %s\n",
                        clientSocket.getInetAddress().getHostAddress(), content);
                try {
                    // validating input data
                    InputCommunicationValidate.inputValidate(content);
                    // identify query from input data
                    Optional<ApiMoviesRequest> optRequest = clientParser.createRequest(Optional.ofNullable(content));
                    if(optRequest.isEmpty()){
                        throw new ApiMoviesException(EnumApiMoviesException.PARTNER_CALL_ERROR);
                    }
                    System.out.println("Query : " + optRequest.get().toString());
                    // request to external partner
                    Optional<ImdbResponse> optResponse = imdbCommunication.searchMovie(optRequest.get().getContent());
                    if(optResponse.isEmpty()){
                        throw new ApiMoviesException(EnumApiMoviesException.PARTNER_CALL_ERROR);
                    }
                    System.out.println("ImdbResponse : " + optResponse.get().toString());
                    // parse the response from external partner
                    Optional<ApiMoviesResponse> optApiMoviesResponse = clientParser.createResponse(optResponse);
                    if(optApiMoviesResponse.isEmpty()){
                        throw new ApiMoviesException(EnumApiMoviesException.PARTNER_CALL_ERROR);
                    }
                    System.out.println("Response object : " + optApiMoviesResponse.get().toString());
                    // create output content
                    content = optApiMoviesResponse.get().getLength()
                            + String.valueOf(ApiMoviesConfig.getSeparator())
                            + optApiMoviesResponse.get().getContent();
                    // validating output data
                    OutputCommunicationValidate.outputValidate(content);
                } catch (ApiMoviesException ex){
                    // create error output
                    content = ex.getMessage().trim().length()
                            + String.valueOf(ApiMoviesConfig.getSeparator())
                            + ex.getMessage().trim();
                }
                System.out.printf("Sending to %s : %s\n", clientSocket.getInetAddress().getHostAddress(), content);
                // send response for client
                output.println(content);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (output != null)
                    output.close();
                if (input != null)
                    input.close();
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
