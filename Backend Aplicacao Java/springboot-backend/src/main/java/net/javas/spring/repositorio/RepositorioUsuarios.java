package net.javas.spring.repositorio;


import org.springframework.data.jpa.repository.JpaRepository;

import net.java.spring.modelo.Usuario;

public interface RepositorioUsuarios extends JpaRepository<Usuario, Long>{

	
}
