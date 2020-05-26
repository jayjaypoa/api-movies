package br.com.joacirjunior.apimovies.util;

import br.com.joacirjunior.apimovies.enumeration.EnumApiMoviesException;
import br.com.joacirjunior.apimovies.exception.ApiMoviesException;
import br.com.joacirjunior.apimovies.logger.ApiMoviesConsoleLog;
import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class ApiMoviesUtil {

    private static ApiMoviesConsoleLog logger;

    public static int checkSeparatorPosition(String content) throws ApiMoviesException {
        if(content.indexOf(ApiMoviesConfig.getSeparator(), 0) <= 0
                || content.indexOf(ApiMoviesConfig.getSeparator(), 0) == (content.length()-1)) {
            logger.error(EnumApiMoviesException.SEPARATOR_NOT_FOUND);
            throw new ApiMoviesException(EnumApiMoviesException.SEPARATOR_NOT_FOUND);
        } else {
            return content.indexOf(ApiMoviesConfig.getSeparator(), 0);
        }
    }

    public static char getFirstLetter(String string) throws ApiMoviesException {
        if(StringUtils.isNotBlank(string)){
            return string.charAt(0);
        }
        logger.error(EnumApiMoviesException.GENERIC_ERROR);
        throw new ApiMoviesException(EnumApiMoviesException.GENERIC_ERROR);
    }

    public static String encodeValue(String value) throws ApiMoviesException {
        try {
            return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException ex) {
            logger.error(EnumApiMoviesException.URL_ENCODER_ERROR);
            throw new ApiMoviesException(EnumApiMoviesException.URL_ENCODER_ERROR);
        }
    }

}
