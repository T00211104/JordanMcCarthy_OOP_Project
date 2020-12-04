package SalesSYS;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MainMenu extends JFrame implements ActionListener {
    JMenu ProductMenu,ClientMenu,SalesMenu,QuitMenu;
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

        setSize(400,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(250,200);
        setVisible(true);
    }

    public static void main(String[] args) {
        MainMenu Main = new MainMenu();
    }

    public void actionPerformed(ActionEvent event){
        String menuName;
        menuName=event.getActionCommand();//menu name is acting as getActionCommand

        if (menuName.equals(("Add Products"))){
            JOptionPane.showMessageDialog(null,"Add Product GUI opened","Activated Add Product GUI",JOptionPane.INFORMATION_MESSAGE);
            AddProductGUI Ap = new AddProductGUI();
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
            UpdateClientGUI2 Uc = new UpdateClientGUI2();
        }
        if (menuName.equals(("Remove Clients"))){
            JOptionPane.showMessageDialog(null,"Remove Client GUI opened","Activated Remove Client GUI",JOptionPane.INFORMATION_MESSAGE);
            RemoveClientGUI Rc = new RemoveClientGUI();
        }
        if (menuName.equals(("Query Clients"))){
            JOptionPane.showMessageDialog(null,"Query Clients GUI opened","Activated Query Client GUI",JOptionPane.INFORMATION_MESSAGE);
            QueryClientGUI qc = new QueryClientGUI();
        }
        else{
            response.setText("Menu Item" + menuName + "is selected");
        }
    }

    /*Mnemonic Sean Courtney*/
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

    /*Mnemonic Sean Courtney*/
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
    /*Mnemonic Sean Courtney*/
    private void createSalesFile() {
        JMenuItem item;

        SalesMenu = new JMenu("Sales");

        item = new JMenu("Process Sale");
        item.addActionListener(this);
        SalesMenu.add(item);
    }
}

