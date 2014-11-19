package hu.javachallenge.resteltmy.rest;

import hu.javachallenge.resteltmy.WorldMap;
import hu.javachallenge.resteltmy.entities.Package;
import hu.javachallenge.resteltmy.entities.Planet;
import hu.javachallenge.resteltmy.entities.Ship;
import hu.javachallenge.resteltmy.models.DropPackageModel;
import hu.javachallenge.resteltmy.models.DropPackageStatus;
import hu.javachallenge.resteltmy.models.PickPackageModel;
import hu.javachallenge.resteltmy.models.PickPackageStatus;

import java.util.Objects;

import javax.inject.Inject;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Path("/rest")
public class RestAPI {

    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Inject
    private Ship ship;

    @Inject
    private WorldMap worldMap;

    @GET
    @Path("getGalaxy")
    @Produces(MediaType.APPLICATION_JSON)
    public String getGalaxy() {
        return worldMap.toString();
    }

    @GET
    @Path("whereIs")
    @Produces(MediaType.APPLICATION_JSON)
    public String whereIs() {
        return ship.toString();
    }

    @POST
    @Path("pickPackage")
    @Produces(MediaType.APPLICATION_JSON)
    public String pickPackage(@FormParam("packageId") Integer packageId) {
        Planet planet = worldMap.getPlanetByName(ship.getCurrentPlanet());
        Package packageToBePickedUp = findPackageOnPlanet(planet,
                packageId);

        if (worldMap.findPackage(packageId) == null) {
            return returnPickPackageResponse(PickPackageStatus.NOT_FOUND);
        } else {
            if (!Objects.equals(worldMap.findPackage(packageId), ship.getCurrentPlanet())) {
                return returnPickPackageResponse(PickPackageStatus.USER_NOT_ON_THE_PLANET);
            }

            if (packageToBePickedUp != null) {
                if (ship.getCapacity() < 1) {
                    return returnPickPackageResponse(PickPackageStatus.LIMIT_EXCEEDED);
                }
                ship.pickPakage(packageToBePickedUp);
                return returnPickPackageResponse(PickPackageStatus.PACKAGE_PICKED);
            }
            return returnPickPackageResponse(PickPackageStatus.USER_NOT_ON_THE_PLANET);
        }
    }

    @POST
    @Path("dropPackage")
    @Produces(MediaType.APPLICATION_JSON)
    public String DropPackage(@FormParam("packageId") final Integer packageId) {

        Package pack = Iterables.find(ship.getPackages(), new Predicate<Package>() {
            @Override
            public boolean apply(Package input) {
                return input.getId() == packageId;
            }
        });

        if (pack != null) {
            boolean targetReached = pack.getTargetPlanet().equals(ship.getCurrentPlanet());
            boolean dropAtSource = pack.getOriginalPlanet().equals(ship.getCurrentPlanet());
            if (targetReached || dropAtSource) {
                return returnDropPackageResponse(DropPackageStatus.PACKAGE_DROPPED, dropAtSource ? 0 : pack.getFee());
            } else {
                return returnDropPackageResponse(DropPackageStatus.NOT_AT_DESTINATION, 0);
            }

        }
        return returnDropPackageResponse(DropPackageStatus.NOT_WITH_USER, 0);
    }

    private String returnDropPackageResponse(DropPackageStatus status, int score) {
        DropPackageModel packageModel = new DropPackageModel();
        packageModel.setScoreIncrease(score);
        packageModel.setStatus(status);
        return new Gson().toJson(packageModel);
    }

    private String returnPickPackageResponse(PickPackageStatus status) {
        PickPackageModel packageModel = new PickPackageModel();
        packageModel.setRemainingCapacity(ship.getCapacity());
        packageModel.setStatus(status);
        return new Gson().toJson(packageModel);
    }

    private Package findPackageOnPlanet(Planet planet, final int packageId) {
        return Iterables.find(planet.getPackages(), new Predicate<Package>() {
            @Override
            public boolean apply(Package input) {
                return input.getId() == packageId;
            }
        });
    }
}
