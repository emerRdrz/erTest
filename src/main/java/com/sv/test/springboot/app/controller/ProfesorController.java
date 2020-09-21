package com.sv.test.springboot.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sv.test.springboot.app.constant.ViewConstant;
import com.sv.test.springboot.app.pojos.Grados;
import com.sv.test.springboot.app.pojos.Profesores;
import com.sv.test.springboot.app.service.GradosService;
import com.sv.test.springboot.app.service.ProfesoresService;



@Controller
@RequestMapping("/profesores")
public class ProfesorController {
	
	private static final Log LOG = LogFactory.getLog(ProfesorController.class);
	
	@Autowired
	@Qualifier("profesoresService")
	ProfesoresService profesoresService;
	
	@Autowired
	@Qualifier("gradosService")
	GradosService gradosService;

	
	@GetMapping("/profesorForm")
	public String redirectProfesoresForm(@RequestParam(name = "idProfesor", required = false) int idProfesor,
			Model model) {
		Profesores profesor = new Profesores();
		if(idProfesor != 0) {
			profesor = profesoresService.findProfesorById(idProfesor);
		}		
		
		List<Grados> gradosList = new ArrayList<Grados>();
		gradosList = gradosService.listAllGrados();
		
		model.addAttribute("profesor",profesor);
		model.addAttribute("gradosList",gradosList);
		
		return ViewConstant.PROFESOR_FORM;
	}
	
	@GetMapping("/cancel")
	public String cancel() {
		return "redirect:/profesors/showProfesores";
	}
	
	@PostMapping("/addProfesor")
	public String addProfesor(@ModelAttribute(name = "profesorModel") Profesores profesor, Model model) {
		LOG.info("METHOD: addProfesores() --PARAMS: " + profesor.toString());
		
		if(null != profesoresService.addProfesor(profesor)) {
			model.addAttribute("result", 1);
		}else {
			model.addAttribute("result", 0);
		}
		
		return "redirect:/profesores/showProfesores";
	}
	
	@GetMapping("/showProfesores")
	public ModelAndView showProfesores() {
		ModelAndView mav = new ModelAndView(ViewConstant.PROFESORES);	
		
		mav.addObject("listProfesores", profesoresService.listAllProfesores());
		
		return mav;
	}
	
	@GetMapping("/removeProfesor")
	public ModelAndView removeProfesores(@RequestParam(name = "idProfesor", required = true) int idProfesor) {
		profesoresService.removeProfesor(idProfesor);
		return showProfesores();		
	}
}
