import cabinvoice.CabInvoiceGenerator;
import org.junit.Assert;
import org.junit.Test;

public class CabInvoiceGeneratorTest {
    @Test
    public void calculateFareForToGetTotalAmountAtEndOfTheMonthReturnAsInvoice() {
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        double record = cabInvoiceGenerator.calculateFare(5, 20);
        Assert.assertEquals(70, record,0.0);
    }

    @Test
    public void calculateFareForToGetTotalAmountAtEndOfTheMonthReturnAsInvoices() {
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        double record = cabInvoiceGenerator.calculateFare(0.5, 2);
        Assert.assertEquals(5.0, record,0.0);
    }
}
