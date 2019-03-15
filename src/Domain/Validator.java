package Domain;

public class Validator {

    /**
     * Booking validation
     * @param booking
     */
    public void validate(Booking booking){

        String error = "";
        if(booking.getNrPersoane() == 0){
            error += "Room not available. Select a different room.";
        }

        if(booking.getNrZile() <= 0){
            error += "The days number must be positive.";
        }

        if(!error.equals("")){
            throw new RuntimeException();
        }
    }
}
