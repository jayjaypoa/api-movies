package br.com.joacirjunior.apimovies.logger;

import br.com.joacirjunior.apimovies.enumeration.EnumApiMoviesException;
import br.com.joacirjunior.apimovies.logger.impl.ApiMoviesConsoleLogImpl;
import com.google.inject.ImplementedBy;

@ImplementedBy(ApiMoviesConsoleLogImpl.class)
public interface ApiMoviesConsoleLog {
    void info(String message);
    void error(String message);
    void error(EnumApiMoviesException error);
    void error(EnumApiMoviesException error, String detail);
}
