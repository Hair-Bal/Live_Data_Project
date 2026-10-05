/**
 * Stores Info about an individual flight received from the Aviationstack API
 *
 * @author Zach Baird
 * @version 1.0
 */
public class Flight {
    private String flightDate;
    private String status;
    private String airline;
    private String flightNumber;
    private String departureAirport;
    private String departureTime;
    private String arrivalAirport;
    private String arrivalTime;

    /**
     *
     *Creates a Flight object containing information about a flight.
     *
     *@param flightDate the date of the flight
     *@param status the current status of the flight
     *@param airline the name of the airline
     *@param flightNumber the flight number
     *@param departureAirport the airport where the flight departs
     *@param departureTime the scheduled departure time
     *@param arrivalAirport the airport where the flight arrives
     *@param arrivalTime the scheduled arrival time
     */
    public Flight(String flightDate, String status, String airline,
                  String flightNumber, String departureAirport,
                  String departureTime, String arrivalAirport,
                  String arrivalTime) {

        this.flightDate = flightDate;
        this.status = status;
        this.airline = airline;
        this.flightNumber = flightNumber;
        this.departureAirport = departureAirport;
        this.departureTime = departureTime;
        this.arrivalAirport = arrivalAirport;
        this.arrivalTime = arrivalTime;
    }

    /**
     * Gets the date of the flight.
     *
     * @return the flight date
     */
    public String getFlightDate() {
        return flightDate;
    }

    /**
     * Gets the current status of the flight.
     *
     * @return the flight status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Gets the name of the airline operating the flight.
     *
     * @return the airline name
     */
    public String getAirline() {
        return airline;
    }

    /**
     * Gets the flight number.
     *
     * @return the flight number
     */
    public String getFlightNumber() {
        return flightNumber;
    }

    /**
     * Gets the departure airport.
     *
     * @return the departure airport
     */
    public String getDepartureAirport() {
        return departureAirport;
    }

    /**
     * Gets the scheduled departure time.
     *
     * @return the departure time
     */
    public String getDepartureTime() {
        return departureTime;
    }

    /**
     * Gets the arrival airport.
     *
     * @return the arrival airport
     */
    public String getArrivalAirport() {
        return arrivalAirport;
    }

    /**
     * Gets the scheduled arrival time.
     *
     * @return the arrival time
     */
    public String getArrivalTime() {
        return arrivalTime;
    }
    
}
