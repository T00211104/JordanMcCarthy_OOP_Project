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
import java.util.Iterator;

//QueryClientGUI.java
/*This GUI class implements JFrame. The GUI Class displays a JOptionPane
*which displays a button which will retrieves all the Client details and
*displays in a JOptionPane*/

public class QueryClientGUI extends JFrame {

    public QueryClientGUI() {
        super("Query Clients");

        JPanel jpanel = new JPanel();
        jpanel.setLayout(new BoxLayout(jpanel, BoxLayout.Y_AXIS));

        jpanel.add(Box.createVerticalStrut(50));
        jpanel.add(createTitlePanel());
        jpanel.add(createDetailsPanel());
        jpanel.add(Box.createVerticalStrut(40));
        jpanel.add(createSubmitPanel());
        jpanel.add(Box.createVerticalStrut(20));

        add(jpanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(225,200);
        setVisible(true);
        setResizable(false);

    }

    public static void main(String[] args) {
        QueryClientGUI qc = new QueryClientGUI();
    }

    private class WindowEventHandler implements WindowListener {

        public void windowOpened(WindowEvent e) {
            JOptionPane.showMessageDialog(null, "Window now opened", "Window Opened",
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
            JOptionPane.showMessageDialog(null, "Query Client Window Closed", "Query Client Window Closed",
                    JOptionPane.INFORMATION_MESSAGE);

            MainMenu mnu = new MainMenu();
        }

        @Override
        public void windowIconified(WindowEvent e) {
            JOptionPane.showMessageDialog(null, "Query Client Window Minimised", "Query Client Window Minimised",
                    JOptionPane.INFORMATION_MESSAGE);
        }

        @Override
        public void windowDeiconified(WindowEvent e) {
            JOptionPane.showMessageDialog(null, "Query Client Window Unminimised", "Query Client Window Unminimised",
                    JOptionPane.INFORMATION_MESSAGE);

            MainMenu Main = new MainMenu();
        }

        @Override
        public void windowActivated(WindowEvent e) {
            System.out.println("Query Client Window Activated");
        }

        @Override
        public void windowDeactivated(WindowEvent e) {
            System.out.println("Query Client Window Deactivated");
        }
    }

    private JPanel createTitlePanel() {
        JPanel jpanel = new JPanel();

        JLabel titleLabel = new JLabel("Query Client Details");
        titleLabel.setFont(new Font("serif", Font.PLAIN, 15));

        jpanel.add(titleLabel);

        return jpanel;
    }

    private JPanel createDetailsPanel() {
        JPanel jpanel = new JPanel();
        jpanel.setLayout(new GridBagLayout());


        return jpanel;
    }

    private void addComponent(Container container, Component component,
                              int gridx, int gridy, int gridwidth, int gridheight,
                              Insets insets, int anchor, int fill) {

        GridBagConstraints gbc = new GridBagConstraints(gridx, gridy,
                gridwidth, gridheight, 0.0, 0.0, anchor, fill, insets, 5, 5);

        container.add(component, gbc);
    }

    public Component createSubmitPanel() {
        JPanel jpanel = new JPanel();

        JButton btnQueryClient = new JButton("Query Client");

        btnQueryClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Client c1 = new Client(1, "Michael", "McGinn", "0871234567", new GregorianCalendar(2006, 9, 15));
                Client c2 = new Client(2, "Margaret", "Flaherty", "0872345678", new GregorianCalendar(2007, 3, 17));
                Client c3 = new Client(3, "Tyrone", "Mitchell", "0873456789", new GregorianCalendar(2090, 5, 13));
                Client c4 = new Client(4, "Margaret", "Flaherty", "0872345678", new GregorianCalendar(2017, 1, 18));
                Client c5 = new Client(5, "Margaret", "Flaherty", "0872345678", new GregorianCalendar(2015, 13, 2));
                ArrayList<Client> allClients = new ArrayList<Client>(Arrays.asList(c1, c2, c3, c4, c5));

                try {
                    Client at;
                    String allClientData = "";

                    Iterator<Client> iterator = allClients.iterator();

                    while (iterator.hasNext()) {
                        at = iterator.next();
                        if (at != null)
                            allClientData += at + "\n";
                    }
                    JOptionPane.showMessageDialog(null, allClientData, "List of all Clients", JOptionPane.INFORMATION_MESSAGE);


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
                                "Invalid Phone No", JOptionPane.ERROR_MESSAGE);
                    else
                        JOptionPane.showMessageDialog(null, iae.getMessage(),
                                "Invalid Date Registered", JOptionPane.ERROR_MESSAGE);
                }
            }

        });
        jpanel.add(btnQueryClient);

        return jpanel;
    }
}

//using an iterator here just for practice (could have easily done without it in this case)
   /* Iterator<Product> iterator = allProducts.iterator();

        while(iterator.hasNext()) {
        pr = iterator.next();
        if (pr != null)
            allProductData += pr + "\n";
    }

        JOptionPane.showMessageDialog(null,allProductData,"List of all Products",JOptionPane.INFORMATION_MESSAGE);*/
