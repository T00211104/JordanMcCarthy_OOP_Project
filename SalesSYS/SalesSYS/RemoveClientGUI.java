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

//RemoveClientGUI.java
/*This GUI class implements JFrame. This class asks the user which
* ClientID to remove, it displays the ClientID's to make sure
* the user is certain about deleting the client's details, then if
* the user wants to it will delete it form the array*/

public class RemoveClientGUI extends JFrame {

    private final Insets normalInsets = new Insets(10, 10, 0, 10);
    private final Insets topInsets = new Insets(10, 10, 0, 10);
    private JTextField ClientIDField;


    public RemoveClientGUI()  {

        super("Remove Client");


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

    public static void main(String args[]) throws Exception{
        Object RemoveClientGUI = new RemoveClientGUI();
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
            System.out.println("Remove Client Window Activated");
        }

        @Override
        public void windowDeactivated(WindowEvent e) {
            System.out.println("Remove Client Window Deactivated");
        }
    }

    private JPanel createTitlePanel() {

        JPanel jpanel = new JPanel();

        JLabel titleLabel = new JLabel("Client Details");
        titleLabel.setFont(new Font("sans-serif",Font.PLAIN,18));

        jpanel.add(titleLabel);

        return jpanel;
    }

    private JPanel createDetailsPanel() {

        JPanel jpanel = new JPanel();
        jpanel.setLayout(new GridBagLayout());

        int gridy = 0;

        JLabel ClientIDLabel = new JLabel("ClientID: ");
        addComponent(jpanel, ClientIDLabel, 0, gridy, 1, 1, normalInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        ClientIDField = new JTextField(12);
        addComponent(jpanel, ClientIDField, 1, gridy, 1, 1, topInsets,
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

        JButton btnRemoveClient = new JButton("Remove Client");

        btnRemoveClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Client c1 = new Client(1,"Michael","McGinn","0871234567",new GregorianCalendar(2006,02,15));
                Client c2 = new Client(2,"Margaret","Flaherty","0872345678",new GregorianCalendar(2007,03,17));
                Client c3 = new Client(3,"Tyrone","Mitchell","0873456789",new GregorianCalendar(2090,05,13));
                Client c4 = new Client(4,"Margaret","Flaherty","0874567891",new GregorianCalendar(2017,04,18));
                Client c5 = new Client(5,"Margaret","Flaherty","0831353213",new GregorianCalendar(2015,12,2));
                ArrayList<Client> allClients = new ArrayList<Client>(Arrays.asList(c1,c2,c3,c4,c5));

                try {
                    int cID = 0;
                    String ClientID = ClientIDField.getText();
                    if (ClientID != null && !ClientID.isEmpty()) {
                        cID = Integer.parseInt(ClientID);
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "You did not enter a valid ClientID", "Error!!", JOptionPane.ERROR_MESSAGE);

                    }

                    ArrayList<Client> foundClients = new ArrayList<Client>();
                    int searchKey = Integer.parseInt(JOptionPane.showInputDialog("Please enter the ClientID you wish to remove"));
                    for (Client cl : allClients)
                        if (cl.getClientID() == searchKey)
                            foundClients.add(cl);
                    /**/                  /*else if(cl.getClientID() != searchKey){
                            ClientID cl = JOptionPane.showInputDialog("Invalid!! Please enter the ClientID again");
                        }*/

                    String text = "";

                    for (Client cl : foundClients)
                        if (cl != null) {
                            text += cl + "\n";
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"Invalid ID","Please enter another ID",JOptionPane.ERROR_MESSAGE);
                            JOptionPane.showInputDialog("The ClientID you entered was Invalid, Please enter again");
                        }
                    int searchID = Integer.parseInt(JOptionPane.showInputDialog("The following Clients matched your search phrase\n\n" + text +
                            "\n\nPlease enter the id of the one you want to remove"));
                    Client ClientToRemove = null;

                    for (Client cl : foundClients)
                        if (cl != null && cl.getClientID() == searchID)
                            ClientToRemove = cl;

                    int removeChoice = JOptionPane.showConfirmDialog(null, "The Clients you wish to remove are:\n\n" +
                            ClientToRemove + "\n\nAre you sure you wish to remove this Client?", "Client Removal Confirmation", JOptionPane.YES_NO_CANCEL_OPTION);

                    if (removeChoice == JOptionPane.YES_OPTION) {
                        allClients.remove(ClientToRemove);
                        JOptionPane.showMessageDialog(null, "Client now removed from array list!",
                                "Client Removed", JOptionPane.INFORMATION_MESSAGE);
                    } else
                        JOptionPane.showMessageDialog(null, "Client removal canceled",
                                "Client Not Removed", JOptionPane.INFORMATION_MESSAGE);

                    foundClients.clear();
                } catch (NumberFormatException numberFormatException) {
                    numberFormatException.printStackTrace();
                } catch (HeadlessException headlessException) {
                    headlessException.printStackTrace();
                }
            }});

        jpanel.add(btnRemoveClient);

        return jpanel;
    }
}