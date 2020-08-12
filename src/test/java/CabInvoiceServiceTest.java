import cabinvoice.CabInvoiceService;
import cabinvoice.InvoiceSummary;
import cabinvoice.Ride;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CabInvoiceServiceTest {
    public int time;
    public double distance;
    CabInvoiceService cabInvoiceService = null;


    @Before
    public void setup() {
        cabInvoiceService = new CabInvoiceService();
    }

    @Test
    public void givenKilometerAndMin_ShouldReturnCalculateFares() {
        CabInvoiceService cabInvoiceService = new CabInvoiceService();
        double fare = cabInvoiceService.calculateFare(3, 4);
        Assert.assertEquals(34, fare, 0.0);

    }

    @Test
    public void givenKilometerAndMin_ShouldReturnTotalFares() {
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)};
        InvoiceSummary summary = cabInvoiceService.calculateFare(rides);
        InvoiceSummary expected = new InvoiceSummary(2, 30.0);
        Assert.assertEquals(expected, summary);

    }

    @Test
    public void givenKilometerAndMin_ShouldReturn() {
        String userId = "Riyaz";
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)};
        cabInvoiceService.addRides(userId, rides);
        InvoiceSummary summary = cabInvoiceService.calculateFare(rides);
        InvoiceSummary expected = new InvoiceSummary(2, 30.0);
        Assert.assertEquals(expected, summary);

    }

}
