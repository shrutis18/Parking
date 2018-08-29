import enums.SlotCapacityType;
import enums.VehicleType;

import java.util.ArrayList;

public class AllotmentBooth {
    private Vehicle aVehicle;
    private ArrayList<ParkingSlot> parkingSlots;

    public AllotmentBooth(ArrayList<ParkingSlot> parkingSlots) {
        this.parkingSlots = parkingSlots;
    }

    public void allotSlot(Vehicle aVehicle) {
        ParkingSlot freeSlot = parkingSlots.stream().filter(slot -> (slot.getVehicle() == null &&  feasibleSlot(slot, aVehicle) != null)).findFirst().get();
        freeSlot.setVehicle(aVehicle);
    }

    private ParkingSlot feasibleSlot(ParkingSlot slot, Vehicle aVehicle) {
        ParkingSlot feasibleSlot = null;
        if(aVehicle.getVehicleType() == VehicleType.LARGE &&  slot.getCapacityType() == SlotCapacityType.LARGE){
            feasibleSlot = slot;
        }
        else if(aVehicle.getVehicleType() == VehicleType.MEDIUM && (slot.getCapacityType() == SlotCapacityType.MEDIUM || slot.getCapacityType() == SlotCapacityType.LARGE) ){
            feasibleSlot= slot;
        }
        else if(aVehicle.getVehicleType() == VehicleType.SMALL && (slot.getCapacityType() == SlotCapacityType.SMALL || slot.getCapacityType() == SlotCapacityType.MEDIUM || slot.getCapacityType() == SlotCapacityType.LARGE )){
            feasibleSlot= slot;
        }
        return feasibleSlot;
    }

    public ArrayList<ParkingSlot> getParkingSlots() {
        return parkingSlots;
    }
}
