package hu.javachallenge.resteltmy.app.models;

import com.google.gson.Gson;

/**
 *
 * @author Baksa Tibor
 */
public class PickPackageModel {

    private PickPackageStatus status;
    private Integer remainingCapacity;

    public PickPackageStatus getStatus() {
        return status;
    }

    public void setStatus(PickPackageStatus status) {
        this.status = status;
    }

    public int getRemainingCapacity() {
        return remainingCapacity;
    }

    public void setRemainingCapacity(Integer remainingCapacity) {
        this.remainingCapacity = remainingCapacity;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
