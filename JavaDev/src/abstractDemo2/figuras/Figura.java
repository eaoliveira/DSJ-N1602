package abstractDemo2.figuras;

import java.awt.*;
import java.io.Serializable;

public abstract class Figura implements Serializable {
  private static final long serialVersionUID = 1234L;
  protected Color color = Color.black;
  protected int x = 0;
  protected int y = 0;
  protected int largura = 90;
  protected int altura = 90;
  protected transient Container canvas = null;  
  
  public static final int FORA_DA_BORDA = 0;
  public static final int NORTE = 1;
  public static final int SUL = 2;
  public static final int LESTE = 4;
  public static final int OESTE = 8;
  public static final int NORDESTE = 5;
  public static final int SUDESTE = 6;
  public static final int NOROESTE = 9;
  public static final int SUDOESTE = 10;

  public Figura(Container c) {
    canvas = c;
    move(0, 0);
  }
  
  public Figura(Container c, Color color) {
    this(c);
    this.color = color;
  }

  public void setContainer(Container c) {
    this.canvas = c;
  }

  public Color getColor() {
    return color;
  }

  public void setColor(Color color) {
    this.color = color;
  }

  public int getX() {
    return x;
  }

  public void setX(int x) {
    Dimension d = canvas.getSize();
    Insets in = canvas.getInsets();

    if(x < 0 + in.left) 
      x = 0 + in.left;
    else if(x + largura >= d.width - in.right - 1)
      x = d.width - in.right - largura - 1;
    
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    Dimension d = canvas.getSize();
    Insets in = canvas.getInsets();

    if(y < 0 + in.top) 
      y = 0 + in.top;
    else if(y + altura >= d.height - in.bottom - 1)
      y = d.height - in.bottom - altura - 1;
    
    this.y = y;
  }

  public int getAltura() {
    return altura;
  }

  public void setAltura(int altura) {
    this.altura = altura;
  }

  public int getLargura() {
    return largura;
  }

  public void setLargura(int largura) {
    this.largura = largura;
  }

  public void setTamanho(int dx, int dy, int borda) {
    switch(borda) {
      case LESTE:
        setLargura(getLargura() + dx);
        break;
      case SUDESTE:
        setLargura(getLargura() + dx);
        setAltura(getAltura() + dy);
        break;
      case SUL:
        setAltura(getAltura() + dy);
        break;
      case OESTE:
        setX(x + dx);
        setLargura(getLargura() - dx);
        break;
      case SUDOESTE:
        setX(x + dx);
        setLargura(getLargura() - dx);
        setAltura(getAltura() + dy);
        break;
      case NOROESTE:
        setX(x + dx);
        setLargura(getLargura() - dx);
        setY(y + dy);
        setAltura(getAltura() - dy);
        break;
      case NORTE:
        setY(y + dy);
        setAltura(getAltura() - dy);
        break;
      case NORDESTE:
        setY(y + dy);
        setAltura(getAltura() - dy);
        setLargura(getLargura() + dx);
        break;
    }
  }
  
  public void move(int dx, int dy) {
    setX(x + dx);
    setY(y + dy);
  }
 
  public abstract boolean contem(double x, double y);

  public abstract void desenha(Graphics g);

  /**
   * 
   * @param x Coordenada X
   * @param y Coordenada Y
   * @return  
   *    OESN
   *    0000   0 FORA DA BORDA
   *    0001   1 NORTE
   *    0010   2 SUL
   *    0100   4 LESTE
   *    0101   5 NORDESTE
   *    0110   6 SUDESTE
   *    1000   8 OESTE
   *    1001   9 NOROESTE
   *    1010  10 SUDOESTE
   *
   *          y
   * 
   *          N      N      N
   * x   O +---+---+ E
   *          |      |       |
   *     O +---+---+ E
   *          |      |       |
   *     O +---+---+ E   largura
   *         S      S      S
   *    
   *               altura
   */
  public abstract int qualBorda(double x, double y);
}
