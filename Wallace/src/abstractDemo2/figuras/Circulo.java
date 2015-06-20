package abstractDemo2.figuras;

import java.awt.*;
import java.awt.geom.*;

@SuppressWarnings("serial")
public class Circulo extends Figura {
  private transient Ellipse2D elipse = null;
  private transient Ellipse2D innerElipse = null;

  public Circulo(Container c) {
    super(c);
  }
  
  public Circulo(Container c, Color co) {
    super(c, co);
  }

  @Override
  public void desenha(Graphics g) {
    Graphics2D g2D = (Graphics2D)g;
    innerElipse = new Ellipse2D.Double(x+5, y+5, largura-10, altura-10);
    elipse = new Ellipse2D.Double(x, y, largura, altura);
    g2D.setColor(color);
    g2D.fill(elipse);
    g2D.setColor(Color.black);
    g2D.draw(elipse);
  }

  @Override
  public boolean contem(double x, double y) {
    return elipse != null ? elipse.contains(x, y) : false;
  }

  @Override
  public int qualBorda(double x, double y) {
    boolean in = innerElipse != null ? innerElipse.contains(x, y) : false;
    boolean out = contem(x, y);
    int borda = FORA_DA_BORDA;
    
    if(out & !in) {
      int meio = (this.x + largura/2);
      if(x > meio + 5)
        borda |= LESTE;
      else if(x < meio - 5)
        borda |= OESTE;

      meio = (this.y + altura/2);
      if(y > meio + 5)
        borda |= SUL;
      else if(y < meio - 5)
        borda |= NORTE;
    }
      
    return borda;
  }
}
