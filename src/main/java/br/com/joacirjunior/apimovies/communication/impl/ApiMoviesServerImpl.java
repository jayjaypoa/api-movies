package br.com.joacirjunior.apimovies.communication.impl;

import br.com.joacirjunior.apimovies.communication.ApiMoviesServer;
import br.com.joacirjunior.apimovies.communication.handler.impl.ClientHandlerImpl;
import br.com.joacirjunior.apimovies.enumeration.EnumApiMoviesException;
import br.com.joacirjunior.apimovies.exception.ApiMoviesException;
import br.com.joacirjunior.apimovies.util.ApiMoviesConfig;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class ApiMoviesServerImpl implements ApiMoviesServer {

    public ApiMoviesServerImpl() {
    }

    @Override
    public void execute() throws ApiMoviesException {
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
                new Thread(new ClientHandlerImpl(client)).start();
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
