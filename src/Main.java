import Domain.*;
import Repository.*;
import Service.*;
import UI.*;

public class Main {

  public static void main (String args[]) {
      Validator validator = new Validator();
      BookingRepository bookingRepository = new BookingRepository(validator);
      BookingService bookingService = new BookingService(bookingRepository);
      Console console = new Console(bookingService);
      console.run();
  }
}
