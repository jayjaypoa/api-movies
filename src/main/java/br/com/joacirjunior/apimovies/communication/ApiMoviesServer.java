package br.com.joacirjunior.apimovies.communication;

import br.com.joacirjunior.apimovies.communication.impl.ApiMoviesServerImpl;
import br.com.joacirjunior.apimovies.exception.ApiMoviesException;
import com.google.inject.ImplementedBy;

@ImplementedBy(ApiMoviesServerImpl.class)
public interface ApiMoviesServer {
    void execute() throws ApiMoviesException;
}
