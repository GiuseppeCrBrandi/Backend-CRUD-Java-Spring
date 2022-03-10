package net.java.spring.controle;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.java.spring.modelo.Usuario;
import net.java.spring.servico.ServicoUsuario;

@RestController
@RequestMapping("/api/employees")
public class ControleDeUsuarios {
	
	
	private ServicoUsuario servicoDeUsuario;
    public ControleDeUsuarios(ServicoUsuario servicoDeUsuario) {
		super();
		
		this.servicoDeUsuario = servicoDeUsuario;
	}
	
	// criando a RESP API 
    
	@PostMapping()
	public ResponseEntity<Usuario> saveEmployee(@RequestBody Usuario usuario){
		return new ResponseEntity<Usuario>(servicoDeUsuario.saveEmployee(usuario), HttpStatus.CREATED);
	}
	
	// opcao de pegar todos os usuarios API
	
	@GetMapping
	public List<Usuario> getTodosUsuarios(){
		return servicoDeUsuario.getTodosUsuarios();
	}
	
	// http://localhost:8080/api/employees/1
	
	// RESP API com ID
	
	@GetMapping("{id}")
	public ResponseEntity<Usuario> getUsuarioPorId(@PathVariable("id") long usuarioId){
		return new ResponseEntity<Usuario>(servicoDeUsuario.getUsuarioPorId(usuarioId), HttpStatus.OK);
	}
	
	// http://localhost:8080/api/employees/1
	
	// Update 
	
	@PutMapping("{id}")
	public ResponseEntity<Usuario> updateUsuario(@PathVariable("id") long id
												  ,@RequestBody Usuario usuario){
		return new ResponseEntity<Usuario>(servicoDeUsuario.updateUsuario(usuario, id), HttpStatus.OK);
		
	}
	
	// http://localhost:8080/api/employees/1
	
	// Funcao deletar
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deletarUsuario(@PathVariable("id") long id){
		
		// comando para deletar usuario do banco
		
		servicoDeUsuario.deletarUsuario(id);
		
		return new ResponseEntity<String>("usuario deletado com sucesso", HttpStatus.OK);
	}
	
}
