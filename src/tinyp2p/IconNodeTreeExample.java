/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tinyp2p;


import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Hashtable;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.plaf.metal.MetalIconFactory;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

/**
 * @version 1.0 01/12/99
 */
public class IconNodeTreeExample extends JFrame {
  public IconNodeTreeExample() {
    super("IconNode TreeExample");

    String[] strs = { "swing home", // 0
        "platf", // 1
        "basic.txt", // 2
        "metal.c", // 3
        "metal.java", // 4
        "metal.html", // 5
        "Computer", // 6
        "A:", // 7
        "C:", // 8
        "D:" }; // 9

    IconNode[] nodes = new IconNode[strs.length];
    for (int i = 0; i < strs.length; i++)
      nodes[i] = new IconNode(strs[i]);
    nodes[0].add(nodes[1]);
    for (int i = 2; i <= 5; i++)
      nodes[1].add(nodes[i]);
    nodes[0].add(nodes[6]);
    for (int i = 7; i <= 9; i++)
      nodes[6].add(nodes[i]);

    //
    // set Icon directly
    //
    nodes[0].setIcon(MetalIconFactory.getFileChooserHomeFolderIcon());

    //
    // use JTree default Icon
    //
    // nodes[1]
    // nodes[2]

    //
    // set Icon by user Object
    //
    // nodes[3]
    // nodes[4]
    // nodes[5]

    //
    // set Icon by name
    //
    nodes[6].setIconName("computer");
    nodes[7].setIconName("floppyDrive");
    nodes[8].setIconName("hardDrive");
    nodes[9].setIconName("hardDrive");

    JTree tree = new JTree(nodes[0]);
    tree.putClientProperty("JTree.icons", makeIcons());
    tree.setCellRenderer(new IconNodeRenderer());
    JScrollPane sp = new JScrollPane(tree);
    getContentPane().add(sp, BorderLayout.CENTER);
  }

  private Hashtable makeIcons() {
    Hashtable icons = new Hashtable();
    icons.put("floppyDrive", MetalIconFactory.getTreeFloppyDriveIcon());
    icons.put("hardDrive", MetalIconFactory.getTreeHardDriveIcon());
    icons.put("computer", MetalIconFactory.getTreeComputerIcon());
    icons.put("c", TextIcons.getIcon("c"));
    icons.put("java", TextIcons.getIcon("java"));
    icons.put("html", TextIcons.getIcon("html"));
    return icons;
  }

  public static void main(String args[]) {
    try {
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
    } catch (Exception evt) {}
  
    IconNodeTreeExample frame = new IconNodeTreeExample();
    frame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
    frame.setSize(300, 150);
    frame.setVisible(true);
  }
}

class IconNodeRenderer extends DefaultTreeCellRenderer {

  public Component getTreeCellRendererComponent(JTree tree, Object value,
      boolean sel, boolean expanded, boolean leaf, int row,
      boolean hasFocus) {

    super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf,
        row, hasFocus);

    Icon icon = ((IconNode) value).getIcon();

    if (icon == null) {
      Hashtable icons = (Hashtable) tree.getClientProperty("JTree.icons");
      String name = ((IconNode) value).getIconName();
      if ((icons != null) && (name != null)) {
        icon = (Icon) icons.get(name);
        if (icon != null) {
          setIcon(icon);
        }
      }
    } else {
      setIcon(icon);
    }

    return this;
  }
}

class IconNode extends DefaultMutableTreeNode {

  protected Icon icon;

  protected String iconName;

  public IconNode() {
    this(null);
  }

  public IconNode(Object userObject) {
    this(userObject, true, null);
  }

  public IconNode(Object userObject, boolean allowsChildren, Icon icon) {
    super(userObject, allowsChildren);
    this.icon = icon;
  }

  public void setIcon(Icon icon) {
    this.icon = icon;
  }

  public Icon getIcon() {
    return icon;
  }

  public String getIconName() {
    if (iconName != null) {
      return iconName;
    } else {
      String str = userObject.toString();
      int index = str.lastIndexOf(".");
      if (index != -1) {
        return str.substring(++index);
      } else {
        return null;
      }
    }
  }

  public void setIconName(String name) {
    iconName = name;
  }

}

class TextIcons extends MetalIconFactory.TreeLeafIcon {

  protected String label;

  private static Hashtable labels;

  protected TextIcons() {
  }

  public void paintIcon(Component c, Graphics g, int x, int y) {
    super.paintIcon(c, g, x, y);
    if (label != null) {
      FontMetrics fm = g.getFontMetrics();

      int offsetX = (getIconWidth() - fm.stringWidth(label)) / 2;
      int offsetY = (getIconHeight() - fm.getHeight()) / 2 - 2;

      g.drawString(label, x + offsetX, y + offsetY + fm.getHeight());
    }
  }

  public static Icon getIcon(String str) {
    if (labels == null) {
      labels = new Hashtable();
      setDefaultSet();
    }
    TextIcons icon = new TextIcons();
    icon.label = (String) labels.get(str);
    return icon;
  }

  public static void setLabelSet(String ext, String label) {
    if (labels == null) {
      labels = new Hashtable();
      setDefaultSet();
    }
    labels.put(ext, label);
  }

  private static void setDefaultSet() {
    labels.put("c", "C");
    labels.put("java", "J");
    labels.put("html", "H");
    labels.put("htm", "H");

    // and so on
    /*
     * labels.put("txt" ,"TXT"); labels.put("TXT" ,"TXT"); labels.put("cc"
     * ,"C++"); labels.put("C" ,"C++"); labels.put("cpp" ,"C++");
     * labels.put("exe" ,"BIN"); labels.put("class" ,"BIN");
     * labels.put("gif" ,"GIF"); labels.put("GIF" ,"GIF");
     * 
     * labels.put("", "");
     */
  }
}
