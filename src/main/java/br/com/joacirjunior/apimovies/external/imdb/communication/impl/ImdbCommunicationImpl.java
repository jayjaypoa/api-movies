package br.com.joacirjunior.apimovies.external.imdb.communication.impl;

import br.com.joacirjunior.apimovies.enumeration.EnumApiMoviesException;
import br.com.joacirjunior.apimovies.exception.ApiMoviesException;
import br.com.joacirjunior.apimovies.external.imdb.communication.ImdbCommunication;
import br.com.joacirjunior.apimovies.external.imdb.dto.ImdbMovie;
import br.com.joacirjunior.apimovies.external.imdb.dto.ImdbResponse;
import br.com.joacirjunior.apimovies.external.imdb.mapper.ImdbResponseMapper;
import br.com.joacirjunior.apimovies.util.ApiMoviesUtil;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ImdbCommunicationImpl implements ImdbCommunication {

    private static int IMDB_TIMEOUT = 5000;

    private static String IMDB_FIRST_LETTER_IDENTIFIER = "$FIRST_LETTER";

    private static String IMDB_TITLE_IDENTIFIER = "$MOVIE_TITLE";

    private static String IMDB_URL_SEARCH = "https://sg.media-imdb.com/suggests/"
            + IMDB_FIRST_LETTER_IDENTIFIER + "/" + IMDB_TITLE_IDENTIFIER + ".json";

    private static String IMDB_MOVIE_IDENTIFIER_START_WITH = "tt";

    private static String IMDB_RESPONSE_INITIAL = "(";

    private static String IMDB_RESPONSE_FINAL = ")";

    @Override
    public Optional<ImdbResponse> searchMovie(String title) throws ApiMoviesException {
        try {
            Optional<StringBuffer> optImdbResponse = this.callImdb(title);
            if (!optImdbResponse.isEmpty()) {
                StringBuffer imdbResponse = optImdbResponse.get();
                String jsonString = imdbResponse.substring(
                        imdbResponse.indexOf(IMDB_RESPONSE_INITIAL) + IMDB_RESPONSE_INITIAL.length(),
                        (imdbResponse.length() - IMDB_RESPONSE_FINAL.length()));
                Optional<ImdbResponse> opt = ImdbResponseMapper.convertToImdbResponse(jsonString);
                List<ImdbMovie> filtered = opt.get().getMoviesData()
                        .stream()
                        .filter(elem -> elem.getIdentifier().toLowerCase().trim()
                                .startsWith(IMDB_MOVIE_IDENTIFIER_START_WITH.toLowerCase().trim()))
                        .collect(Collectors.toCollection(ArrayList::new));
                opt.get().setMoviesData(filtered);
                return opt;
            }
        } catch (Exception e){
            e.printStackTrace();
            throw new ApiMoviesException(EnumApiMoviesException.PARTNER_MOVIE_NOT_FOUND);
        }
        return Optional.empty();
    }


    /**
     * Call for the IMDB partner to get movies content.
     *
     * */
    private Optional<StringBuffer> callImdb(String titleMovie) throws ApiMoviesException {
        Optional optResult = Optional.empty();
        HttpURLConnection connection = null;
        try {
            DataOutputStream output = null;
            try {
                connection = configureGetConnection(connection, this.defineUrlToCall(titleMovie));
                if(connection.getResponseCode() == HttpURLConnection.HTTP_OK){
                    optResult = this.getResponseContent(connection);
                } else {
                    Reader streamReader = new InputStreamReader(connection.getErrorStream());
                    optResult = Optional.ofNullable(new StringBuffer().append(streamReader.toString()));
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new ApiMoviesException(EnumApiMoviesException.PARTNER_CALL_ERROR);
            }
        } catch (Exception ioe){
            ioe.printStackTrace();
            throw new ApiMoviesException(EnumApiMoviesException.PARTNER_CALL_ERROR);
        } finally {
            connection.disconnect();
        }
        return optResult;
    }

    private HttpURLConnection configureGetConnection(HttpURLConnection connection, URL url) throws IOException {
        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setConnectTimeout(IMDB_TIMEOUT);
        connection.setReadTimeout(IMDB_TIMEOUT);
        connection.setDoOutput(true);
        return connection;
    }

    private URL defineUrlToCall(String title) throws ApiMoviesException {
        try {
            String url = IMDB_URL_SEARCH.replace(IMDB_FIRST_LETTER_IDENTIFIER,
                    String.valueOf(ApiMoviesUtil.getFirstLetter(title)));
            return new URL(url.replace(IMDB_TITLE_IDENTIFIER, this.normalizeMovieTitle(title)));
        } catch (Exception ex){
            throw new ApiMoviesException(EnumApiMoviesException.PARTNER_URL_ERROR);
        }
    }

    private Optional<StringBuffer> getResponseContent(HttpURLConnection connection) throws IOException {
        String inputLine = "";
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        return Optional.ofNullable(content);
    }

    private String normalizeMovieTitle(String title) throws ApiMoviesException {
        if(StringUtils.isNotBlank(title)) {
            return title.replaceAll(" ", "%20");
        }
        throw new ApiMoviesException(EnumApiMoviesException.GENERIC_ERROR);
    }

}
