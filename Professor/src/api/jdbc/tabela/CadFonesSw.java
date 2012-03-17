package api.jdbc.tabela;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.text.ParseException;

import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.TableColumn;
import javax.swing.text.MaskFormatter;

import objeto.old.Fone;
import objeto.old.TipoFone;

public class CadFonesSw extends JFrame {

  private static final long serialVersionUID = 1L;
  private JPanel jContentPane = null;
  private JLabel lbTipo = null;
  private JComboBox<TipoFone> cbTipo = null;
  private JLabel lbDdd = null;
  private JTextField tfDdd = null;
  private JLabel lbNum = null;
  private JTextField tfNum = null;
  private JScrollPane jScrollPane = null;
  private JTable tbFones = null;
  private JButton btInclui = null;
  private JButton btSair = null;
  private FoneTableDb foneModel = new FoneTableDb();

  /**
   * This method initializes cbTipo
   * 
   * @return javax.swing.JComboBox
   */
  private JComboBox<TipoFone> getCbTipo() {
    if(cbTipo == null) {
      cbTipo = new JComboBox<TipoFone>();
      cbTipo.setModel(new DefaultComboBoxModel<TipoFone>(TipoFone.values()));
      cbTipo.setBounds(new Rectangle(60, 60, 145, 24));
    }
    return cbTipo;
  }

  /**
   * This method initializes tfDdd
   * 
   * @return javax.swing.JTextField
   */
  private JTextField getTfDdd() {
    if(tfDdd == null) {
      try {
        MaskFormatter mask = new MaskFormatter("##");
        mask.setValidCharacters(" 0123456789");
        tfDdd = new JFormattedTextField(mask);
      } catch(ParseException ex) {
        System.err.println("DDD: mascara invalida!");
        tfDdd = new JTextField();
      }
      tfDdd.setBounds(new Rectangle(225, 60, 56, 23));
    }
    return tfDdd;
  }

  private JTextField getNewTfDdd() {
    JTextField tfDdd = null;
    try {
      MaskFormatter mask = new MaskFormatter("##");
      mask.setValidCharacters(" 0123456789");
      tfDdd = new JFormattedTextField(mask);
    } catch(ParseException ex) {
      System.err.println("DDD: mascara invalida!");
      tfDdd = new JTextField();
    }
    tfDdd.setBounds(new Rectangle(225, 60, 56, 23));
    return tfDdd;
  }

  /**
   * This method initializes tfNum
   * 
   * @return javax.swing.JTextField
   */
  private JTextField getTfNum() {
    if(tfNum == null) {
      try {
        MaskFormatter mask = new MaskFormatter("####-####");
        mask.setValidCharacters(" 0123456789");
        tfNum = new JFormattedTextField(mask);
      } catch(ParseException ex) {
        System.err.println("DDD: mascara invalida!");
        tfNum = new JTextField();
      }
      tfNum.setBounds(new Rectangle(300, 60, 130, 21));
    }
    return tfNum;
  }

  private JTextField getNewTfNum() {
    JTextField tfNum = null;
    try {
      MaskFormatter mask = new MaskFormatter("####-####");
      mask.setValidCharacters(" 0123456789");
      tfNum = new JFormattedTextField(mask);
    } catch(ParseException ex) {
      System.err.println("DDD: mascara invalida!");
      tfNum = new JTextField();
    }
    tfNum.setBounds(new Rectangle(300, 60, 130, 21));
    return tfNum;
  }

  /**
   * This method initializes jScrollPane
   * 
   * @return javax.swing.JScrollPane
   */
  private JScrollPane getJScrollPane() {
    if(jScrollPane == null) {
      jScrollPane = new JScrollPane();
      jScrollPane.setBounds(new Rectangle(35, 165, 431, 242));
      jScrollPane.setViewportView(getTbFones());
    }
    return jScrollPane;
  }

