import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class UserDisplay  implements ActionListener {
    private int count = 0;
    private JButton button;
    private JFrame frame;
    private JPanel panel;
    /*labels and text fields for each element in a flight object
     *@author Jack Martin
     */
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



    public UserDisplay() {
        frame = new JFrame();
        panel = new JPanel();

        panel.setBorder(BorderFactory.createEmptyBorder(50, 50, 20, 30));
        panel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
  
        
        frame.setTitle("Flight Tracker");
        frame.setSize(350, 400);
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        airlineLabel = new JLabel("Enter Airline Name:");
        panel.add(airlineLabel);

        airlineTextField = new TextField(20);
        airlineTextField.setPreferredSize(new Dimension(10, 5));
        panel.add(airlineTextField);

        statusLabel = new JLabel("Enter Flight Status:");
        panel.add(statusLabel);

        statusTextField = new TextField(20);
        statusTextField.setPreferredSize(new Dimension(10, 5));
        panel.add(statusTextField);

        dateLabel = new JLabel("Enter Flight Date:");
        panel.add(dateLabel);

        dateTextField = new TextField(20);
        dateTextField.setPreferredSize(new Dimension(10, 5));
        panel.add(dateTextField);

        departureAirportLabel = new JLabel("Enter Departure Airport:");
        panel.add(departureAirportLabel);

        departureAirportTextField = new TextField(20);
        departureAirportTextField.setPreferredSize(new Dimension(10, 5));
        panel.add(departureAirportTextField);

        departureTimeLabel = new JLabel("Enter Departure Time:");
        panel.add(departureTimeLabel);

        departureTimeTextField = new TextField(20);
        departureTimeTextField.setPreferredSize(new Dimension(10, 5));
        panel.add(departureTimeTextField);

        arrivalAirportLabel = new JLabel("Enter Arrival Airport:");
        panel.add(arrivalAirportLabel);

        arrivalAirportTextField = new TextField(20);
        arrivalAirportTextField.setPreferredSize(new Dimension(10, 5));
        panel.add(arrivalAirportTextField);

        arrivalTimeLabel = new JLabel("Enter Arrival Time:");
        panel.add(arrivalTimeLabel);

        arrivalTimeTextField = new TextField(20);
        arrivalTimeTextField.setPreferredSize(new Dimension(10, 5));
        panel.add(arrivalTimeTextField);
        
        button = new JButton("Filter");
        button.addActionListener(this);
        panel.add(button);
        //this is a test
        String data = FlightDataFetcher.fetchLiveFlightData();
        //this is a test
        ArrayList<Flight> flights = FlightDataSeparator.separateFlights(data);
        JTextArea outputTextArea = new JTextArea(20,20);
        //this is a test
        for (int i = 0; i < flights.size(); i++){
            outputTextArea.append("====Flight " + (i + 1) + "====" );

            outputTextArea.append("Date: "
                    + flights.get(i).getFlightDate());

            outputTextArea.append("Date: "
                    + flights.get(i).getStatus());

            outputTextArea.append("Airline: "
                    + flights.get(i).getAirline());

            outputTextArea.append("Departure Airport: "
                    + flights.get(i).getDepartureAirport());

            outputTextArea.append("Departure Time: "
                    + flights.get(i).getDepartureTime());

            outputTextArea.append("Arrival Time: "
                    + flights.get(i).getArrivalTime());

            outputTextArea.append("Arrival Airport: "
                    + flights.get(i).getArrivalAirport()+"\n");


        }
        outputTextArea.setLineWrap(true);
        outputTextArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(outputTextArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        frame.add(scrollPane, BorderLayout.SOUTH);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        count++;
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}
