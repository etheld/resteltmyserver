package hu.javachallenge.resteltmy.app;

import java.io.Closeable;
import java.io.IOException;

import com.sun.jersey.api.container.filter.GZIPContentEncodingFilter;
import com.sun.jersey.api.core.DefaultResourceConfig;
import com.sun.jersey.simple.container.SimpleServerFactory;

public class App {
	public static void main(String[] args) throws IllegalArgumentException, IOException {
		DefaultResourceConfig resourceConfig = new DefaultResourceConfig(
				RestAPI.class);
		// The following line is to enable GZIP when client accepts it
		resourceConfig.getContainerResponseFilters().add(
				new GZIPContentEncodingFilter());
		Closeable server = SimpleServerFactory.create("http://0.0.0.0:8888",
				resourceConfig);
		try {
			System.out.println("Press any key to stop the service...");
			System.in.read();
		} finally {
			server.close();
		}
	}
}
