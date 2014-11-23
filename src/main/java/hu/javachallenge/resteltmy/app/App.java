package hu.javachallenge.resteltmy.app;

import hu.javachallenge.resteltmy.rest.RestAPI;

import org.glassfish.jersey.server.ResourceConfig;

public class App extends ResourceConfig {
    public App() {
        register(RestAPI.class);
    }
}
