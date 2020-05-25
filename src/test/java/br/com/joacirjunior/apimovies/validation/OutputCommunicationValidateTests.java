package br.com.joacirjunior.apimovies.validation;

import br.com.joacirjunior.apimovies.ApiMoviesBaseTests;
import br.com.joacirjunior.apimovies.exception.ApiMoviesException;
import org.junit.Test;

public class OutputCommunicationValidateTests extends ApiMoviesBaseTests {

    @Test
    public void successSeparatorTest() throws ApiMoviesException {
        OutputCommunicationValidate.outputValidate("5:12345");
        OutputCommunicationValidate.outputValidate("7:TITANIC");
        OutputCommunicationValidate.outputValidate("7:TITANic");
        OutputCommunicationValidate.outputValidate("10:lagoa azul");
        OutputCommunicationValidate.outputValidate("17:O Poderoso Chefão");
        OutputCommunicationValidate.outputValidate("13:The Godfather");
        OutputCommunicationValidate.outputValidate("15:A Grande Famlia");
    }

    @Test(expected = ApiMoviesException.class)
    public void blankSeparatorTest() throws ApiMoviesException {
        OutputCommunicationValidate.outputValidate("");
    }

    @Test(expected = ApiMoviesException.class)
    public void lengthZeroTest() throws ApiMoviesException {
        OutputCommunicationValidate.outputValidate("0:Lagoa Azul");
    }

    @Test(expected = ApiMoviesException.class)
    public void higherLengthTest() throws ApiMoviesException {
        OutputCommunicationValidate.outputValidate("200:Lagoa Azul");
    }

    @Test(expected = ApiMoviesException.class)
    public void nullContentTest() throws ApiMoviesException {
        OutputCommunicationValidate.outputValidate("null");
    }

    @Test(expected = ApiMoviesException.class)
    public void newLineTest() throws ApiMoviesException {
        OutputCommunicationValidate.outputValidate("\\n");
    }

    @Test(expected = ApiMoviesException.class)
    public void withoutIntegerLengthTest() throws ApiMoviesException {
        OutputCommunicationValidate.outputValidate("aaa:bbb");
    }

    @Test(expected = ApiMoviesException.class)
    public void withoutLengthWithContentTest() throws ApiMoviesException {
        OutputCommunicationValidate.outputValidate(":bbb");
    }

    @Test(expected = ApiMoviesException.class)
    public void withoutContentWithLengthTest() throws ApiMoviesException {
        OutputCommunicationValidate.outputValidate("3:");
    }

    @Test(expected = ApiMoviesException.class)
    public void justSeparatorTest() throws ApiMoviesException {
        OutputCommunicationValidate.outputValidate(":");
    }

    @Test(expected = ApiMoviesException.class)
    public void withoutSeparatorButNotBlankTest() throws ApiMoviesException {
        OutputCommunicationValidate.outputValidate("something");
    }

}
