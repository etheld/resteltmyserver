package hu.javachallenge.resteltmy.app;

import java.awt.List;
import java.util.Arrays;

import hu.javachallenge.resteltmy.rest.RestAPI;

import org.glassfish.jersey.server.ResourceConfig;

public class App extends ResourceConfig {
    public App() {
        register(RestAPI.class);
    }
}
