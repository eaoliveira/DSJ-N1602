package abstractDemo2.figuras;

import java.awt.*;

@SuppressWarnings("serial")
public class Triangulo extends Figura {
  private transient Polygon triangulo = null;
  private transient Polygon innerTriangulo = null;

  public Triangulo(Container c) {
    super(c);
  }
  
  public Triangulo(Container c, Color co) {
    super(c, co);
  }
  
  @Override
  public void desenha(Graphics g) {
    int[] xPoint = new int[3];
    int[] yPoint = new int[3];

    xPoint[0] = x+((largura)/2); yPoint[0] = y;
    xPoint[1] = x; yPoint[1] = y+altura;
    xPoint[2] = x+largura; yPoint[2] = y+altura;

    triangulo = new Polygon(xPoint, yPoint, 3);

    xPoint[0] = x+5+((largura-10)/2); yPoint[0] = y+10;
    xPoint[1] = x+7; yPoint[1] = y+altura-5;
    xPoint[2] = x+largura-7; yPoint[2] = y+altura-5;

    innerTriangulo = new Polygon(xPoint, yPoint, 3);

    Graphics2D g2D = (Graphics2D)g;
    g2D.setColor(color);
    g2D.fill(triangulo);
    g2D.setColor(Color.black);
    g2D.draw(triangulo);
  }

  @Override
  public boolean contem(double x, double y) {
    return triangulo != null ? triangulo.contains(x, y) : false;
  }
  
  @Override
  public int qualBorda(double x, double y) {
    boolean in = innerTriangulo != null ? innerTriangulo.contains(x, y) : false;
    boolean out = contem(x, y);
    int borda = FORA_DA_BORDA;
    
    if(out & !in) {
      if(y < this.y + altura - 5 &&
         y > this.y + 10) {
        int meio = (this.x + largura/2);
        if(x > meio - 3)
          borda = NORDESTE;
        else if(x < meio - 3)
          borda = NOROESTE;
      } else {
        if(x > this.x + largura - 5)
          borda |= LESTE;
        else if(x < this.x + 7)
          borda |= OESTE;
      }
      
      if(y > this.y + altura - 5)
        borda |= SUL;
      else if(y < this.y + 10)
        borda |= NORTE;
    }
      
    return borda;
  }

}
