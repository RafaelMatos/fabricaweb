package br.com.fabricadeprogramador.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fabricadeprogramador.persistencia.entidade.Usuario;

/**
 * @author work
 *
 */
public class UsuarioDAO {

	Connection con = ConnectionFactory.getConnection();
	public void cadastrar(Usuario user) {
		// TODO Auto-generated method stub
		
		
		String sql = "INSERT INTO usuario(nome,login,senha) VALUES(?,?,?)";
		
		try(PreparedStatement stm = con.prepareStatement(sql)) {
			
			stm.setString(1, user.getNome());
			stm.setString(2, user.getLogin());
			stm.setString(3, user.getSenha());
			
			stm.execute();
			stm.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void alterar(Usuario user) {
		
		String sql = "UPDATE usuario SET nome=?, login=?, senha=?  WHERE id =?";
		
		try(PreparedStatement stm = con.prepareStatement(sql)) {
			
			
			
			stm.setString(1, user.getNome());
			stm.setString(2, user.getLogin());
			stm.setString(3, user.getSenha());
			stm.setInt(4, user.getId());
			
			stm.execute();
			stm.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void excluir(Usuario user) {
		
		String sql = "DELETE from usuario WHERE id = ?;";
				
				try(PreparedStatement stm = con.prepareStatement(sql)) {
										
					stm.setInt(1, user.getId());
					stm.execute();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
		
	}
	
	public void salvar(Usuario user) {
		
		if(user.getId() != null) {
			alterar(user);
		}else {
			cadastrar(user);
		}
	}
	
	/**
	 * Busca de um registro no banco de dados pelo número de id do usuário
	 * @param id É um inteiro que representa o número do id do usuário a ser buscado
	 * @return Um objeto usuário quando encontraou null quando não encontra
	 */
	public Usuario buscaPorId(Integer id) {
		String sql = "SELECT * FROM usuario WHERE id = ?";
		
		try(PreparedStatement stm = con.prepareStatement(sql)) {
			
			stm.setInt(1, id);
			ResultSet resultset = stm.executeQuery();
			
			if(resultset.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(resultset.getInt("id"));
				usuario.setNome(resultset.getString("nome"));
				usuario.setLogin(resultset.getString("login"));
				usuario.setSenha(resultset.getString("senha"));
				
				return usuario;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	} 
	
	/**
	 * Realiza a busca de todos registros da tabela de usuarios
	 * @return Uma lista de objetos Usuario contendo 0 elementos quando não encontrar 
	 * ou n elementos quando encontrar.
	 */
	
	public List<Usuario> buscarTodos() {
		String sql = "SELECT * FROM usuario";
		
		List<Usuario> list = new ArrayList<Usuario>();
		
		try(PreparedStatement stm = con.prepareStatement(sql)) {
			
			
			ResultSet resultset = stm.executeQuery();
			
			while(resultset.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(resultset.getInt("id"));
				usuario.setNome(resultset.getString("nome"));
				usuario.setLogin(resultset.getString("login"));
				usuario.setSenha(resultset.getString("senha"));
				
				//Adicionando usuario na lista
				list.add(usuario);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	} 
	
	public Usuario autenticar(Usuario userConsult) {
		
		String sql = "SELECT * FROM usuario WHERE login = ? and senha =?";
		
		try(PreparedStatement stm = con.prepareStatement(sql)) {
			
			stm.setString(1, userConsult.getLogin());
			stm.setString(2, userConsult.getSenha());
			ResultSet result = stm.executeQuery();
			if(result.next()) {
			
			Usuario user = new Usuario();
			user.setId(result.getInt("id")); 
			user.setNome( result.getString("nome"));
			user.setLogin( result.getString("login"));
			user.setSenha( result.getString("senha"));
			
			return user;
			}else {
				return null;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
	}

}
