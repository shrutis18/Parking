import enums.VehicleType;

public class Vehicle {
    private VehicleType vehicleType;
    private String vehicleNumber;

    public Vehicle(String aVehicleNumber, VehicleType vehicleType) {
        this.vehicleNumber = aVehicleNumber;
        this.vehicleType = vehicleType;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
}
