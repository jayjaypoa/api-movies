package br.com.joacirjunior.apimovies.communication.parser;

import br.com.joacirjunior.apimovies.communication.parser.impl.ClientParserImpl;
import br.com.joacirjunior.apimovies.dto.ApiMoviesRequest;
import br.com.joacirjunior.apimovies.dto.ApiMoviesResponse;
import br.com.joacirjunior.apimovies.exception.ApiMoviesException;
import br.com.joacirjunior.apimovies.external.imdb.model.ImdbResponse;
import com.google.inject.ImplementedBy;

import java.util.Optional;

@ImplementedBy(ClientParserImpl.class)
public interface ClientParser {
    Optional<ApiMoviesRequest> createRequest(Optional<String> optRequestContent) throws ApiMoviesException;
    Optional<ApiMoviesResponse> createResponse(Optional<ImdbResponse> optImdbResponse) throws ApiMoviesException;
}
