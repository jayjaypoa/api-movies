package br.com.joacirjunior.apimovies;

import br.com.joacirjunior.apimovies.ApiMoviesApplication;
import br.com.joacirjunior.apimovies.logger.Slf4jTypeListener;
import com.google.inject.AbstractModule;
import com.google.inject.matcher.Matchers;

public class ApiMoviesModule extends AbstractModule {

    @Override
    protected void configure() {
        //bindListener(Matchers.any(), new Slf4jTypeListener());
        //requestStaticInjection(ApiMoviesApplication.class);
    }

}
