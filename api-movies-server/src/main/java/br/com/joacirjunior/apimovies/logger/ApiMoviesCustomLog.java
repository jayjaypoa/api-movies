package br.com.joacirjunior.apimovies.logger;

import br.com.joacirjunior.apimovies.enumeration.EnumApiMoviesException;
import br.com.joacirjunior.apimovies.logger.impl.ApiMoviesCustomLogImpl;
import com.google.inject.ImplementedBy;

@ImplementedBy(ApiMoviesCustomLogImpl.class)
public interface ApiMoviesCustomLog {
    void info(String message);
    void error(String message);
    void error(EnumApiMoviesException error);
    void error(EnumApiMoviesException error, String detail);
}
