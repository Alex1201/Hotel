package Service;
import Domain.*;
import Repository.*;

import java.awt.print.Book;
import java.util.*;

public class BookingService {
    private BookingRepository repository;

    /**
     * Instantare booking service
     * @param repository
     */
    public BookingService(BookingRepository repository){
        this.repository = repository;
    }

    /**
     * Adaugare booking in lista
     * @param ID
     * @param nrPersoane
     * @param nrCamera
     * @param nrZile
     * @param rating
     * @param feedback
     * @param leftRoom
     */
    public void startBooking(int ID, int nrPersoane, int nrCamera, int nrZile, int rating, String feedback, boolean leftRoom){
        for(Booking c : repository.getAll()){
            if(c.getID() == ID && !c.isLeftRoom()){
                throw new RuntimeException("The room is busy.");
            }
        }
        Booking booking = new Booking(ID, nrPersoane, nrCamera, nrZile, rating, feedback, leftRoom);
        repository.add(booking);
    }

    /**
     * Remove booking id
     * @param id
     * @param nrCamera
     * @param rating
     * @param feedback
     */
    public void endBooking(int id ,int nrCamera, int rating, String feedback){
        if (rating < 1 || rating > 5) throw  new RuntimeException("Rating must be between 1 and 5.");
        if (feedback.length() <= 0) throw  new RuntimeException("Please leave a feedback.");

        for (Booking c : repository.getAll()){
            if (c.getID() == id){
                c.setFeedback(feedback);
                c.setRating(rating);
                c.isLeftRoom();
                repository.update(c);
            }
        }
        throw new RuntimeException("No booking for room ID.");
    }

    /**
     *
     * @return List of view models ordered descendingly by average stand prices
     */
    public List<ReportViewModel> getReport(){

        //Group rating by  room id
        Map<Integer, List<Integer>> roomGroups = new HashMap<>();
        for (Booking c: repository.getAll()){
            if(c.isLeftRoom()){
                int roomNr = c.getNrCamera();
                if (roomGroups.containsKey(roomNr)){
                    roomGroups.get(roomNr).add(c.getRating());
                }else {
                    List<Integer> firstPrice = new ArrayList<>();
                    firstPrice.add(c.getRating());
                    roomGroups.put(roomNr, firstPrice);
                }
            }
        }

        List<ReportViewModel> result = new ArrayList<>();
        for (Integer id : roomGroups.keySet()){
            double average = 0;
            for (int rating : roomGroups.get(id)){
                average += rating;
            }
            average /= roomGroups.get(id).size();
            result.add(new ReportViewModel(id, average));
        }
        result.sort((a1, a2) -> a1.getAverageRating() > a2.getAverageRating() ? -1 : 0);
        return result;
    }
}
