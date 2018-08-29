import enums.SlotCapacityType;

public class ParkingSlot {
    private int slotNumber;
    private SlotCapacityType aCapacityType;
    private Vehicle vehicle;


    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public SlotCapacityType getCapacityType() {
        return aCapacityType;
    }

    public ParkingSlot(int slotNumber, SlotCapacityType aCapacityType) {
        this.slotNumber = slotNumber;
        this.aCapacityType = aCapacityType;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}
