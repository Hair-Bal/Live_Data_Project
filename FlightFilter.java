/**
 * FlightFilter stores searched items entered by the user through the UI
 * and evaluates whether a specific Flight matches those criteria.
 *
 * @author Joshua Castro
 * @version 1.2
 */
public class FlightFilter {
    private String airlineName;
    private String flightStatus;
    private String flightDate;
    private String departureAirport;
    private String departureTime;
    private String arrivalAirport;
    private String arrivalTime;

    /**
     * Empty constructor allows the UI to create a blank filter
     * and set variables as the user types them in.
     */
    public FlightFilter() {
        this.airlineName = "";
        this.flightStatus = "";
        this.flightDate = "";
        this.departureAirport = "";
        this.departureTime = "";
        this.arrivalAirport = "";
        this.arrivalTime = "";
    }
    //setters
    public void setAirlineName(String airlineName) { this.airlineName = airlineName; }
    public void setFlightStatus(String flightStatus) { this.flightStatus = flightStatus; }
    public void setFlightDate(String flightDate) { this.flightDate = flightDate; }
    public void setDepartureAirport(String departureAirport) { this.departureAirport = departureAirport; }
    public void setDepartureTime(String departureTime) { this.departureTime = departureTime; }
    public void setArrivalAirport(String arrivalAirport) { this.arrivalAirport = arrivalAirport; }
    public void setArrivalTime(String arrivalTime) { this.arrivalTime = arrivalTime; }

    //getters
    public String getAirlineName() { return airlineName; }
    public String getFlightStatus() { return flightStatus; }
    public String getFlightDate() { return flightDate; }
    public String getDepartureAirport() { return departureAirport; }
    public String getDepartureTime() { return departureTime; }
    public String getArrivalAirport() { return arrivalAirport; }
    public String getArrivalTime() { return arrivalTime; }

    /**
     * compares the user's filter criteria against a Flight object.
     * If a filter variable is empty, it skips that specific check.
     *
     * @param flight The Flight object to check
     * @return true if the flight matches all entered criteria, false otherwise
     */
    public boolean matches(Flight flight) {
        if (!airlineName.isEmpty() && !flight.getAirline().equalsIgnoreCase(airlineName)) return false;
        if (!flightStatus.isEmpty() && !flight.getStatus().equalsIgnoreCase(flightStatus)) return false;
        if (!flightDate.isEmpty() && !flight.getFlightDate().equalsIgnoreCase(flightDate)) return false;
        if (!departureAirport.isEmpty() && !flight.getDepartureAirport().equalsIgnoreCase(departureAirport)) return false;
        if (!departureTime.isEmpty() && !flight.getDepartureTime().equalsIgnoreCase(departureTime)) return false;
        if (!arrivalAirport.isEmpty() && !flight.getArrivalAirport().equalsIgnoreCase(arrivalAirport)) return false;
        if (!arrivalTime.isEmpty() && !flight.getArrivalTime().equalsIgnoreCase(arrivalTime)) return false;

        return true;
    }
}
