package com.example.dw.jpa;

import com.example.dw.jpa.config.Config;
import com.example.dw.jpa.dao.Dao;
import com.example.dw.jpa.dao.DaoImpl;
import com.example.dw.jpa.service.PlayerService;
import com.example.dw.jpa.service.ScoreService;
import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import io.dropwizard.setup.Environment;

public class AppModule extends AbstractModule {

    final Config configuration;
    final Environment environment;

    public AppModule(final Config configuration, final Environment environment) {
        this.configuration = configuration;
        this.environment = environment;
    }

    @Override
    protected void configure() {
        bind(Config.class).toInstance(configuration);
        bind(Environment.class).toInstance(environment);
        bind(Dao.class).to(DaoImpl.class).in(Singleton.class);
        bind(PlayerService.class).in(Singleton.class);
        bind(ScoreService.class).in(Singleton.class);
    }
}
