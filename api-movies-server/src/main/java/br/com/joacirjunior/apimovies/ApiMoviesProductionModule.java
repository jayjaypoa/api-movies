package br.com.joacirjunior.apimovies;

import br.com.joacirjunior.apimovies.logger.ApiMoviesCustomLog;
import br.com.joacirjunior.apimovies.logger.impl.ApiMoviesCustomLogImpl;
import com.google.inject.AbstractModule;

public class ApiMoviesProductionModule extends AbstractModule {

    public ApiMoviesProductionModule() {
    }

    @Override
    protected void configure() {
        bind(ApiMoviesCustomLog.class).to(ApiMoviesCustomLogImpl.class);
    }

}
