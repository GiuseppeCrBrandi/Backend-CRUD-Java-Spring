package net.javaguides.springboot.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import net.java.spring.exceptions.ResourceNotFoundException;
import net.java.spring.modelo.Usuario;
import net.java.spring.servico.ServicoUsuario;
import net.javas.spring.repositorio.RepositorioUsuarios;

@Service
public class EmployeeServiceImpl implements ServicoUsuario{

	private RepositorioUsuarios repositorioUsuario;
	
	public EmployeeServiceImpl(RepositorioUsuarios repositorioUsuarios) {
		super();
		this.repositorioUsuario = repositorioUsuarios;
	}

	@Override
	public List<Usuario> getTodosUsuarios() {
		return repositorioUsuario.findAll();
	}
	
	@Override
	public Usuario saveEmployee(Usuario usuario) {
		return repositorioUsuario.save(usuario);
	}

	@Override
	public Usuario getUsuarioPorId(long id) {
		return repositorioUsuario.findById(id).orElseThrow(() -> 
						new ResourceNotFoundException("Usuario", "Id", id));
		
	}

	@Override
	public Usuario updateUsuario(Usuario usuario, long id) {
		
		//checar se o usuario com id x ja existe no banco
		Usuario usuarioexistente = repositorioUsuario.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Usuario", "Id", id)); 
		
		usuarioexistente.setFirstName(usuario.getFirstName());
		usuarioexistente.setLastName(usuario.getLastName());
		usuarioexistente.setEmail(usuario.getEmail());
		
		// salvar o usuario
		repositorioUsuario.save(usuarioexistente);
		return usuarioexistente;
	}

	@Override
	public void deletarUsuario(long id) {
		
		// checar se usuario ja existe
		repositorioUsuario.findById(id).orElseThrow(() -> 
								new ResourceNotFoundException("Usuario", "Id", id));
		repositorioUsuario.deleteById(id);
	}
	
}
