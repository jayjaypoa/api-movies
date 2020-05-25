package br.com.joacirjunior.apimovies.external.imdb.mapper;

import br.com.joacirjunior.apimovies.enumeration.EnumApiMoviesException;
import br.com.joacirjunior.apimovies.exception.ApiMoviesException;
import br.com.joacirjunior.apimovies.external.imdb.dto.ImdbResponse;
import com.google.gson.Gson;

import java.util.Optional;

public class ImdbResponseMapper {

    public static Optional<ImdbResponse> convertToImdbResponse(String jsonString) throws ApiMoviesException {
        try {
            return Optional.ofNullable(new Gson().fromJson(jsonString, ImdbResponse.class));
        } catch (Exception e) {
            e.printStackTrace();
            throw new ApiMoviesException(EnumApiMoviesException.PARTNER_MAPPER_ERROR);
        }
    }

}
