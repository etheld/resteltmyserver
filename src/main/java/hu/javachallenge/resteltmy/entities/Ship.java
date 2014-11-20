package hu.javachallenge.resteltmy.entities;

import hu.javachallenge.resteltmy.WorldMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

public class Ship {

	private transient int capacity = 3;

	private static final int SPEED_DECREASE_PER_PACKET = 20;
	private static final int FULLSPEED = 170;

	private final List<Package> packages = new ArrayList<Package>();
	private String userName;

	@SerializedName("targetPlanetName")
	private String target;

	@SerializedName("planetName")
	private String currentPlanet;

	private transient Long startTime;

	private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(Ship.class);
	
	public Ship(WorldMap worldMap) {
		Random rng = new Random();
		Planet starterPlanet = worldMap.getPlanets().get(rng.nextInt(worldMap.getPlanets().size()));
		setCurrentPlanet(starterPlanet.getName());
		setUserName("restelt my");
		setTarget(starterPlanet.getName());
	}

	private Integer arriveAfterMs;

	private final transient Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();

	public Integer getArriveAfterMs() {
		return arriveAfterMs;
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
		arriveAfterMs = arriveAfterMs != null && arriveAfterMs - System.currentTimeMillis() > 0 ? (int) (arriveAfterMs - System
				.currentTimeMillis()) : null;
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

	public Integer calculateArrive(final Planet destination, final WorldMap worldMap) {
		Planet source = worldMap.getPlanetByName(currentPlanet);
		double distance = source.getDistance(destination);
		return (int) (distance / getSpeed())*1000;
	}

	public boolean isMovingCurrently() {
		return startTime + arriveAfterMs > System.currentTimeMillis();
	}

	public void move(final Integer arriveAfterMs, final  Planet destination) {
		if (startTime == null || startTime + arriveAfterMs > System.currentTimeMillis()) {
			System.out.println("Starting");
			startTime = System.currentTimeMillis();
		}
		target = destination.getName();
		Runnable run = new Runnable() {

			@Override
			public void run() {
				try {
					LOG.debug("Sleeping: " + arriveAfterMs);
					Thread.sleep(arriveAfterMs);
					LOG.debug("Changing currentplant: " + currentPlanet);
					currentPlanet = destination.getName();
					LOG.debug("Changed currentplant: " + currentPlanet);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		new Thread(run).start();
	}

}
