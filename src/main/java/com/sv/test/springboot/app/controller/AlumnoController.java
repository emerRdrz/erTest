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
import com.sv.test.springboot.app.pojos.Alumnos;
import com.sv.test.springboot.app.pojos.Grados;
import com.sv.test.springboot.app.pojos.Profesores;
import com.sv.test.springboot.app.service.AlumnosService;
import com.sv.test.springboot.app.service.ProfesoresService;



@Controller
@RequestMapping("/alumnos")
public class AlumnoController {
	
	private static final Log LOG = LogFactory.getLog(AlumnoController.class);
	
	@Autowired
	@Qualifier("alumnosService")
	AlumnosService alumnosService;
	
	@Autowired
	@Qualifier("profesoresService")
	ProfesoresService profesoresService;

	
	@GetMapping("/alumnoForm")
	public String redirectAlumnosForm(@RequestParam(name = "idAlumno", required = false) int idAlumno,
			Model model) {
		Alumnos alumno = new Alumnos();
		if(idAlumno != 0) {
			alumno = alumnosService.findAlumnoById(idAlumno);
		}		
		
		List<Profesores> profesoresList = new ArrayList<Profesores>();
		profesoresList = profesoresService.listAllProfesores();
		
		model.addAttribute("alumno",alumno);
		model.addAttribute("profesoresList",profesoresList);
		
		return ViewConstant.ALUMNO_FORM;
	}
	
	@GetMapping("/cancel")
	public String cancel() {
		return "redirect:/alumnos/showAlumnos";
	}
	
	@PostMapping("/addAlumno")
	public String addAlumno(@ModelAttribute(name = "alumnoModel") Alumnos alumno, Model model) {
		LOG.info("METHOD: addAlumnos() --PARAMS: " + alumno.toString());
		
		if(null != alumnosService.addAlumno(alumno)) {
			model.addAttribute("result", 1);
		}else {
			model.addAttribute("result", 0);
		}
		
		return "redirect:/alumnos/showAlumnos";
	}
	
	@GetMapping("/showAlumnos")
	public ModelAndView showAlumnos() {
		ModelAndView mav = new ModelAndView(ViewConstant.ALUMNOS);	
		
		mav.addObject("listAlumnos", alumnosService.listAllAlumnos());
		
		return mav;
	}
	
	@GetMapping("/removeAlumno")
	public ModelAndView removeAlumnos(@RequestParam(name = "idAlumno", required = true) int idAlumno) {
		alumnosService.removeAlumno(idAlumno);
		return showAlumnos();		
	}
}
