/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DynamicERP.frames.mainpkg;

import java.awt.Component;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

/**
 *
 * @author Shan
 */
class CustomeTreeCellRenderer extends DefaultTreeCellRenderer {

    public CustomeTreeCellRenderer() {
        try {
            this.root = new CustomTreeNode(new ImageIcon(ImageIO.read(getClass().getResource("/oracledms/frames/resources/delete-xxl_1.png"))));
        } catch (IOException ex) {
            Logger.getLogger(CustomeTreeCellRenderer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    CustomTreeNode root;
    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {

//            if (!leaf) {
        CustomTreeNode node = (CustomTreeNode) value;

        if (node.getIcon() != null) {
            System.out.println(node + " - " + node.getIcon());
            setClosedIcon(node.getIcon());
            setOpenIcon(node.getIcon());
            setLeafIcon(node.getIcon());
        } else {
            System.out.println(node + " - default");
            setClosedIcon(getDefaultClosedIcon());
            setLeafIcon(getDefaultLeafIcon());
            setOpenIcon(getDefaultOpenIcon());
        }
//            }

        super.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);

        return this;
    }
    
}