package br.com.joacirjunior.apimovies.communication;

import br.com.joacirjunior.apimovies.exception.ApiMoviesException;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Optional;

public interface ApiMoviesServerSocket {

    Optional<ServerSocket> getServerSocket() throws ApiMoviesException;

    Optional<Socket> acceptSocket() throws ApiMoviesException;

}
