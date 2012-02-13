package introducao;

import java.applet.Applet;
import java.awt.Graphics;

@SuppressWarnings("serial")
public class AloApplet extends Applet {
  public void paint(Graphics g) {
    g.drawString("Alo Mundo!", 50, 25);
  }
}
