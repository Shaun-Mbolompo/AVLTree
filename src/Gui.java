import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;

/**
* Gui object extending the JFrame object and implementing the ActionListener interface to
* display graphic user interface to explain how I run the apps 
* 
* @author Shaun
* @version 1.0 02/03/2022
*/

public class Gui extends JFrame implements ActionListener{
    
    private static final int WIDTH = 1100;
    private static final int HEIGHT = 500;
    private static final int LEN = 60;
    private static final int HEI = 20;

    /**
    * Takes in area text
    *
    */
    
    private JTextArea text; 

    /**
    * Gui no parameter constructor to set-up the GUI to be display and user to interact with
    * 
    * @param args takes in string argument/s
    */
 
    public static void main(String[] args)
    {
     Gui gui = new Gui();
     gui.setVisible(true);
    }
    /**
    * Gui empty constructor, creates the windows frame, panels, labels, text area and buttons
    * for creating a user interface
    *
    */
         
    public Gui()
    {
        super("Assignment manuel");
        setSize(WIDTH,HEIGHT);
        getContentPane().setBackground(Color.PINK);
        setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        panel.setBackground(Color.PINK);
        panel.setLayout(new BorderLayout());
        
        ImageIcon image = new ImageIcon("image/images.jpg");
        JLabel label = new JLabel("Hi there, you can press the button 'Help' if you need guidance on how the experiment work!");
        label.setIcon(image);
        panel.add(label, BorderLayout.NORTH);
        text = new JTextArea(HEI,LEN);
        text.setBackground(Color.WHITE);
        JPanel textPanel = new JPanel();
        textPanel.setBackground(Color.BLACK);
        textPanel.add(text);
        panel.add(textPanel,BorderLayout.CENTER);
        JPanel panelBut = new JPanel();
        panelBut.setBackground(Color.GREEN);
        panelBut.setLayout(new FlowLayout());
        JLabel labelBut = new JLabel("Buttons ");
        panelBut.add(labelBut);
        
        JButton help = new JButton("Help");
        help.addActionListener(this);
        panelBut.add(help);
        
        JButton run = new JButton("Run experiment");
        run.addActionListener(this);
        panelBut.add(run);
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
 
        panel.add(panelBut,BorderLayout.SOUTH);
        add(panel, BorderLayout.CENTER);
         
    }
    
    /**
    * Fires a text message when the buttons are pressed to display a message to the user 
    * 
    * @param e ActionEvent object to use its methods, in this case the method to reference 
    * the buttons by name to fire an event
    */
    
    public void actionPerformed(ActionEvent e)
    {
        String action = e.getActionCommand();
        if(action.equals("Help")){
            text.setText(
            "Hi, I run the experiment through using AVLExperiment program. I use it to generate randomised arrays from the vaccinations.csv file and store the data"+ "\n" + 
            "in an AVL tree. I then use the data items from the vaccinations.csv to test the AVL tree with the different ordered data to see if it does balance the"+"\n"+
            "nodes and provide good performance for storage and retrieval of data."+"\n"+
            "If you press 'Run experiment', the experiment will be carried and the results of the experiment will be shown in few minutes. For you to end the program "+"\n"+
            "you will need to close the two graphs by clicking on the close icon on the top right after viewing them."+"\n"+
            "If you have problem seeing the graphs, you should install the matplotlib.pyplot libaray in your pc. Furthermore, if you want to see the image displayed"+ "\n" +
            "on this user interface if not appearing now, you can change the path from '/home/shaun/Assignment2/image/images.jpg' on the Gui java class under src"+ "\n" +
            "directiory by simply replacing '/home/shaun/' by the path of your pc'."+ "\n" + "\n" +
            "Thank you!");
            text.setEditable(false);
        }
        else if(action.equals("Run experiment")){

           dispose();}
    }

}
