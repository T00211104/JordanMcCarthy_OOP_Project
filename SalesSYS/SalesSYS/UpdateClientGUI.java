package SalesSYS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
//UpdateClient.java
/*This GUI class is used to Update a clients details using JFrame. Also attributes being
 ClientID, firstName, lastName, PhoneNo and date Registered, that are retrieved from the Client.java. This GUI displays a JOptionPane
  and gives the user the attributes boxes so he/she can input into the textFields, the GUI then displays
   the details and is updated in the system.*/

public class UpdateClientGUI extends JFrame {
    private final Insets normalInsets = new Insets(5, 10, 0, 10);
    private final Insets topInsets = new Insets(5, 110, 0, 0);
    private JTextField ClientIDField;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField phoneNoField;
    private JTextField dateRegisteredField;


    public UpdateClientGUI() {
        super("Query Client Details");

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(Box.createVerticalStrut(60));
        panel.add(createTitlePanel());
        panel.add(createDetailsPanel());
        panel.add(Box.createVerticalStrut(40));
        panel.add(createSubmitPanel());
        panel.add(Box.createVerticalStrut(20));

        add(panel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,375);
        setVisible(true);
        setResizable(false);

    }

    public static void main(String[] args) { Object UpdateClientGUI = new UpdateClientGUI();}

    private class WindowEventHandler implements WindowListener {

        public void windowOpened(WindowEvent e) {
            JOptionPane.showMessageDialog(null, "Update Client Window now opened", "Window Opened",
                    JOptionPane.INFORMATION_MESSAGE);
        }

        public void windowClosing(WindowEvent e) {
            JOptionPane.showMessageDialog(null, "Now closing window", "Closing Window",
                    JOptionPane.INFORMATION_MESSAGE);
            int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit this application?", "Exiting Application Confirmation",
                    JOptionPane.YES_NO_CANCEL_OPTION);

            if (choice == JOptionPane.YES_OPTION)
                dispose();
        }

        @Override
        public void windowClosed(WindowEvent e) {
            JOptionPane.showMessageDialog(null, "Update Client Window Closed", "Update Client Window Closed",
                    JOptionPane.INFORMATION_MESSAGE);

            MainMenu mnu = new MainMenu();
        }

        @Override
        public void windowIconified(WindowEvent e) {
            JOptionPane.showMessageDialog(null, "Update Client Window Minimised", "Update Client Window Minimised",
                    JOptionPane.INFORMATION_MESSAGE);
        }

        @Override
        public void windowDeiconified(WindowEvent e) {
            JOptionPane.showMessageDialog(null, "Update Client Window Unminimised", "Update Client Window Unminimised",
                    JOptionPane.INFORMATION_MESSAGE);

            MainMenu Main = new MainMenu();
        }

        @Override
        public void windowActivated(WindowEvent e) {
            JOptionPane.showMessageDialog(null,"Update Client Window Activated","Update Client Window Opened",JOptionPane.INFORMATION_MESSAGE);
        }

