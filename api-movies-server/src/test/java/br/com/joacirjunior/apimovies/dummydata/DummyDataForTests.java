package br.com.joacirjunior.apimovies.dummydata;

import br.com.joacirjunior.apimovies.external.imdb.model.ImdbMovie;
import br.com.joacirjunior.apimovies.external.imdb.model.ImdbResponse;

import java.util.ArrayList;
import java.util.List;

public class DummyDataForTests {

    public static ImdbResponse createImdbResponse(){
        ImdbResponse imdbResponse = new ImdbResponse();
        imdbResponse.setMovies(createListImdbMovie());
        return imdbResponse;
    }

    public static List<ImdbMovie> createListImdbMovie(){
        List<ImdbMovie> listMovies = new ArrayList<>();
        listMovies.add(new ImdbMovie("TITANIC", "tt0000001", null));
        listMovies.add(new ImdbMovie("O PODEROSO CHEFÃO", "tt0000002", null));
        listMovies.add(new ImdbMovie("SICARIO", "tt0000003", null));
        return listMovies;
    }

}
