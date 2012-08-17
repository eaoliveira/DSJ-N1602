package objeto.resposta;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class CadEndereco extends JDialog implements ActionListener {
	private Endereco end = null;
	private JTextField tfLogr = new JTextField(25);
	private JTextField tfNum = new JTextField(5);
	private JTextField tfCompl = new JTextField(10);
	private JTextField tfBairro = new JTextField(12);
	private JTextField tfCep = new JTextField(8);
	private JTextField tfCidade = new JTextField(12);
	private JTextField tfEstado = new JTextField(3);
	private JButton btInserir = criaBotao("Inserir", KeyEvent.VK_I, this);
	private JButton btFechar = criaBotao("Sair", KeyEvent.VK_S, this);
	
	public CadEndereco(Endereco end, Window tela) {
		this.end = end;
		tfLogr.setText(end.getLogradouro());
		tfNum.setText(end.getNumero());
		tfBairro.setText(end.getBairro());
		tfCep.setText(end.getCep());
		tfCompl.setText(end.getComplemento());
		tfCidade.setText(end.getCidade());
		tfEstado.setText(end.getEstado());
		
		setLayout(new BorderLayout());
		add(criaPainel(new GridLayout(4,  1),
				criaPainel(new FlowLayout(FlowLayout.LEFT,5,5), 
						criaCampo("Logr.", tfLogr)), 
				criaPainel(new FlowLayout(FlowLayout.LEFT,5,5), 
						criaCampo("Nº", tfNum),criaCampo("Compl.", tfCompl)),
				criaPainel(new FlowLayout(FlowLayout.LEFT,5,5), 
								criaCampo("Bairro", tfBairro),criaCampo("CEP", tfCep)),
				criaPainel(new FlowLayout(FlowLayout.LEFT,5,5), 
										criaCampo("Cidade", tfCidade),criaCampo("UF", tfEstado))				
						), BorderLayout.CENTER);
		add(criaPainel(new FlowLayout(FlowLayout.CENTER, 15, 5),
				   btInserir, btFechar)	,	BorderLayout.SOUTH);
		
		setTitle("Cad. Endereço");
		pack();
		setModal(true);
		setLocationRelativeTo(tela);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}

	public JPanel criaPainel(LayoutManager layout, JComponent ... ojbs) {
		JPanel pn = new JPanel();
		pn.setLayout(layout);
		for (JComponent obj : ojbs)
		   pn.add(obj);	
		
		return pn;
	}
	
	public JPanel criaCampo(String label, JComponent obj) {
		JPanel painel = new JPanel();
		painel.add(new JLabel(label));
		painel.add(obj);
		return painel;
	}
	
	public JButton criaBotao(String label, int tecla, ActionListener acao) {
		JButton bt = new JButton(label);
		bt.setMnemonic(tecla);
		bt.addActionListener(acao);
		return bt;
	}
	
	public void actionPerformed(ActionEvent ev) {
		String cmd = ev.getActionCommand();
		if(cmd.equals("Inserir")) { // Inserir
			end.setLogradouro(tfLogr.getText());
			end.setNumero(tfNum.getText());
			end.setBairro(tfBairro.getText());
			end.setCep(tfCep.getText());
			end.setComplemento(tfCompl.getText());
			end.setCidade(tfCidade.getText());
			end.setEstado(tfEstado.getText());
			setVisible(false);
		} else { // Sair
			setVisible(false);
		}
	}

	public static void main(String[] args) {
		try {
			SwingUtilities.invokeAndWait(new Runnable() {
				public void run() {
					Endereco end = new Endereco();
					end.setLogradouro("Rua do Fico");
					end.setNumero("33");
					end.setBairro("Centro");
					end.setCep("01234-213");
					end.setComplemento("apto 12");
					end.setCidade("São Paulo");
					end.setEstado("SP");

					CadEndereco tela = new CadEndereco(end, null);
					tela.setVisible(true);
					
					JOptionPane.showMessageDialog(null, end);
				}
			});
		} catch (InvocationTargetException | InterruptedException e) {
			e.printStackTrace();
		}
	}
}