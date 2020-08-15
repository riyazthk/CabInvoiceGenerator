import cabinvoice.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CabInvoiceServiceTest {

    Ride[] rides = null;
    CabInvoiceService cabInvoiceService = null;
    InvoiceSummary invoiceSummary = null;
    private RideRepository rideRepository = null;

    @Before
    public void setup() {
        cabInvoiceService = new CabInvoiceService();
        rideRepository = new RideRepository();
        cabInvoiceService.setRideRepository(rideRepository);
        rides = new Ride[]{
                new Ride(CabRide.NORMAL, 2.0, 5),
                new Ride(CabRide.PREMIUM, 0.1, 1)
        };

    }


    @Test
    public void givenRideListSelect_WhenCalculated_ThenShouldReturnInvoiceSummary() {
        Ride[] rides = {new Ride(CabRide.NORMAL, 2.0, 5),
                new Ride(CabRide.NORMAL, 0.1, 1)};
        InvoiceSummary summary = cabInvoiceService.calculateFare(rides);
        InvoiceSummary expected = new InvoiceSummary(2, 27.0);
        Assert.assertEquals(expected, summary);

    }

    @Test
    public void givenRidesListForUserId_WhenCalculated_ThenReturnInvoiceSummary() throws InvoiceGenerateException {
        String userId = "Riyaz";
        Ride[] rides = {new Ride(CabRide.NORMAL, 2.0, 5),
                new Ride(CabRide.PREMIUM, 0.1, 1)};
        cabInvoiceService.addRides(userId, rides);
        InvoiceSummary summary = cabInvoiceService.getInvoiceSummary(userId);
        InvoiceSummary expected = new InvoiceSummary(2, 28.5);
        Assert.assertEquals(expected, summary);


    }

    @Test
    public void givenUserIdAsNull_WhenCalculated_ShouldThrownAnException() {
        try {
            String userId = null;
            Ride[] rides = {new Ride(CabRide.NORMAL, 2.0, 5),
                    new Ride(CabRide.PREMIUM, 0.1, 1)};
            cabInvoiceService.addRides(userId, rides);
            InvoiceSummary summary = cabInvoiceService.getInvoiceSummary(userId);
            InvoiceSummary expected = new InvoiceSummary(2, 30.0);
            Assert.assertEquals(expected, summary);
        } catch (InvoiceGenerateException e) {
            Assert.assertEquals(InvoiceGenerateException.ExceptionType.USER_ID_BE_A_NOTNULL_OR_NOTEMPTY, e.type);
        }

    }

    @Test
    public void givenUserIdAsEmpty_WhenCalculated_ShouldThrowAnException() {
        try {
            String userId = "";
            Ride[] rides = {new Ride(CabRide.NORMAL, 2.0, 5),
                    new Ride(CabRide.PREMIUM, 0.1, 1)};
            this.setup();
            cabInvoiceService.addRides(userId, rides);
            InvoiceSummary summary = cabInvoiceService.getInvoiceSummary(userId);
            InvoiceSummary expected = new InvoiceSummary(2, 30.0);
            Assert.assertEquals(expected, summary);
        } catch (InvoiceGenerateException e) {
            Assert.assertEquals(InvoiceGenerateException.ExceptionType.USER_ID_BE_A_NOTNULL_OR_NOTEMPTY, e.type);
        }

    }

    @Test
    public void givenRideListForUserSelectPremiumAndNormalRide_WhenCalculated_ShouldReturnInvoiceSummary() throws InvoiceGenerateException {
        String userId = "riyaz";
        Ride[] rides = {new Ride(CabRide.NORMAL, 2.0, 5),
                new Ride(CabRide.PREMIUM, 0.1, 1)};
        cabInvoiceService.addRides(userId, rides);
        InvoiceSummary summary = cabInvoiceService.getInvoiceSummary(userId);
        InvoiceSummary expected = new InvoiceSummary(2, 28.5);
        Assert.assertEquals(expected, summary);
    }

    @Test
    public void givenUserSelectThePremiumAndNormalRide_WhenCalculated_ShouldReturnInvoiceSummary() throws InvoiceGenerateException {
        String userId = "riyaz";
        Ride[] rides = {new Ride(CabRide.NORMAL, 2.0, 5),
                new Ride(CabRide.PREMIUM, 0.1, 1)};
        cabInvoiceService.addRides(userId, rides);
        InvoiceSummary summary = cabInvoiceService.getInvoiceSummary(userId);
        InvoiceSummary expected = new InvoiceSummary(2, 28.5);
        Assert.assertEquals(expected, summary);

    }
}
