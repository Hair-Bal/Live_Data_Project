import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
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
        panel.setLayout(new FlowLayout(1, 1, 1));
  
        
        frame.setTitle("Flight Tracker");
        frame.setSize(350, 400);
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        airlineLabel = new JLabel("Enter Airline Name:");
        airlineLabel.setBounds(10, 20, 20, 25);
        panel.add(airlineLabel);

        airlineTextField = new TextField(20);
        airlineTextField.setPreferredSize(new Dimension(10, 5));
        airlineTextField.setBounds(10, 30, 20, 25);
        panel.add(airlineTextField);

        statusLabel = new JLabel("Enter Flight Status:");
        statusLabel.setBounds(10, 40, 20, 25);
        panel.add(statusLabel);

        statusTextField = new TextField(20);
        statusTextField.setPreferredSize(new Dimension(10, 5));
        statusTextField.setBounds(10, 50, 20, 25);
        panel.add(statusTextField);

        dateLabel = new JLabel("Enter Flight Date:");
        dateLabel.setBounds(10, 60, 20, 25);
        panel.add(dateLabel);

        dateTextField = new TextField(20);
        dateTextField.setPreferredSize(new Dimension(10, 5));
        dateTextField.setBounds(10, 70, 20, 25);
        panel.add(dateTextField);

        departureAirportLabel = new JLabel("Enter Departure Airport:");
        departureAirportLabel.setBounds(20, 30, 20, 25);
        panel.add(departureAirportLabel);

        departureAirportTextField = new TextField(20);
        departureAirportTextField.setPreferredSize(new Dimension(10, 5));
        departureAirportTextField.setBounds(20, 40, 20, 25);
        panel.add(departureAirportTextField);

        departureTimeLabel = new JLabel("Enter Departure Time:");
        departureTimeLabel.setBounds(20, 70, 20, 25);
        panel.add(departureTimeLabel);

        departureTimeTextField = new TextField(20);
        departureTimeTextField.setPreferredSize(new Dimension(10, 5));
        departureTimeTextField.setBounds(20, 80, 20, 25);
        panel.add(departureTimeTextField);

        arrivalAirportLabel = new JLabel("Enter Arrival Airport:");
        arrivalAirportLabel.setBounds(30, 30, 20, 25);
        panel.add(arrivalAirportLabel);

        arrivalAirportTextField = new TextField(20);
        arrivalAirportTextField.setPreferredSize(new Dimension(10, 5));
        arrivalAirportTextField.setBounds(30, 40, 20, 25);
        panel.add(arrivalAirportTextField);

        arrivalTimeLabel = new JLabel("Enter Arrival Time:");
        arrivalTimeLabel.setBounds(30, 70, 20, 25);
        panel.add(arrivalTimeLabel);

        arrivalTimeTextField = new TextField(20);
        arrivalTimeTextField.setPreferredSize(new Dimension(10, 5));
        arrivalTimeTextField.setBounds(30, 80, 20, 25);
        panel.add(arrivalTimeTextField);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        count++;
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}
