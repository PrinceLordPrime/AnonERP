/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class Main {
  public static void main(String args[]) {
    JFrame f = new JFrame();
    f.setLayout(new FlowLayout());
    f.setSize(240, 250);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JScrollPane jscrlpLabel = new JScrollPane(new JLabel(
        "<html>A<br>B<br>C<br>D<br>E<br>F<br>G<br>H<br></html>."));

    jscrlpLabel.setPreferredSize(new Dimension(200, 100));

    JLabel label = new JLabel("Option");
    JCheckBox a = new JCheckBox("A");
    JCheckBox b = new JCheckBox("B");
    JCheckBox c = new JCheckBox("C");
    JCheckBox d = new JCheckBox("D");
    JCheckBox e = new JCheckBox("E");

    Box box = Box.createVerticalBox();

    box.add(label);
    box.add(a);
    box.add(b);
    box.add(c);
    box.add(d);
    box.add(e);

    JScrollPane jscrlpBox = new JScrollPane(box);
    jscrlpBox.setPreferredSize(new Dimension(140, 90));
    f.add(jscrlpLabel);
    f.add(jscrlpBox);

    f.setVisible(true);
  }
}