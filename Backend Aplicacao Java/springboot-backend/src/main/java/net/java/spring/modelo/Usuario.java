package net.java.spring.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="employees")
public class Usuario {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "primeiro_nome", nullable = false)
	private String primeiroNome;
	
	
	@Column(name = "ultimo_nome")
	private String ultimoNome;
	
	@Column(name = "email")
	private String email;
	
}
