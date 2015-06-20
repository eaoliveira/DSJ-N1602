package Visao;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Modelo.Agencia;
import Modelo.Caixa;


public class Janela extends JFrame implements Runnable {

	Agencia agencia;

	JLabel lbAgenciaBancaria, lbFilaPreferencial, lbNrPessoas, lbFilaNormal,
			lbCaixas;
	JTextField tfFilaPreferencial, tfFilaNormal, tfQtdPEssoas;
	ArrayList<Caixa> arrayCaixas;
	ArrayList<JTextField> arrayTextField;
	JButton btAbreAgencia, btFecharAgencia;
	JPanel pnAgenciaBancaria, pnLabels, pnQtdPessoas, pnLbCaixa, pnCaixas,
			pnBotao, pnPrincipal, pnTextField, pnTeste;
	
	Thread thread;


	public Janela() {
		agencia = new Agencia();

		this.lbAgenciaBancaria = new JLabel(
				"Agencia Bancaria - Simulação de Filas");
		this.lbAgenciaBancaria.setFont(new Font("Font.BOL", Font.BOLD, 16));
		this.lbFilaPreferencial = new JLabel("Fila Preferencial");
		this.lbFilaNormal = new JLabel("Fila Normal");
		this.lbNrPessoas = new JLabel("N° de pessoas");
		this.lbCaixas = new JLabel("Caixas");
		this.lbCaixas.setFont(new Font("bold", Font.BOLD, 14));

		this.tfQtdPEssoas = new JTextField("10/S");
		this.tfFilaNormal = new JTextField("0");
		this.tfFilaPreferencial = new JTextField("0");

		this.arrayTextField = new ArrayList<JTextField>();
		this.arrayCaixas = new ArrayList<Caixa>();
		for (Caixa caixa : this.agencia.getListaDeCaixa()) {
			JTextField t = new JTextField("Nenhum");
			t.setFont(new Font("teste", Font.BOLD, 15));
			this.arrayTextField.add(t);

			this.arrayCaixas.add(caixa);
		}

		this.btAbreAgencia = new JButton("Abre a Agencia");
		this.btAbreAgencia.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				agencia.abrir();
				//thread = new Thread(this);
				
				
				//JOptionPane.showMessageDialog(null, agencia.estaAberta);

			}
		});
		this.btFecharAgencia = new JButton("Fehcar a Agencia");
		this.btFecharAgencia.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				agencia.fechar();
				//JOptionPane.showMessageDialog(null, agencia.estaAberta);

			}
		});
		this.pnTeste = new JPanel(new GridLayout(2, 3, 10, 10));
		this.pnAgenciaBancaria = new JPanel(new FlowLayout());
		this.pnAgenciaBancaria.add(this.lbAgenciaBancaria, BorderLayout.CENTER);
		this.pnLabels = new JPanel(new FlowLayout());

		/*
		 * this.pnLabels.add(lbFilaPreferencial);
		 * this.pnLabels.add(lbNrPessoas); this.pnLabels.add(lbFilaNormal);
		 */

		this.pnTeste.add(lbFilaPreferencial);
		this.pnTeste.add(lbNrPessoas);
		this.pnTeste.add(lbFilaNormal);
		this.pnTeste.add(tfFilaPreferencial);
		this.pnTeste.add(tfQtdPEssoas);
		this.pnTeste.add(tfFilaNormal);

		/*
		 * this.pnLabels.add(tfFilaPreferencial);
		 * this.pnLabels.add(tfQtdPEssoas); this.pnLabels.add(tfFilaNormal);
		 * 
		 * this.pnQtdPessoas = new JPanel(new FlowLayout());
		 * this.pnQtdPessoas.add(tfFilaPreferencial);
		 * this.pnQtdPessoas.add(tfQtdPEssoas);
		 * this.pnQtdPessoas.add(tfFilaNormal);
		 */

		this.pnLbCaixa = new JPanel(new FlowLayout());
		this.pnLbCaixa.add(lbCaixas);
		this.pnTextField = new JPanel(new GridLayout(1, 5, 10, 10));
		for (JTextField text : arrayTextField) {
			this.pnTextField.add(text);
		}
		this.pnBotao = new JPanel(new FlowLayout());
		this.pnBotao.add(btAbreAgencia);
		this.pnBotao.add(btFecharAgencia);

		this.pnPrincipal = new JPanel(new GridLayout(6, 0, 5, 5));
		this.pnPrincipal.add(pnAgenciaBancaria);

		this.pnPrincipal.add(pnTeste);

		/*
		 * this.pnPrincipal.add(pnLabels); this.pnPrincipal.add(pnQtdPessoas);
		 */

		this.pnPrincipal.add(pnLbCaixa);
		this.pnPrincipal.add(pnTextField);
		this.pnPrincipal.add(pnBotao);

		this.add(pnPrincipal);

		this.setSize(600, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	@Override
	public void run() {
		while (!this.thread.isInterrupted()) {
		
			if ( arrayCaixas.get(0).atendimento == null) {
				arrayTextField.get(0).setText("nenhum");
			} else if (arrayCaixas.get(0).atendimento.isYouIsOld()) {

				arrayTextField.get(0).setText("Idoso");
			} else {
				arrayTextField.get(0).setText("Normal");
			}
			/*
			if ( arrayCaixas.get(0).atendimento == null) {
				arrayTextField.get(1).setText("nenhum");
			} else if (arrayCaixas.get(2).atendimento.isYouIsOld()) {

				arrayTextField.get(3).setText("Idoso");
			} else {
				arrayTextField.get(4).setText("Normal");
			}

			*/}
		
	}

	public static void main(String[] args) {
		Janela j = new Janela();
		Thread t = new Thread(j);
		t.start();
	}

}
