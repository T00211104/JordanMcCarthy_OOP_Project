package SalesSYS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class QueryProductGUI extends JFrame {



    public QueryProductGUI() {
        super("Query Products");

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
        setSize(250,300);
        setVisible(true);
        setResizable(false);

    }

    public static void main(String args[]) throws Exception {
        Object QueryProductGUI = new QueryProductGUI();
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

        JLabel titleLabel = new JLabel("Query Product Details");
        titleLabel.setFont(new Font("serif", Font.PLAIN, 15));

        jpanel.add(titleLabel);

        return jpanel;
    }

    private JPanel createDetailsPanel() {
        JPanel jpanel = new JPanel();
        jpanel.setLayout(new GridBagLayout());

        return jpanel;
    }

    public Component createSubmitPanel() {
        JPanel jpanel = new JPanel();

        JButton btnQueryProduct = new JButton("Query Product");

        btnQueryProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Product p1 = new Product(1,"Maxiflex Gloves","MaxiFlex",15,"A Breathable glove that provides protection and grip",3);
                Product p2 = new Product(2,"DEWALT CHALLENGER 3 SAFETY BOOT","DEWALT",3,"Waterproof Brown Safety Boots",150);
                Product p3 = new Product(3,"MOLDEX 2405 MASK,Manufacturer","MOLDEX",15,"Classic FFP-Mask: perfect fit without nose clip",4);
                Product p4 = new Product(4,"BOLLE TRACKER SAFETY GLASSES","Bolle",6,"The Bolle Tracker Safety Glasses are designed to protect against mechanical and chemical risks",15);
                Product p5 = new Product(5,"BIZWELD NAVY BOILERSUIT","BIZWELD",4," Clever design features include flame resistant reflective tape",45);
                ArrayList<Product> allProducts = new ArrayList<Product>(Arrays.asList(p1, p2, p3, p4, p5));

                try {
                    Product at;
                    String allProductData = "";

                    Iterator<Product> iterator = allProducts.iterator();

                    while (iterator.hasNext()) {
                        at = iterator.next();
                        if (at != null)
                            allProductData += at + "\n";
                    }
                    JOptionPane.showMessageDialog(null, allProductData, "List of all Clients", JOptionPane.INFORMATION_MESSAGE);


                } catch (NumberFormatException nfe) {
                } catch (IllegalArgumentException iae) {
                    if (iae.getMessage().contains("0"))
                        JOptionPane.showMessageDialog(null, iae.getMessage(),
                                "Invalid ProductID", JOptionPane.ERROR_MESSAGE);
                    else if (iae.getMessage().contains(""))
                        JOptionPane.showMessageDialog(null, iae.getMessage(),
                                "Invalid Name", JOptionPane.ERROR_MESSAGE);
                    else if (iae.getMessage().contains(""))
                        JOptionPane.showMessageDialog(null, iae.getMessage(),
                                "Invalid Manufacturer", JOptionPane.ERROR_MESSAGE);
                    else if (iae.getMessage().contains(""))
                        JOptionPane.showMessageDialog(null, iae.getMessage(),
                                "Invalid Quantity", JOptionPane.ERROR_MESSAGE);
                    else if (iae.getMessage().contains(""))
                        JOptionPane.showMessageDialog(null, iae.getMessage(),
                                "Invalid Description", JOptionPane.ERROR_MESSAGE);
                    else
                        JOptionPane.showMessageDialog(null, iae.getMessage(),
                                "Invalid Price", JOptionPane.ERROR_MESSAGE);
                }
            }

        });
        jpanel.add(btnQueryProduct);

        return jpanel;
    }
}
