package Domain;

public class Booking {
    private int ID, nrPersoane, nrCamera, nrZile, rating;
    private String feedback;
    private boolean leftRoom;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getNrPersoane() {
        return nrPersoane;
    }

    public void setNrPersoane(int nrPersoane) {
        this.nrPersoane = nrPersoane;
    }

    public int getNrCamera() {
        return nrCamera;
    }

    public void setNrCamera(int nrCamera) {
        this.nrCamera = nrCamera;
    }

    public int getNrZile() {
        return nrZile;
    }

    public void setNrZile(int nrZile) {
        this.nrZile = nrZile;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public boolean isLeftRoom() {
        return leftRoom;
    }

    public void setLeftRoom(boolean leftRoom) {
        this.leftRoom = leftRoom;
    }

    public Booking(int ID, int nrPersoane, int nrCamera, int nrZile, int rating, String feedback, boolean leftRoom) {
        this.ID = ID;
        this.nrPersoane = nrPersoane;
        this.nrCamera = nrCamera;
        this.nrZile = nrZile;
        this.rating = rating;
        this.feedback = feedback;
        this.leftRoom = leftRoom;
    }
}
