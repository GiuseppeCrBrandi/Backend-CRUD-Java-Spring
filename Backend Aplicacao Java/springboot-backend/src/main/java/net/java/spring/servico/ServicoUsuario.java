package net.java.spring.servico;

import java.util.List;

import net.java.spring.modelo.Usuario;

public interface ServicoUsuario {
	Usuario saveEmployee(Usuario usuario);
	List<Usuario> getTodosUsuarios();
	Usuario getUsuarioPorId(long id);
	Usuario updateUsuario(Usuario usuario, long id);
	void deletarUsuario(long id);
}
