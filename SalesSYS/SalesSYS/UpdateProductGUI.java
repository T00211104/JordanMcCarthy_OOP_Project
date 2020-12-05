package SalesSYS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Arrays;


//UpdateProductGUI.java
/*This GUI class is used to Update a Product details using JFrame. Also attributes being
(productID,name,manufacturer,quantity,description,price) retrieved from the
Product.java. This GUI displays a JOptionPane and gives the user the attributes boxes so
he/she can input into the textFields, the GUI then displays the details and is updated in
the system.*/
public class UpdateProductGUI extends JFrame{

    private final Insets normalInsets = new Insets(5,10,0,10);
    private final Insets topInsets = new Insets(5,10,0,10);
    private JTextField ProductIDField;
    private JTextField NameField;
    private JTextField ManufacturerField;
    private JTextField QuantityField;
    private JTextField DescriptionField;
    private JTextField PriceField;

    public UpdateProductGUI(){
        super("Update Products");

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel,BoxLayout.Y_AXIS));

        jPanel.add(Box.createVerticalStrut(75));
        jPanel.add(createTitlePanel());
        jPanel.add(createDetailsPanel());
        jPanel.add(Box.createVerticalStrut(20));
        jPanel.add(createSubmitPanel());
        jPanel.add(Box.createVerticalStrut(30));

        add(jPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450,450);
        setVisible(true);
        setResizable(false);
    }

    public static void main(String[] args) {
        Object UpdateProductGUI = new UpdateProductGUI();
    }

    private class WindowEventHandler implements WindowListener {

        public void windowOpened(WindowEvent e) {
            JOptionPane.showMessageDialog(null, "Update Product Window now opened", "Window Opened",
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
            JOptionPane.showMessageDialog(null, "Update Product Window Closed", "Update Product Window Closed",
                    JOptionPane.INFORMATION_MESSAGE);

            MainMenu mnu = new MainMenu();
        }

        @Override
        public void windowIconified(WindowEvent e) {
            JOptionPane.showMessageDialog(null, "Update Product Window Minimised", "Update Product Window Minimised",
                    JOptionPane.INFORMATION_MESSAGE);
        }

        @Override
        public void windowDeiconified(WindowEvent e) {
            JOptionPane.showMessageDialog(null, "Update Product Window Unminimised", "Update Product Window Unminimised",
                    JOptionPane.INFORMATION_MESSAGE);

            MainMenu Main = new MainMenu();
        }

        @Override
        public void windowActivated(WindowEvent e) {
            JOptionPane.showMessageDialog(null,"Update Product Window Activated","Update Product Window Opened",JOptionPane.INFORMATION_MESSAGE);
        }

        @Override
        public void windowDeactivated(WindowEvent e) {
            JOptionPane.showMessageDialog(null,"Update Product Window De-activated","Update Product Window Closed",JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private JPanel createTitlePanel() {
        JPanel panel = new JPanel();

        JLabel titleLabel = new JLabel("Product Details");
        titleLabel.setFont(new Font("serif",Font.PLAIN,20));

        panel.add(titleLabel);

        return panel;
    }

    private JPanel createDetailsPanel(){
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        int gridy = 0;

        JLabel ProductIDLabel = new JLabel("ProductID: ");
        addComponent(panel,ProductIDLabel,0,gridy,1,1, normalInsets,
                GridBagConstraints.LINE_START,GridBagConstraints.HORIZONTAL);

        ProductIDField = new JTextField(15);
        addComponent(panel,ProductIDField,1,gridy++,1,1,topInsets,
                GridBagConstraints.LINE_START,GridBagConstraints.HORIZONTAL);

        JLabel NameLabel = new JLabel("Name: ");
        addComponent(panel,NameLabel,0,gridy,1,1,normalInsets,
                GridBagConstraints.LINE_START,GridBagConstraints.HORIZONTAL);

        NameField = new JTextField(1);
        addComponent(panel,NameField,1,gridy++,2,1,topInsets,
                GridBagConstraints.LINE_START,GridBagConstraints.HORIZONTAL);

        JLabel ManufacturerLabel = new JLabel("Manufacturer: ");
        addComponent(panel,ManufacturerLabel,0,gridy,1,1,normalInsets,
                GridBagConstraints.LINE_START,GridBagConstraints.HORIZONTAL);

        ManufacturerField = new JTextField(1);
        addComponent(panel,ManufacturerField,1,gridy++,2,1,topInsets,
                GridBagConstraints.LINE_START,GridBagConstraints.HORIZONTAL);

        JLabel QuantityLabel = new JLabel("Quantity: ");
        addComponent(panel,QuantityLabel,0,gridy,1,1,normalInsets,
                GridBagConstraints.LINE_START,GridBagConstraints.HORIZONTAL);

        QuantityField = new JTextField(1);
        addComponent(panel,QuantityField,1,gridy++,2,1,topInsets,
                GridBagConstraints.LINE_START,GridBagConstraints.HORIZONTAL);

        JLabel DescriptionLabel = new JLabel("Description: ");
        addComponent(panel,DescriptionLabel,0,gridy,1,1,normalInsets,
                GridBagConstraints.LINE_START,GridBagConstraints.HORIZONTAL);

        DescriptionField = new JTextField(1);
        addComponent(panel,DescriptionField,1,gridy++,2,1,topInsets,
                GridBagConstraints.LINE_START,GridBagConstraints.HORIZONTAL);

        JLabel PriceLabel = new JLabel("\nPrice: ");
        addComponent(panel,PriceLabel,0,gridy,1,1,normalInsets,
                GridBagConstraints.LINE_START,GridBagConstraints.HORIZONTAL);

        PriceField = new JTextField(1);
        addComponent(panel,PriceField,1,gridy,2,1,topInsets,
                GridBagConstraints.LINE_START,GridBagConstraints.HORIZONTAL);
        return panel;
    }

    private void addComponent(Container container, Component component,
                              int gridx, int gridy, int gridwidth, int gridheight, Insets insets, int anchor, int fill){

        GridBagConstraints gbc = new GridBagConstraints(gridx,gridy,
                1,1,0.0,0.0,anchor,fill,insets,5,5);

        container.add(component, gbc);
    }

    private JPanel createSubmitPanel(){
        JPanel jPanel = new JPanel();

        JButton btnAddProduct = new JButton("Update Product");

        btnAddProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    int pID = 0;
                    String ProductID = ProductIDField.getText();
                    if(ProductID != null && !ProductID.isEmpty()){
                        pID = Integer.parseInt(ProductID);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"You did not enter a valid ProductID","Error!",JOptionPane.ERROR_MESSAGE);
                    }
                    String Name = NameField.getText();
                    if (Name != null && !Name.isEmpty()){

                    }
                    else{
                        JOptionPane.showMessageDialog(null,"You did not enter a valid Name","Error!",JOptionPane.ERROR_MESSAGE);
                    }
                    String Manufacturer = ManufacturerField.getText();
                    if (Manufacturer!=null&&!Manufacturer.isEmpty()){
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"You did not enter a valid Manufacturer","Error!",JOptionPane.ERROR_MESSAGE);
                    }

                    int qty = 0;
                    String Quantity = QuantityField.getText();
                    if (Quantity!=null&&!Quantity.isEmpty()){
                        qty = Integer.parseInt(Quantity);
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"You did not enter a valid Quantity","Error!",JOptionPane.ERROR_MESSAGE);
                    }

                    String Description = DescriptionField.getText();
                    if(Description!= null&&!Description.isEmpty()){

                    }
                    else{
                        JOptionPane.showMessageDialog(null,"You did not enter a valid Description","Error!",JOptionPane.ERROR_MESSAGE);
                    }

                    int pr=0;
                    String Price = PriceField.getText();
                    if(Price!=null&&!Price.isEmpty()){
                        pr = Integer.parseInt(Price);
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"You did not enter a valid Price","Error!",JOptionPane.ERROR_MESSAGE);
                    }
                    Product p1 = new Product(1,"Maxiflex Gloves","MaxiFlex",15,"A Breathable glove that provides protection and grip",3);
                    Product p2 = new Product(2,"DEWALT CHALLENGER 3 SAFETY BOOT","DEWALT",3,"Waterproof Brown Safety Boots",150);
                    Product p3 = new Product(3,"MOLDEX 2405 MASK,Manufacturer","MOLDEX",15,"Classic FFP-Mask: perfect fit without nose clip",4);
                    Product p4 = new Product(4,"BOLLE TRACKER SAFETY GLASSES","Bolle",6,"The Bolle Tracker Safety Glasses are designed to protect against mechanical and chemical risks",15);
                    Product p5 = new Product(5,"BIZWELD NAVY BOILERSUIT","BIZWELD",4," Clever design features include flame resistant reflective tape",45);
                    ArrayList<Product>allProducts = new ArrayList<Product>(Arrays.asList(p1,p2,p3,p4,p5));


                    Product product = new Product(pID,Name,Manufacturer,qty,Description,pr);
                    allProducts.add(product);

                    JOptionPane.showMessageDialog(null,"Product details are added\n\nDetails are -  " + product,"Added Product",JOptionPane.INFORMATION_MESSAGE);
                }catch (NumberFormatException nfe){
                    JOptionPane.showMessageDialog(null,"Date Registered must be in the form dd-mm-yyyy","Invalid Date Registered",JOptionPane.ERROR_MESSAGE);
                }catch (IllegalArgumentException iae){
                    if (iae.getMessage().contains("First Name: "))
                        JOptionPane.showMessageDialog(null,iae.getMessage(),"Invalid First Name",JOptionPane.ERROR_MESSAGE);
                    else if (iae.getMessage().contains("Last Name: "))
                        JOptionPane.showMessageDialog(null,iae.getMessage(),"Invalid Last Name",JOptionPane.ERROR_MESSAGE);
                    else if (iae.getMessage().contains("Phone No: "))
                        JOptionPane.showMessageDialog(null,iae.getMessage(),"Invalid Phone No",JOptionPane.ERROR_MESSAGE);
                    else
                        JOptionPane.showMessageDialog(null,iae.getMessage(),"Invalid Date Registered",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        jPanel.add(btnAddProduct);
        return jPanel;
    }
}