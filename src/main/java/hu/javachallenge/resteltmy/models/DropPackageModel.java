package hu.javachallenge.resteltmy.models;

/**
 *
 * @author Baksa Tibor
 */
public class DropPackageModel {

	private DropPackageStatus status;
	private int scoreIncrease;

	public DropPackageStatus getStatus() {
		return status;
	}

	public void setStatus(DropPackageStatus status) {
		this.status = status;
	}

	public int getScoreIncrease() {
		return scoreIncrease;
	}

	public void setScoreIncrease(int scoreIncrease) {
		this.scoreIncrease = scoreIncrease;
	}

	@Override
	public String toString() {
		return "DropPackageModel{" + "status=" + status + ", scoreIncrease=" + scoreIncrease + '}';
	}
}
