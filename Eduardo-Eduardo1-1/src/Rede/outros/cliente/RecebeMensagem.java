package Rede.outros.cliente;

import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class RecebeMensagem implements Runnable {
	public BufferedReader recebe;
	String t;
	JTextArea ta;
	Thread tred;

	public RecebeMensagem(JTextArea taMensagem) {
		ta = taMensagem;
		tred = new Thread(this);
		// tred.sleep(10);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		while (!tred.isInterrupted()) {

			try {
				ta.append(recebe.readLine() + '\n');

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}
		}

	}
}
