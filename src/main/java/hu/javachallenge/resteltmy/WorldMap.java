package hu.javachallenge.resteltmy;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import hu.javachallenge.resteltmy.entities.Package;
import hu.javachallenge.resteltmy.entities.Planet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class WorldMap {

  private static final int PLANET_NUM = 80;

  public WorldMap() {
    List<String> names = new ArrayList<>(Arrays.asList("Daturn",
      "Ayjuydrion", "Vahines", "Aprosie", "Praiter", "Iystomia", "Trioaliv", "Ahsnurn", "Stoyetov", "Iasncillon", "Cliasaelea", "Oeiiysmadus",
      "Iarilia", "Ubrarvis", "Grunia", "Iubrade", "Flaiomia", "Udblippe", "Chaoegantu", "Oegrmichi", "Smoeyeyria", "Oyfiycluna"));
    Random rng = new Random();

    List<Integer> randomNumbers = new ArrayList<>();

    while (randomNumbers.size() < PLANET_NUM * 30) {

      Integer randomNumber = rng.nextInt(100000) + 10000;
      if (!randomNumbers.contains(randomNumber)) {
        randomNumbers.add(randomNumber);
      }
    }
    for (int i = 0; i < PLANET_NUM; i++) {
      planets.add(new Planet(names.remove(rng.nextInt(names.size())),
        200 + rng.nextDouble() * 1800,
        200 + rng.nextDouble() * 1800));
    }
    for (Planet p : planets) {
      List<Package> packages = new ArrayList<>();
      for (int i = 0; i < 30; i++) {
        hu.javachallenge.resteltmy.entities.Package pack = new Package();
        Planet targetPlanet = getRandomTargetPlanet(p, rng);
        pack.setFee((int) p.getDistance(targetPlanet) / 100);
        pack.setOriginalPlanet(p.getName());
        pack.setTargetPlanet(targetPlanet.getName());
        pack.setText("random");
        pack.setId(randomNumbers.remove(rng.nextInt(randomNumbers
          .size())));
        packages.add(pack);
        packageToPlanet.put(pack.getId(), pack.getOriginalPlanet());
      }
      p.setPackages(packages);
    }
  }

  private final transient Gson gson = new GsonBuilder().setPrettyPrinting()
    .create();

  private final Map<Integer, String> packageToPlanet = new TreeMap<>();

  private List<Planet> planets = new ArrayList<>();

  public List<Planet> getPlanets() {
    return planets;
  }

  public void setPlanets(List<Planet> planets) {
    this.planets = planets;
  }

  @Override
  public String toString() {
    return gson.toJson(this);
  }

  public Planet getPlanetByName(String planetName) {
    for (Planet planet : planets) {
      if (planet.getName().equals(planetName)) {
        return planet;
      }
    }
    throw new RuntimeException("Planet name not found: " + planetName);
  }

  public String findPackage(Integer packageId) {
    return packageToPlanet.get(packageId);
  }

  private Planet getRandomTargetPlanet(Planet p, Random rng) {
    Planet randomPlanet;
    do {
      randomPlanet = planets.get(rng.nextInt(planets.size()));
    } while (randomPlanet.equals(p));
    return randomPlanet;
  }
}
