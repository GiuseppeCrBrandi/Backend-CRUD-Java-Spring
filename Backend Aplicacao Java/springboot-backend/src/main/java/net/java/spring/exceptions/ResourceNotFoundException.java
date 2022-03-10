package net.java.spring.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String resourceName;
	private String nomeDoCampo;
	private Object valorDoCampo;
	
	public ResourceNotFoundException(String resourceName, String nomeDoCampo, Object valorDoCampo) {
		
		super(String.format("%s not found with %s : '%s'", resourceName, nomeDoCampo, valorDoCampo));
		this.resourceName = resourceName;
		this.nomeDoCampo = nomeDoCampo;
		this.valorDoCampo = valorDoCampo;
	}
	
	public String getResourceName() {
		return resourceName;
	}
	
	public String getNomeDoCampo() {
		return nomeDoCampo;
	}
	
	public Object getValorDoCampo() {
		return valorDoCampo;
	}
	
}
