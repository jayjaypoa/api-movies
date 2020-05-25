package br.com.joacirjunior.apimovies;

import br.com.joacirjunior.apimovies.communication.ApiMoviesServer;
import br.com.joacirjunior.apimovies.communication.impl.ApiMoviesServerImpl;
import br.com.joacirjunior.apimovies.exception.ApiMoviesException;

public class ApiMoviesApplication {

    // @InjectLogger static Logger LOGGER;

    public static void main (String[] args) throws Exception {
        ApiMoviesServer apiMoviesServer = new ApiMoviesServerImpl();
        apiMoviesServer.execute();
    }

}
