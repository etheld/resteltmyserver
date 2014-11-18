package hu.javachallenge.resteltmy.entities;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Planet {
    public Planet(String name, double x, double y) {
		super();
		this.name = name;
		this.x = x;
		this.y = y;
	}

	private final transient Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private String name;
    private double x;
    private double y;
    private List<Package> packages;

    @Override
    public String toString() {
        return gson.toJson(this);
    }

    public String getName() {
        return name;
    }
    
    public double getDistance(Planet p) {
    	return Math.sqrt((p.x-x)*(p.x-x) + (p.y-y)*(p.y-y));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (name == null ? 0 : name.hashCode());
        result = prime * result + (packages == null ? 0 : packages.hashCode());
        long temp;
        temp = Double.doubleToLongBits(x);
        result = prime * result + (int) (temp ^ temp >>> 32);
        temp = Double.doubleToLongBits(y);
        result = prime * result + (int) (temp ^ temp >>> 32);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Planet other = (Planet) obj;
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        if (packages == null) {
            if (other.packages != null) {
                return false;
            }
        } else if (!packages.equals(other.packages)) {
            return false;
        }
        if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x)) {
            return false;
        }
        if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y)) {
            return false;
        }
        return true;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public List<Package> getPackages() {
        return packages;
    }

    public void setPackages(List<Package> packages) {
        this.packages = packages;
    }
}
