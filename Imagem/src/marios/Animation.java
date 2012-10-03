package marios;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class Animation {
	static AnimatedSprite sprite;
	static JFrame frame;
	static final GraphicsConfiguration CONFIG = GraphicsEnvironment
			.getLocalGraphicsEnvironment().getDefaultScreenDevice()
			.getDefaultConfiguration();

	public static void main(String[] args) {
		frame = new JFrame("ImageAnimation");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(200, 200);
		//frame.setBackground(Color.black);
		frame.setVisible(true);

		// BufferedImage[] imgs = new BufferedImage[6];
		// for (int i = 0; i < 6; i++)
		// imgs[i] = createTransparentImage("bola.gold."+(i+1), null);

		BufferedImage[] imgs = splitImages(
				createTransparentImage("mario2.png", null), 6, 4);

		sprite = new AnimatedSprite(imgs);
//		sprite.addNewAnimation("roll-on", new int[] { 0, 1, 2, 3, 4, 5 });
		sprite.addNewAnimation("walk-forward", new int[] { 15, 16, 17 });
		sprite.setLocation(100 - imgs[0].getWidth() / 2,
				100 - imgs[0].getHeight() / 2);

		Thread goldBall = new Thread() {
			public void run() {
				while (true) {
					Graphics2D g = (Graphics2D) frame.getGraphics();
					sprite.draw(g);
					g.dispose();
					try {
						Thread.sleep(250);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		goldBall.start();
	}

	public static BufferedImage[] splitImage(BufferedImage img, int cols, int rows) {
		int w = img.getWidth() / cols;
		int h = img.getHeight() / rows;
		int num = 0;
		BufferedImage imgs[] = new BufferedImage[w * h];
		
		for (int y = 0; y < rows; y++) {
			for (int x = 0; x < cols; x++) {
				imgs[num] = new BufferedImage(w, h, img.getType());

				Graphics2D g = imgs[num].createGraphics();
				g.drawImage(img, 0, 0, w, h, w * x, h * y, w * x + w, h * y + h, null);
				g.dispose();
				num++;
			}
		}
		return imgs;
	}
	
	public static BufferedImage[] splitImages(BufferedImage image, int col,	int row) {
		int total = col * row; // total returned images
		int num = 0; // frame counter
		int w = image.getWidth() / col; // w=width,
		int h = image.getHeight() / row; // h=height
		BufferedImage[] imgs = new BufferedImage[total];

		for (int y = 0; y < row; y++) {
			for (int x = 0; x < col; x++) {
				int transparency = image.getColorModel().getTransparency();
				imgs[num] = CONFIG.createCompatibleImage(w, h, transparency);

				Graphics2D g = imgs[num].createGraphics();
				g.drawImage(image, 0, 0, w, h, x * w, y * h, (x + 1) * w, (y + 1) * h, null);
				g.dispose();
				num++;
			}
		}

		return imgs;
	}

	public static BufferedImage createTransparentImage(String img, Color fundo) {
		// String imgName = "teste/img/" + ResourceBundle
		// .getBundle("teste.dados").getString(img);
		String imgName = "teste/" + img;
		Image image = new ImageIcon(Animation.class.getClassLoader().getResource(
				imgName)).getImage();
		BufferedImage buffImg = CONFIG.createCompatibleImage(image.getWidth(null),
				image.getHeight(null), Transparency.BITMASK);
		Graphics2D g2d = buffImg.createGraphics();
		g2d.setComposite(AlphaComposite.Src);
		g2d.drawImage(image, 0, 0, null);
		g2d.dispose();

		Color cor = new Color(buffImg.getRGB(0, 0));

		for (int k = 0; k < buffImg.getHeight(); k++) {
			for (int l = 0; l < buffImg.getWidth(); l++) {
				int color = buffImg.getRGB(l, k);
				if (color == cor.getRGB()) {
					buffImg.setRGB(l, k, color & 0x00ffffff);
				}
			}
		}

		if (fundo != null) {
			BufferedImage newImg = new BufferedImage(buffImg.getWidth(), buffImg
					.getHeight(), BufferedImage.TYPE_INT_ARGB);
			g2d = newImg.createGraphics();
			g2d.setColor(fundo);
			g2d.fillRect(0, 0, buffImg.getWidth(), buffImg.getHeight());
			g2d.drawImage(buffImg, 0, 0, null);
			g2d.dispose();
			buffImg = newImg;
		}

		return buffImg;
	}

}
