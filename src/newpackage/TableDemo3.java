/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;
// TableDemo3.java

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

class TableDemo3 extends JFrame implements ActionListener
{
  JTable jt;

  boolean horizFlag;
  boolean vertFlag;

  TableDemo3 (String title)
  {
   // Pass the title to the JFrame superclass so that it appears in
   // the title bar.

   super (title);

   // Tell the program to exit when the user either selects Close
   // from the System menu or presses an appropriate X button on the
   // title bar.

   setDefaultCloseOperation (EXIT_ON_CLOSE);

   // Create a table with a default table model that specifies 10
   // rows by 10 columns dimensions.

   jt = new JTable (new DefaultTableModel (10, 10));

   // Add the table to the center portion of the frame window's
   // content pane.

   getContentPane ().add (jt);

   // Create a panel for positioning buttons.

   JPanel jp = new JPanel ();

   // Create a "Change Grid Color" button, register the current
   // TableDemo3 object as a listener to that button's action 
   // events, and add that button to the panel.

   JButton jb = new JButton ("Change Grid Color");
   jb.addActionListener (this);
   jp.add (jb);

   // Create a "Show/Hide Horizontal Lines" button, register the
   // current TableDemo3 object as a listener to that button's 
   // action events, and add that button to the panel.

   jb = new JButton ("Show/Hide Horizontal Lines");
   jb.addActionListener (this);
   jp.add (jb);

   // Create a "Show/Hide Vertical Lines" button, register the
   // current TableDemo3 object as a listener to that button's 
   // action events, and add that button to the panel.

   jb = new JButton ("Show/Hide Vertical Lines");
   jb.addActionListener (this);
   jp.add (jb);

   // Add the panel to the south portion of the frame window's
   // content pane.

   getContentPane ().add (jp, BorderLayout.SOUTH);

   // Establish the frame's initial size as 600x250 pixels.

   setSize (600, 250);

   // Display the frame window and all contained components.

   setVisible (true);
  }

  public void actionPerformed (ActionEvent e)
  {
   // Obtain a reference to the JButton object associated with the
   // peer window from where an action event was fired.

   JButton jb = (JButton) e.getSource ();

   // Obtain the JButton's text label.

   String label = jb.getText ();

   // If the label equals "Change Grid Color," then change the grid
   // color. If the label equals "Show/Hide Horizontal Lines," then
   // show or hide those lines by calling setShowHorizontalLines()
   // with the horizFlag Boolean argument value. Then toggle the
   // state of horizFlag so the next call to that method undoes the
   // current call. If label does not match the previous two 
   // strings,
   // then show or hide vertical lines by calling
   // setShowVerticalLines() with the vertFlag Boolean argument
   // value. Then toggle the state of vertFlag so the next call to
   // that method undoes the current call.

   if (label.equals ("Change Grid Color"))
     jt.setGridColor (new Color (rnd (256), rnd (256), 
                   rnd (256)));
   else
   if (label.equals ("Show/Hide Horizontal Lines"))
   {
     jt.setShowHorizontalLines (horizFlag);
     horizFlag = !horizFlag;
   }
   else
   {
     jt.setShowVerticalLines (vertFlag);
     vertFlag = !vertFlag;
   }
  }

  public static int rnd (int limit)
  {
   // Return a random number greater than or equal to 0 and less
   // than limit.

   return (int) (Math.random () * limit);
  }

  public static void main (String [] args)
  {
   // Create a TableDemo3 object, which creates the GUI.

   new TableDemo3 ("Table Demo #3");
  }
}