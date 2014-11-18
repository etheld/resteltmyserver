package hu.javachallenge.resteltmy.entities;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

public class Ship {

	private transient int capacity = 3;

	private final static Ship INSTANCE = new Ship();

	private static final int SPEED_DECREASE_PER_PACKET = 20;
	private static final int FULLSPEED = 170;

	private final List<Package> packages = new ArrayList<Package>();
	private String userName;

	@SerializedName("planetName")
	private String target;

	@SerializedName("targetPlanetName")
	private String currentPlanet;

	private Integer arriveAfterMs;

	private final transient Gson gson = new GsonBuilder().setPrettyPrinting()
			.serializeNulls().create();

	private Ship() {

	}

	public Integer getArriveAfterMs() {
		return arriveAfterMs;
	}

	public static Ship getInstance() {
		return INSTANCE;
	}

	public int getCapacity() {
		return capacity;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getCurrentPlanet() {
		return currentPlanet;
	}

	public void setCurrentPlanet(String currentPlanet) {
		this.currentPlanet = currentPlanet;
	}

	@Override
	public String toString() {
		return gson.toJson(this);
	}

	public void setArriveAfterMs(Integer arriveAfterMs) {
		this.arriveAfterMs = arriveAfterMs;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getSpeed() {
		return FULLSPEED - packages.size() * SPEED_DECREASE_PER_PACKET;
	}

	public boolean isMoving() {
		return !target.equals(currentPlanet);
	}

	public void pickPakage(Package p) {
		packages.add(p);
		capacity--;
	}

	public void dropPackage(Package p) {
		packages.remove(p);
		capacity++;
	}

	public List<Package> getPackages() {
		return packages;
	}

}
