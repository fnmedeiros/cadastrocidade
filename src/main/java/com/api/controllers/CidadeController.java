package com.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.api.modelo.Cidade;
import com.api.repository.CidadeRepository;

@Controller
public class CidadeController {

	@Autowired
	private CidadeRepository cr;
	
	@RequestMapping(value="/cadastrarCidade", method=RequestMethod.GET)
	public String form(){
		return "cidade/formCidade";
	}
	
	@RequestMapping(value="/cadastrarCidade", method=RequestMethod.POST)
	public String form(Cidade cidade){
		cr.save(cidade);
		
		return "redirect:/cidades";
	}
	
	@RequestMapping("/cidades")
	public ModelAndView listaCidades() {
		ModelAndView mv = new ModelAndView("index");
		Iterable<Cidade> cidades = cr.findAll();
		mv.addObject("cidades", cidades);
		return mv;
	}
	
	
}
