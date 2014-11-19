package hu.javachallenge.resteltmy.app;

import hu.javachallenge.resteltmy.entities.Ship;

import org.glassfish.hk2.utilities.binding.AbstractBinder;

public class AppBinder extends AbstractBinder{

    @Override
    protected void configure() {
        bind(Ship.class).to(Ship.class);
    }

}
