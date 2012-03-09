package objeto.resposta;

import static objeto.resposta.SwingUtil.criaBotao;
import static objeto.resposta.SwingUtil.criaCampo;
import static objeto.resposta.SwingUtil.criaPainel;
import static objeto.resposta.SwingUtil.painelBotao;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class TelaPessoas extends JFrame implements ActionListener {
	private List<Pessoa> lista = new ArrayList<>();
	
	private JTextField tfNome = new JTextField(20);
	private JTextField tfFone = new JTextField(15);
	private JTabbedPane tab = new JTabbedPane();
	private JTextField tfRg = new JTextField(20);
	private JTextField tfCpf = new JTextField(20);
	private JTextField tfEmail = new JTextField(20);
	private JTextField tfCnpj = new JTextField(20);
	private JTextField tfIncr = new JTextField(20);
	private JTextField tfSite = new JTextField(20);
	private JButton btIncluir = criaBotao("Incluir", KeyEvent.VK_I, this);
	private JButton btListar = criaBotao("Listar", KeyEvent.VK_L, this);
	private JButton btSair = criaBotao("Sair", KeyEvent.VK_S, this);
	private JButton btEnd = criaBotao("...", KeyEvent.VK_PERIOD, this);

	public TelaPessoas() {
		setTitle("Cadastro de Pessoas");

		add(criaPainel(
				new GridLayout(2, 1),
				criaCampo("Nome", tfNome),
				criaPainel(new FlowLayout(FlowLayout.LEADING, 0, 0),
						criaCampo("Fone", tfFone), criaCampo("End.", btEnd))), "North");

		tab.addTab(
				"Fisica",
				criaPainel(new GridLayout(3, 1), criaCampo("RG", tfRg),
						criaCampo("CPF", tfCpf), criaCampo("E-mail", tfEmail)));

		tab.addTab(
				"Juridica",
				criaPainel(new GridLayout(3, 1), criaCampo("CNPJ", tfCnpj),
						criaCampo("I.E.", tfIncr), criaCampo("Sitel", tfSite)));

		add(tab, "Center");

		add(painelBotao(btIncluir, btListar, btSair), "South");

		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ev) {
		String cmd = ev.getActionCommand();

		if (cmd.equals("Incluir")) {
			if(tab.getSelectedIndex() ==0) {
				PessoaFisica p = new PessoaFisica();
				p.setNome(tfNome.getText());
				p.setFone(tfFone.getText());
				p.setRg(tfRg.getText());
				p.setCpf(tfCpf.getText());
				p.setEmail(tfEmail.getText());
				
				lista.add(p);
			} else {
				PessoaJuridica p = new PessoaJuridica();
				p.setNome(tfNome.getText());
				p.setFone(tfFone.getText());
				p.setCnpj(tfCnpj.getText());
				p.setIncrEst(tfIncr.getText());
				p.setSite(tfSite.getText());
				
				lista.add(p);
			}
			
			tfNome.requestFocus();
			tfNome.setText("");
			tfFone.setText("");
			tfRg.setText("");
			tfCpf.setText("");
			tfEmail.setText("");
			tfCnpj.setText("");
			tfIncr.setText("");
			tfSite.setText("");
		} else if (cmd.equals("Listar")) {
			String txt = "Cadastro de Pessoas\n\n";
			for (int i = 0;i < lista.size();i++)
				txt += lista.get(i) + "\n";
			
			JOptionPane.showMessageDialog(this, txt);
		} else if (cmd.equals("...")) {

		} else {
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new TelaPessoas();
			}
		});
	}
}
