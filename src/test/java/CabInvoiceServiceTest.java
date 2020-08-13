import cabinvoice.CabInvoiceService;
import cabinvoice.InvoiceGenerateException;
import cabinvoice.InvoiceSummary;
import cabinvoice.Ride;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CabInvoiceServiceTest {
    public int time;
    public double distance;
    CabInvoiceService cabInvoiceService = null;
    CabInvoiceService invoiceService = null;

    @Before
    public void setup() {
        cabInvoiceService = new CabInvoiceService();
        invoiceService = new CabInvoiceService(distance, time);
    }

    @Test
    public void givenKilometerAndMin_ShouldReturnCalculateFares() {
        this.setup();
        double fare = cabInvoiceService.calculateFare(3, 4);
        Assert.assertEquals(34, fare, 0.0);

    }

    @Test
    public void givenKilometerAndMin_ShouldReturnTotalFares() {
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)};
        this.setup();
        InvoiceSummary summary = cabInvoiceService.calculateFare(rides);
        InvoiceSummary expected = new InvoiceSummary(2, 30.0);
        Assert.assertEquals(expected, summary);

    }

    @Test
    public void givenKilometerAndMin_ShouldReturn() throws InvoiceGenerateException {
        String userId = "Riyaz";
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)};
        this.setup();
        cabInvoiceService.addRides(userId, rides);
        InvoiceSummary summary = cabInvoiceService.calculateFare(rides);
        InvoiceSummary expected = new InvoiceSummary(2, 30.0);
        Assert.assertEquals(expected, summary);


    }

    @Test
    public void givenUserIdAsNull_ShouldThrownAnException() {
        try {
            String userId = null;
            Ride[] rides = {new Ride(2.0, 5),
                    new Ride(0.1, 1)};
            this.setup();
            cabInvoiceService.addRides(userId, rides);
            InvoiceSummary summary = cabInvoiceService.calculateFare(rides);
            InvoiceSummary expected = new InvoiceSummary(2, 30.0);
            Assert.assertEquals(expected, summary);
        } catch (InvoiceGenerateException e) {
            Assert.assertEquals(InvoiceGenerateException.ExceptionType.USER_ID_BE_A_NOTNULL_OR_NOTEMPTY, e.type);
        }

    }

    @Test
    public void givenUserIdAsEmpty_ShouldThrowAnException() {
        try {
            String userId = "";
            Ride[] rides = {new Ride(2.0, 5),
                    new Ride(0.1, 1)};
            this.setup();
            cabInvoiceService.addRides(userId, rides);
            InvoiceSummary summary = cabInvoiceService.calculateFare(rides);
            InvoiceSummary expected = new InvoiceSummary(2, 30.0);
            Assert.assertEquals(expected, summary);
        } catch (InvoiceGenerateException e) {
            Assert.assertEquals(InvoiceGenerateException.ExceptionType.USER_ID_BE_A_NOTNULL_OR_NOTEMPTY, e.type);
        }

    }

    @Test
    public void givenUserSelectThePremiumPackageAsNormalRideShouldReturnTotalFare() throws InvoiceGenerateException {
        String userId = "riyaz";
        distance = 10;
        time = 1;
        this.setup();
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)};
        invoiceService.addRides(userId, rides);
        InvoiceSummary summary = invoiceService.calculateFare(rides);
        InvoiceSummary expected = new InvoiceSummary(2, 30.0);
        Assert.assertEquals(expected, summary);
    }

    @Test
    public void givenUserSelectThePremiumPackageAsPremiumRideShouldReturnTotalFare() throws InvoiceGenerateException {
        String userId = "riyaz";
        distance = 15;
        time = 2;
        this.setup();
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)};
        invoiceService.addRides(userId, rides);
        InvoiceSummary summary = invoiceService.calculateFare(rides);
        InvoiceSummary expected = new InvoiceSummary(2, 60.0);
        Assert.assertEquals(expected, summary);

    }
}