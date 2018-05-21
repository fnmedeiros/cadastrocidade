package com.api.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.modelo.Cidade;
import com.api.repository.CidadeRepository;

@RestController
@RequestMapping("/cidade")
public class CidadeResource {

	@Autowired
	private CidadeRepository cr;
	
	@GetMapping(produces="application/json")
	public @ResponseBody Iterable<Cidade> listaCidades(){
		Iterable<Cidade> listaCidades = cr.findAll();
		return listaCidades;
	}
	
	
	
	@PostMapping
	public Cidade gravaCidade(Cidade cidade){
		
		return cr.save(cidade);
	}
	
	@PutMapping
	public Cidade atualizaCidade(@RequestBody Cidade cidade) {
		return cr.save(cidade);
	}
	
	@DeleteMapping
	public Cidade deletaCidade(@RequestBody Cidade cidade) {
		cr.delete(cidade);
		return cidade;
	}
	
}

