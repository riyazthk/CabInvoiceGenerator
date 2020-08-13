package cabinvoice;

public enum CabRide {
    NORMAL(10.0,1.0,5.0),PREMIUM(15.0,2.0,20);
    private final double costPerKm;
    private final double costPerMin;
    private final double minFare;

    CabRide(double costPerKm,double costPerMin,double minFare){
        this.costPerKm=costPerKm;
        this.costPerMin=costPerMin;
        this.minFare=minFare;
    }

    public double calCostOf(Ride rides) {
        double calculateFare = costPerKm * rides.distance+ costPerMin * rides.time;
        return calculateFare;
    }
}
