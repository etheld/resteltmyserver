package hu.javachallenge.resteltmy.models;

import hu.javachallenge.resteltmy.entities.Planet;
import java.util.List;

/**
 *
 * @author Baksa Tibor
 */
public class GetGalaxyModel {

	private List<Planet> planets;

	public List<Planet> getPlanets() {
		return planets;
	}

	public void setPlanets(List<Planet> planets) {
		this.planets = planets;
	}

	@Override
	public String toString() {
		return "GetGalaxyModel{" + "planets=" + planets + '}';
	}
}
