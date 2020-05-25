package br.com.joacirjunior.apimovies.util;

import br.com.joacirjunior.apimovies.enumeration.EnumApiMoviesException;
import br.com.joacirjunior.apimovies.exception.ApiMoviesException;
import org.apache.commons.lang3.StringUtils;

public class ApiMoviesUtil {

    public static int checkSeparatorPosition(String content) throws ApiMoviesException {
        if(content.indexOf(ApiMoviesConfig.getSeparator(), 0) <= 0
                || content.indexOf(ApiMoviesConfig.getSeparator(), 0) == (content.length()-1)) {
            throw new ApiMoviesException(EnumApiMoviesException.SEPARATOR_NOT_FOUND);
        } else {
            return content.indexOf(ApiMoviesConfig.getSeparator(), 0);
        }
    }

    public static char getFirstLetter(String string) throws ApiMoviesException {
        if(StringUtils.isNotBlank(string)){
            return string.charAt(0);
        }
        throw new ApiMoviesException(EnumApiMoviesException.GENERIC_ERROR);
    }

}
