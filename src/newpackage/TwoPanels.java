/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TwoPanels extends JFrame {

    public TwoPanels() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        final JPanel panel1 = new JPanel();
        panel1.setBackground(Color.RED);
        final JPanel panel2 = new JPanel();
        panel2.setBackground(Color.BLUE);

        JButton button = new JButton("ADD AND REMOVE PANEL");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (panel1.isShowing()) {
                    remove(panel1);
                    add(panel2, BorderLayout.CENTER);
                    revalidate();
                    repaint();
                } else if (panel2.isShowing()) {
                    remove(panel2);
                    add(panel1, BorderLayout.CENTER);
                    revalidate();
                    repaint();
                }
            }
        });

        add(panel1, BorderLayout.CENTER);
        add(button, BorderLayout.PAGE_END);

        pack();
        setLocationByPlatform(true);
        setVisible(true);
    }

    public static void main(String... args) {
        SwingUtilities.invokeLater(new  Runnable() {
            @Override
            public void run() {
                new TwoPanels();
            }
        });
    }
}