package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import repositorys.RedSocialRepository;

@RestController
@RequestMapping("/RedSocial")
public class RedSocialController {

	@Autowired
	private RedSocialRepository redSocialRepository;
}
