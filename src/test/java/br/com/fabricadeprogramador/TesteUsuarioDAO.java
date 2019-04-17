package br.com.fabricadeprogramador;

import java.util.List;

import br.com.fabricadeprogramador.persistencia.entidade.Usuario;
import br.com.fabricadeprogramador.persistencia.jdbc.UsuarioDAO;

public class TesteUsuarioDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		//testCadastrar();
		//testAlterar();
		//testExcluir();
		//testSalvar();
//		testBuscarPorId();
//		testBuscarTodos();
		testAltenticar();
		
	}
	
	private static void testAltenticar() {
		UsuarioDAO userDAO = new UsuarioDAO();
		
		Usuario user = new Usuario();
		user.setLogin("Astrid");
		user.setSenha("Odin");
		user.setId(user.getId());
		user.setNome(user.getNome());
		
		Usuario userReturn = userDAO.autenticar(user);
		System.out.println(userReturn);
	}
	
	private static void testBuscarTodos() {
		UsuarioDAO userDAO = new UsuarioDAO();
		
		List<Usuario> list = userDAO.buscarTodos();
		System.out.println("====Lista de Usuários====");
		for(Usuario u:list) {
//			System.out.println("=========================");
			System.out.println("Id :" + u.getId() );
			System.out.println("Nome: "+ u.getNome());
			System.out.println("Login: "+ u.getLogin());
			System.out.println("Senha: "+u.getSenha());
			System.out.println("=========================");
		}
		
	}
	
	
	private static void testBuscarPorId() {
		UsuarioDAO userDAO = new UsuarioDAO();
		
		Usuario user = userDAO.buscaPorId(4);
		if(user != null) {
			System.out.println("===== Usuário id :" + user.getId() + " =====");
			System.out.println("Nome: "+ user.getNome());
			System.out.println("Login: "+ user.getLogin());
			System.out.println("Senha: "+user.getSenha());
			System.out.println("=========================");
		}else {
			System.out.println("Usuario não encontrado!");
		}
	}
	
	public static void testCadastrar(){
		
		//Criando o Usuario		
		Usuario user = new Usuario();
		
		user.setNome("Enio");
		user.setLogin("enio");
		user.setSenha("8376");
		
		//Cadastrando usuario no banco de dados		
		UsuarioDAO userDAO = new UsuarioDAO();
		userDAO.cadastrar(user);
		
		System.out.println("Cadastrado com Sucesso!");
		
	}
	
public static void testAlterar(){
		
		//Criando o Usuario		
		Usuario user = new Usuario();
		user.setId(5);
		user.setNome("Enio Almeida");
		user.setLogin("enio@");
		user.setSenha("8366");
		
		//Alterando usuario no banco de dados		
		UsuarioDAO userDAO = new UsuarioDAO();
		userDAO.alterar(user);
		
		System.out.println("Alterado com Sucesso!");
		
	}


	public static void testExcluir(){
		
		//Criando o Usuario		
		Usuario user = new Usuario();
		user.setId(2);
		
		
		//Excluir usuario no banco de dados		
		UsuarioDAO userDAO = new UsuarioDAO();
		userDAO.excluir(user);
		
		System.out.println("Excluido com Sucesso!");
		
	}
	
	public static void testSalvar() {
		Usuario user = new Usuario();
//		user.setId(5);
		user.setNome("Fernanda Lima");
		user.setLogin("Fe.lima");
		user.setSenha("4532");
		
		UsuarioDAO userDAO = new UsuarioDAO();
		userDAO.salvar(user);
		System.out.println("Salvo com sucesso!");
	}


}

