package Repository;
import Domain.*;
import java.util.*;

public class BookingRepository {

    private List<Booking> bookings = new ArrayList<>();
    private Validator validator;

    /**
     * Instantiere repository
     * @param validator
     */
    public BookingRepository(Validator validator){
        this.validator = validator;
    }

    /**
     * Search by id
     * @param id
     * @return
     */
    private Booking searchID(int id){
        for(Booking c : bookings){
            if(c.getID() == id){
                return c;
            }
        }
        return null;
    }

    /**
     * Add a booking
     * @param booking
     */
    public void add(Booking booking){
        if(searchID(booking.getID()) != null){
            throw new RuntimeException("Booking ID already exists.");
        }
        validator.validate(booking);
        bookings.add(booking);
    }

    /**
     * Update a booking
      * @param booking
     */
    public void update(Booking booking){
        Booking existBooking = searchID(booking.getID());
        if(existBooking == null){
            throw new RuntimeException("Booking ID does not exist.");
        }

        validator.validate(booking);
        for(int i=0; i<bookings.size(); i++){
            if (bookings.get(i).getID() == existBooking.getID()){
                bookings.set(i, booking);
                return;
            }
        }
    }

    public List<Booking> getAll(){
        return bookings;
    }
}
