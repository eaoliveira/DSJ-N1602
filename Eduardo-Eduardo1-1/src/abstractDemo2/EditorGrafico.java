package abstractDemo2;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;

import abstractDemo2.figuras.Circulo;
import abstractDemo2.figuras.Figura;
import abstractDemo2.figuras.Quadrado;
import abstractDemo2.figuras.Triangulo;
import abstractDemo2.gui.ActionListenerLaf;
import abstractDemo2.gui.ColorPainel;
import abstractDemo2.gui.PainelDeFiguras;
import abstractDemo2.util.Maker;
import abstractDemo2.util.MenuDefs;

import com.l2fprod.gui.plaf.skin.SkinLookAndFeel;

@SuppressWarnings("serial")
public class EditorGrafico extends JFrame implements ActionListener,
		AdjustmentListener {
	private PainelDeFiguras canvas = null;
	private JLabel txt = new JLabel(" ");
	private static ResourceBundle res;
	private ColorPainel colorP = new ColorPainel();

	static {
		try {
			res = ResourceBundle.getBundle("abstractDemo2.resources.figuras");
		} catch (MissingResourceException mre) {
			System.err.println("Não foi encontrado o arquivo\n"
					+ "abstract2Demo/resources/figuras.properties");
			System.exit(1);
		}
	}

	private final MenuDefs[] tpFiguras = new MenuDefs[] {
			new MenuDefs("Criar Círculo", "cir", KeyEvent.VK_C, new ImageIcon(
					res.getString("cir")), "Cria um Círculo"),
			new MenuDefs("Criar Quadrado", "qua", KeyEvent.VK_Q, new ImageIcon(
					res.getString("qua")), "Cria um Quadrado"),
			new MenuDefs("Criar Triângulo", "tri", KeyEvent.VK_T, new ImageIcon(
					res.getString("tri")), "Cria um Triângulo"),
			new MenuDefs("Limpar Tela", "cls", KeyEvent.VK_L, new ImageIcon(
					res.getString("cls")), "Limpa a Tela"), };

	private final MenuDefs[] tpToolBar = new MenuDefs[] {
			new MenuDefs("Criar Círculo", "cir", KeyEvent.VK_C, new ImageIcon(
					res.getString("cir")), "Cria um Círculo"),
			new MenuDefs("Criar Quadrado", "qua", KeyEvent.VK_Q, new ImageIcon(
					res.getString("qua")), "Cria um Quadrado"),
			new MenuDefs("Criar Triângulo", "tri", KeyEvent.VK_T, new ImageIcon(
					res.getString("tri")), "Cria um Triângulo"),
			new MenuDefs("Limpar Tela", "cls", KeyEvent.VK_L, new ImageIcon(
					res.getString("cls")), "Limpa a Tela"),
			new MenuDefs(),
			new MenuDefs("Sair", "ext", KeyEvent.VK_S, KeyEvent.VK_X, new ImageIcon(
					res.getString("ext")), "Sai do Programa") };

	private final MenuDefs[] tpAcao = new MenuDefs[] {
			new MenuDefs("Abrir Figuras", "abr", KeyEvent.VK_A,
					"Abrir Figuras salvas em arquivo"),
			new MenuDefs("Salvar Figuras", "sav", KeyEvent.VK_S,
					"Salvar Figuras em arquivo"),
			new MenuDefs("Painel de Cores", "cor", KeyEvent.VK_P,
					"Abre o Painel de Cores"),
			new MenuDefs(),
			new MenuDefs("Sair", "ext", KeyEvent.VK_S, KeyEvent.VK_X, new ImageIcon(
					res.getString("ext")), "Sai do Programa") };

	private final MenuDefs[] tpPopup = new MenuDefs[] {
			new MenuDefs("Para o Topo", "top", "Traz a Figura para o Topo"),
			new MenuDefs("Para Baixo", "bai", "Envia a Figura abaixo de todas"), };

	private final MenuDefs[] tpTemas = new MenuDefs[] {
			new MenuDefs("Default L&F", "def", KeyEvent.VK_D, "Default Look & Feel"),
			new MenuDefs("Skin L&F", "ski", KeyEvent.VK_S, "Skin Look & Feel"),
			new MenuDefs("Napkin L&F", "nap", KeyEvent.VK_N, "Napkin Look & Feel"),
//			new MenuDefs("Substance L&F", "sub", KeyEvent.VK_U,
//					"Substance Look & Feel"), 
					};

	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String cmd = res.getString("laf");

					if (cmd.equals("defLaf")) {
						UIManager.setLookAndFeel(UIManager
								.getCrossPlatformLookAndFeelClassName());
					} else if (cmd.equals("skiLaf")) {
						SkinLookAndFeel.setSkin(SkinLookAndFeel
								.loadThemePack("bin/abstractDemo2/libs/themepack.zip"));
						UIManager
								.setLookAndFeel("com.l2fprod.gui.plaf.skin.SkinLookAndFeel");
					} else if (cmd.equals("napLaf")) {
						UIManager
								.setLookAndFeel("net.sourceforge.napkinlaf.NapkinLookAndFeel");
//					} else if (cmd.equals("subLaf")) {
//						UIManager
//								.setLookAndFeel("org.jvnet.substance.SubstanceLookAndFeel");
//						SubstanceDefaultLookAndFeel
//								.setCurrentTheme(new SubstanceAquaTheme());
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null,
							"Não foi possível mudar o Look & Feel\n" + ex.getMessage(),
							"E R R O", JOptionPane.ERROR_MESSAGE);
				}

				new EditorGrafico();
			}
		});
	}

	public EditorGrafico() {
		setTitle("Painel de Figuras");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = getContentPane();
		contentPane.add(Maker.makeToolBar(tpToolBar, this), "North");

		JMenuBar menuBar = new JMenuBar();
		menuBar.add(Maker.makeMenu(new MenuDefs("Ações", KeyEvent.VK_A), tpAcao,
				this));
		menuBar.add(Maker.makeMenu(new MenuDefs("Figuras", KeyEvent.VK_F),
				tpFiguras, this));
		menuBar.add(Maker.makeMenu(new MenuDefs("Look & Feel", KeyEvent.VK_L),
				tpTemas, new ActionListenerLaf(this)));
		setJMenuBar(menuBar);

		canvas = new PainelDeFiguras(Maker.makePopupMenu(tpPopup, this));
		canvas.setBackground(Color.white);
		canvas.setBorder(BorderFactory.createEtchedBorder());
		canvas.setPreferredSize(new Dimension(1070, 720));
		canvas.setDropTarget(new DropTarget(colorP.getColorChooser(),
				(DropTargetListener) canvas));

		JScrollPane sp = new JScrollPane(canvas);
		sp.setPreferredSize(new Dimension(500, 400));
		sp.getVerticalScrollBar().addAdjustmentListener(this);
		sp.getHorizontalScrollBar().addAdjustmentListener(this);
		contentPane.add(sp, "Center");

		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.X_AXIS));
		p.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		p.add(txt);
		contentPane.add(p, "South");

		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	@SuppressWarnings("unchecked")
	public void actionPerformed(ActionEvent e) {
		boolean ok = true;
		txt.setText(" ");
		String cmd = e.getActionCommand();
		Color cor = new Color((int) Math.ceil(Math.random() * 255),
				(int) Math.ceil(Math.random() * 255),
				(int) Math.ceil(Math.random() * 255));

		if (cmd.equals("ext")) {
			System.exit(0);
		} else if (cmd.equals("cls")) {
			canvas.reset();
		} else if (e.getActionCommand().equals("cor")) {
			colorP.setLocation(0, getLocation().y);
			colorP.setVisible(true);
		} else if (e.getActionCommand().equals("abr")) {
			JFileChooser chooser = new JFileChooser();

			if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
				ObjectInputStream in = null;
				try {
				  in = new ObjectInputStream(new FileInputStream(
						chooser.getSelectedFile()));
					canvas.reset();
					canvas.setFiguras(((java.util.List<Figura>) in.readObject()));
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(this,
							"Não foi possível abrir as Figuras" + ex.getMessage());
				}
			}
		} else if (e.getActionCommand().equals("sav")) {
			JFileChooser chooser = new JFileChooser();

			if (chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
				ObjectOutputStream out = null;
				try {
					out =	new ObjectOutputStream(
						new FileOutputStream(chooser.getSelectedFile()));
					out.writeObject(canvas.getFiguras());
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(this,
							"Não foi possível salvar as Figuras" + ex.getMessage());
				}
			}
		} else if (e.getActionCommand().equals("top")) {
			canvas.toTop();
		} else if (e.getActionCommand().equals("bai")) {
			canvas.toBottom();
		} else if (cmd.equals("cir")) {
			ok = canvas.add(new Circulo(canvas, cor));
		} else if (cmd.equals("qua")) {
			ok = canvas.add(new Quadrado(canvas, cor));
		} else if (cmd.equals("tri")) {
			ok = canvas.add(new Triangulo(canvas, cor));
		}

		if (!ok)
			txt.setText("Foi criado o número máximo de figuras!");

		repaint();
	}

	public void adjustmentValueChanged(AdjustmentEvent e) {
		repaint();
	}
}
