package abstractDemo2.gui;

import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.dnd.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;
import abstractDemo2.figuras.Figura;

@SuppressWarnings("serial")
public class PainelDeFiguras extends JPanel implements DropTargetListener,
    MouseListener, MouseMotionListener {
  private DataFlavor colorFlavor = null;
  private List<Figura> lista = new ArrayList<Figura>();
  private Figura figSelecionada = null;
  private Figura figPopupMenu = null;
  private JPopupMenu popup = null;
  private int tipoBorda = Figura.FORA_DA_BORDA;
  private final int button3 = java.awt.event.InputEvent.BUTTON3_DOWN_MASK;
  private int xSel = 0;
  private int ySel = 0;

  public PainelDeFiguras() {
    super(new GridLayout(1, 1));
    try {
      colorFlavor = new DataFlavor(DataFlavor.javaJVMLocalObjectMimeType
        + ";class=java.awt.Color");
    }
    catch(ClassNotFoundException e) {}

    addMouseListener(this);
    addMouseMotionListener(this);
  }

  public PainelDeFiguras(JPopupMenu menu) {
    this();
    this.popup = menu;
  }
  
  public void setPopupMenu(JPopupMenu menu) {
    this.popup = menu;
  }
  
  public boolean add(Figura f) {
    return lista.add(f);
  }

  public void reset() {
    lista.clear();
  }

  public List<Figura> getFiguras() {
    return lista;
  }

  public void setFiguras(List<Figura> figuras) {
    this.lista = new ArrayList<Figura>();
    
    for(Figura f : figuras) {
      f.setContainer(this);
      this.lista.add(f);
    }
  }

  public void toTop() { 
    if(figPopupMenu != null) {
      int idx = lista.indexOf(figPopupMenu);
      lista.add(figPopupMenu);
      lista.remove(idx);
      figPopupMenu = null;
    }
  }

  public void toBottom() { 
    if(figPopupMenu != null) {
      int idx = lista.indexOf(figPopupMenu);
      lista.remove(idx);
      lista.add(0, figPopupMenu);
      figPopupMenu = null;
    }
  }
  
  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    for(Figura f : lista)
      if(f != null)
        f.desenha(g);
  }

  public void mouseClicked(MouseEvent e) {
    for(int i = lista.size() - 1;i >= 0;i--) {
      figSelecionada = lista.get(i);

      if(figSelecionada.contem(e.getX(), e.getY())) {
        if((e.getModifiersEx() & button3) == button3 &&
            popup != null) {
          figPopupMenu = figSelecionada;
          popup.show(e.getComponent(), e.getX(), e.getY());
        } else {
          xSel = e.getX();
          ySel = e.getY();
          figPopupMenu = null;
        }
        break;
      } else
        figPopupMenu = figSelecionada = null;
    }
  }
  
  public void mousePressed(MouseEvent e) {
    mouseClicked(e);
  }

  public void mouseReleased(MouseEvent e) {
    figSelecionada = null;
  }

  public void mouseEntered(MouseEvent e) {}

  public void mouseExited(MouseEvent e) {
    figSelecionada = null;
  }

  public void mouseDragged(MouseEvent e) {
    if(figSelecionada != null && 
       figPopupMenu == null) {
      if(tipoBorda == Figura.FORA_DA_BORDA)
        figSelecionada.move(e.getX() - xSel, e.getY() - ySel);
      else
        figSelecionada.setTamanho(e.getX() - xSel, e.getY() - ySel, tipoBorda);
        
      xSel = e.getX();
      ySel = e.getY();
      repaint();
    }
  }
  
  public void mouseMoved(MouseEvent e) {
    Cursor c = Cursor.getDefaultCursor();

    for(int i = lista.size() - 1;i >= 0;i--) {
      Figura f = lista.get(i);
      if(f.contem(e.getX(), e.getY())) {
        switch((tipoBorda = f.qualBorda(e.getX(), e.getY()))) {
          case Figura.NORTE:  
            c = Cursor.getPredefinedCursor(Cursor.N_RESIZE_CURSOR);
            break;
          case Figura.SUL:  
            c = Cursor.getPredefinedCursor(Cursor.S_RESIZE_CURSOR);
            break;
          case Figura.LESTE:  
            c = Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR);
            break;
          case Figura.OESTE:  
            c = Cursor.getPredefinedCursor(Cursor.W_RESIZE_CURSOR);
            break;
          case Figura.NORDESTE:  
            c = Cursor.getPredefinedCursor(Cursor.NE_RESIZE_CURSOR);
            break;
          case Figura.NOROESTE:  
            c = Cursor.getPredefinedCursor(Cursor.NW_RESIZE_CURSOR);
            break;
          case Figura.SUDESTE:  
            c = Cursor.getPredefinedCursor(Cursor.SE_RESIZE_CURSOR);
            break;
          case Figura.SUDOESTE:  
            c = Cursor.getPredefinedCursor(Cursor.SW_RESIZE_CURSOR);
            break;
          default:
            c = Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR);
        }
        break;
      }
    }
    setCursor(c);
  }
  
  public void dragEnter(DropTargetDragEvent dtde) {
    if(dtde.isDataFlavorSupported(colorFlavor))
      dtde.acceptDrag(DnDConstants.ACTION_COPY_OR_MOVE);
  }

  public void dragExit(DropTargetEvent dte) {}

  public void dragOver(DropTargetDragEvent dtde) {}

  public void drop(DropTargetDropEvent dtde) {
    if(dtde.isDataFlavorSupported(colorFlavor)) {
      dtde.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);

      try {
        Point p = dtde.getLocation();

        for(int i = lista.size() - 1;i >= 0;i--) {
          Figura f = lista.get(i);

          if(f.contem(p.getX(), p.getY())) {
            Transferable t = dtde.getTransferable();
            f.setColor((Color)t.getTransferData(colorFlavor));
            repaint();
            dtde.dropComplete(true);
            break;
          }
        }
      }
      catch(Exception ex) {
        dtde.dropComplete(false);
      }
    } else
      dtde.rejectDrop();
  }

  public void dropActionChanged(DropTargetDragEvent dtde) {}

}
