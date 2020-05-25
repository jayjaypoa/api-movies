package br.com.joacirjunior.apimovies.communication.parser.impl;

import br.com.joacirjunior.apimovies.communication.parser.ClientParser;
import br.com.joacirjunior.apimovies.dto.ApiMoviesRequest;
import br.com.joacirjunior.apimovies.dto.ApiMoviesResponse;
import br.com.joacirjunior.apimovies.enumeration.EnumApiMoviesException;
import br.com.joacirjunior.apimovies.exception.ApiMoviesException;
import br.com.joacirjunior.apimovies.external.imdb.dto.ImdbMovie;
import br.com.joacirjunior.apimovies.external.imdb.dto.ImdbResponse;
import br.com.joacirjunior.apimovies.util.ApiMoviesConfig;
import br.com.joacirjunior.apimovies.util.ApiMoviesUtil;

import java.util.Optional;

public class ClientParserImpl implements ClientParser {

    @Override
    public Optional<ApiMoviesRequest> createRequest(Optional<String> optRequestContent) throws ApiMoviesException {
        try {
            int position = ApiMoviesUtil.checkSeparatorPosition(optRequestContent.get());
            Integer length = Integer.parseInt(optRequestContent.get().substring(0, position));
            String content = optRequestContent.get().substring(position+1, (length + position + 1));
            return Optional.ofNullable(new ApiMoviesRequest(length, content.toLowerCase()));
        } catch (Exception e){
            throw new ApiMoviesException(EnumApiMoviesException.PARSER_REQUEST_ERROR);
        }
    }

    @Override
    public Optional<ApiMoviesResponse> createResponse(Optional<ImdbResponse> optImdbResponse) throws ApiMoviesException {
        String outputContent = "";
        if(!optImdbResponse.isEmpty()) {
            for(ImdbMovie movie : optImdbResponse.get().getMoviesData()){
                if(movie.getIdentifier().startsWith("tt"))
                    outputContent = outputContent.concat(movie.getTitle().concat(String.valueOf(ApiMoviesConfig.getTitleSeparator())));
            }
            return Optional.ofNullable(new ApiMoviesResponse(outputContent.length(), outputContent));
        } else {
            throw new ApiMoviesException(EnumApiMoviesException.PARSER_RESPONSE_ERROR);
        }
    }
}
