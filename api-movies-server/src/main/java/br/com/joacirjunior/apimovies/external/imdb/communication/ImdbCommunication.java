package br.com.joacirjunior.apimovies.external.imdb.communication;

import br.com.joacirjunior.apimovies.exception.ApiMoviesException;
import br.com.joacirjunior.apimovies.external.imdb.communication.impl.ImdbCommunicationImpl;
import br.com.joacirjunior.apimovies.external.imdb.dto.ImdbResponse;
import com.google.inject.ImplementedBy;

import java.util.Optional;

@ImplementedBy(ImdbCommunicationImpl.class)
public interface ImdbCommunication {
    Optional<ImdbResponse> searchMovie(String title) throws ApiMoviesException;
}
