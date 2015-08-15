package faces;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;

import modelo.Funcionario;
import modelo.dao.CadastroDeFuncionario;
import modelo.dao.DaoException;

@ManagedBean(name="funcLista")
@RequestScoped
@SuppressWarnings( {"unchecked", "rawtypes"})
public class ListaFuncBean {
  private ListDataModel dados = null;
	@EJB
	CadastroDeFuncionario dao;

  public String deleta() {
    List<Funcionario> aDeletar = new ArrayList<Funcionario>();

    for(FuncModel f : (List<FuncModel>)dados.getWrappedData())
      if(f.isDel())
        aDeletar.add(new Funcionario(f.getId()));

    String msg = "";

    if(aDeletar.size() != 0) {
      try {
        dao.removeFuncinario(aDeletar);
        msg = "Funcionarios deletados!";
        dados = null;
      } catch(DaoException ex) {
        msg = "Problemas na delecao dos Funcionarios!";
      }
    } else {
      msg = "Nao existem itens selecionados!";
    }

    FacesContext.getCurrentInstance().addMessage(null,
      new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));

    return "fim";
  }

  public boolean getTemFuncionario() {
	  return dao.getLista().size() > 0;
  }
  
  public ListDataModel getDados() {
    if(dados == null) {
      List<FuncModel> lista = new ArrayList<FuncModel>();

      List<Funcionario> obj = dao.getLista();

      if(obj.size() > 0) {
        for(Funcionario f : obj) {
          lista.add(
          		new FuncModel(f.getId(), f.getNome(),
          				          f.getMatricula()));
        }
      }
      return (dados = new ListDataModel(lista));
    } else {
      return dados;
    }
  }
}