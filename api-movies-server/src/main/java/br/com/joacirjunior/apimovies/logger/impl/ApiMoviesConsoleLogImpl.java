package br.com.joacirjunior.apimovies.logger.impl;

import br.com.joacirjunior.apimovies.enumeration.EnumApiMoviesException;
import br.com.joacirjunior.apimovies.logger.ApiMoviesConsoleLog;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import java.util.logging.Logger;

@Singleton
public class ApiMoviesConsoleLogImpl implements ApiMoviesConsoleLog {

    private final Logger logger;

    @Inject
    public ApiMoviesConsoleLogImpl(Logger logger) {
        this.logger = logger;
    }

    @Override
    public void info(String message) {
        logger.info(message);
    }

    @Override
    public void error(String message) {
        logger.severe(message);
    }

    @Override
    public void error(EnumApiMoviesException error) {
        logger.severe(error.getCodeAndMessage());
    }

    @Override
    public void error(EnumApiMoviesException error, String detail) {
        logger.severe(error.getCodeAndMessage() + " -- " + detail);
    }

}
