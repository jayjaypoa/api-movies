package br.com.joacirjunior.apimovies.communication.parser;

import br.com.joacirjunior.apimovies.communication.parser.impl.ClientParserImpl;
import br.com.joacirjunior.apimovies.exception.ApiMoviesException;
import br.com.joacirjunior.apimovies.dto.ApiMoviesRequest;
import br.com.joacirjunior.apimovies.dto.ApiMoviesResponse;
import br.com.joacirjunior.apimovies.external.imdb.dto.ImdbResponse;
import com.google.inject.ImplementedBy;

import java.util.Optional;

@ImplementedBy(ClientParserImpl.class)
public interface ClientParser {
    Optional<ApiMoviesRequest> createRequest(Optional<String> opt) throws ApiMoviesException;
    Optional<ApiMoviesResponse> createResponse(Optional<ImdbResponse> opt) throws ApiMoviesException;
}
