package br.com.joacirjunior.apimovies.communication.impl;

import br.com.joacirjunior.apimovies.communication.ApiMoviesServer;
import br.com.joacirjunior.apimovies.communication.handler.ClientHandler;
import br.com.joacirjunior.apimovies.communication.handler.impl.ClientHandlerImpl;
import br.com.joacirjunior.apimovies.communication.parser.impl.ClientParserImpl;
import br.com.joacirjunior.apimovies.enumeration.EnumApiMoviesException;
import br.com.joacirjunior.apimovies.exception.ApiMoviesException;
import br.com.joacirjunior.apimovies.external.imdb.communication.impl.ImdbCommunicationImpl;
import br.com.joacirjunior.apimovies.external.imdb.parser.impl.ImdbParserImpl;
import br.com.joacirjunior.apimovies.logger.ApiMoviesCustomLog;
import br.com.joacirjunior.apimovies.util.ApiMoviesConfig;
import com.google.inject.Inject;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;


public class ApiMoviesServerImpl implements ApiMoviesServer {

    private Socket connection;
    private ApiMoviesCustomLog logger;

    @Inject
    public ApiMoviesServerImpl(ApiMoviesCustomLog logger){
        this.logger = logger;
    }

    @Inject
    public ApiMoviesServerImpl(Socket connection,
                               ApiMoviesCustomLog logger){
        this.connection = connection;
        this.logger = logger;
    }

    @Override
    public void execute() throws ApiMoviesException {
        logger.info("Executing...");
        try {
            int count = 0;
            ServerSocket serverSocket = this.getServerSocketAlreadyConfigurated();
            while (true) {
                Socket connection = serverSocket.accept();
                logger.info("New client connected - Client IP : " + connection.getInetAddress().getHostAddress());
                Runnable runnable = new ApiMoviesServerImpl(connection, logger);
                Thread thread = new Thread(runnable);
                thread.start();
            }
        } catch (Exception ex) {
            logger.error(EnumApiMoviesException.FATAL_ERROR, "FATAL ERRROR : " + ex.getMessage());
            throw new ApiMoviesException(EnumApiMoviesException.FATAL_ERROR);
        }
    }

    @Override
    public void run() {
        BufferedReader input = null;
        BufferedOutputStream output = null;
        try {
            input = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            output = new BufferedOutputStream(connection.getOutputStream());
            ClientHandler handler = new ClientHandlerImpl(
                                            new ClientParserImpl(),
                                            new ImdbCommunicationImpl(logger, new ImdbParserImpl(logger)),
                                            logger);
            handler.processAndReply(connection, input, output);
        } catch (IOException e) {
            e.printStackTrace();
            logger.error(EnumApiMoviesException.SERVER_RUN_IO_ERROR, e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (IOException e) {
                e.printStackTrace();
                logger.error(EnumApiMoviesException.SERVER_RUN_IO_ERROR,
                        "ON CLOSING : " + e.getMessage());
            }
        }
    }

    /**
     * Get the server socket already configurated
     *
     * */
    private ServerSocket getServerSocketAlreadyConfigurated() throws ApiMoviesException {
        try {
            ServerSocket serverSocket = new ServerSocket(ApiMoviesConfig.getPortNumber());
            serverSocket.setReuseAddress(ApiMoviesConfig.isAllowedAddressReuse());
            return serverSocket;
        } catch (Exception e) {
            logger.error(EnumApiMoviesException.SOCKET_GENERATE_ERROR, e.getMessage());
            throw new ApiMoviesException(EnumApiMoviesException.SOCKET_GENERATE_ERROR);
        }
    }

}
