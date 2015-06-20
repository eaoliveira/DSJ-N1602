package abstractDemo2.figuras;

import java.awt.*;
import java.awt.geom.*;

@SuppressWarnings("serial")
public class Quadrado extends Figura {
  private transient Rectangle2D quadrado = null;
  private transient Rectangle2D innerQuadrado = null;

  public Quadrado(Container c) {
    super(c);
  }

  public Quadrado(Container c, Color co) {
    super(c, co);
  }
  
  @Override
  public void desenha(Graphics g) {
    Graphics2D g2D = (Graphics2D)g;
    innerQuadrado = new Rectangle2D.Double(x+5, y+5, largura-10, altura-10);
    quadrado = new Rectangle2D.Double(x, y, largura, altura);
    g2D.setColor(color);
    g2D.fill(quadrado);
    g2D.setColor(Color.black);
    g2D.draw(quadrado);
  }

  @Override
  public boolean contem(double x, double y) {
    return quadrado != null ? quadrado.contains(x, y) : false;
  }
  
  @Override
  public int qualBorda(double x, double y) {
    boolean in = innerQuadrado != null ? innerQuadrado.contains(x, y) : false;
    boolean out = contem(x, y);
    int borda = FORA_DA_BORDA;
    
    if(out & !in) {
      if(x > this.x + largura - 5)
        borda |= LESTE;
      else if(x < this.x + 5)
        borda |= OESTE;

      if(y > this.y + altura - 5)
        borda |= SUL;
      else if(y < this.y + 5)
        borda |= NORTE;
    }
      
    return borda;
  }
}
