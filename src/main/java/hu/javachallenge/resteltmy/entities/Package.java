package hu.javachallenge.resteltmy.entities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;


public class Package {

    private final transient Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @SerializedName("packageId")
    private Integer id;
    private String originalPlanet;
    private String targetPlanet;
    private String text;
    private String actualPlanet;
    private int fee;

    @Override
    public String toString() {
        return gson.toJson(this);
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getOriginalPlanet() {
        return originalPlanet;
    }
    public void setOriginalPlanet(String originalPlanet) {
        this.originalPlanet = originalPlanet;
    }
    public String getTargetPlanet() {
        return targetPlanet;
    }
    public void setTargetPlanet(String targetPlanet) {
        this.targetPlanet = targetPlanet;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public String getActualPlanet() {
        return actualPlanet;
    }
    public void setActualPlanet(String actualPlanet) {
        this.actualPlanet = actualPlanet;
    }
    public int getFee() {
        return fee;
    }
    public void setFee(int fee) {
        this.fee = fee;
    }
}
