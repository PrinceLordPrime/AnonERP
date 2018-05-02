/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
 
public class BoxLayoutDemo {
    public static void addComponentsToPane(Container pane) {
        pane.setLayout(new BoxLayout(pane, BoxLayout.PAGE_AXIS));
        addAHedder("abf","sdsd",pane);
        addAPannel( pane); addAPannel( pane); addAPannel( pane); addAPannel( pane); addAPannel( pane); addAPannel( pane); addAPannel( pane);
    }
 
    private static void addAPannel( Container container) {
        javax.swing.JPanel panel = new javax.swing.JPanel();
        panel.addMouseListener(new MouseListener(){

            @Override
            public void mouseClicked(MouseEvent me) {
                
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mousePressed(MouseEvent me) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseReleased(MouseEvent me) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent me) {
//                panel.setBackground(Color.green);
            }

            @Override
            public void mouseExited(MouseEvent me) {
//                java.awt.Point p = new java.awt.Point(me.getLocationOnScreen());
//                SwingUtilities.convertPointFromScreen(p, me.getComponent());
//                if(me.getComponent().contains(p)) {return;}
//                panel.setBackground(null);
            }
        });
        JTextField J = new JTextField(4);
        JTextField J1 = new JTextField(4);
        panel.add(J);
        panel.add(J1);
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        container.add(panel);
    }
 
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("BoxLayoutDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Set up the content pane.
        addComponentsToPane(frame.getContentPane());
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
 
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void addAHedder(String abf, String sdsd,Container container) {
         javax.swing.JPanel panel = new javax.swing.JPanel();
        panel.addMouseListener(new MouseListener(){

            @Override
            public void mouseClicked(MouseEvent me) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mousePressed(MouseEvent me) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseReleased(MouseEvent me) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent me) {
//                panel.setBackground(Color.green);
            }

            @Override
            public void mouseExited(MouseEvent me) {
//                java.awt.Point p = new java.awt.Point(me.getLocationOnScreen());
//                SwingUtilities.convertPointFromScreen(p, me.getComponent());
//                if(me.getComponent().contains(p)) {return;}
//                panel.setBackground(null);
            }
        });
        JLabel J = new JLabel(abf+"");
        JLabel J1 = new JLabel(sdsd);
        panel.add(J);
        panel.add(J1);
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        container.add(panel);
    }
}