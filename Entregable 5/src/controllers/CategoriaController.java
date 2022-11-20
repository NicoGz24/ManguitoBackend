package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import repositorys.CategoriaRepository;


@RestController
@RequestMapping("/Categoria")
public class CategoriaController {

	@Autowired
	private CategoriaRepository categoriaRepository;

}
