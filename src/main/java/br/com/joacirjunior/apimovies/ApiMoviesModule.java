package br.com.joacirjunior.apimovies;

import br.com.joacirjunior.apimovies.communication.ApiMoviesServer;
import br.com.joacirjunior.apimovies.communication.handler.ClientHandler;
import br.com.joacirjunior.apimovies.communication.handler.impl.ClientHandlerImpl;
import br.com.joacirjunior.apimovies.communication.impl.ApiMoviesServerImpl;
import br.com.joacirjunior.apimovies.communication.parser.ClientParser;
import br.com.joacirjunior.apimovies.communication.parser.impl.ClientParserImpl;
import br.com.joacirjunior.apimovies.external.imdb.communication.ImdbCommunication;
import br.com.joacirjunior.apimovies.external.imdb.communication.impl.ImdbCommunicationImpl;
import com.google.inject.AbstractModule;

public class ApiMoviesModule extends AbstractModule {

    @Override
    protected void configure() {

        bind(ApiMoviesServer.class).to(ApiMoviesServerImpl.class);
        bind(ClientParser.class).to(ClientParserImpl.class);
        bind(ClientHandler.class).to(ClientHandlerImpl.class);
        bind(ImdbCommunication.class).to(ImdbCommunicationImpl.class);

        //bindListener(Matchers.any(), new Slf4jTypeListener());
        //requestStaticInjection(ApiMoviesApplication.class);

    }

}
