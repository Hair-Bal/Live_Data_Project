import java.util.ArrayList;

/**
 * driver class serves as the main for the Flight Tracker.
 * it fetches the live flight data from the API, goes through it, and initializes the UI.
 *
 * @author Zach Baird
 * @author Jack Martin
 * @author Joshua Castro
 */
public class driver{
    /**
     * Main method to capture raw data capture and launch the UI.
     *
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Fetching live flight data from Aviationstack...");

        // fetch and separate data once in driver
        String data = FlightDataFetcher.fetchLiveFlightData();
        ArrayList<Flight> flights = FlightDataSeparator.separateFlights(data);

        // pass the populated array to the UI class
        UserDisplay userDisplay = new UserDisplay(flights);

        for (int i = 0; i < flights.size(); i++) {
            System.out.println("====Flight " + (i + 1) + "====" );
            System.out.println("Date: " + flights.get(i).getFlightDate());
            System.out.println("Status: " + flights.get(i).getStatus());
            System.out.println("Airline: " + flights.get(i).getAirline());
            System.out.println("Departure Airport: " + flights.get(i).getDepartureAirport());
            System.out.println("Departure Time: " + flights.get(i).getDepartureTime());
            System.out.println("Arrival Time: " + flights.get(i).getArrivalTime());
            System.out.println("Arrival Airport: " + flights.get(i).getArrivalAirport());
        }
    }
}