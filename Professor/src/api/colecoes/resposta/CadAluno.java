package api.colecoes.resposta;

import static api.gui.Util.criaBotao;
import static api.gui.Util.criaPainel;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class CadAluno extends JFrame implements ActionListener {
	private JTextField tfNome = new JTextField(10);
	private JTextField tfMatr = new JTextField(10);
	private JButton btInserir =	criaBotao("Inserir", KeyEvent.VK_I, this);
	private JButton btListar = criaBotao("Listar", KeyEvent.VK_L, this);
	private JButton btSair = criaBotao("Sair", KeyEvent.VK_S, this);
	private Set<Aluno> lista = new TreeSet<Aluno>();
	private int matricula = 1;
	
 	public CadAluno() {
		setTitle("Cad Aluno");
		add(criaPainel(new GridLayout(2,1),
				criaPainel("Nome", tfNome),
				criaPainel("Matricula", tfMatr)
				), "Center");
		add(criaPainel(btInserir, btListar, btSair),
				"South");
		
		tfMatr.setEditable(false);
		tfMatr.setText(String.valueOf(matricula++));
		
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getRootPane().setDefaultButton(btInserir);
		setResizable(false);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ev) {
		String cmd = ev.getActionCommand();
		
		if(cmd.equals("Inserir")) {
			Aluno a = new Aluno();
			a.setNome(tfNome.getText());
			a.setMatricula(tfMatr.getText());
			if(!lista.add(a)) 
				JOptionPane.showMessageDialog(this, "O Aluno ja foi cadastrado previamente!");
			else {
				tfNome.setText("");
				tfNome.requestFocus();
				tfMatr.setText(String.valueOf(matricula++));			
			}
		} else if(cmd.equals("Listar")) {
			StringBuilder sb = new StringBuilder("Relatorio de Alunos\n\n");
			for (Aluno a : lista)
				sb.append(a + "\n");
			
			JOptionPane.showMessageDialog(this, sb.toString());
		} else {
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		new CadAluno();
	}
}
