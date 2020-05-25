package br.com.joacirjunior.apimovies.exception;

import br.com.joacirjunior.apimovies.enumeration.EnumApiMoviesException;

public class ApiMoviesException extends Exception {

    public ApiMoviesException(EnumApiMoviesException enumApiMoviesException){
        super(enumApiMoviesException.getCode() + " - " + enumApiMoviesException.getMessage());
    }

    public ApiMoviesException(String errorMessage){
        super(errorMessage);
    }

}
