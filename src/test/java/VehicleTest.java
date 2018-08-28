import enums.VehicleType;
import org.junit.Assert;
import org.junit.Test;

public class VehicleTest {
    @Test
    public void itShouldHaveAVehicleNumber() {
        //given
        String aVehicleNumber = "1234ABCD";
        Vehicle aVehicle = new Vehicle(aVehicleNumber, VehicleType.MEDIUM);
        //when
        String vehicleNumber = aVehicle.getVehicleNumber();
        //then
        Assert.assertEquals(aVehicleNumber,vehicleNumber);
    }

    @Test
    public void itShouldHaveAVehicleType() {
        //given
        String aVehicleNumber = "1234ABCD";
        Vehicle aVehicle = new Vehicle(aVehicleNumber, VehicleType.SMALL);
        //when
        VehicleType aVehicleType =  aVehicle.getVehicleType();
        //then
        Assert.assertEquals(VehicleType.SMALL,aVehicleType);

    }
}
