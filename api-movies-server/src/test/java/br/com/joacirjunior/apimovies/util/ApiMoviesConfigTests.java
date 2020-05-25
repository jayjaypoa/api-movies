package br.com.joacirjunior.apimovies.util;

import br.com.joacirjunior.apimovies.ApiMoviesBaseTests;
import org.junit.Assert;
import org.junit.Test;

public class ApiMoviesConfigTests extends ApiMoviesBaseTests {

    @Test
    public void getSeparatorTest() {
        Assert.assertEquals(":", String.valueOf(ApiMoviesConfig.getSeparator()));
    }

    @Test
    public void getTitleSeparatorTest() {
        Assert.assertEquals("\\n", ApiMoviesConfig.getTitleSeparator());
    }

    @Test
    public void getTitleSeparatorNullTest() {
        Assert.assertNotEquals(null, ApiMoviesConfig.getTitleSeparator());
    }

    @Test
    public void getPortNumberTest() {
        Assert.assertEquals(32000, ApiMoviesConfig.getPortNumber());
    }

    @Test
    public void getPortNumberNullTest() {
        Assert.assertNotEquals (null, ApiMoviesConfig.getPortNumber());
    }

    @Test
    public void isAllowedAddressReuseTest(){
        Assert.assertTrue(ApiMoviesConfig.isAllowedAddressReuse());
    }

}
