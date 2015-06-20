package chat;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

@SuppressWarnings("serial")
public class ClienteChatView extends JFrame implements ActionListener, Runnable {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnArquivo;
	private JMenuItem itemMenuConectaDesconecta;
	private JMenuItem itemMenuSair;
	private JScrollPane scrollPane;
	private JTextArea txtHistorico;
	private JLabel lblMensagem;
	private JTextField txtMsg;
	private JButton btnEnviar;
	
	private Socket skt;
	private PrintWriter out;
	private BufferedReader in;
	private Thread threadLeitura;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClienteChatView frame = new ClienteChatView();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ClienteChatView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 539, 296);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnArquivo = new JMenu("Arquivo");
		menuBar.add(mnArquivo);

		itemMenuConectaDesconecta = new JMenuItem("Conectar");
		itemMenuConectaDesconecta.addActionListener(this);
		mnArquivo.add(itemMenuConectaDesconecta);

		itemMenuSair = new JMenuItem("Sair");
		itemMenuSair.addActionListener(this);
		mnArquivo.add(itemMenuSair);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 5, 513, 193);

		lblMensagem = new JLabel("Mensagem:");
		lblMensagem.setBounds(5, 209, 66, 16);

		txtMsg = new JTextField();
		txtMsg.setEnabled(false);
		txtMsg.addActionListener(this);
		txtMsg.setBounds(83, 207, 356, 20);
		txtMsg.setColumns(10);

		btnEnviar = new JButton("Enviar");
		btnEnviar.setEnabled(false);
		btnEnviar.addActionListener(this);
		btnEnviar.setBounds(445, 204, 73, 26);
		contentPane.setLayout(null);

		txtHistorico = new JTextArea();
		txtHistorico.setEditable(false);
		scrollPane.setViewportView(txtHistorico);
		contentPane.add(scrollPane);
		contentPane.add(lblMensagem);
		contentPane.add(txtMsg);
		contentPane.add(btnEnviar);

	}

	public void actionPerformed(ActionEvent e) {
		Object botao = e.getSource();

		try {
			if (botao.equals(itemMenuConectaDesconecta)&&(itemMenuConectaDesconecta.getText().equals("Conectar"))) {//método para conectar
				skt =   new Socket("localhost", 1234);                              // Estabelecendo conexão com o servidor
				out =   new PrintWriter(skt.getOutputStream());                         // envia a mensagem para o servidor através do canal de saída
				in =    new BufferedReader(new InputStreamReader(skt.getInputStream()));// recebe a mensagem do servidor através do canal de entrada
				threadLeitura = new Thread(this);										// cria uma nova thread passando a própria classe como runnable
				threadLeitura.start();													// inicia a thread
				txtMsg.requestFocus();													//pede o foco para o campo
				txtMsg.setEnabled(true);     											//habilita o campo de msg
				btnEnviar.setEnabled(true);                                             //habilita o botão de envio
				itemMenuConectaDesconecta.setText("Desconectar");						//seta o rótulo do menu de conexao

			}else if(botao.equals(itemMenuConectaDesconecta)&&(itemMenuConectaDesconecta.getText().equals("Desconectar"))){
				itemMenuConectaDesconecta.setText("Conectar");							//seta o rótulo do menu de conexao
				out.println("SAIR");													//avisa o servidor que a conexão será encerrada
				out.flush();															//libera a saída 
				threadLeitura.interrupt();												//solicita o fim da conexão
				skt.close();															//finaliza a conexao
				btnEnviar.setEnabled(false);                                            //desabilita o botão de envio
				txtMsg.setEnabled(false);     										    //desabilita o campo de msg
				
				
			}else if (botao.equals(btnEnviar)) {										//ação de enviar
				String msg = txtMsg.getText();											// lê o texto digitado pelo usuário
				out.println(msg);														//envia para o servidor a msg digitada
				out.flush();															//descarrega 
				txtMsg.setText("");														//limpa o campo de msg
				txtMsg.requestFocus();													//pede o foco
			}else if (botao.equals(txtMsg)) {							     			//ação com a tecla enter
				btnEnviar.doClick();							         				//aciona o botao enviar
			} else {																	//ação para desconectar
			int op = JOptionPane.showOptionDialog(this, "Deseja Sair do Chat?", "Sair",JOptionPane.YES_NO_OPTION,  JOptionPane.QUESTION_MESSAGE, null, new String[] { "Sim" , "Não"},"Sim");
			if(op == 0){
				System.exit(0);
			}
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void run() {
		try {
			while (!threadLeitura.isInterrupted()) {
				if(in.ready())
					txtHistorico.append(in.readLine() + "\n");
				Thread.sleep(100);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}
