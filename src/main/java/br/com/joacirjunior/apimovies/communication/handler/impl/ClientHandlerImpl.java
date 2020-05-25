package br.com.joacirjunior.apimovies.communication.handler.impl;

import br.com.joacirjunior.apimovies.communication.handler.ClientHandler;
import br.com.joacirjunior.apimovies.communication.parser.impl.ClientParserImpl;
import br.com.joacirjunior.apimovies.dto.ApiMoviesRequest;
import br.com.joacirjunior.apimovies.dto.ApiMoviesResponse;
import br.com.joacirjunior.apimovies.enumeration.EnumApiMoviesException;
import br.com.joacirjunior.apimovies.exception.ApiMoviesException;
import br.com.joacirjunior.apimovies.external.imdb.communication.impl.ImdbCommunicationImpl;
import br.com.joacirjunior.apimovies.external.imdb.dto.ImdbResponse;
import br.com.joacirjunior.apimovies.util.ApiMoviesConfig;
import br.com.joacirjunior.apimovies.validation.InputCommunicationValidate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Optional;

public class ClientHandlerImpl implements ClientHandler {

    private Socket clientSocket;

    public ClientHandlerImpl(Socket clientSocket) {
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
                System.out.printf("Sent from the client: %s\n", content);
                try {
                    // validating input data
                    InputCommunicationValidate.inputValidate(content);
                    // identify query from input data
                    Optional<ApiMoviesRequest> optRequest =
                            new ClientParserImpl().createRequest(Optional.ofNullable(content));
                    if(optRequest.isEmpty()){
                        throw new ApiMoviesException(EnumApiMoviesException.PARTNER_CALL_ERROR);
                    }
                    System.out.println("Query : " + optRequest.get().toString());
                    // request to external partner
                    Optional<ImdbResponse> optResponse =
                            new ImdbCommunicationImpl().searchMovie(optRequest.get().getContent());
                    if(optResponse.isEmpty()){
                        throw new ApiMoviesException(EnumApiMoviesException.PARTNER_CALL_ERROR);
                    }
                    System.out.println("ImdbResponse : " + optResponse.get().toString());
                    // parse the response from external partner
                    Optional<ApiMoviesResponse> optApiMoviesResponse =
                            new ClientParserImpl().createResponse(optResponse);
                    if(optApiMoviesResponse.isEmpty()){
                        throw new ApiMoviesException(EnumApiMoviesException.PARTNER_CALL_ERROR);
                    }
                    System.out.println("Response object : " + optApiMoviesResponse.get().toString());
                    // create output content
                    content = optApiMoviesResponse.get().getLength()
                            + String.valueOf(ApiMoviesConfig.getSeparator())
                            + optApiMoviesResponse.get().getContent();
                } catch (ApiMoviesException ex){
                    // create error output
                    content = ex.getMessage().trim().length()
                            + String.valueOf(ApiMoviesConfig.getSeparator()) + ex.getMessage().trim();
                }
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
