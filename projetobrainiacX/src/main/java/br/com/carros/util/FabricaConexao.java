package br.com.carros.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import br.com.carros.util.excessao.ErroSistema;

public class FabricaConexao {
	
	private static Connection conexao;
	private static final String URL_CONEXAO = "jdbc:mysql://localhost:3306/genericBD?useTimezone=true&serverTimezone=UTC";
	private static final String USUARIO = "root";
	private static final String SENHA = "1234";
	
	
	public static Connection getConexao() throws ErroSistema {
		
		if(conexao == null) {
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conexao = DriverManager.getConnection(URL_CONEXAO,USUARIO,SENHA);
			} catch (ClassNotFoundException ex) {
				throw new ErroSistema("Não foi possível conectar ao banco de dados", ex);
			} catch (SQLException ex) {
				throw new ErroSistema("O driver do banco de dados não foi encontrado", ex);
			}
		}
		
		return conexao;
	}
	
	public static void fecharConexao() throws ErroSistema {
		
		if(conexao != null) {
			try {
				conexao.close();
				conexao = null;
			} catch (SQLException ex) {
				throw new ErroSistema("Erro ao fechar conexão com o banco de dados", ex);
			}
			
		}
	}
	
	
}
