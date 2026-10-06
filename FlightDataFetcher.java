import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * FlightDataFetcher connects to the Aviationstack API to capture live,
 * real-time flight data.
 *
 * Sources Used:
 * - BufferedReader: https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/io/BufferedReader.html
 * - InputStreamReader: https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/io/InputStreamReader.html
 * - HttpURLConnection: https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/net/HttpURLConnection.html
 *
 * @author Joshua Castro
 * @version 1.4
 */
public class FlightDataFetcher {
    private static final String API_KEY = "8cba4fee8bf8894b74d3cb2b88cb6bed";
    private static final String ENDPOINT = "https://api.aviationstack.com/v1/flights?access_key=" + API_KEY;

    /**
     * Connects to the Aviationstack REST API via HTTP GET and fetches
     * the raw live JSON flight data.
     *
     * @return A String containing the raw JSON response of active flights
     */
    public static String fetchLiveFlightData() {
        StringBuilder response = new StringBuilder();

        try {
            // Convert the endpoint string into a URL object
            URL url = new URL(ENDPOINT);
            //open http connection to make request parameters and response codes.
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            //tells server to read data
            conn.setRequestMethod("GET");

            int responseCode = conn.getResponseCode();

            if (responseCode == 200) {
                // Read the live data
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String line;

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                // display success message & output the captured data
                System.out.println("Live Aviation Data Successfully Captured:");
                System.out.println(response.toString());

            } else {
                System.out.println("API request failed with HTTP error code: " + responseCode);
                System.out.println("Please check your API access key or internet connection.");
            }

        } catch (Exception e) {
            //if crashes, errors, prints this
            System.out.println("An error occurred during data capture:");
            //print the exact error for debugging
            e.printStackTrace();
        }

        return response.toString();
    }

    /**
     * Main method to test and demonstrate raw data capture.
     *
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Fetching live flight data from Aviationstack...");
        fetchLiveFlightData();
                /**
         * Works with Flight and FlightDataSeparator to output the data in a readable way
         * for loop that loops through each slight, printing appropriate information
         * @Author Zach Baird
         * @Author Jack Martin
         */
        String data = fetchLiveFlightData();
        ArrayList<Flight> flights = FlightDataSeparator.separateFlights(data);
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
