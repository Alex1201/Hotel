package UI;
import Domain.*;
import Service.*;
import java.util.*;

public class Console {
    private BookingService service;
    private Scanner input = new Scanner(System.in);

    public Console(BookingService service){
        this.service = service;
    }

    private  void menu(){
        System.out.println("\n1. Add a booking.");
        System.out.println("2. End a booking.");
        System.out.println("3. Show rating report.");
        System.out.println("4. Quit.");
        System.out.println("Your Option.");
    }

    private void bookingEntry(){
        System.out.println("\nInsert ID: ");
        int bookingID = input.nextInt();
        System.out.println("Room#: ");
        int roomNr = input.nextInt();
        System.out.println("People#: ");
        int peopleNr = input.nextInt();
        System.out.println("Days#: ");
        int daysNr = input.nextInt();

        try {
            service.startBooking(bookingID, roomNr, peopleNr, daysNr,0,"",false);
            System.out.println("Booking started!");
        }catch (RuntimeException ex){
            System.out.println("Error appeared.");
            System.out.println(ex.getMessage());
        }
    }

    private void bookingExit(){
        System.out.println("\nInsert ID: ");
        int bookingID = input.nextInt();
        System.out.println("\nRoom#: ");
        int roomNr = input.nextInt();
        System.out.println("Rating: ");
        int rating = input.nextInt();
        System.out.println("Feedback: ");
        String feedback = new Scanner(System.in).nextLine();
        System.out.println();

        try {
            service.endBooking(bookingID, roomNr,rating, feedback);
            System.out.println("Booking ended.");
            System.out.println();
        } catch (RuntimeException ex){
            System.out.println("Error appeared.");
            System.out.println(ex.getMessage());
            System.out.println();
        }
    }

    private void report(){
        List<ReportViewModel> roomReports = service.getReport();
        System.out.println("Rooms average ratings\n=============");
        for (ReportViewModel roomReport : roomReports){
            System.out.println(String.format("Room: %d - Average Rating: %f", roomReport.getRoomID(), roomReport.getAverageRating()));
        }
    }

    public void run(){
        while (true){
            menu();
            int option = input.nextInt();
            if(option == 1){
                bookingEntry();
            }else if(option == 2){
                bookingExit();
            }else if (option == 3){
                report();
            }else if(option == 0){
                break;
            }else {
                System.out.println("Invalid option.");
            }
        }
    }
}
