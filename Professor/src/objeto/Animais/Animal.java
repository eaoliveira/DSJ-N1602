package objeto.Animais;

public abstract class Animal {
  protected int pernas;
  
  protected Animal(int pernas) {
    this.pernas = pernas;
  }

  public abstract void anda();

  public abstract void come();

  public String toString() {
    return String.valueOf(pernas);
  }
}
