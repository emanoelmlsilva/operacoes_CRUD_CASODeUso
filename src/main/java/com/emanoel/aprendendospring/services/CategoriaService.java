package com.emanoel.aprendendospring.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emanoel.aprendendospring.domain.Categoria;
import com.emanoel.aprendendospring.repositories.CategoriaRepository;
import com.emanoel.aprendendospring.services.Exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) {
		
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: "+id+", Tipo: "+Categoria.class.getName()));
	}

	public Categoria insert(Categoria obj) {
		obj.setId(null);//toda fez que um objeto novo for inserido o Id tem que ser nullo, pois senão o save ira conciderar uma atualiação e não uma adição.
		return repo.save(obj);
	}
	
	public Categoria update(Categoria obj) {
		find(obj.getId());//verificar se o objeto passado existe
		return repo.save(obj);//serve tanto para atualizar quanto para inserir, quando o id or nulo inseri, senão atualiza
	}
}
