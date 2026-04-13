package parkingspot;

import vehicle.Vehicle;
import vehicle.VehicleSize;

public interface ParkingSpot {

    public boolean isAvailable();

    public void occupy(Vehicle vehicle);

    public void vacate();

    public int getSpotNumber();

    public VehicleSize getVehicleSize();
}
