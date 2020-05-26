package br.com.joacirjunior.apimovies.external.imdb.parser;

import br.com.joacirjunior.apimovies.external.imdb.model.ImdbResponse;
import br.com.joacirjunior.apimovies.external.imdb.parser.impl.ImdbParserImpl;
import com.google.inject.ImplementedBy;
import org.jsoup.nodes.Document;

import java.util.Optional;

@ImplementedBy(ImdbParserImpl.class)
public interface ImdbParser {
    Optional<ImdbResponse> parserImdbContent(Document document);
}
