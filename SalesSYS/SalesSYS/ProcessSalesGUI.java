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


/*This GUI */

public class ProcessSalesGUI extends JFrame{
     private final Insets normalInsets = new Insets(5,10,0,10);
     private final Insets topInsets = new Insets(5,110,0,10);
     private JTextField ProductIDField;
     private JTextField ClientIDField;
     private JTextField NameField;
     private JTextField QuantityField;


     public ProcessSalesGUI(){
         super("Process Sales");

         JPanel jPanel = new JPanel();
         jPanel.setLayout(new BoxLayout(jPanel,BoxLayout.Y_AXIS));

         jPanel.add(Box.createVerticalStrut(60));
         jPanel.add(createTitlePanel());
         jPanel.add(createDetailsPanel());
         jPanel.add(Box.createVerticalStrut(40));
         jPanel.add(createSubmitPanel());
         jPanel.add(Box.createVerticalStrut(20));

         add(jPanel);

         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setSize(400,400);
         setVisible(true);
         setResizable(false);
     }

    public static void main(String[] args) {
        Object ProcessSalesGUI = new ProcessSalesGUI();
    }

    private class WindowEventHandler implements WindowListener {

        public void windowOpened(WindowEvent e) {
            JOptionPane.showMessageDialog(null, "Process Sales Window now opened", "Window Opened",
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
            JOptionPane.showMessageDialog(null, "Process Sales Window Closed", "Process Sales Window Closed",
                    JOptionPane.INFORMATION_MESSAGE);

            MainMenu Main = new MainMenu();
        }

        @Override
        public void windowIconified(WindowEvent e) {
            JOptionPane.showMessageDialog(null, "Process Sales Window Minimised", "Process Sales Window Minimised",
                    JOptionPane.INFORMATION_MESSAGE);
        }

        @Override
        public void windowDeiconified(WindowEvent e) {
            JOptionPane.showMessageDialog(null, "Process Sales Window Unminimised", "Process Sales Window Unminimised",
                    JOptionPane.INFORMATION_MESSAGE);

            MainMenu Main = new MainMenu();
        }

        @Override
        public void windowActivated(WindowEvent e) {
            JOptionPane.showMessageDialog(null,"Process Sales Window Activated","Process Sales Window Opened",JOptionPane.INFORMATION_MESSAGE);
        }

        @Override
        public void windowDeactivated(WindowEvent e) {
            JOptionPane.showMessageDialog(null,"Process Sales Window De-activated","Process Sales Window Closed",JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private JPanel createTitlePanel() {
         JPanel jPanel = new JPanel();

         JLabel titleLabel = new JLabel("Process Sales");
         titleLabel.setFont(new Font("serif",Font.PLAIN,15));

         jPanel.add(titleLabel);

         return jPanel;
     }

    private JPanel createDetailsPanel() {
         JPanel jPanel = new JPanel();
         jPanel.setLayout(new GridBagLayout());

        int gridy = 0;

        JLabel ProductIDLabel = new JLabel("ProductID:");
        addComponent(jPanel,ProductIDLabel,0,gridy,1,1,normalInsets,
                GridBagConstraints.LINE_START,GridBagConstraints.HORIZONTAL);

        ProductIDField = new JTextField(10);
        addComponent(jPanel, ProductIDField,0,gridy++,1,1,topInsets,
                GridBagConstraints.LINE_START,GridBagConstraints.HORIZONTAL);

        JLabel ClientIDLabel = new JLabel("ClientID:");
        addComponent(jPanel,ClientIDLabel,0,gridy,1,1,normalInsets,
                GridBagConstraints.LINE_START,GridBagConstraints.HORIZONTAL);

        ClientIDField = new JTextField(10);
        addComponent(jPanel, ClientIDField,0,gridy++,1,1,topInsets,
                GridBagConstraints.LINE_START,GridBagConstraints.HORIZONTAL);

        JLabel NameLabel = new JLabel("Product Name:");
        addComponent(jPanel,NameLabel,0,gridy,1,1,normalInsets,
                GridBagConstraints.LINE_START,GridBagConstraints.HORIZONTAL);

        NameField = new JTextField(10);
        addComponent(jPanel, NameField,0,gridy++,1,1,topInsets,
                GridBagConstraints.LINE_START,GridBagConstraints.HORIZONTAL);

        JLabel QuantityLabel = new JLabel("Quantity:");
        addComponent(jPanel,QuantityLabel,0,gridy,1,1,normalInsets,
                GridBagConstraints.LINE_START,GridBagConstraints.HORIZONTAL);

        QuantityField = new JTextField(10);
        addComponent(jPanel, QuantityField,0,gridy++,1,1,topInsets,
                GridBagConstraints.LINE_START,GridBagConstraints.HORIZONTAL);

     return jPanel;
 }
    private void addComponent(Container container, Component component,
                              int gridx, int gridy, int gridwidth, int gridheight, Insets insets,
                              int anchor, int fill){

        GridBagConstraints gbc = new GridBagConstraints(gridx,gridy,
                1,1,0.0,0.0,anchor,fill,insets,5,5);

        container.add(component, gbc);
    }

    private JPanel createSubmitPanel(){

         JPanel jPanel = new JPanel();

    JButton ProcessSaleButton = new JButton("Checkout");

        ProcessSaleButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

                try {

                    int cID = 0;
                    String ClientID = ClientIDField.getText();
                    if (ClientID != "" && ClientID.isEmpty()) {
                        cID = Integer.parseInt(ClientID);
                    }

                    int pID = 0;
                    String ProductID = ProductIDField.getText();
                    if (ProductID != "" && ProductID.isEmpty()) {
                        pID = Integer.parseInt(ProductID);
                    }
                    String Name = NameField.getText();
                    if (Name != "" && Name.isEmpty()) {

                    }
                    int qty;
                    String Quantity = QuantityField.getText();
                    if (Quantity != "" && Quantity.isEmpty()) {
                        qty = Integer.parseInt(Quantity);
                    }


                    Client c1 = new Client(1, "Michael", "McGinn", "0871234567", new GregorianCalendar(2006, 01, 15));
                    Client c2 = new Client(2, "Margaret", "Flaherty", "0872345678", new GregorianCalendar(2007, 03, 17));
                    Client c3 = new Client(3, "Tyrone", "Mitchell", "0873456789", new GregorianCalendar(2090, 05, 13));
                    Client c4 = new Client(4, "Margaret", "Flaherty", "0874567891", new GregorianCalendar(2017, 01, 18));
                    Client c5 = new Client(5, "Margaret", "Flaherty", "0831353213", new GregorianCalendar(2015, 12, 2));
                    ArrayList<Client> allClients = new ArrayList<Client>(Arrays.asList(c1, c2, c3, c4, c5));

                    Product p1 = new Product(1, "Maxiflex Gloves", "MaxiFlex", 15, "A Breathable glove that provides protection and grip", 3);
                    Product p2 = new Product(2, "DEWALT CHALLENGER 3 SAFETY BOOT", "DEWALT", 3, "Waterproof Brown Safety Boots", 150);
                    Product p3 = new Product(3, "MOLDEX 2405 MASK,Manufacturer", "MOLDEX", 15, "Classic FFP-Mask: perfect fit without nose clip", 4);
                    Product p4 = new Product(4, "BOLLE TRACKER SAFETY GLASSES", "Bolle", 6, "The Bolle Tracker Safety Glasses are designed to protect against mechanical and chemical risks", 15);
                    Product p5 = new Product(5, "BIZWELD NAVY BOILERSUIT", "BIZWELD", 4, " Clever design features include flame resistant reflective tape", 45);
                    ArrayList<Product> allProducts = new ArrayList<Product>(Arrays.asList(p1, p2, p3, p4, p5));

                        JOptionPane.showMessageDialog(null, "Client details are added\n\nDetails are -  " + c1, "Added Client", JOptionPane.INFORMATION_MESSAGE);
                    } catch (NumberFormatException nfe) {
                        JOptionPane.showMessageDialog(null, "Form must be filled correctly", "Invalid Date Registered", JOptionPane.ERROR_MESSAGE);
                    } catch (IllegalArgumentException iae) {
                        if (iae.getMessage().contains("ClientID: "))
                            JOptionPane.showMessageDialog(null, iae.getMessage(), "Invalid First Name", JOptionPane.ERROR_MESSAGE);
                        else if (iae.getMessage().contains("ProductID: "))
                            JOptionPane.showMessageDialog(null, iae.getMessage(), "Invalid Phone No", JOptionPane.ERROR_MESSAGE);
                        else
                            JOptionPane.showMessageDialog(null, iae.getMessage(), "Invalid Date Registered", JOptionPane.ERROR_MESSAGE);
                    }}

        });
        jPanel.add(ProcessSaleButton);
        return jPanel;}
}