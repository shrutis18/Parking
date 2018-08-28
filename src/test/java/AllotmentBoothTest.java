import enums.SlotCapacityType;
import enums.VehicleType;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
        AllotmentBooth anAllotmentBooth = new AllotmentBooth(parkingSlots,aVehicle);

        //when
        anAllotmentBooth.allotSlotToAVehicle(aVehicle);
        //then
       // Assert.assertEquals(aParkingSlot1.getVehicle() , aVehicle);
    }
}
