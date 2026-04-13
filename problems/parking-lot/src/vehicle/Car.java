package vehicle;

public class Car implements Vehicle {

    private String licensePlate;

    public Car(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    @Override
    public String getLicencePlate() {
        return licensePlate;
    }

    @Override
    public VehicleSize getSize() {
        return VehicleSize.MEDIUM;
    }
}
