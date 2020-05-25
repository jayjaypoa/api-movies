package br.com.joacirjunior.apimovies;

import br.com.joacirjunior.apimovies.communication.ApiMoviesServer;
import br.com.joacirjunior.apimovies.communication.handler.ClientHandler;
import br.com.joacirjunior.apimovies.communication.impl.ApiMoviesServerImpl;
import br.com.joacirjunior.apimovies.exception.ApiMoviesException;
import br.com.joacirjunior.apimovies.logger.ApiMoviesConsoleLog;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class ApiMoviesApplication {

    @Inject
    private static ApiMoviesApplication application;

    public static void main (String[] args) throws ApiMoviesException {
        // initialize injector
        Injector injector = Guice.createInjector(new ApiMoviesModule());
        // getting ApiMoviesServer instance
        ApiMoviesServer apiMoviesServer = new ApiMoviesServerImpl(
                injector.getInstance(ApiMoviesConsoleLog.class),
                injector.getInstance(ClientHandler.class)
        );
        // execute the application
        apiMoviesServer.execute();
    }

}
