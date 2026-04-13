package parkinglot;

import parkingspot.ParkingSpot;
import vehicle.Vehicle;
import vehicle.VehicleSize;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingManager {
    private Map<VehicleSize, List<ParkingSpot>> availableSpots;
    private Map<Vehicle, ParkingSpot> vehicleToSpotMap;
    private Map<ParkingSpot, Vehicle> spotToVehicleMap;

    public ParkingManager(Map<VehicleSize, List<ParkingSpot>> availableSpots) {
        this.availableSpots = availableSpots;
        this.vehicleToSpotMap = new HashMap<>();
        this.spotToVehicleMap = new HashMap<>();
    }

    public ParkingSpot findSpotForVehicle(Vehicle vehicle) {
        VehicleSize vehicleSize = vehicle.getSize();

        for (VehicleSize size : VehicleSize.values()) {
            if (size.ordinal() >= vehicleSize.ordinal()) {
                List<ParkingSpot> parkingSpots = availableSpots.get(size);
                for (ParkingSpot parkingSpot : parkingSpots) {
                    if (parkingSpot.isAvailable()) {
                        return parkingSpot;
                    }
                }
            }
        }

        return null;
    }

    public ParkingSpot parkVehicle(Vehicle vehicle) {
        ParkingSpot spot = findSpotForVehicle(vehicle);
        if (spot != null) {
            spot.occupy(vehicle);
            vehicleToSpotMap.put(vehicle, spot);
            spotToVehicleMap.put(spot, vehicle);
            availableSpots.get(spot.getVehicleSize()).remove(spot);
            return spot;
        }

        return null;
    }

    public void unparkVehicle(Vehicle vehicle) {
        ParkingSpot spot = vehicleToSpotMap.get(vehicle);
        if (spot != null) {
            spot.vacate();
            vehicleToSpotMap.remove(vehicle);
            spotToVehicleMap.remove(spot);
            availableSpots.get(spot.getVehicleSize()).add(spot);
        }
    }
}
