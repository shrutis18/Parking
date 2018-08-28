import enums.SlotCapacityType;

public class ParkingSlot {
    private int slotNumber;
    private SlotCapacityType aCapacityType;

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
}
