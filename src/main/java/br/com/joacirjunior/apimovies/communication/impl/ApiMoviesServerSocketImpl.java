package br.com.joacirjunior.apimovies.communication.impl;

import br.com.joacirjunior.apimovies.communication.ApiMoviesServerSocket;
import br.com.joacirjunior.apimovies.enumeration.EnumApiMoviesException;
import br.com.joacirjunior.apimovies.exception.ApiMoviesException;
import br.com.joacirjunior.apimovies.util.ApiMoviesConfig;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Optional;

public class ApiMoviesServerSocketImpl implements ApiMoviesServerSocket {

    @Override
    public Optional<ServerSocket> getServerSocket() throws ApiMoviesException {
        try {
            return Optional.of(new ServerSocket(ApiMoviesConfig.getPortNumber()));
        } catch (IOException e) {
            throw new ApiMoviesException(EnumApiMoviesException.SOCKET_GENERATE_ERROR);
        }
    }

    @Override
    public Optional<Socket> acceptSocket() throws ApiMoviesException {
        Optional<ServerSocket> optional = this.getServerSocket();
        System.out.println("Listening");
        if(!optional.isEmpty()){
            ServerSocket serverSocket = optional.get();
            try {
                System.out.println("111");
                Socket socket = serverSocket.accept();
                System.out.println("2222");
                return Optional.of(socket);
            } catch (IOException e) {
                System.out.println("ERROR - " + e.getMessage());
                throw new ApiMoviesException(EnumApiMoviesException.SOCKET_ACCEPT_ERROR);
            }
        } else {
            System.out.println("3333");
            EnumApiMoviesException error = EnumApiMoviesException.SOCKET_NOT_FOUND_FOR_ACCEPT;
            System.out.println("ERROR - " + error.getCodeAndMessage());
            throw new ApiMoviesException(error);
        }
    }

}
