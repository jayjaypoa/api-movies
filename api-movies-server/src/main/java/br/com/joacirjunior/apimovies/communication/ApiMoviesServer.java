package br.com.joacirjunior.apimovies.communication;

import br.com.joacirjunior.apimovies.communication.impl.ApiMoviesServerImpl;
import br.com.joacirjunior.apimovies.exception.ApiMoviesException;
import com.google.inject.ImplementedBy;

@ImplementedBy(ApiMoviesServerImpl.class)
public interface ApiMoviesServer extends Runnable {
    void execute() throws ApiMoviesException;
}
