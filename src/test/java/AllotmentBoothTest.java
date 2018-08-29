import enums.SlotCapacityType;
import enums.VehicleType;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Optional;

public class AllotmentBoothTest {
    @Test

    public void itShouldBeAbleToAllotASlotToAVehicle() {
        //given
        ArrayList<ParkingSlot> parkingSlots = new ArrayList<>();
        ParkingSlot aParkingSlot1 = new ParkingSlot(4, SlotCapacityType.LARGE);
        ParkingSlot aParkingSlot2 = new ParkingSlot(2, SlotCapacityType.MEDIUM);
        ParkingSlot aParkingSlot3 = new ParkingSlot(3, SlotCapacityType.SMALL);
        Vehicle aVehicle =  new Vehicle("1234abcd", VehicleType.LARGE);
        parkingSlots.add(aParkingSlot1);
        parkingSlots.add(aParkingSlot2);
        parkingSlots.add(aParkingSlot2);
        AllotmentBooth anAllotmentBooth = new AllotmentBooth(parkingSlots);

        //when
        anAllotmentBooth.allotSlot(aVehicle);
        //then
        ArrayList<ParkingSlot> slots = anAllotmentBooth.getParkingSlots();
        long count = slots.stream().filter(slot -> slot.getVehicle() != null).count();
        Assert.assertEquals(1 , count);
    }

    @Test
    public void itShouldAllotALargeVehicleToALargeSlotOnly() {
        //given
        ArrayList<ParkingSlot> parkingSlots = new ArrayList<>();
        ParkingSlot aParkingSlot1 = new ParkingSlot(4, SlotCapacityType.LARGE);
        ParkingSlot aParkingSlot2 = new ParkingSlot(2, SlotCapacityType.MEDIUM);
        ParkingSlot aParkingSlot3 = new ParkingSlot(3, SlotCapacityType.SMALL);
        Vehicle aVehicle =  new Vehicle("1234abcd", VehicleType.LARGE);
        parkingSlots.add(aParkingSlot3);
        parkingSlots.add(aParkingSlot2);
        parkingSlots.add(aParkingSlot1);
        AllotmentBooth anAllotmentBooth = new AllotmentBooth(parkingSlots);
        //when
        anAllotmentBooth.allotSlot(aVehicle);
        //then
        ArrayList<ParkingSlot> slots = anAllotmentBooth.getParkingSlots();
        Optional<ParkingSlot> allotedSlot = slots.stream().filter((slot) -> slot.getVehicle() == aVehicle).findFirst();
        Assert.assertEquals(SlotCapacityType.LARGE, allotedSlot.get().getCapacityType());
    }

    @Test
    public void itCanAllotASmallVehicleToASmallOrLargeOrMediumSlot() {
        //given
        ArrayList<ParkingSlot> parkingSlots = new ArrayList<>();
        ParkingSlot aParkingSlot1 = new ParkingSlot(4, SlotCapacityType.LARGE);
        ParkingSlot aParkingSlot2 = new ParkingSlot(2, SlotCapacityType.MEDIUM);
        Vehicle aVehicle =  new Vehicle("1224r", VehicleType.SMALL);
        parkingSlots.add(aParkingSlot2);
        parkingSlots.add(aParkingSlot1);
        AllotmentBooth anAllotmentBooth = new AllotmentBooth(parkingSlots);
        //when
        anAllotmentBooth.allotSlot(aVehicle);
        //then
        ArrayList<ParkingSlot> slots = anAllotmentBooth.getParkingSlots();
        Optional<ParkingSlot> allotedSlot = slots.stream().filter((slot) -> slot.getVehicle() == aVehicle).findFirst();
        Assert.assertEquals(SlotCapacityType.MEDIUM, allotedSlot.get().getCapacityType());
    }
}
