package abstractDemo2.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import abstractDemo2.util.*;

@SuppressWarnings("serial")
public class ColorPainel extends JDialog {
  private JColorChooser chooser = new JColorChooser();
  
  public JColorChooser getColorChooser() {
    return chooser;
  }
  
  public ColorPainel() {
    super();
    setTitle("Drag Color Panel");
    setModal(false);
    setLayout(new BorderLayout());
    setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

    chooser.setDragEnabled(true);
    add(chooser, "Center");
    
    JPanel temp = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JButton btOk = Maker.mkBotao("Ok", new ActionListener() {
      public void actionPerformed(ActionEvent ev) {
        setVisible(false);
      }
    });
    temp.add(btOk);
    getRootPane().setDefaultButton(btOk);
    add(temp, "South");
    
    pack();
    setLocationRelativeTo(getParent());
  }
}
