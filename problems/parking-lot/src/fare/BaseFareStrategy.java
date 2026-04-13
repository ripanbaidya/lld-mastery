package fare;

import ticket.Ticket;

import java.math.BigDecimal;

public class BaseFareStrategy implements FareStrategy {

    private static final BigDecimal SMALL_VEHICLE_FARE = new BigDecimal("2.00");
    private static final BigDecimal MEDIUM_VEHICLE_FARE = new BigDecimal("4.00");
    private static final BigDecimal LARGE_VEHICLE_FARE = new BigDecimal("6.00");

    @Override
    public BigDecimal calculateFare(Ticket ticket, BigDecimal inputFare) {
        BigDecimal fare = inputFare;
        BigDecimal rate;

        switch (ticket.getVehicle().getSize()) {
            case SMALL -> rate = SMALL_VEHICLE_FARE;
            case MEDIUM -> rate = MEDIUM_VEHICLE_FARE;
            case LARGE -> rate = LARGE_VEHICLE_FARE;
            default -> throw new IllegalArgumentException("Unknown vehicle size");
        }

        fare = fare.add(rate.multiply(ticket.calculateParkingDuration()));
        return fare;
    }
}
