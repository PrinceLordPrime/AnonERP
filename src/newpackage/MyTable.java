/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class MyTable extends JTable implements MouseMotionListener {
    int mouseHoverRow = -1;

    public MyTable() {
           addMouseMotionListener(this);
    }

    //codes

    public Component prepareRenderer(TableCellRenderer renderer, int rowIndex,
            int vColIndex) {
        Component c = super.prepareRenderer(renderer, rowIndex, vColIndex);
        Color back = getSelectionBackground();
        int red = back.getRed();
        int green = back.getGreen();
        int blue = back.getBlue();
        if (rowIndex == mouseHoverRow) {
            c.setBackground(Color.LIGHT_GRAY);
        } else {
            c.setBackground(getBackground());
        }
        return c;
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        Point p = new Point(e.getX(), e.getY());
        mouseHoverRow = rowAtPoint(p);
//        mouseHoverCol = columnAtPoint(p);
        prepareRenderer(getCellRenderer(20, 20),p.y, p.x);
    }
}