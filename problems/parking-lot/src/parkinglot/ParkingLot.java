package parkinglot;

import fare.FareCalculator;
import parkingspot.ParkingSpot;
import ticket.Ticket;
import vehicle.Vehicle;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class ParkingLot {
    private final ParkingManager parkingManager;
    private final FareCalculator fareCalculator;

    public ParkingLot(ParkingManager parkingManager, FareCalculator fareCalculator) {
        this.parkingManager = parkingManager;
        this.fareCalculator = fareCalculator;
    }

    public Ticket parkVehicle(Vehicle vehicle) {
        ParkingSpot parkingSpot = parkingManager.parkVehicle(vehicle);
        if (parkingSpot != null) {
            return new Ticket(generateTicketId(), vehicle, parkingSpot,
                    LocalDateTime.now());
        } else {
            return null;
        }
    }

    public BigDecimal unparkVehicle(Ticket ticket) {
        if (ticket != null) {
            ticket.setExitTime(LocalDateTime.now());
            parkingManager.unparkVehicle(ticket.getVehicle());

            return fareCalculator.calculateFare(ticket);
        }

        return BigDecimal.ZERO;
    }

    private String generateTicketId() {
        return "TKT" + UUID.randomUUID().toString();
    }
}
