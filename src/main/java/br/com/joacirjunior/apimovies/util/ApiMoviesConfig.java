package br.com.joacirjunior.apimovies.util;

public class ApiMoviesConfig {

    private static final int PORT_NUMBER = 32000;

    private static final boolean ALLOWED_ADDRESS_REUSE = true;

    private static final char SEPARATOR = ':';

    private static final String TITLE_SEPARATOR = "\\n";

    public ApiMoviesConfig(){
    }

    public static int getPortNumber(){
        return PORT_NUMBER;
    }

    public static boolean isAllowedAddressReuse(){
        return ALLOWED_ADDRESS_REUSE;
    }

    public static char getSeparator(){
        return SEPARATOR;
    }

    public static String getTitleSeparator(){
        return TITLE_SEPARATOR;
    }

}
