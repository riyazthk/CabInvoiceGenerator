package cabinvoice;

public class InvoiceSummary {
    public double totalAverage;
    private  int numOfRide;
    private double totalFare;

    public InvoiceSummary(int numOfRide, double totalFare) {
    this.numOfRide=numOfRide;
    this.totalFare=totalFare;
    this.totalAverage=totalFare/numOfRide;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o)return true;
        if(o==null || getClass()!=o.getClass())return false;
        InvoiceSummary that=(InvoiceSummary) o;
        return numOfRide == that.numOfRide &&
                Double.compare(that.totalFare,totalFare)==0 &&
                Double.compare(that.totalAverage,totalAverage)==0;
    }
}
