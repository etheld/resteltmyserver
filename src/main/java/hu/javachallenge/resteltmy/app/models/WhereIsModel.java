package hu.javachallenge.resteltmy.app.models;

import hu.javachallenge.resteltmy.entities.Package;
import java.util.List;

/**
 *
 * @author Baksa Tibor
 */
public class WhereIsModel {

	private String userName;
	private String planetName;
	private String targetPlanetName;
	private Integer arriveAfterMs;
	private List<Package> packages;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPlanetName() {
		return planetName;
	}

	public void setPlanetName(String planetName) {
		this.planetName = planetName;
	}

	public String getTargetPlanetName() {
		return targetPlanetName;
	}

	public void setTargetPlanetName(String targetPlanetName) {
		this.targetPlanetName = targetPlanetName;
	}

	public int getArriveAfterMs() {
		return arriveAfterMs;
	}

	public void setArriveAfterMs(Integer arriveAfterMs) {
		this.arriveAfterMs = arriveAfterMs;
	}

	public List<Package> getPackages() {
		return packages;
	}

	public void setPackages(List<Package> packages) {
		this.packages = packages;
	}

	@Override
	public String toString() {
		return "WhereIsModel{" + "userName=" + userName + ", planetName=" + planetName + ", targetPlanetName=" + targetPlanetName + ", arriveAfterMs=" + arriveAfterMs + ", packages=" + packages + '}';
	}
}
