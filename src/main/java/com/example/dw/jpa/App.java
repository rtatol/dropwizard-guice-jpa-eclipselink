package com.example.dw.jpa;

import com.example.dw.jpa.config.Config;
import com.example.dw.jpa.config.DbConfig;
import com.example.dw.jpa.resource.HomeResource;
import com.example.dw.jpa.resource.PlayerResource;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.PersistFilter;
import com.google.inject.persist.jpa.JpaPersistModule;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import java.util.Properties;

public class App extends Application<Config> {

    public static void main(String[] args) throws Exception {
        new App().run(args);
    }

    @Override
    public void initialize(final Bootstrap<Config> bootstrap) {
    }

    @Override
    public void run(final Config conf, final Environment env) throws Exception {
        final Injector injector = Guice.createInjector(new AppModule(conf, env), createJpaModule(conf.getDbConfig()));
        env.servlets().addFilter("persistFilter", injector.getInstance(PersistFilter.class));
        env.jersey().register(injector.getInstance(HomeResource.class));
        env.jersey().register(injector.getInstance(PlayerResource.class));
    }

    private JpaPersistModule createJpaModule(final DbConfig dbConfig) {
        final Properties properties = new Properties();
        properties.put("javax.persistence.jdbc.driver", dbConfig.getDriver());
        properties.put("javax.persistence.jdbc.url", dbConfig.getUrl());
        properties.put("javax.persistence.jdbc.user", dbConfig.getUsername());
        properties.put("javax.persistence.jdbc.password", dbConfig.getPassword());

        final JpaPersistModule jpaModule = new JpaPersistModule("DefaultUnit");
        jpaModule.properties(properties);

        return jpaModule;
    }
}
