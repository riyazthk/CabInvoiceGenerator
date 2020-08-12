package cabinvoice;


public class CabInvoiceService {

    private final RideRepository rideRepository;
    private final int time = 1;
    private final double distance = 10;

    public CabInvoiceService() {
        this.rideRepository = new RideRepository();
    }


    public double calculateFare(double kilometer, double minutes) {


        double calculateFare = kilometer * distance + minutes * time;
        if (calculateFare < 5)
            return calculateFare = 5;

        return calculateFare;
    }

    public InvoiceSummary calculateFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += this.calculateFare(ride.distance, ride.time);
        }
        return new InvoiceSummary(rides.length, totalFare);
    }

    public void addRides(String userId, Ride[] rides) {
        rideRepository.addRide(userId, rides);
    }

    public InvoiceSummary getInvoiceSummary(String userId) {
        return this.calculateFare(rideRepository.getRides(userId));
    }
}
