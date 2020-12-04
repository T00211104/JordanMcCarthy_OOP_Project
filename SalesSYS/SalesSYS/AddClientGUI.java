package SalesSYS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class AddClientGUI extends JFrame{

    private final Insets normalInsets = new Insets(5,10,0,10);
    private final Insets topInsets = new Insets(5,110,0,0);
    private JTextField ClientIDField;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField phoneNoField;
    private JTextField dateRegisteredField;
    private GregorianCalendar dateChosen;

    public AddClientGUI(){
        super("Add Client Details");

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));

        panel.add(Box.createVerticalStrut(60));
        panel.add(createTitlePanel());
        panel.add(createDetailsPanel());
        panel.add(Box.createVerticalStrut(40));
        panel.add(createSubmitPanel());
        panel.add(Box.createVerticalStrut(20));

        add(panel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(360,360);
        setVisible(true);
        setResizable(false);
    }

    public static void main(String[] args) {
        Object AddClientGUI = new AddClientGUI();}

    private class WindowEventHandler implements WindowListener {

        public void windowOpened(WindowEvent e) {
            JOptionPane.showMessageDialog(null, "Add Client Window now opened", "Window Opened",
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
            JOptionPane.showMessageDialog(null, "Add Client Window Closed", "Add Client Window Closed",
                    JOptionPane.INFORMATION_MESSAGE);

            MainMenu mnu = new MainMenu();
        }

        @Override
        public void windowIconified(WindowEvent e) {
            JOptionPane.showMessageDialog(null, "Add Client Window Minimised", "Add Client Window Minimised",
                    JOptionPane.INFORMATION_MESSAGE);
        }

        @Override
        public void windowDeiconified(WindowEvent e) {
            JOptionPane.showMessageDialog(null, "Add Client Window Unminimised", "Add Client Window Unminimised",
                    JOptionPane.INFORMATION_MESSAGE);

            MainMenu Main = new MainMenu();
        }

        @Override
        public void windowActivated(WindowEvent e) {
            JOptionPane.showMessageDialog(null,"Add Client Window Activated","Add Client Window Opened",JOptionPane.INFORMATION_MESSAGE);
        }

        @Override
        public void windowDeactivated(WindowEvent e) {
            JOptionPane.showMessageDialog(null,"Add Client Window De-activated","Add Client Window Closed",JOptionPane.INFORMATION_MESSAGE);
        }
    }



    private JPanel createTitlePanel() {
        JPanel panel = new JPanel();

        JLabel titleLabel = new JLabel("Add Client Details");
        titleLabel.setFont(new Font("serif",Font.PLAIN,15));

        panel.add(titleLabel);

        return panel;
    }

    private JPanel createDetailsPanel(){
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        int gridy = 0;

        JLabel ClientIDLabel = new JLabel("ClientID");
        addComponent(panel,ClientIDLabel,0,gridy,1,1,normalInsets,
                GridBagConstraints.LINE_START,GridBagConstraints.HORIZONTAL);

        ClientIDField = new JTextField(10);
        addComponent(panel, ClientIDField,0,gridy++,1,1,topInsets,
                GridBagConstraints.LINE_START,GridBagConstraints.HORIZONTAL);

        JLabel firstNameLabel = new JLabel("First Name: ");
        addComponent(panel,firstNameLabel,0,gridy,1,1,normalInsets,
                GridBagConstraints.LINE_START,GridBagConstraints.HORIZONTAL);

        firstNameField = new JTextField(10);
        addComponent(panel,firstNameField,0,gridy++,1,1,topInsets,
                GridBagConstraints.LINE_START,GridBagConstraints.HORIZONTAL);

        JLabel lastNameLabel = new JLabel("Last Name: ");
        addComponent(panel,lastNameLabel,0,gridy,1,1,normalInsets,
                GridBagConstraints.LINE_START,GridBagConstraints.HORIZONTAL);

        lastNameField = new JTextField(10);
        addComponent(panel,lastNameField,0,gridy++,1,1,topInsets,
                GridBagConstraints.LINE_START,GridBagConstraints.HORIZONTAL);

        JLabel phoneNoLabel = new JLabel("Phone No: ");
        addComponent(panel,phoneNoLabel,0,gridy,1,1,normalInsets,
                GridBagConstraints.LINE_START,GridBagConstraints.HORIZONTAL);

        phoneNoField = new JTextField(10);
        addComponent(panel,phoneNoField,0,gridy++,1,1,topInsets,
                GridBagConstraints.LINE_START,GridBagConstraints.HORIZONTAL);

        JLabel dateRegisteredLabel = new JLabel("Date Registered: ");
        addComponent(panel,dateRegisteredLabel,0,gridy,1,1,normalInsets,
                GridBagConstraints.LINE_START,GridBagConstraints.HORIZONTAL);

        dateRegisteredField = new JTextField("dd-mm-yyyy",10);
        addComponent(panel,dateRegisteredField,0,gridy,1,1,topInsets,
                GridBagConstraints.LINE_START,GridBagConstraints.HORIZONTAL);

        JButton dateRegisteredButton = new JButton("Date Registered");
        dateRegisteredButton.setPreferredSize(new Dimension(1,1));
        addComponent(panel,dateRegisteredButton,0,gridy++,1,1,topInsets,
                GridBagConstraints.LINE_START,GridBagConstraints.HORIZONTAL);

        dateRegisteredButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DateChooser dateChooser = new DateChooser(AddClientGUI.this);
                dateChosen = dateChooser.getDateChosen();

                if(dateChosen!=null){
                    System.out.println(dateChosen.get(Calendar.DATE) + "-" +
                            dateChosen.get(Calendar.MONTH) + "-" +
                            dateChosen.get(Calendar.YEAR));

                    String dayString, monthString;

                    if (dateChosen.get(Calendar.DATE)<10)
                        dayString = "0" + dateChosen.get(Calendar.DATE);
                    else
                        dayString = "" + dateChosen.get(Calendar.DATE);

                    if(dateChosen.get(Calendar.MONTH)<10)
                        monthString = "0" + dateChosen.get(Calendar.MONTH);
                    else
                        monthString = "" + dateChosen.get(Calendar.MONTH);

                    dateRegisteredField.setText(dayString + "-" +monthString + "-" + dateChosen.get(Calendar.YEAR));
                }
            }
        });
        return panel;
    }

    private void addComponent(Container container, Component component,
                              int gridx, int gridy, int gridwidth, int gridheight, Insets insets,
                              int anchor, int fill){

        GridBagConstraints gbc = new GridBagConstraints(gridx,gridy,
                gridwidth,gridheight,0.0,0.0,anchor,fill,insets,5,5);

        container.add(component, gbc);
    }

    private JPanel createSubmitPanel(){
        JPanel panel = new JPanel();

        JButton addClientButton = new JButton("Add Client");

        addClientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dateRegistered = dateRegisteredField.getText();

                if (dateRegistered.length() == 10){

                    try{


                        int cid =0;
                        String clientID = ClientIDField.getText();
                        if(clientID != null && clientID.isEmpty())
                        {
                            cid = Integer.parseInt(clientID);
                        }


                        String firstName = firstNameField.getText();
                        if(firstName!="" && firstName.isEmpty())
                        {
                           String fn = firstName;
                        }

                        String lastName = lastNameField.getText();
                        if(lastName!="" && lastName.isEmpty())
                        {

                        }

                        String PhoneNo = phoneNoField.getText();
                        if(PhoneNo!="" && PhoneNo.isEmpty())
                        {

                        }
                        int day = Integer.parseInt(dateRegistered.substring(0,1));
                        int month = Integer.parseInt(dateRegistered.substring(3,4));
                        int year = Integer.parseInt(dateRegistered.substring(6));



                        GregorianCalendar dateRegisteredGC = new GregorianCalendar(year,month-1,day);
                        dateRegisteredGC.setLenient(false);
                        dateRegisteredGC.getTime();

                        System.out.println(dateRegisteredGC.get(Calendar.DATE) + "-" +
                                dateRegisteredGC.get(Calendar.MONTH) + "-" +
                                dateRegisteredGC.get(Calendar.YEAR));

                        Client c = new Client(cid,firstName,lastName,PhoneNo,dateRegisteredGC);

                        Client c1 = new Client(1,"Michael","McGinn","0871234567",new GregorianCalendar(2006,01,15));
                        Client c2 = new Client(2,"Margaret","Flaherty","0872345678",new GregorianCalendar(2007,03,17));
                        Client c3 = new Client(3,"Tyrone","Mitchell","0873456789",new GregorianCalendar(2090,05,13));
                        Client c4 = new Client(4,"Margaret","Flaherty","0874567891",new GregorianCalendar(2017,01,18));
                        Client c5 = new Client(5,"Margaret","Flaherty","0831353213",new GregorianCalendar(2015,12,2));
                        ArrayList<Client> allClients = new ArrayList<Client>(Arrays.asList(c1,c2,c3,c4,c5));

                        JOptionPane.showMessageDialog(null,"Client details are added\n\nDetails are -  " + c,"Added Client",JOptionPane.INFORMATION_MESSAGE);
                    }catch (NumberFormatException nfe){
                        JOptionPane.showMessageDialog(null,"Form must be filled correctly","Invalid Date Registered",JOptionPane.ERROR_MESSAGE);
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
                } else
                    JOptionPane.showMessageDialog(null,"Date Registered must be at 7 characters long","Invalid Date Registered",JOptionPane.ERROR_MESSAGE);
            }});
        panel.add(addClientButton);
        return panel;
    }

}