package br.com.joacirjunior.apimovies.communication.handler.impl;

import br.com.joacirjunior.apimovies.communication.handler.ClientHandler;
import br.com.joacirjunior.apimovies.communication.parser.ClientParser;
import br.com.joacirjunior.apimovies.dto.ApiMoviesRequest;
import br.com.joacirjunior.apimovies.dto.ApiMoviesResponse;
import br.com.joacirjunior.apimovies.enumeration.EnumApiMoviesException;
import br.com.joacirjunior.apimovies.exception.ApiMoviesException;
import br.com.joacirjunior.apimovies.external.imdb.communication.ImdbCommunication;
import br.com.joacirjunior.apimovies.external.imdb.model.ImdbResponse;
import br.com.joacirjunior.apimovies.logger.ApiMoviesCustomLog;
import br.com.joacirjunior.apimovies.util.ApiMoviesConfig;
import br.com.joacirjunior.apimovies.validation.InputCommunicationValidate;
import br.com.joacirjunior.apimovies.validation.OutputCommunicationValidate;
import com.google.inject.Inject;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;
import java.util.Optional;

public class ClientHandlerImpl implements ClientHandler {

    private final ClientParser clientParser;
    private final ImdbCommunication imdbCommunication;
    private final ApiMoviesCustomLog logger;

    @Inject
    public ClientHandlerImpl(ClientParser clientParser,
                             ImdbCommunication imdbCommunication,
                             ApiMoviesCustomLog logger) {
        this.clientParser = clientParser;
        this.imdbCommunication = imdbCommunication;
        this.logger = logger;
    }

    /**
     * Validate the query input, invoke the partner and send the response for the client.
     *
     * */
    public void processAndReply(Socket connection, BufferedReader input,
                                 BufferedOutputStream output) throws IOException {
        String content = "";
        while ((content = input.readLine()) != null) {
            logger.info("Sent from the client " + connection.getInetAddress().getHostAddress() + " : '" + content + "'");
            try {
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
                    // wait
                    // Thread.sleep(3000);
                } catch (ApiMoviesException ex) {
                    logger.error("The content response will be a error message");
                    content = ex.getMessage().length() + String.valueOf(ApiMoviesConfig.getSeparator()) + ex.getMessage();
                }
            } catch (Exception ex) {
                logger.error(EnumApiMoviesException.FATAL_ERROR, ex.getMessage());
            }
            // send the content to client
            logger.info("Sending response to " + connection.getInetAddress().getHostAddress() + " : " + content);
            output.write((content + (char) 13 + (char) 10).getBytes());
            output.flush();
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
        return optApiMoviesResponse.get().getLength()
                + String.valueOf(ApiMoviesConfig.getSeparator())
                + optApiMoviesResponse.get().getContent();
    }

}
