package br.com.joacirjunior.apimovies.dto;

public class ApiMoviesResponse extends ApiMoviesBaseDTO {

    public ApiMoviesResponse() {
        super();
    }

    public ApiMoviesResponse(Integer length, String content) {
        super(length, content);
    }

}
