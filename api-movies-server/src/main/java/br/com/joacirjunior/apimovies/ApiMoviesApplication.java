package br.com.joacirjunior.apimovies;

import br.com.joacirjunior.apimovies.communication.ApiMoviesServer;
import br.com.joacirjunior.apimovies.communication.impl.ApiMoviesServerImpl;
import br.com.joacirjunior.apimovies.exception.ApiMoviesException;
import br.com.joacirjunior.apimovies.logger.ApiMoviesCustomLog;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class ApiMoviesApplication {

    public static void main (String[] args) throws ApiMoviesException {
        Injector injector = Guice.createInjector(new ApiMoviesProductionModule());
        ApiMoviesServer apiMoviesServer = new ApiMoviesServerImpl(
                injector.getInstance(ApiMoviesCustomLog.class)
        );
        apiMoviesServer.execute();
    }

}
