package com.sv.test.springboot.app.controller;

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
import com.sv.test.springboot.app.service.GradosService;



@Controller
@RequestMapping("/grados")
public class GradoController {
	
	private static final Log LOG = LogFactory.getLog(GradoController.class);
	
	@Autowired
	@Qualifier("gradosService")
	GradosService gradosService;

	
	@GetMapping("/gradoForm")
	public String redirectGradosForm(@RequestParam(name = "idGrado", required = false) int idGrado,
			Model model) {
		Grados grado = new Grados();
		if(idGrado != 0) {
			grado = gradosService.findGradoById(idGrado);
		}		
		
		model.addAttribute("grado",grado);
		return ViewConstant.GRADO_FORM;
	}
	
	@GetMapping("/cancel")
	public String cancel() {
		return "redirect:/grados/showGrados";
	}
	
	@PostMapping("/addGrado")
	public String addGrado(@ModelAttribute(name = "gradoModel") Grados grado, Model model) {
		LOG.info("METHOD: addGrados() --PARAMS: " + grado.toString());
		
		if(null != gradosService.addGrado(grado)) {
			model.addAttribute("result", 1);
		}else {
			model.addAttribute("result", 0);
		}
		
		return "redirect:/grados/showGrados";
	}
	
	@GetMapping("/showGrados")
	public ModelAndView showGrados() {
		ModelAndView mav = new ModelAndView(ViewConstant.GRADOS);	
		
		mav.addObject("listGrados", gradosService.listAllGrados());
		
		return mav;
	}
	
	@GetMapping("/removeGrado")
	public ModelAndView removeGrados(@RequestParam(name = "idGrado", required = true) int idGrado) {
		gradosService.removeGrado(idGrado);
		return showGrados();		
	}
}
