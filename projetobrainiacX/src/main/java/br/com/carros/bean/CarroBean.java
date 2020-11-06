package br.com.carros.bean;

import br.com.carros.dao.CarroDAO;
import br.com.carros.entidade.Carro;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class CarroBean extends CrudBean<Carro,CarroDAO>{
	
	private CarroDAO carroDAO;
	
	
	@Override
	public CarroDAO getDAO() {
		if(carroDAO == null) {
			carroDAO = new CarroDAO();
		}
		return carroDAO;
	}

	@Override
	public Carro criarNovaEntidade() {
		return new Carro();
	}



}
