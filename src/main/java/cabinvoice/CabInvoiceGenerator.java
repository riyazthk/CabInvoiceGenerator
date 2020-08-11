package cabinvoice;

public class CabInvoiceGenerator {
    public double calculateFare(double kilometer,double minutes) {
        int perKilometerCharge=10;
        int perMinuteCharge=1;
        double calulateFare=0;
        if(kilometer>1) {
            double calculateKilometer = kilometer * perKilometerCharge;
            double calculateMinutes = minutes * perMinuteCharge;
            calulateFare = calculateKilometer + calculateMinutes;
        }else{
            calulateFare=5;
        }
        return calulateFare;
    }
}
