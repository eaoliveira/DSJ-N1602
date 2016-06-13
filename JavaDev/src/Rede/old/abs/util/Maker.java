package Rede.old.abs.util;

import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

public class Maker {
  private Maker() {
  }

  public static JMenu makeMenu(MenuDefs menu, MenuDefs[] itens,
      ActionListener ac) {
    JMenu mn = new JMenu(menu.item);

    if(menu.atalho != -1) mn.setMnemonic(menu.atalho);

    if(itens != null) {
      for(MenuDefs menuIt : itens) {
        if(menuIt.item == null)
          mn.add(new JSeparator());
        else {
          JMenuItem it = null;

          if(menuIt.icone != null)
            it = new JMenuItem(menuIt.item, menuIt.icone);
          else
            it = new JMenuItem(menuIt.item);

          if(menuIt.comando != null) it.setActionCommand(menuIt.comando);

          it.setMnemonic(menuIt.atalho);
          it.setAccelerator(KeyStroke.getKeyStroke(
            menuIt.acelKey != -1 ? menuIt.acelKey : menuIt.atalho,
            ActionEvent.ALT_MASK));
          it.addActionListener(ac);
          mn.add(it);
        }
      }
    }

    return mn;
  }

  @SuppressWarnings("serial")
	public static JToolBar makeToolBar(MenuDefs[] itens, ActionListener ac) {
    JToolBar tb = new JToolBar();

    if(itens != null) {
      for(MenuDefs menuIt : itens) {
        if(menuIt.item == null)
          tb.add(Box.createHorizontalStrut(5));
        else {
          JButton bt = null;

          if(menuIt.icone != null)
            bt = new JButton(menuIt.icone) {
              public float getAlignmentY() {
                return 0.5f;
              }
            };
          else
            bt = new JButton(menuIt.item) {
              public float getAlignmentY() {
                return 0.5f;
              }
            };

          if(menuIt.comando != null) 
            bt.setActionCommand(menuIt.comando);

          bt.setRequestFocusEnabled(false);
          bt.setMargin(new Insets(1, 1, 1, 1));
          bt.setMnemonic(menuIt.atalho);
          bt.addActionListener(ac);

          if(menuIt.dica != null)
            bt.setToolTipText(menuIt.dica);

          tb.add(bt);
        }
      }
    }
    tb.add(Box.createHorizontalGlue());

    return tb;
  }

  public static JButton mkBotao(String label, ActionListener act) {
    JButton temp = new JButton(label);
    temp.addActionListener(act);

    return temp;
  }

  public static JButton mkBotao(String label, String cmd, ActionListener act) {
    JButton temp = mkBotao(label, act);
    temp.setActionCommand(cmd);

    return temp;
  }

  public static JPanel mkPainel(String label, JComponent cmp) {
    JPanel temp = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
    temp.add(new JLabel(label));
    temp.add(cmp);

    return temp;
  }

  public static Border mkTitledBorder(String titulo) {
    return BorderFactory.createCompoundBorder(
      BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
        titulo), BorderFactory.createEmptyBorder(3, 3, 3, 3));
  }
}
