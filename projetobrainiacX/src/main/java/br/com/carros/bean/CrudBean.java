package br.com.carros.bean;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import br.com.carros.dao.CrudDAO;
import br.com.carros.util.excessao.ErroSistema;


public abstract class CrudBean<E,D extends CrudDAO> {
	
	private String estadoTela = "buscar";
	
	private E entidade;
	private List<E> entidades;
	
	public void novo() {
		entidade =  criarNovaEntidade();
		mudarParaInseri();
	}
	
	@SuppressWarnings("unchecked")
	public void salvar() {
		try {
			getDAO().salvar(entidade);
			entidade = criarNovaEntidade();
			adicionarMensagem("Salvo com sucesso!", FacesMessage.SEVERITY_INFO);
			mudarParaBusca();
		} catch (ErroSistema ex) {
			Logger.getLogger(CrudBean.class.getName()).log(Level.SEVERE,null,ex);
			adicionarMensagem(ex.getMessage(), FacesMessage.SEVERITY_ERROR);
		}
	}
	
	public void editar(E entidade) {
		this.entidade = entidade;
		mudarParaEdita();
	}
	
	public void deletar(E entidade) {
		try {
			getDAO().deletar(entidade);
			entidades.remove(entidade);
			adicionarMensagem("Deletado com sucesso!", FacesMessage.SEVERITY_INFO);
		} catch (ErroSistema ex) {
			Logger.getLogger(CrudBean.class.getName()).log(Level.SEVERE,null,ex);
			adicionarMensagem(ex.getMessage(), FacesMessage.SEVERITY_ERROR);
		}
	}
	
	public void buscar() {
		
		if(isBusca() == false) {
			mudarParaBusca();
			return;
		}
		
		try {
			entidades = getDAO().buscar();
			if(entidades == null || entidades.size()<1) {
				adicionarMensagem("Não temos nada Cadastrado!", FacesMessage.SEVERITY_INFO);
			}
		} catch (ErroSistema ex) {
			Logger.getLogger(CrudBean.class.getName()).log(Level.SEVERE,null,ex);
			adicionarMensagem(ex.getMessage(), FacesMessage.SEVERITY_ERROR);
		}
	}
	
	public void adicionarMensagem(String mensagem, FacesMessage.Severity tipoErro) {
		FacesMessage fm = new FacesMessage(tipoErro, mensagem, null);
		FacesContext.getCurrentInstance().addMessage(null, fm);
	}
	
	
	public E getEntidade() {
		return entidade;
	}

	public void setEntidade(E entidade) {
		this.entidade = entidade;
	}

	public List<E> getEntidades() {
		return entidades;
	}

	public void setEntidades(List<E> entidades) {
		this.entidades = entidades;
	}

	//Criar métodos na classe Bean
	public abstract D getDAO();
	public abstract E criarNovaEntidade();
	
	//Controle de Tela
	public boolean isInseri() {
		
		return "inserir".equals(estadoTela);
	}
	public boolean isEdita() {
		
		return "editar".equals(estadoTela);
	}
	public boolean isBusca() {
		
		return "buscar".equals(estadoTela);
	}
	
	public void mudarParaInseri() {
		estadoTela = "inserir";
	}
	public void mudarParaEdita() {
		estadoTela = "editar";
	}
	public void mudarParaBusca() {
		estadoTela = "buscar";
	}
}
