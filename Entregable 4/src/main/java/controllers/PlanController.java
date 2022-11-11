package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import repositorys.PlanRepository;

@RestController
@RequestMapping("/Plan")
public class PlanController {
	
	@Autowired
	private PlanRepository planRepository;
}
