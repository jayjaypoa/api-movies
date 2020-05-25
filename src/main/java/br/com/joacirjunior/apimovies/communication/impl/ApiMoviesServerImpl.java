package br.com.joacirjunior.apimovies.communication.impl;

import br.com.joacirjunior.apimovies.communication.ApiMoviesServer;
import br.com.joacirjunior.apimovies.communication.handler.ClientHandler;
import br.com.joacirjunior.apimovies.communication.parser.ClientParser;
import br.com.joacirjunior.apimovies.enumeration.EnumApiMoviesException;
import br.com.joacirjunior.apimovies.exception.ApiMoviesException;
import br.com.joacirjunior.apimovies.external.imdb.communication.ImdbCommunication;
import br.com.joacirjunior.apimovies.util.ApiMoviesConfig;
import com.google.inject.Inject;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class ApiMoviesServerImpl implements ApiMoviesServer {

    private ClientHandler clientHandler;

    @Inject
    public ApiMoviesServerImpl(ClientHandler clientHandler) {
        this.clientHandler = clientHandler;
    }

    @Override
    public void execute() throws ApiMoviesException {
        System.out.println("Server initialized");
        ServerSocket server = null;
        try {
            // server socket configuration
            server = new ServerSocket(ApiMoviesConfig.getPortNumber());
            server.setReuseAddress(ApiMoviesConfig.isAllowedAddressReuse());
            while (true) {
                // accept the new connection
                Socket client = server.accept();
                System.out.println("New client connected - IP : " + client.getInetAddress().getHostAddress());
                // start the background thread for these proccessment
                clientHandler.setClientSocket(client);
                new Thread(clientHandler).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new ApiMoviesException(EnumApiMoviesException.FATAL_ERROR);
        } finally {
            if (server != null) {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new ApiMoviesException(EnumApiMoviesException.FATAL_ERROR);
                }
            }
            System.out.println("Finished");
        }
    }

}
