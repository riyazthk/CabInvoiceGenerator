package cabinvoice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RideRepository {
    Map<String, ArrayList<Ride>> userRides=null;
    public RideRepository(){
        this.userRides=new HashMap<>();
    }

    public void addRide(String userId, Ride[] rides) throws InvoiceGenerateException {
        if(userId==null || userId.equals("")){
            throw new InvoiceGenerateException("userId should not be empty or notnull",InvoiceGenerateException.ExceptionType.USER_ID_BE_A_NOTNULL_OR_NOTEMPTY);
        }
        ArrayList<Ride>rideList=this.userRides.get(userId);
        if(rideList==null){
            this.userRides.put(userId,new ArrayList<>(Arrays.asList(rides)));
        }
    }

    public Ride[] getRides(String userId) {
        return this.userRides.get(userId).toArray(new Ride[0]);
    }
}
