package br.com.joacirjunior.apimovies.validation;

import br.com.joacirjunior.apimovies.ApiMoviesBaseTests;
import br.com.joacirjunior.apimovies.exception.ApiMoviesException;
import org.junit.Test;

public class BaseCommunicationValidateTests extends ApiMoviesBaseTests {

    @Test
    public void successSeparatorTest() throws ApiMoviesException {
        BaseCommunicationValidate.separatorValidate("5:12345");
        BaseCommunicationValidate.separatorValidate("7:TITANIC");
        BaseCommunicationValidate.separatorValidate("7:TITANic");
        BaseCommunicationValidate.separatorValidate("10:lagoa azul");
        BaseCommunicationValidate.separatorValidate("17:O Poderoso Chefão");
        BaseCommunicationValidate.separatorValidate("13:The Godfather");
        BaseCommunicationValidate.separatorValidate("15:A Grande Famlia");
    }

    @Test(expected = ApiMoviesException.class)
    public void blankSeparatorTest() throws ApiMoviesException {
        BaseCommunicationValidate.separatorValidate("");
    }

    @Test(expected = ApiMoviesException.class)
    public void lengthZeroTest() throws ApiMoviesException {
        BaseCommunicationValidate.separatorValidate("0:Lagoa Azul");
    }

    @Test(expected = ApiMoviesException.class)
    public void higherLengthTest() throws ApiMoviesException {
        BaseCommunicationValidate.separatorValidate("200:Lagoa Azul");
    }

    @Test(expected = ApiMoviesException.class)
    public void nullContentTest() throws ApiMoviesException {
        BaseCommunicationValidate.separatorValidate("null");
    }

    @Test(expected = ApiMoviesException.class)
    public void newLineTest() throws ApiMoviesException {
        BaseCommunicationValidate.separatorValidate("\\n");
    }

    @Test(expected = ApiMoviesException.class)
    public void withoutIntegerLengthTest() throws ApiMoviesException {
        BaseCommunicationValidate.separatorValidate("aaa:bbb");
    }

    @Test(expected = ApiMoviesException.class)
    public void withoutLengthWithContentTest() throws ApiMoviesException {
        BaseCommunicationValidate.separatorValidate(":bbb");
    }

    @Test(expected = ApiMoviesException.class)
    public void withoutContentWithLengthTest() throws ApiMoviesException {
        BaseCommunicationValidate.separatorValidate("3:");
    }

    @Test(expected = ApiMoviesException.class)
    public void justSeparatorTest() throws ApiMoviesException {
        BaseCommunicationValidate.separatorValidate(":");
    }

    @Test(expected = ApiMoviesException.class)
    public void withoutSeparatorButNotBlankTest() throws ApiMoviesException {
        BaseCommunicationValidate.separatorValidate("something");
    }

}
