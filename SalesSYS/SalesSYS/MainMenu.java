package SalesSYS;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


//MainMenu.java
/*This Main Menu class implements a JFrame.Which then creates a JMenu so we can create a MenuBar.
The menuBar Creates the Items such as Products, Clients and Sales. The WindowEventHandler is used to
pop up a JOptionPane when an action is completed .The actionPerformed takes in inputs so if I click on
a word as described, it would pop up another GUI.The CreateFile are used to add in the menuItems that
appear beneath the MenuBar when hovering over the Name of the 'List'*/

public class MainMenu extends JFrame implements ActionListener {
    JMenu ProductMenu, ClientMenu, SalesMenu;
    JLabel response;

    public MainMenu() {
        super("Main Menu");

        setLayout(new GridBagLayout());

        createProductFile();
        createClientFile();
        createSalesFile();

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.setBackground(Color.CYAN);
        menuBar.add(ProductMenu);
        menuBar.add(ClientMenu);
        menuBar.add(SalesMenu);

        response = new JLabel("Welcome to SalesSYS");
        add(response);

        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(250, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        Object Main = new MainMenu();
    }

    private class WindowEventHandler implements WindowListener {

    public void windowOpened(WindowEvent e) {
        JOptionPane.showMessageDialog(null, "Main Menu Window now opened",  "Main Menu Window Opened",
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


    public void windowClosed(WindowEvent e) {
        JOptionPane.showMessageDialog(null, "Main Menu Window Closed", "Main Menu Window Closed",
                JOptionPane.INFORMATION_MESSAGE);

        MainMenu mnu = new MainMenu();
    }


    public void windowIconified(WindowEvent e) {
        JOptionPane.showMessageDialog(null, "Main Menu Window Minimised", "Main Menu Window Minimised",
                JOptionPane.INFORMATION_MESSAGE);
    }


    public void windowDeiconified(WindowEvent e) {
        JOptionPane.showMessageDialog(null, "Main Menu Window Unminimised", "Main Menu Window Unminimised",
                JOptionPane.INFORMATION_MESSAGE);

        MainMenu Main = new MainMenu();
    }


    public void windowActivated(WindowEvent e) {
        JOptionPane.showMessageDialog(null, "Main Menu Window Activated", "Main Menu Window Opened", JOptionPane.INFORMATION_MESSAGE);
    }


    public void windowDeactivated(WindowEvent e) {
        JOptionPane.showMessageDialog(null, "Main Menu Window De-activated", "Main Menu Window Closed", JOptionPane.INFORMATION_MESSAGE);
    }

}


    public void actionPerformed(ActionEvent event){
        String menuName;
        menuName=event.getActionCommand();//menu name is acting as getActionCommand

        if (menuName.equals(("Add Products"))){
            JOptionPane.showMessageDialog(null,"Add Product GUI opened","Activated Add Product GUI",JOptionPane.INFORMATION_MESSAGE);
           AddProductGUI ap =new AddProductGUI();
        }
        if (menuName.equals(("Update Products"))){
            JOptionPane.showMessageDialog(null,"Update Product GUI opened","Activated Update Product GUI",JOptionPane.INFORMATION_MESSAGE);
            UpdateProductGUI Up = new UpdateProductGUI();
        }
        if (menuName.equals(("Remove Products"))){
            JOptionPane.showMessageDialog(null,"Remove Product GUI opened","Activated Remove Product GUI",JOptionPane.INFORMATION_MESSAGE);
            RemoveProductGUI Rp = new RemoveProductGUI();
        }
        if (menuName.equals(("Query Products"))){
            JOptionPane.showMessageDialog(null,"Query Products GUI opened","Activated Query Products GUI",JOptionPane.INFORMATION_MESSAGE);
            QueryProductGUI Qp = new QueryProductGUI();
        }
        if (menuName.equals(("Add Clients"))){
            JOptionPane.showMessageDialog(null,"Add Client GUI opened","Activated Add Client GUI",JOptionPane.INFORMATION_MESSAGE);
            AddClientGUI Ac = new AddClientGUI();
        }
        if (menuName.equals(("Update Clients"))){
            JOptionPane.showMessageDialog(null,"Update Client GUI opened","Activated Update Client GUI",JOptionPane.INFORMATION_MESSAGE);
            UpdateClientGUI Uc = new UpdateClientGUI();
        }
        if (menuName.equals(("Remove Clients"))){
            JOptionPane.showMessageDialog(null,"Remove Client GUI opened","Activated Remove Client GUI",JOptionPane.INFORMATION_MESSAGE);
            RemoveClientGUI rc = new RemoveClientGUI();
        }
        if (menuName.equals(("Query Clients"))){
            JOptionPane.showMessageDialog(null,"Query Clients GUI opened","Activated Query Client GUI",JOptionPane.INFORMATION_MESSAGE);
            QueryClientGUI qc = new QueryClientGUI();
        }
        else{
            response.setText("Menu Item" + menuName + "is selected");
        }
    }

    /*****************************************************
     *    Code from a fellow student   (include this comment for clarity)
     *    Title:    …..java, lines 101,106,111,116
     *    Author: T00012345: Sean Courtney (Name of student whose code is being cited)
     *    Site owner/sponsor:  NA
     *    Date: 05/12/2020
     *    Code version:  NA
     *    Availability:  NA

     *    Modified:  Code refactored (Identifiers renamed)
     *****************************************************/

    private void createProductFile() {
        JMenuItem item;

        ProductMenu = new JMenu("Products");

        item = new JMenu("Add Products");
        item.setMnemonic(KeyEvent.VK_A);
        item.addActionListener(this);
        ProductMenu.add(item);

        item = new JMenu("Update Products");
        item.setMnemonic(KeyEvent.VK_U);
        item.addActionListener(this);
        ProductMenu.add(item);

        item = new JMenu("Remove Products");
        item.setMnemonic(KeyEvent.VK_R);
        item.addActionListener(this);
        ProductMenu.add(item);

        item = new JMenuItem("Query Products");
        item.setMnemonic(KeyEvent.VK_Q);
        item.addActionListener(this);
        ProductMenu.add(item);
    }

    /*****************************************************
     *    Code from a fellow student   (include this comment for clarity)
     *    Title:    …..java, lines 139,144,149,154
     *    Author: T00012345:Sean Courtney (Name of student whose code is being cited)
     *    Site owner/sponsor:  NA
     *    Date: dd/mm/yyy
     *    Code version:  NA
     *    Availability:  NA

     *    Modified:  Code refactored (Identifiers renamed)
     *****************************************************/

    private void createClientFile() {
        JMenuItem item;

        ClientMenu = new JMenu("Clients");

        item = new JMenu("Add Clients");
        item.setMnemonic(KeyEvent.VK_A);
        item.addActionListener(this);
        ClientMenu.add(item);

        item = new JMenu("Update Clients");
        item.setMnemonic(KeyEvent.VK_U);
        item.addActionListener(this);
        ClientMenu.add(item);

        item = new JMenu("Remove Clients");
        item.setMnemonic(KeyEvent.VK_R);
        item.addActionListener(this);
        ClientMenu.add(item);

        item = new JMenuItem("Query Clients");
        item.setMnemonic(KeyEvent.VK_Q);
        item.addActionListener(this);
        ClientMenu.add(item);
    }
    /*****************************************************
     *    Code from a fellow student   (include this comment for clarity)
     *    Title:    …..java, lines 179
     *    Author: T00012345: Sean Courtney (Name of student whose code is being cited)
     *    Site owner/sponsor:  NA
     *    Date: dd/mm/yyy
     *    Code version:  NA
     *    Availability:  NA

     *    Modified:  Code refactored (Identifiers renamed)
     *****************************************************/

    private void createSalesFile() {
        JMenuItem item;

        SalesMenu = new JMenu("Sales");

        item = new JMenu("Process Sales");
        item.setMnemonic(KeyEvent.VK_P);
        item.addActionListener(this);
        SalesMenu.add(item);
    }
}

