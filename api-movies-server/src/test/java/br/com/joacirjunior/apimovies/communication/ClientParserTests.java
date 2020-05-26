package br.com.joacirjunior.apimovies.communication;

import br.com.joacirjunior.apimovies.ApiMoviesBaseTests;
import br.com.joacirjunior.apimovies.communication.parser.ClientParser;
import br.com.joacirjunior.apimovies.dto.ApiMoviesResponse;
import br.com.joacirjunior.apimovies.dummydata.DummyDataForTests;
import br.com.joacirjunior.apimovies.exception.ApiMoviesException;
import br.com.joacirjunior.apimovies.external.imdb.model.ImdbMovie;
import br.com.joacirjunior.apimovies.external.imdb.model.ImdbResponse;
import br.com.joacirjunior.apimovies.util.ApiMoviesConfig;
import com.google.inject.Inject;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

public class ClientParserTests extends ApiMoviesBaseTests {

    @Inject
    private ClientParser clientParser;

    @Test
    public void successCreateRequestTest() throws ApiMoviesException {
        Assert.assertEquals("7", String.valueOf(clientParser.createRequest(
                Optional.ofNullable("7:TITANIC")).get().getLength()));
        Assert.assertEquals("7", String.valueOf(clientParser.createRequest(
                Optional.ofNullable("7:TITanic")).get().getLength()));
        Assert.assertEquals("17", String.valueOf(clientParser.createRequest(
                Optional.ofNullable("17:O Poderoso Chefão")).get().getLength()));
        Assert.assertEquals("15", String.valueOf(clientParser.createRequest(
                Optional.ofNullable("15:A Grande Famlia")).get().getLength()));
        Assert.assertEquals("10", String.valueOf(clientParser.createRequest(
                Optional.ofNullable("10:lagoa azul")).get().getLength()));
    }

    @Test(expected = ApiMoviesException.class)
    public void createRequestExceptionEmptyTest() throws ApiMoviesException {
        clientParser.createRequest(Optional.empty());
    }

    @Test(expected = ApiMoviesException.class)
    public void createRequestExceptionWithoutLengthTest() throws ApiMoviesException {
        clientParser.createRequest(Optional.ofNullable(":TITANIC"));
    }

    @Test(expected = ApiMoviesException.class)
    public void createRequestExceptionWithoutLengthAlsoTest() throws ApiMoviesException {
        clientParser.createRequest(Optional.ofNullable("TITANIC"));
    }

    @Test(expected = ApiMoviesException.class)
    public void createRequestExceptionWithoutContentTest() throws ApiMoviesException {
        clientParser.createRequest(Optional.ofNullable("4:"));
    }

    @Test
    public void successCreateResponseTest() throws ApiMoviesException {
        ImdbResponse imdbResponse = DummyDataForTests.createImdbResponse();
        Optional<ImdbResponse> optImdbResponse = Optional.ofNullable(imdbResponse);
        Optional<ApiMoviesResponse> opt = clientParser.createResponse(optImdbResponse);
        String expected = "";
        for(ImdbMovie imdbMovie : imdbResponse.getMovies()){
            expected = expected + imdbMovie.getTitle() + ApiMoviesConfig.getTitleSeparator();
        }
        Assert.assertEquals(String.valueOf(expected.length()), opt.get().getLength().toString());
        Assert.assertEquals(expected, opt.get().getContent());
    }

    @Test
    public void successCreateOtherResponseTest() throws ApiMoviesException {
        ImdbResponse imdbResponse = DummyDataForTests.createImdbResponse();
        Optional<ImdbResponse> optImdbResponse = Optional.ofNullable(imdbResponse);
        Optional<ApiMoviesResponse> opt = clientParser.createResponse(optImdbResponse);
        Assert.assertNotEquals("TITANIC\nSICARIO\n".length(), opt.get().getLength().toString());
        Assert.assertNotEquals("TITANIC\nSICARIO\n", opt.get().getContent());
    }

    @Test(expected = ApiMoviesException.class)
    public void createResponseExceptionEmptyTest() throws ApiMoviesException {
        Optional<ApiMoviesResponse> opt = clientParser.createResponse(Optional.empty());
    }

}
