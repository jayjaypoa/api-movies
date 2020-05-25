package br.com.joacirjunior.apimovies.validation;

import br.com.joacirjunior.apimovies.enumeration.EnumApiMoviesException;
import br.com.joacirjunior.apimovies.exception.ApiMoviesException;
import org.apache.commons.lang3.StringUtils;

public class OutputCommunicationValidate extends BaseCommunicationValidate {

    /**
     * Check if the OUTPUT formation is valid.
     * */
    public static void outputValidate(String output) throws ApiMoviesException {
        if(StringUtils.isNotBlank(output)){
            separatorValidate(output);
        } else {
            throw new ApiMoviesException(EnumApiMoviesException.INVALID_OUTPUT_VALIDATION);
        }
    }

}
