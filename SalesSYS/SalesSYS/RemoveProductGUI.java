package SalesSYS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Arrays;

//RemoveProductGUI.java
/*This GUI class implements JFrame. This class asks the user which
* ProductID to remove, it displays the ProductID's to make sure
* the user is certain about deleting the product's details, then if
* asks if the user wants to do and it will delete it from the array*/

public class RemoveProductGUI extends JFrame {

    private final Insets normalInsets = new Insets(10, 10, 0, 10);
    private final Insets topInsets = new Insets(10, 10, 0, 10);
    private JTextField ProductIDField;


    public RemoveProductGUI()  {

        super("Remove Table");


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
        setSize(300,300);
        setVisible(true);
        setResizable(false);

    }

    public static void main(String args[]){

        Object RemoveProduct = new RemoveProductGUI();
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
            JOptionPane.showMessageDialog(null, "Remove Client Window Closed", "Remove Client Window Closed",
                    JOptionPane.INFORMATION_MESSAGE);

            MainMenu mnu = new MainMenu();
        }

        @Override
        public void windowIconified(WindowEvent e) {
            JOptionPane.showMessageDialog(null, "Remove Client Window Minimised", "Remove Client Window Minimised",
                    JOptionPane.INFORMATION_MESSAGE);
        }

        @Override
        public void windowDeiconified(WindowEvent e) {
            JOptionPane.showMessageDialog(null, "Remove Client Window Unminimised", "Remove Client Window Unminimised",
                    JOptionPane.INFORMATION_MESSAGE);

            MainMenu Main = new MainMenu();
        }

        @Override
        public void windowActivated(WindowEvent e) {
            JOptionPane.showMessageDialog(null,"Remove Product Window Activated","Remove Product Window Opened",JOptionPane.INFORMATION_MESSAGE);
        }

        @Override
        public void windowDeactivated(WindowEvent e) {
            JOptionPane.showMessageDialog(null,"Remove Product Window De-activated","Remove Product Window CLosed",JOptionPane.INFORMATION_MESSAGE);
        }
    }



    private JPanel createTitlePanel() {

        JPanel jpanel = new JPanel();

        JLabel titleLabel = new JLabel("Product Details");
        titleLabel.setFont(new Font("sans-serif",Font.PLAIN,18));

        jpanel.add(titleLabel);

        return jpanel;
    }

    private JPanel createDetailsPanel() {

        JPanel jpanel = new JPanel();
        jpanel.setLayout(new GridBagLayout());

        int gridy = 0;

        JLabel ProductIDLabel = new JLabel("ProductID: ");
        addComponent(jpanel, ProductIDLabel, 0, gridy, 1, 1, normalInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        ProductIDField = new JTextField(10);
        addComponent(jpanel, ProductIDField, 1, gridy++, 1, 1, topInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        return jpanel;
    }

    private void addComponent(Container container, Component component,
                              int gridx, int gridy, int gridwidth, int gridheight, Insets insets,
                              int anchor, int fill) {

        GridBagConstraints gbc = new GridBagConstraints(gridx, gridy,
                gridwidth, gridheight, 0.0, 0.0, anchor, fill, insets, 5, 5);

        container.add(component, gbc);
    }

    private JPanel createSubmitPanel() {

        JPanel jpanel = new JPanel();

        JButton btnRemoveProduct = new JButton("Remove Product");

        btnRemoveProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Product p1 = new Product(1,"Maxiflex Gloves","MaxiFlex",15,"A Breathable glove that provides protection and grip",3);
                Product p2 = new Product(2,"DEWALT CHALLENGER 3 SAFETY BOOT","DEWALT",3,"Waterproof Brown Safety Boots",150);
                Product p3 = new Product(3,"MOLDEX 2405 MASK,Manufacturer","MOLDEX",15,"Classic FFP-Mask: perfect fit without nose clip",4);
                Product p4 = new Product(4,"BOLLE TRACKER SAFETY GLASSES","Bolle",6,"The Bolle Tracker Safety Glasses are designed to protect against mechanical and chemical risks",15);
                Product p5 = new Product(5,"BIZWELD NAVY BOILERSUIT","BIZWELD",4," Clever design features include flame resistant reflective tape",45);
                ArrayList<Product>allProducts = new ArrayList<Product>(Arrays.asList(p1,p2,p3,p4,p5));

                try {
                    int pID = 0;
                    String ProductID = ProductIDField.getText();
                    if (ProductID != null && !ProductID.isEmpty()) {
                        pID = Integer.parseInt(ProductID);
                    } else {
                        JOptionPane.showMessageDialog(null, "You did not enter a valid table number", "Error!!", JOptionPane.ERROR_MESSAGE);

                    }

                    ArrayList<Product> foundProducts = new ArrayList<Product>();
                    int searchKey = Integer.parseInt(JOptionPane.showInputDialog("Please enter the ProductID you wish to remove"));
                    for (Product pr : allProducts)
                        if (pr.getProductID() == searchKey)
                            foundProducts.add(pr);

                    String text = "";

                    for (Product pr : foundProducts)
                        if (pr != null) {
                            text += pr + "\n";
                        }
                    int searchID = Integer.parseInt(JOptionPane.showInputDialog("The following Products matched your search phrase\n\n" + text +
                            "\n\nPlease enter the id of the one you want to remove"));
                    Product ProductToRemove = null;

                    for (Product pr : foundProducts)
                        if (pr != null && pr.getProductID() == searchID)
                            ProductToRemove = pr;

                    int removeChoice = JOptionPane.showConfirmDialog(null, "The Product you wish to remove are:\n\n" +
                            ProductToRemove + "\n\nAre you sure you wish to remove this Product?", "Product Removal Confirmation", JOptionPane.YES_NO_CANCEL_OPTION);

                    if (removeChoice == JOptionPane.YES_OPTION) {
                        allProducts.remove(ProductToRemove);
                        JOptionPane.showMessageDialog(null, "Product now removed from array list!",
                                "Product Removed", JOptionPane.INFORMATION_MESSAGE);
                    } else
                        JOptionPane.showMessageDialog(null, "Product removal canceled",
                                "Product Not Removed", JOptionPane.INFORMATION_MESSAGE);

                    foundProducts.clear();
                } catch (NumberFormatException numberFormatException) {
                    numberFormatException.printStackTrace();
                } catch (HeadlessException headlessException) {
                    headlessException.printStackTrace();
                }
            }});

        jpanel.add(btnRemoveProduct);

        return jpanel;
    }
}