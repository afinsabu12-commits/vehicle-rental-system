import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class VehicleRentalSystem extends JFrame implements ActionListener {

    JTextField nameField, daysField;
    JComboBox<String> vehicleBox;
    JTextArea outputArea;
    JButton calculateBtn;

    public VehicleRentalSystem() {

        setTitle("Vehicle Rental System");
        setSize(450, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));

        panel.add(new JLabel("Customer Name:"));
        nameField = new JTextField();
        panel.add(nameField);

        panel.add(new JLabel("Vehicle Type:"));
        vehicleBox = new JComboBox<>(new String[]{"Car", "Bike"});
        panel.add(vehicleBox);

        panel.add(new JLabel("Rental Days:"));
        daysField = new JTextField();
        panel.add(daysField);

        calculateBtn = new JButton("Calculate Rent");
        calculateBtn.addActionListener(this);
        panel.add(calculateBtn);

        add(panel, BorderLayout.NORTH);

        outputArea = new JTextArea();
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        setVisible(true);
    }

    // Create Table
    public static void createTable() {
        try {
            Connection con = DBConnection.getConnection();
            Statement stmt = con.createStatement();

            String sql = "CREATE TABLE IF NOT EXISTS rentals ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "customer_name TEXT,"
                    + "vehicle_type TEXT,"
                    + "days INTEGER,"
                    + "total_rent REAL)";

            stmt.execute(sql);
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            String name = nameField.getText();
            String vehicle = vehicleBox.getSelectedItem().toString();
            int days = Integer.parseInt(daysField.getText());

            if (name.isEmpty() || days <= 0) {
                throw new Exception("Invalid Input!");
            }

            double rate = 0;
            if (vehicle.equals("Car")) {
                rate = 1000;
            } else {
                rate = 500;
            }

            double totalRent = rate * days;

            outputArea.setText("Customer: " + name +
                    "\nVehicle: " + vehicle +
                    "\nDays: " + days +
                    "\nTotal Rent: ₹" + totalRent);

            // Insert into Database
            Connection con = DBConnection.getConnection();
            String query = "INSERT INTO rentals (customer_name, vehicle_type, days, total_rent) VALUES (?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, vehicle);
            ps.setInt(3, days);
            ps.setDouble(4, totalRent);

            ps.executeUpdate();
            con.close();

            JOptionPane.showMessageDialog(this, "Saved to Database!");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        createTable();
        new VehicleRentalSystem();
    }
}
