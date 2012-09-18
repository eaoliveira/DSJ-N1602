package api.colecoes.resposta;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class CadFone extends JFrame implements ActionListener {
	private JTextField tfDdd = new JTextField(5);
	private JTextField tfNum = new JTextField(10);
	private JComboBox<TipoFone> cbTipo  = new JComboBox<TipoFone>(TipoFone.values());
	private JButton btSalvar = criaBotao("Salvar", this);
	private JButton btListar = criaBotao("Listar", this);
	private JButton btSair = criaBotao("Sair", this);
	
	List<Fone> lista = new ArrayList<Fone>();
	
	public CadFone() {
		setTitle("Cad Fone");
		
		add(
				criaPainel(new GridLayout(2, 1),
				   criaPainel(new FlowLayout(FlowLayout.LEFT, 15, 5),
				     criaPainel(new JLabel("DDD"), tfDdd),
				     criaPainel(new JLabel("N."), tfNum)),
				   criaPainel(new JLabel("Tipo"), cbTipo))
				, "Center");
		
		add(criaPainel(new FlowLayout(FlowLayout.CENTER, 15, 5),
				btSalvar, btListar, btSair)
				, "South");
		
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ev) {
		String cmd = ev.getActionCommand();

		if (cmd.equals("Salvar")) {
			Fone f = new Fone();
			f.setDdd(tfDdd.getText());
			f.setNumero(tfNum.getText());
			f.setTipo((TipoFone)cbTipo.getSelectedItem());
			lista.add(f);
			
			tfDdd.setText("");
			tfNum.setText("");
			cbTipo.setSelectedIndex(0);
			tfDdd.requestFocus();
			
		} else if (cmd.equals("Listar")) {
			StringBuilder sb = new StringBuilder("Lista de Fones Cadastrados\n\n");
			for (Fone f : lista)
				sb.append(f + "\n");
			
			JOptionPane.showMessageDialog(this, sb.toString());
		} else {
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		new CadFone();
	}

  private JButton criaBotao(String label, ActionListener act) {	
	   JButton bt = new JButton(label);
	   bt.addActionListener(act);
	   return bt;
  }
  
  private JPanel criaPainel(LayoutManager layout, JComponent ... obj) {
		JPanel pn = new JPanel();
		pn.setLayout(layout);
		for (JComponent o : obj) {
			pn.add(o);
		}
	 return pn;
  }  
  
  private JPanel criaPainel(JComponent ... obj) {
  	return criaPainel(new FlowLayout(FlowLayout.LEFT, 5, 5), obj);
  }
}
