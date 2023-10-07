package dto.bookerApiRequests;

import lombok.Data;

@Data
public class CreatingBookingRequest {

    private String firstname;
    private String lastname;
    private String additionalneeds;
    private int totalprice;
    private boolean depositpaid;
    private Bookingdates bookingdates;

    @Data
    public static class Bookingdates{
        private String checkin;
        private String checkout;
    }


}
