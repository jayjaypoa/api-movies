package br.com.joacirjunior.apimovies.validation;

import br.com.joacirjunior.apimovies.enumeration.EnumApiMoviesException;
import br.com.joacirjunior.apimovies.exception.ApiMoviesException;
import br.com.joacirjunior.apimovies.util.ApiMoviesUtil;
import org.apache.commons.lang3.StringUtils;

public class BaseCommunicationValidate {

    /**
     * Responsible for apply separator validation rule.
     * The rule is the same for INPUT or OUTPUT.
     *
     * */
    public static void separatorValidate(String content) throws ApiMoviesException {
        if(StringUtils.isNotBlank(content)) {
            verifyValidLength(content);
        } else {
            throw new ApiMoviesException(EnumApiMoviesException.INVALID_SEPARATOR_VALIDATION);
        }
    }

    /**
     * Verify if the length is more than zero value and if the length is a
     * valid value (length number should be the same of query or payload length).
     *
     * */
    private static void verifyValidLength(String content) throws ApiMoviesException {
        int position = ApiMoviesUtil.checkSeparatorPosition(content);
        try {
            Integer length = Integer.parseInt(content.substring(0, position));
            if (length > 0) {
                if(content.substring(position+1, (length + position + 1)).length() != length){
                    throw new ApiMoviesException(EnumApiMoviesException.INVALID_LENGTH_VALIDATION);
                }
            } else {
                throw new ApiMoviesException(EnumApiMoviesException.INVALID_LENGTH_VALIDATION);
            }
        } catch (NumberFormatException | StringIndexOutOfBoundsException ex){
            throw new ApiMoviesException(EnumApiMoviesException.INVALID_LENGTH_VALIDATION);
        }
    }

}
