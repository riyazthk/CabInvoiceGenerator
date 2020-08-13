package cabinvoice;


public class CabInvoiceService {

    private final RideRepository rideRepository;
    //    private  int time=1 ;
//    private  double distance=10 ;
    private int minutes;
    private double kilometer;

    public CabInvoiceService() {
        this.rideRepository = new RideRepository();
        this.kilometer = 10;
        this.minutes = 1;
    }

    public CabInvoiceService(double distance, int time) {
        this.rideRepository = new RideRepository();
        this.kilometer = distance;
        this.minutes = time;
    }


    public double calculateFare(double distance, double time) {
        double minimumFare;
        if (kilometer == 10) {
            minimumFare = 5;
        } else {
            minimumFare = 20;
        }
        double calculateFare = kilometer * distance + minutes * time;
        if (calculateFare < minimumFare)
            return calculateFare = minimumFare;

        return calculateFare;
    }

    public InvoiceSummary calculateFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += this.calculateFare(ride.distance, ride.time);
        }
        return new InvoiceSummary(rides.length, totalFare);
    }

    public void addRides(String userId, Ride[] rides) throws InvoiceGenerateException {
        rideRepository.addRide(userId, rides);
    }

    public InvoiceSummary getInvoiceSummary(String userId) {
        return this.calculateFare(rideRepository.getRides(userId));
    }
}
