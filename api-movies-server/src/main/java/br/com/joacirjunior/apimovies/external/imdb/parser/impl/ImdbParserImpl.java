package br.com.joacirjunior.apimovies.external.imdb.parser.impl;

import br.com.joacirjunior.apimovies.external.imdb.model.ImdbMovie;
import br.com.joacirjunior.apimovies.external.imdb.model.ImdbResponse;
import br.com.joacirjunior.apimovies.external.imdb.parser.ImdbParser;
import br.com.joacirjunior.apimovies.logger.ApiMoviesCustomLog;
import com.google.inject.Inject;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ImdbParserImpl implements ImdbParser {

    private ApiMoviesCustomLog logger;

    @Inject
    public ImdbParserImpl(ApiMoviesCustomLog logger) {
        this.logger = logger;
    }

    public Optional<ImdbResponse> parserImdbContent(Document document) {
        logger.info("Parsing IMDB response...");
        Elements resultText = document.select("td.result_text");
        if(!resultText.isEmpty()){
            List<ImdbMovie> list = new ArrayList<>();
            resultText.forEach(elem -> {
                Elements otherElement = elem.select("a");
                String movieLink = otherElement.attr("href");
                String movieIdentifier = movieLink.replace("/title/", "").trim();
                int length = movieIdentifier.indexOf("/?");
                movieIdentifier = movieIdentifier.substring(0, length);
                String movieTitle = elem.select("[href]").text();
                ImdbMovie movie = new ImdbMovie(movieTitle, movieIdentifier, movieLink);
                if(!list.contains(movie)){
                    list.add(movie);
                }
            });
            logger.info("Parse completed");
            return Optional.ofNullable(new ImdbResponse(list));
        }
        return Optional.empty();
    }

}