  /**
   * This method initializes tbFones
   * 
   * @return javax.swing.JTable
   */
  private JTable getTbFones() {
    if(tbFones == null) {
      tbFones = new JTable();
      tbFones.setModel(foneModel);
      tbFones.setAutoCreateRowSorter(true); // ordena automaticamente os valores na tabela
      
//      TableRowSorter<TableModel> sorter = 
//        new TableRowSorter<TableModel>(foneModel);
//      tbFones.setRowSorter(sorter);

      JComboBox<TipoFone> cbTipo2 = new JComboBox<TipoFone>();
      cbTipo2.setModel(new DefaultComboBoxModel<TipoFone>(TipoFone.values()));

      TableColumn cm = tbFones.getColumnModel().getColumn(0);
      cm.setCellEditor(new DefaultCellEditor(cbTipo2));
      cm = tbFones.getColumnModel().getColumn(1);
      cm.setCellEditor(new DefaultCellEditor(getNewTfDdd()));
      cm = tbFones.getColumnModel().getColumn(2);
      cm.setCellEditor(new DefaultCellEditor(getNewTfNum()));
    }
    return tbFones;
  }

  /**
   * This method initializes btInclui
   * 
   * @return javax.swing.JButton
   */
  private JButton getBtInclui() {
    if(btInclui == null) {
      btInclui = new JButton();
      btInclui.setBounds(new Rectangle(60, 105, 105, 31));
      btInclui.setMnemonic(KeyEvent.VK_I);
      btInclui.setText("Incluir");
      btInclui.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent e) {
          Fone fone = new Fone();
					fone.setTipo((TipoFone)cbTipo.getSelectedItem());
					fone.setDdd(tfDdd.getText());
					fone.setNumero(tfNum.getText());

					foneModel.add(fone);

					cbTipo.setSelectedIndex(0);
					cbTipo.requestFocus();

					if(tfDdd instanceof JFormattedTextField)
						((JFormattedTextField)tfDdd).setValue(null);
					else
						tfDdd.setText("");
					
					if(tfNum instanceof JFormattedTextField)
						((JFormattedTextField)tfNum).setValue(null);
					else
						tfNum.setText("");
        }
      });
    }
    return btInclui;
  }

  /**
   * This method initializes btSair
   * 
   * @return javax.swing.JButton
   */
  private JButton getBtSair() {
    if(btSair == null) {
      btSair = new JButton();
      btSair.setBounds(new Rectangle(315, 105, 103, 30));
      btSair.setMnemonic(KeyEvent.VK_S);
      btSair.setText("Sair");
      btSair.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent e) {
          System.exit(0);
        }
      });
    }
    return btSair;
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        CadFonesSw thisClass = new CadFonesSw();
        thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        thisClass.setLocationRelativeTo(null);
        thisClass.setVisible(true);
      }
    });
  }

  /**
   * This is the default constructor
   */
  public CadFonesSw() {
    super();
    initialize();
  }

  /**
   * This method initializes this
   * 
   * @return void
   */
  private void initialize() {
    this.setSize(498, 451);
    this.setContentPane(getJContentPane());
    this.setTitle("Cadastro de Telefones");
    this.getRootPane().setDefaultButton(btInclui);
  }

  /**
   * This method initializes jContentPane
   * 
   * @return javax.swing.JPanel
   */
  private JPanel getJContentPane() {
    if(jContentPane == null) {
      lbNum = new JLabel();
      lbNum.setBounds(new Rectangle(300, 30, 57, 15));
      lbNum.setText("Numero");
      lbDdd = new JLabel();
      lbDdd.setBounds(new Rectangle(225, 30, 38, 15));
      lbDdd.setText("DDD");
      lbTipo = new JLabel();
      lbTipo.setBounds(new Rectangle(60, 30, 38, 15));
      lbTipo.setText("Tipo");
      jContentPane = new JPanel();
      jContentPane.setLayout(null);
      jContentPane.add(lbTipo, null);
      jContentPane.add(getCbTipo(), null);
      jContentPane.add(lbDdd, null);
      jContentPane.add(getTfDdd(), null);
      jContentPane.add(lbNum, null);
      jContentPane.add(getTfNum(), null);
      jContentPane.add(getJScrollPane(), null);
      jContentPane.add(getBtInclui(), null);
      jContentPane.add(getBtSair(), null);
    }
    return jContentPane;
  }

}  //  @jve:decl-index=0:visual-constraint="7,0"
