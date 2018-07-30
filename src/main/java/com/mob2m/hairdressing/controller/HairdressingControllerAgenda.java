package com.mob2m.hairdressing.controller;

import java.util.Date;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mob2m.hairdressing.model.dao.Professionals;
import com.mob2m.hairdressing.model.service.ProfessionalSelection;
import com.mob2m.hairdressing.model.service.UserAuthentication;
import com.mob2m.hairdressing.service.AgendaDateService;
import com.mob2m.hairdressing.service.ProfessionalsService;

@RestController
public class HairdressingControllerAgenda {

	@Autowired
	private UserAuthentication userAuthentication;

	@Autowired
	private AgendaDateService agendaDateService;

	@Autowired
	private ProfessionalsService professionalsService;

	@RequestMapping(path = "/agenda", method = RequestMethod.GET)
	public ModelAndView getAgenda() {
		ModelAndView mv = userAuthentication.getModelViewWithUser("agenda");
		//List<AgendaDate> listAllAgenda = agendaDateService.listAllAgendaDate();
		ProfessionalSelection professionalSelection = new ProfessionalSelection();
		Long userSubisidiaryId = (Long) mv.getModel().get("userSubisidiaryId");
		List<Professionals> listProfessionals = professionalsService.listAllProfessionalsBySubsidiary(userSubisidiaryId);
		mv.addObject("professionalId", professionalSelection);
		mv.addObject("professionalList", listProfessionals);
		mv.addObject("removeFindAll", "none");
		return mv;
	}

	@RequestMapping(path = "/agenda/{agendaDate}/{companySubsidiaryId}/{professionalId}/{}", method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON)
	public ModelAndView getAgenda(@PathVariable("agendaDate") Date agendaDate, @PathVariable("companySubsidiaryId") Long companySubsidiaryId,
			@PathVariable("professionalId") Long professionalId) {
		ModelAndView mv = userAuthentication.getModelViewWithUser("agenda");
		mv.addObject("removeFindAll", "none");
		return mv;
	}

}
