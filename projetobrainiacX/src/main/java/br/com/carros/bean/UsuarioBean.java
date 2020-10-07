package br.com.carros.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.carros.dao.UsuarioDAO;
import br.com.carros.entidade.Usuario;

@ManagedBean
@SessionScoped
public class UsuarioBean extends CrudBean<Usuario, UsuarioDAO>{
	
	private UsuarioDAO usuarioDAO;
	
	@Override
	public UsuarioDAO getDAO() {
		if(usuarioDAO == null) {
			usuarioDAO = new UsuarioDAO();
		}
		
		return usuarioDAO;
	}

	@Override
	public Usuario criarNovaEntidade() {
		return new Usuario();
	}

}
