package br.com.joacirjunior.apimovies.validation;

import br.com.joacirjunior.apimovies.enumeration.EnumApiMoviesException;
import br.com.joacirjunior.apimovies.exception.ApiMoviesException;
import org.apache.commons.lang3.StringUtils;

public class InputCommunicationValidate extends BaseCommunicationValidate {

    /**
     * Check if the INPUT formation is valid.
     * */
    public static void inputValidate(String input) throws ApiMoviesException {
        if(StringUtils.isNotBlank(input)){
            separatorValidate(input);
        } else {
            throw new ApiMoviesException(EnumApiMoviesException.INVALID_INPUT_VALIDATION);
        }
    }

}
