package view;

import javafx.scene.shape.Circle;
import model.TheObject;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


import static java.lang.Thread.sleep;


public class StatsView extends JPanel implements ActionListener {
    Timer tm = new Timer(500 , this);

    private int lastY = 250;
    private int lastX = 20;
    private  Graphics g ;
    public static   int min = 0 , sec = 0 ;

    public void init() {
        JFrame frame = new JFrame();

        frame.setTitle("my production statistics");
        frame.setSize(600, 300);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        Container contentPane = frame.getContentPane();
        contentPane.add(new StatsView() );
        JLabel myTime = new JLabel();
        String time = (min + " : " + sec);
        myTime.setText(time);
        myTime.setSize(20 , 20);
       // contentPane.add(myTime);






        frame.setVisible(true);

    }



    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.fillOval(lastX , lastY , 10 , 10);
        g.setColor(Color.RED);
        tm.start();

    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (sec == 59) { min = min+1 ; sec = 0;}
        else sec = sec+1;
        repaint();
        revalidate();
        lastX = lastX + 15;
        lastY = lastY - 20*TheObject.numHammers;
        TheObject.numHammers = 0 ;
    }
}
