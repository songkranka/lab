package th.co.pt.ptgapp.dao.task;

public class TripDto {

    private String tripId;
    private String tripName;

    public TripDto() {
    }

    public TripDto(String tripId, String tripName) {
        this.tripId = tripId;
        this.tripName = tripName;
    }

    public String getTripId() {
        return tripId;
    }

    public void setTripId(String tripId) {
        this.tripId = tripId;
    }

    public String getTripName() {
        return tripName;
    }

    public void setTripName(String tripName) {
        this.tripName = tripName;
    }
}
