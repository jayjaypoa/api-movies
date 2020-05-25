package br.com.joacirjunior.apimovies;

import br.com.joacirjunior.apimovies.communication.ApiMoviesServer;
import br.com.joacirjunior.apimovies.communication.handler.ClientHandler;
import br.com.joacirjunior.apimovies.communication.impl.ApiMoviesServerImpl;
import br.com.joacirjunior.apimovies.exception.ApiMoviesException;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class ApiMoviesApplication {

    public static void main (String[] args) throws ApiMoviesException {
        // initialize guice injector
        Injector injector = Guice.createInjector();
        // getting ApiMoviesServer instance
        ApiMoviesServer apiMoviesServer = new ApiMoviesServerImpl(
                injector.getInstance(ClientHandler.class)
        );
        // execute the application
        apiMoviesServer.execute();
    }

}
