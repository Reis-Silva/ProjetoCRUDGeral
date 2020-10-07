package br.com.carros.dao;

import java.util.List;

import br.com.carros.util.excessao.ErroSistema;

public interface CrudDAO<E> {
	
	public void salvar(E entidade) throws ErroSistema;
	public void deletar(E entidade) throws ErroSistema;
	public List<E> buscar() throws ErroSistema;

}
