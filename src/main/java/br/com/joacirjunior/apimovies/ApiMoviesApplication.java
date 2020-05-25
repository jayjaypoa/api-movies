package br.com.joacirjunior.apimovies;

import br.com.joacirjunior.apimovies.communication.ApiMoviesServer;
import br.com.joacirjunior.apimovies.communication.impl.ApiMoviesServerImpl;
import br.com.joacirjunior.apimovies.exception.ApiMoviesException;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class ApiMoviesApplication {

    // @InjectLogger static Logger LOGGER;

    public static void main (String[] args) throws ApiMoviesException {
        Injector injector = Guice.createInjector(new ApiMoviesModule());
        ApiMoviesApplication apiMoviesApplication = injector.getInstance(ApiMoviesApplication.class);
        apiMoviesApplication.execute();
    }

    private void execute() throws ApiMoviesException {
        ApiMoviesServer apiMoviesServer = new ApiMoviesServerImpl();
        apiMoviesServer.execute();
    }

}
