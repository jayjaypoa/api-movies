package br.com.joacirjunior.apimovies.dto;

public class ApiMoviesRequest extends ApiMoviesBaseDTO {

    public ApiMoviesRequest() {
        super();
    }

    public ApiMoviesRequest(Integer length, String content) {
        super(length, content);
    }

}
