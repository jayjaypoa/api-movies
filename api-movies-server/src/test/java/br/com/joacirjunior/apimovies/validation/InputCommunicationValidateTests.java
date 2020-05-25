package br.com.joacirjunior.apimovies.validation;

import br.com.joacirjunior.apimovies.ApiMoviesBaseTests;
import br.com.joacirjunior.apimovies.exception.ApiMoviesException;
import org.junit.Test;

public class InputCommunicationValidateTests extends ApiMoviesBaseTests {

    @Test
    public void successSeparatorTest() throws ApiMoviesException {
        InputCommunicationValidate.inputValidate("5:12345");
        InputCommunicationValidate.inputValidate("7:TITANIC");
        InputCommunicationValidate.inputValidate("7:TITANic");
        InputCommunicationValidate.inputValidate("10:lagoa azul");
        InputCommunicationValidate.inputValidate("17:O Poderoso Chefão");
        InputCommunicationValidate.inputValidate("13:The Godfather");
        InputCommunicationValidate.inputValidate("15:A Grande Famlia");
    }

    @Test(expected = ApiMoviesException.class)
    public void blankSeparatorTest() throws ApiMoviesException {
        InputCommunicationValidate.inputValidate("");
    }

    @Test(expected = ApiMoviesException.class)
    public void lengthZeroTest() throws ApiMoviesException {
        InputCommunicationValidate.inputValidate("0:Lagoa Azul");
    }

    @Test(expected = ApiMoviesException.class)
    public void higherLengthTest() throws ApiMoviesException {
        InputCommunicationValidate.inputValidate("200:Lagoa Azul");
    }

    @Test(expected = ApiMoviesException.class)
    public void nullContentTest() throws ApiMoviesException {
        InputCommunicationValidate.inputValidate("null");
    }

    @Test(expected = ApiMoviesException.class)
    public void newLineTest() throws ApiMoviesException {
        InputCommunicationValidate.inputValidate("\\n");
    }

    @Test(expected = ApiMoviesException.class)
    public void withoutIntegerLengthTest() throws ApiMoviesException {
        InputCommunicationValidate.inputValidate("aaa:bbb");
    }

    @Test(expected = ApiMoviesException.class)
    public void withoutLengthWithContentTest() throws ApiMoviesException {
        InputCommunicationValidate.inputValidate(":bbb");
    }

    @Test(expected = ApiMoviesException.class)
    public void withoutContentWithLengthTest() throws ApiMoviesException {
        InputCommunicationValidate.inputValidate("3:");
    }

    @Test(expected = ApiMoviesException.class)
    public void justSeparatorTest() throws ApiMoviesException {
        InputCommunicationValidate.inputValidate(":");
    }

    @Test(expected = ApiMoviesException.class)
    public void withoutSeparatorButNotBlankTest() throws ApiMoviesException {
        InputCommunicationValidate.inputValidate("something");
    }

}
