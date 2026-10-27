import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * represents the graphical UI for the Flight Tracker.
 * displays live flight data and gives interactive text fields to filter the
 * results by specific flight properties.
 *
 * @author Jack Martin
 * @author Joshua Castro
 * @author Zach Baird
 */
public class UserDisplay implements ActionListener {
    private int count = 0;
    private JButton button;
    private JFrame frame;
    private JPanel panel;

    /** The list of active flights fetched from API */
    private ArrayList<Flight> flights;

    /** The text area where flight details are outputted */
    private JTextArea outputTextArea;

    private JLabel airlineLabel;
    private TextField airlineTextField;
    private JLabel dateLabel;
    private TextField dateTextField;
    private JLabel statusLabel;
    private TextField statusTextField;
    private JLabel departureAirportLabel;
    private TextField departureAirportTextField;
    private JLabel departureTimeLabel;
    private TextField departureTimeTextField;
    private JLabel arrivalAirportLabel;
    private TextField arrivalAirportTextField;
    private JLabel arrivalTimeLabel;
    private TextField arrivalTimeTextField;

    /**
     * Constructs user display interface and fills it with the initial flight data.
     *
     * @param flightData An ArrayList of Flight objects to be displayed and filtered
     */
    public UserDisplay(ArrayList<Flight> flightData) {
        this.flights = flightData;

        frame = new JFrame();
        panel = new JPanel();

        panel.setBorder(BorderFactory.createEmptyBorder(50, 50, 20, 30));
        panel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

        frame.setTitle("Flight Tracker");
        frame.setSize(350, 400);
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        airlineLabel = new JLabel("Enter Airline Name:");
        panel.add(airlineLabel);
        airlineTextField = new TextField(20);
        panel.add(airlineTextField);

        statusLabel = new JLabel("Enter Flight Status:");
        panel.add(statusLabel);
        statusTextField = new TextField(20);
        panel.add(statusTextField);

        dateLabel = new JLabel("Enter Flight Date:");
        panel.add(dateLabel);
        dateTextField = new TextField(20);
        panel.add(dateTextField);

        departureAirportLabel = new JLabel("Enter Departure Airport:");
        panel.add(departureAirportLabel);
        departureAirportTextField = new TextField(20);
        panel.add(departureAirportTextField);

        departureTimeLabel = new JLabel("Enter Departure Time:");
        panel.add(departureTimeLabel);
        departureTimeTextField = new TextField(20);
        panel.add(departureTimeTextField);

        arrivalAirportLabel = new JLabel("Enter Arrival Airport:");
        panel.add(arrivalAirportLabel);
        arrivalAirportTextField = new TextField(20);
        panel.add(arrivalAirportTextField);

        arrivalTimeLabel = new JLabel("Enter Arrival Time:");
        panel.add(arrivalTimeLabel);
        arrivalTimeTextField = new TextField(20);
        panel.add(arrivalTimeTextField);

        button = new JButton("Filter");
        button.addActionListener(this);
        panel.add(button);

        outputTextArea = new JTextArea(20,20);

        for (int i = 0; i < flights.size(); i++){
            outputTextArea.append("****Flight " + (i + 1) + "****\n" );
            outputTextArea.append("Date: " + flights.get(i).getFlightDate() + "\n");
            outputTextArea.append("Status: " + flights.get(i).getStatus() + "\n");
            outputTextArea.append("Airline: " + flights.get(i).getAirline() + "\n");
            outputTextArea.append("Departure Airport: " + flights.get(i).getDepartureAirport() + "\n");
            outputTextArea.append("Departure Time: " + flights.get(i).getDepartureTime() + "\n");
            outputTextArea.append("Arrival Time: " + flights.get(i).getArrivalTime() + "\n");
            outputTextArea.append("Arrival Airport: " + flights.get(i).getArrivalAirport() + "\n\n");
        }

        outputTextArea.setLineWrap(true);
        outputTextArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(outputTextArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        frame.add(scrollPane, BorderLayout.SOUTH);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /**
     * Handles the filter button click event. Captures user input from the text fields,
     * applies the properties to a FlightFilter, and updates the text area with matching flights.
     *
     * @param e Action Event triggered by clicking the filter button
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        count++;

        FlightFilter filter = new FlightFilter();
        filter.setAirlineName(airlineTextField.getText().trim());
        filter.setFlightStatus(statusTextField.getText().trim());
        filter.setFlightDate(dateTextField.getText().trim());
        filter.setDepartureAirport(departureAirportTextField.getText().trim());
        filter.setDepartureTime(departureTimeTextField.getText().trim());
        filter.setArrivalAirport(arrivalAirportTextField.getText().trim());
        filter.setArrivalTime(arrivalTimeTextField.getText().trim());

        outputTextArea.setText("");

        int flightCounter = 1;
        for (int i = 0; i < flights.size(); i++) {
            Flight current = flights.get(i);

            if (filter.matches(current)) {
                outputTextArea.append("****Flight " + flightCounter + "****\n" );
                outputTextArea.append("Date: " + current.getFlightDate() + "\n");
                outputTextArea.append("Status: " + current.getStatus() + "\n");
                outputTextArea.append("Airline: " + current.getAirline() + "\n");
                outputTextArea.append("Departure Airport: " + current.getDepartureAirport() + "\n");
                outputTextArea.append("Departure Time: " + current.getDepartureTime() + "\n");
                outputTextArea.append("Arrival Time: " + current.getArrivalTime() + "\n");
                outputTextArea.append("Arrival Airport: " + current.getArrivalAirport() + "\n\n");
                flightCounter++;
            }
        }

        if (flightCounter == 1) {
            outputTextArea.append("No flights matched the filter criteria.\n");
        }
    }
}