package jcalendar;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.greef.ui.calendar.JCalendar;

@SuppressWarnings("serial")
public class TesteCalendario extends JFrame implements ActionListener {
	
	private JPanel contentPane;
	private JLabel lblCalendrio;
	private JButton btnSeleciona;
	private JButton btnSair;
	private JCalendar calendar;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TesteCalendario frame = new TesteCalendario();
					frame.setVisible(true);
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public TesteCalendario() {
		initComponents();
	}
	
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 326, 235);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblCalendrio());
		contentPane.add(getBtnSeleciona());
		contentPane.add(getBtnSair());
		
		calendar = new JCalendar();
		calendar.setBounds(22, 31, 156, 127);
		contentPane.add(calendar);
	}
	
	private JLabel getLblCalendrio() {
		if(lblCalendrio == null) {
			lblCalendrio = new JLabel("Calend\u00E1rio");
			lblCalendrio.setBounds(22, 12, 76, 15);
		}
		return lblCalendrio;
	}
	
	private JButton getBtnSeleciona() {
		if(btnSeleciona == null) {
			btnSeleciona = new JButton("Seleciona");
			btnSeleciona.addActionListener(this);
			btnSeleciona.setBounds(22, 170, 107, 25);
		}
		return btnSeleciona;
	}
	
	private JButton getBtnSair() {
		if(btnSair == null) {
			btnSair = new JButton("Sair");
			btnSair.addActionListener(this);
			btnSair.setBounds(201, 170, 107, 25);
		}
		return btnSair;
	}
	
	public void actionPerformed(ActionEvent ev) {
		String cmd = ev.getActionCommand();
		
		if(cmd.equals("Seleciona")) {
			JOptionPane.showMessageDialog(this, calendar.getSelectedDate());
		} else {
			System.exit(0);
		}
	}
}
