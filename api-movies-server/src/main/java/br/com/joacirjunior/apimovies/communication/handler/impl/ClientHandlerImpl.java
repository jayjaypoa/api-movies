package br.com.joacirjunior.apimovies.communication.handler.impl;

import br.com.joacirjunior.apimovies.communication.handler.ClientHandler;
import br.com.joacirjunior.apimovies.communication.parser.ClientParser;
import br.com.joacirjunior.apimovies.dto.ApiMoviesRequest;
import br.com.joacirjunior.apimovies.dto.ApiMoviesResponse;
import br.com.joacirjunior.apimovies.enumeration.EnumApiMoviesException;
import br.com.joacirjunior.apimovies.exception.ApiMoviesException;
import br.com.joacirjunior.apimovies.external.imdb.communication.ImdbCommunication;
import br.com.joacirjunior.apimovies.external.imdb.model.ImdbResponse;
import br.com.joacirjunior.apimovies.logger.ApiMoviesConsoleLog;
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

    private ApiMoviesConsoleLog logger;
    private ClientParser clientParser;
    private ImdbCommunication imdbCommunication;
    private Socket clientSocket;

    @Inject
    public ClientHandlerImpl(ApiMoviesConsoleLog logger,
                             ClientParser clientParser,
                             ImdbCommunication imdbCommunication,
                             Socket clientSocket) {
        this.logger = logger;
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
        BufferedReader input = null;
        PrintWriter output = null;
        try {
            output = new PrintWriter(clientSocket.getOutputStream(), true);
            input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            this.proccessWhileReceiveMessage(input, output);
        } catch (IOException e) {
            logger.error(e.getMessage());
        } finally {
            try {
                if (output != null)
                    output.close();
                if (input != null)
                    input.close();
                clientSocket.close();
            } catch (IOException e) {
                logger.error(e.getMessage());
            }
        }

    }


    /**
     * Execute the proccess
     *
     * */
    private void proccessWhileReceiveMessage(BufferedReader input, PrintWriter output) throws IOException {
        String content = "";
        while ((content = input.readLine()) != null) {
            logger.info("Sent from the client " + clientSocket.getInetAddress().getHostAddress() + " : " + content);
            try {
                // validating input data
                InputCommunicationValidate.inputValidate(content);
                // identify query from input data
                Optional<ApiMoviesRequest> optRequest = this.identifyRequest(content);
                // call to the partner
                Optional<ImdbResponse> optResponse = this.requestExternalPartner(optRequest);
                // convert to response object format
                content = this.parseExternalPartnerRespone(optResponse);
                // validating output data
                OutputCommunicationValidate.outputValidate(content);
            } catch (ApiMoviesException ex){
                // create error output
                content = ex.getMessage().length() + String.valueOf(ApiMoviesConfig.getSeparator()) + ex.getMessage();
            }
            logger.info("Sending response to " + clientSocket.getInetAddress().getHostAddress() + " : " + content);
            output.println(content);
        }
    }

    /**
     * Identify query from input data
     *
     * */
    private Optional<ApiMoviesRequest> identifyRequest(String content) throws ApiMoviesException {
        Optional<ApiMoviesRequest> optRequest = clientParser.createRequest(Optional.ofNullable(content));
        if(optRequest.isEmpty()){
            logger.error(EnumApiMoviesException.PARTNER_CALL_ERROR, "IS EMPTY");
            throw new ApiMoviesException(EnumApiMoviesException.PARTNER_CALL_ERROR);
        }
        logger.info("Query : " + optRequest.get().toString());
        return optRequest;
    }

    /**
     * Request to external partner (Imdb).
     *
     * */
    private Optional<ImdbResponse> requestExternalPartner(Optional<ApiMoviesRequest> optRequest) throws ApiMoviesException {
        Optional<ImdbResponse> optResponse = imdbCommunication.searchByMovieTitle(optRequest.get().getContent());
        if(optResponse.isEmpty()){
            logger.error(EnumApiMoviesException.PARTNER_MOVIE_NOT_FOUND, "MOVIE NOT FOUND");
            throw new ApiMoviesException(EnumApiMoviesException.PARTNER_MOVIE_NOT_FOUND);
        }
        logger.info("External partner response : " + optResponse.get().toString());
        return optResponse;
    }

    /**
     * Parse the response from external partner (Imdb).
     *
     * */
    private String parseExternalPartnerRespone(Optional<ImdbResponse> optResponse) throws ApiMoviesException {
        Optional<ApiMoviesResponse> optApiMoviesResponse = clientParser.createResponse(optResponse);
        if(optApiMoviesResponse.isEmpty()){
            logger.error(EnumApiMoviesException.PARTNER_CALL_ERROR, "IS EMPTY");
            throw new ApiMoviesException(EnumApiMoviesException.PARTNER_CALL_ERROR);
        }
        logger.info("Response object : " + optApiMoviesResponse.get().toString());
        // create output content
        return optApiMoviesResponse.get().getLength()
                + String.valueOf(ApiMoviesConfig.getSeparator())
                + optApiMoviesResponse.get().getContent();
    }

}
