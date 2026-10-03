import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

//This is not final i still have to put my sources (everything works fine though) so just dont submit this ^^

/**
 * FlightDataFetcher connects to the Aviationstack API to capture live,
 * real-time flight data.
 *
 * @author Joshua Castro
 * @version 1.0
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
            // Convert the endpoint string into a URL object that can be used to route traffic
            URL url = new URL(ENDPOINT);
            //opens a connection to a specified URL. cast that to httpURLconnection to access
            //features like request methods and status codes
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            //tells server to read data
            conn.setRequestMethod("GET");

            int responseCode = conn.getResponseCode();

            if (responseCode == 200) {
                // Read the incoming live data stream, line by line
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String line;

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                // display success message and output the captured data
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
    }
}
