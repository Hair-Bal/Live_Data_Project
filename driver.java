import java.util.ArrayList;
public class driver{
     /** 
     * Main method to test and demonstrate raw data capture.
     *
     * @param args Command line arguments
     */
public static void main(String[] args) {
        System.out.println("Fetching live flight data from Aviationstack...");
                /**
         * Works with Flight and FlightDataSeparator to output the data in a readable way
         * for loop that loops through each slight, printing appropriate information
         * @Author Zach Baird
         * @Author Jack Martin
         */
        String data = FlightDataFetcher.fetchLiveFlightData();
        ArrayList<Flight> flights = FlightDataSeparator.separateFlights(data);
        UserDisplay userDisplay = new UserDisplay();
        //"i" represents the current flight being printed in the loop
        for (int i = 0; i < flights.size(); i++) {

            System.out.println("====Flight " + (i + 1) + "====" );

            System.out.println("Date: "
                    + flights.get(i).getFlightDate());

            System.out.println("Status: "
                    + flights.get(i).getStatus());

            System.out.println("Airline: "
                    + flights.get(i).getAirline());

            System.out.println("Departure Airport: "
                    + flights.get(i).getDepartureAirport());
                
            System.out.println("Departure Time: " 
                + flights.get(i).getDepartureTime());
            
            System.out.println("Arrival Time: " 
                + flights.get(i).getArrivalTime());

            System.out.println("Arrival Airport: " 
                + flights.get(i).getArrivalAirport());
        }
    
    }
}