        @Override
        public void windowDeactivated(WindowEvent e) {
            JOptionPane.showMessageDialog(null,"Update Client Window De-activated","Update Client Window Closed",JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private JPanel createTitlePanel() {
        JPanel panel = new JPanel();

        JLabel titleLabel = new JLabel("Query Client Details");
        titleLabel.setFont(new Font("serif", Font.PLAIN, 15));

        panel.add(titleLabel);

        return panel;
    }

    private JPanel createDetailsPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        int gridy = 0;

        JLabel ClientIDLabel = new JLabel("              ClientID:");
        addComponent(panel, ClientIDLabel, 0, gridy, 1, 1, normalInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        JTextField ClientIDField = new JTextField(8);
        addComponent(panel, ClientIDField, 0, gridy++, 1, 1, topInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        JLabel firstNameLabel = new JLabel("         First Name: ");
        addComponent(panel, firstNameLabel, 0, gridy, 1, 1, normalInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        firstNameField = new JTextField(5);
        addComponent(panel, firstNameField, 0, gridy++, 2, 1, topInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        JLabel lastNameLabel = new JLabel("         Last Name: ");
        addComponent(panel, lastNameLabel, 0, gridy, 1, 1, normalInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        lastNameField = new JTextField(1);
        addComponent(panel, lastNameField, 0, gridy++, 2, 1, topInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        JLabel phoneNoLabel = new JLabel("           Phone No: ");
        addComponent(panel, phoneNoLabel, 0, gridy, 1, 1, normalInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        phoneNoField = new JTextField(1);
        addComponent(panel, phoneNoField, 0, gridy++, 2, 1, topInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        JLabel dateRegisteredLabel = new JLabel("Date Registered: ");
        addComponent(panel, dateRegisteredLabel, 0, gridy, 1, 1, normalInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        dateRegisteredField = new JTextField("dd-mm-yyyy", 1);
        addComponent(panel, dateRegisteredField, 0, gridy, 2, 1, topInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        JButton dateRegisteredButton = new JButton("Date Registered");
        dateRegisteredButton.setPreferredSize(new Dimension(1, 1));
        addComponent(panel, dateRegisteredButton, 0, gridy++, 1, 1, topInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        return panel;
    }

    public void addComponent(Container container, Component component,
                             int gridx, int gridy, int gridwidth, int gridheight,
                             Insets insets, int anchor, int fill) {

        GridBagConstraints gbc = new GridBagConstraints(gridx, gridy,
                gridwidth, gridheight, 0.0, 0.0, anchor, fill, insets, 5, 5);

        container.add(component, gbc);
    }

    public Component createSubmitPanel() {
        JPanel jpanel = new JPanel();

        JButton btnUpdateClient = new JButton("Query Client");

        btnUpdateClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Client c1 = new Client(1, "Michael", "McGinn", "0871234567", new GregorianCalendar(2006, 9, 15));
                Client c2 = new Client(2, "Margaret", "Flaherty", "0872345678", new GregorianCalendar(2007, 03, 17));
                Client c3 = new Client(3, "Tyrone", "Mitchell", "0873456789", new GregorianCalendar(2090, 05, 13));
                Client c4 = new Client(4, "Margaret", "Flaherty", "0872345678", new GregorianCalendar(2017, 01, 18));
                Client c5 = new Client(5, "Margaret", "Flaherty", "0872345678", new GregorianCalendar(2015, 12, 2));
                ArrayList<Client> allClients = new ArrayList<Client>(Arrays.asList(c1, c2, c3, c4, c5));


                try {
                    int iD = 0;
                    String clientID = ClientIDField.getText();
                    if (clientID != null && !clientID.isEmpty()) {
                        iD = Integer.parseInt(clientID);
                    } else {
                        JOptionPane.showMessageDialog(null, "You did not enter a valid clientID", "Error!", JOptionPane.ERROR_MESSAGE);
                    }

                    String fName = firstNameField.getText();
                    if (fName != null && !fName.isEmpty()) {

                    } else {
                        JOptionPane.showMessageDialog(null, "You did not enter a valid first name", "Error!", JOptionPane.ERROR_MESSAGE);
                    }

                    String lName = lastNameField.getText();
                    if (lName != null && !lName.isEmpty()) {

                    } else {
                        JOptionPane.showMessageDialog(null, "You did not enter a valid last name", "Error!", JOptionPane.ERROR_MESSAGE);
                    }

                    String pNo = phoneNoField.getText();
                    if (pNo != null && !pNo.isEmpty()) {

                    } else {
                        JOptionPane.showMessageDialog(null, "You did not enter a valid Phone Number", "Error!", JOptionPane.ERROR_MESSAGE);
                    }


                    String dateReg = dateRegisteredField.getText();
                    if (dateReg != null && !dateReg.isEmpty()) {

                    } else {
                        JOptionPane.showMessageDialog(null, "You did not enter a valid Phone Number", "Error!", JOptionPane.ERROR_MESSAGE);
                    }

                    ArrayList<Client> foundClients = new ArrayList<Client>();
                    String searchKey = JOptionPane.showInputDialog("Please enter the ClientID you wish to update");

                    for (Client at: allClients)
                        if (at.getFirstName().toLowerCase().contains(searchKey.toLowerCase()))
                            foundClients.add(at);
                    String text = "";

                    for (Client at: allClients)
                        if (at.getLastName().toLowerCase().contains(searchKey.toLowerCase()))
                        {foundClients.add(at);
                            text += at + "\n";}


                    for (Client at : allClients)
                        if (at.getPhoneNo().contains(searchKey.toLowerCase()))
                        {foundClients.add(at);
                            text += at + "\n";}

                    int searchID = Integer.parseInt(JOptionPane.showInputDialog("The following matched your search phrase\n\n" + text +
                            "\n\nEnter the id of the one do you want to amend"));
                    Client ClientToAmend = null;
                    for (Client at : foundClients)
                        if (at != null && at.getClientID() == searchID)
                            ClientToAmend = at;

                    String amendChoice = JOptionPane.showInputDialog("The details of the product you wish to amend are:\n\n" +
                            ClientToAmend + "\n\n1.Amend First Name" + "\n\n2.Amend Last Name" +
                            "\n\n3.Amend Phone No" + "\n\n4.Amend Date Registered");

                    int amendChoiceAsInt = Integer.parseInt(amendChoice);
                    while (amendChoiceAsInt < 1 || amendChoiceAsInt > 5) {
                        amendChoice = JOptionPane.showInputDialog("The details of the Client you wish to amend are:\n\n" +
                                ClientToAmend + "\n\n1. Amend First Name" + "\n\n2.Amend Last Name" +
                                "\n\n3.Amend Phone No" + "\n\n4.Amend Date Registered" + "\n\n5. Cancel Amendment\n\nInvalid choice entered!!" +
                                "Must be a value between 1 and 3 inclusive");

                        amendChoiceAsInt = Integer.parseInt(amendChoice);
                    }
                    switch (amendChoice) {
                        case "1":
                            String newFName = JOptionPane.showInputDialog("Please enter a new first name for the client:");
                            ClientToAmend.setFirstName(newFName);
                            break;
                        case "2":
                            String newLastName = JOptionPane.showInputDialog("Please enter a new last name for the client:");
                            ClientToAmend.setLastName(newLastName);
                            break;
                        case "3":
                            String newPhoneNo = JOptionPane.showInputDialog("Please enter a new Phone Number for the client:");
                            ClientToAmend.setPhoneNo(newPhoneNo);

                            break;
                        case "4"://Dylan McCarthy helped with the date
                            int newDay = Integer.parseInt(JOptionPane.showInputDialog(null,"Please enter the new year registered for the client:","",JOptionPane.INFORMATION_MESSAGE));
                            int newMonth = Integer.parseInt(JOptionPane.showInputDialog(null,"Please enter the new year registered for the client:","",JOptionPane.INFORMATION_MESSAGE));
                            int newYear = Integer.parseInt(JOptionPane.showInputDialog(null,"Please enter the new year registered for the client:","",JOptionPane.INFORMATION_MESSAGE));
                            GregorianCalendar newDate = new GregorianCalendar(newYear,newMonth-1,newDay);
                            ClientToAmend.setDateRegistered(newDate);
                            break;
                        case "5":
                            break;
                    }
                    JOptionPane.showMessageDialog(null, "Client Details now amended!",
                            "Client amended", JOptionPane.INFORMATION_MESSAGE);
                    foundClients.clear();

                } catch (NumberFormatException nfe) {
                } catch (IllegalArgumentException iae) {
                    if (iae.getMessage().contains("0"))
                        JOptionPane.showMessageDialog(null, iae.getMessage(),
                                "Invalid ClientID", JOptionPane.ERROR_MESSAGE);
                    else if (iae.getMessage().contains(""))
                        JOptionPane.showMessageDialog(null, iae.getMessage(),
                                "Invalid First Name", JOptionPane.ERROR_MESSAGE);

                    else if (iae.getMessage().contains(""))
                        JOptionPane.showMessageDialog(null, iae.getMessage(),
                                "Invalid Last Name", JOptionPane.ERROR_MESSAGE);
                    else if (iae.getMessage().contains(""))
                        JOptionPane.showMessageDialog(null, iae.getMessage(),
                                "Invalid  Phone Number", JOptionPane.ERROR_MESSAGE);
                    else
                        JOptionPane.showMessageDialog(null, "The Date if Reservation must have day and months values that must be valid",
                                "Invalid Date", JOptionPane.ERROR_MESSAGE);
                }
            }});

        jpanel.add(btnUpdateClient);

        return jpanel;
    }
}