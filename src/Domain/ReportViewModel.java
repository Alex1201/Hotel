package Domain;

public class ReportViewModel {
    private int roomID;
    private double averageRating;

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public ReportViewModel(int roomID, double averageRating) {
        this.roomID = roomID;
        this.averageRating = averageRating;
    }
}
