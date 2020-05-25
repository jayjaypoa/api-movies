package br.com.joacirjunior.apimovies.util;

import br.com.joacirjunior.apimovies.ApiMoviesBaseTests;
import br.com.joacirjunior.apimovies.exception.ApiMoviesException;
import org.junit.Assert;
import org.junit.Test;

public class ApiMoviesUtilTests extends ApiMoviesBaseTests {

    @Test
    public void checkSeparatorPositionTest() throws ApiMoviesException {
        Assert.assertEquals(1, ApiMoviesUtil.checkSeparatorPosition("0:234567"));
        Assert.assertEquals(2, ApiMoviesUtil.checkSeparatorPosition("01:34567"));
        Assert.assertEquals(3, ApiMoviesUtil.checkSeparatorPosition("012:4567"));
        Assert.assertEquals(4, ApiMoviesUtil.checkSeparatorPosition("0123:567"));
        Assert.assertEquals(5, ApiMoviesUtil.checkSeparatorPosition("01234:67"));
        Assert.assertEquals(6, ApiMoviesUtil.checkSeparatorPosition("012345:7"));
    }

    @Test(expected = ApiMoviesException.class)
    public void checkSeparatorAtFirstPositionTest() throws ApiMoviesException {
        ApiMoviesUtil.checkSeparatorPosition(":1234567");
    }

    @Test(expected = ApiMoviesException.class)
    public void checkSeparatorAtLastPositionTest() throws ApiMoviesException {
        ApiMoviesUtil.checkSeparatorPosition("0123456:");
    }

    @Test
    public void successGetFirstLetterTest() throws ApiMoviesException {
        Assert.assertEquals("O", String.valueOf(ApiMoviesUtil.getFirstLetter("Os Normais")));
        Assert.assertEquals("o", String.valueOf(ApiMoviesUtil.getFirstLetter("os normais")));
        Assert.assertEquals("L", String.valueOf(ApiMoviesUtil.getFirstLetter("Lagoa Azul")));
        Assert.assertEquals("1", String.valueOf(ApiMoviesUtil.getFirstLetter("1234567")));
    }

    @Test(expected = ApiMoviesException.class)
    public void successGetFirstLetterExceptionNullTest() throws ApiMoviesException {
        ApiMoviesUtil.getFirstLetter(null);
    }

    @Test(expected = ApiMoviesException.class)
    public void successGetFirstLetterExceptionBlankTest() throws ApiMoviesException {
        ApiMoviesUtil.getFirstLetter("");
    }

}
