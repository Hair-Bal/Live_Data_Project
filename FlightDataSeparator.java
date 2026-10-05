import java.util.ArrayList;

/**
 * Separates individual flight information from the raw JSON data
 * returned by the Aviationstack API.
 *
 * @author Zach Baird
 */
public class FlightDataSeparator {

    /**
     * Separates the raw Aviationstack API response into individual
     * flight objects and stores them in an ArrayList.
     *
     * @param data the raw JSON data returned by the Aviationstack API
     * @return an ArrayList containing the Flight objects found in the data
     */
    public static ArrayList<Flight> separateFlights(String data) {

        ArrayList<Flight> flights = new ArrayList<>();

        int dataStart = data.indexOf("\"data\"");

        if (dataStart == -1) {
            return flights;
        }

        int arrayStart = data.indexOf("[", dataStart);
        int arrayEnd = data.lastIndexOf("]");

        if (arrayStart == -1 || arrayEnd == -1) {
            return flights;
        }

        String flightData = data.substring(arrayStart + 1, arrayEnd);

        int position = 0;

        while (position < flightData.length()) {

            int flightStart = flightData.indexOf("{", position);

            if (flightStart == -1) {
                break;
            }

            int flightEnd = findClosingBrace(flightData, flightStart);

            if (flightEnd == -1) {
                break;
            }

            String singleFlight =
                    flightData.substring(flightStart, flightEnd + 1);

            flights.add(separateFlight(singleFlight));

            position = flightEnd + 1;
        }

        return flights;
    }



    /**
     * Finds the closing brace that matches the opening brace
     * of an individual flight object.
     *
     * @param data the flight data being searched
     * @param start the position of the opening brace
     * @return the position of the matching closing brace, or -1
     *         if no matching brace is found
     */
    private static int findClosingBrace(String data, int start) {

        int braceCount = 0;
        boolean insideQuotes = false;

        for (int i = start; i < data.length(); i++) {

            char current = data.charAt(i);

            if (current == '"') {
                insideQuotes = !insideQuotes;
            }

            if (!insideQuotes) {

                if (current == '{') {
                    braceCount++;
                }

                if (current == '}') {
                    braceCount--;

                    // The braces are balanced
                    if (braceCount == 0) {
                        return i;
                    }
                }
            }
        }

        return -1;
    }


    /**
     * Separates the information contained in a single flight
     * and creates a Flight object from that information.
     *
     * @param data the JSON data for one individual flight
     * @return a Flight object containing the separated flight information
     */
    public static Flight separateFlight(String data) {

        String flightDate = getValue(data, "flight_date");

        String status = getValue(data, "flight_status");

        String departure = getSection(data, "departure");
        String arrival = getSection(data, "arrival");
        String airline = getSection(data, "airline");
        String flight = getSection(data, "flight");

        String departureAirport =
                getValue(departure, "airport");

        String departureTime =
                getValue(departure, "scheduled");

        String arrivalAirport =
                getValue(arrival, "airport");

        String arrivalTime =
                getValue(arrival, "scheduled");

        String airlineName =
                getValue(airline, "name");

        String flightNumber =
                getValue(flight, "number");

        return new Flight(
                flightDate,
                status,
                airlineName,
                flightNumber,
                departureAirport,
                departureTime,
                arrivalAirport,
                arrivalTime
        );
    }



    /**
     * Finds a specific section of information within the flight data.
     * For example, this method can find the departure or arrival section.
     *
     * @param data the flight data being searched
     * @param section the name of the section to find
     * @return a String containing the requested section, or an empty
     *         String if the section cannot be found
     */
    public static String getSection(String data, String section) {

        int sectionStart =
                data.indexOf("\"" + section + "\"");

        if (sectionStart == -1) {
            return "";
        }

        int start =
                data.indexOf("{", sectionStart);

        if (start == -1) {
            return "";
        }

        int end =
                findClosingBrace(data, start);

        if (end == -1) {
            return "";
        }

        return data.substring(start, end + 1);
    }


    /**
     * Finds the value associated with a specific field in the
     * flight data.
     *
     * @param data the flight data being searched
     * @param field the name of the field to find
     * @return the value associated with the field, or "Not found"
     *         if the field does not exist
     */
    public static String getValue(String data, String field) {

        int fieldPosition =
                data.indexOf("\"" + field + "\"");

        if (fieldPosition == -1) {
            return "Not found";
        }

        int colonPosition =
                data.indexOf(":", fieldPosition);

        if (colonPosition == -1) {
            return "Not found";
        }

        int startQuote =
                data.indexOf("\"", colonPosition);

        if (startQuote == -1) {
            return "Not found";
        }

        int endQuote =
                data.indexOf("\"", startQuote + 1);

        if (endQuote == -1) {
            return "Not found";
        }

        return data.substring(
                startQuote + 1,
                endQuote
        );
    }
}

