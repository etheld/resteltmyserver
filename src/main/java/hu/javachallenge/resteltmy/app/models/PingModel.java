package hu.javachallenge.resteltmy.app.models;

/**
 *
 * @author Baksa Tibor
 */
public class PingModel {

	private String response;

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	@Override
	public String toString() {
		return "PingModel{" + "response=" + response + '}';
	}
}
