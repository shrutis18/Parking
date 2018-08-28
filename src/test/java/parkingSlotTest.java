import enums.SlotCapacityType;
import org.junit.Assert;
import org.junit.Test;

public class parkingSlotTest {
    @Test
    public void itShouldHaveASlotNumber(){
        //given
        ParkingSlot aParkingSlot = new ParkingSlot(1, SlotCapacityType.SMALL);
        //when
        int slotNumber = aParkingSlot.getSlotNumber();
        //then
        Assert.assertEquals(1,slotNumber);
    }

    @Test
    public void itShouldHaveACapcityType(){
        //given
        ParkingSlot aParkingSlot = new ParkingSlot(1, SlotCapacityType.SMALL);
        //when
        SlotCapacityType slotCapacityType = aParkingSlot.getCapacityType();
        //then
        Assert.assertEquals(SlotCapacityType.SMALL,slotCapacityType);
    }
}