package br.com.joacirjunior.apimovies.external.imdb.communication.impl;

import br.com.joacirjunior.apimovies.enumeration.EnumApiMoviesException;
import br.com.joacirjunior.apimovies.exception.ApiMoviesException;
import br.com.joacirjunior.apimovies.external.imdb.communication.ImdbCommunication;
import br.com.joacirjunior.apimovies.external.imdb.model.ImdbResponse;
import br.com.joacirjunior.apimovies.external.imdb.parser.ImdbParser;
import br.com.joacirjunior.apimovies.logger.ApiMoviesCustomLog;
import br.com.joacirjunior.apimovies.util.ApiMoviesUtil;
import com.google.inject.Inject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.Optional;

public class ImdbCommunicationImpl implements ImdbCommunication {

    private static int IMDB_TIMEOUT = 5000;
    private static String IMDB_TITLE_IDENTIFIER = "$MOVIE_TITLE";
    private static String IMDB_HOST = "https://www.imdb.com";
    private static String IMDB_URL_SEARCH = IMDB_HOST + "/find?q=$MOVIE_TITLE&s=tt&ref_=fn_al_tt_mr";

    private ApiMoviesCustomLog logger;
    private ImdbParser imdbParser;

    @Inject
    public ImdbCommunicationImpl(ApiMoviesCustomLog logger, ImdbParser imdbParser) {
        this.logger = logger;
        this.imdbParser = imdbParser;
    }

    @Override
    public Optional<ImdbResponse> searchByMovieTitle(String title) throws ApiMoviesException {
        try {
            logger.info("Calling the partner for searh : " + title);
            return this.callImdb(title);
        } catch (Exception e){
            logger.error(EnumApiMoviesException.PARTNER_MOVIE_NOT_FOUND, e.getMessage());
            throw new ApiMoviesException(EnumApiMoviesException.PARTNER_MOVIE_NOT_FOUND);
        }
    }

    /**
     * Call for the IMDB to get movies.
     *
     * */
    private Optional<ImdbResponse> callImdb(String title) throws ApiMoviesException {
        try {
            String url = IMDB_URL_SEARCH.replace(IMDB_TITLE_IDENTIFIER, ApiMoviesUtil.encodeValue(title));
            logger.info("URL : " + url);
            Connection connection = Jsoup
                    .connect(url)
                    .timeout(IMDB_TIMEOUT);
            return imdbParser.parserImdbContent(connection.get());
        } catch (IOException e) {
            logger.error(EnumApiMoviesException.PARTNER_CALL_ERROR, e.getMessage());
            throw new ApiMoviesException(EnumApiMoviesException.PARTNER_CALL_ERROR);
        }
    }



}
