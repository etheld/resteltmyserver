package hu.javachallenge.resteltmy.app.models;

/**
 *
 * @author Baksa Tibor
 */
public class GoModel {

	private GoStatus status;
	private Integer arriveAfterMs;
	private String destination;

	public GoStatus getStatus() {
		return status;
	}

	public void setStatus(GoStatus status) {
		this.status = status;
	}

	public int getArriveAfterMs() {
		return arriveAfterMs;
	}

	public void setArriveAfterMs(Integer arriveAfterMs) {
		this.arriveAfterMs = arriveAfterMs;
	}

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "GoModel{status=" + status + ", arriveAfterMs=" + arriveAfterMs + ", destination=" + destination + "}";
    }
}
