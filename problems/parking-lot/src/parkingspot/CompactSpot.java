package parkingspot;

import vehicle.Vehicle;
import vehicle.VehicleSize;

public class CompactSpot implements ParkingSpot{
    private int spotNumber;
    private Vehicle vehicle;

    public CompactSpot(int spotNumber, Vehicle vehicle) {
        this.spotNumber = spotNumber;
        this.vehicle = null;
    }

    @Override
    public boolean isAvailable() {
        return vehicle == null;
    }

    @Override
    public void occupy(Vehicle vehicle) {
        if (isAvailable()) {
            this.vehicle = vehicle;
        } else {
            // No spot
        }
    }

    @Override
    public void vacate() {
        this.vehicle = null;
    }

    @Override
    public int getSpotNumber() {
        return spotNumber;
    }

    @Override
    public VehicleSize getVehicleSize() {
        return VehicleSize.SMALL;
    }
}
