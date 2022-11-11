package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import repositorys.PosteoRepository;

@RestController
@RequestMapping("/Posteo")
public class PosteoController {

	@Autowired
	private PosteoRepository posteoRepository;
}
