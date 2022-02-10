package com.formacionspring.app.apirest.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.formacionspring.app.apirest.entity.Cliente;

@Repository
public interface ClienteDao extends CrudRepository<Cliente, Long>{
	
	//Se mete Cliente porque se mete un objeto de la clase Cliente
	//y se mete Long porque es el formato del Id.
	
	
	
}
