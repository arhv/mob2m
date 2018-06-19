package com.mob2m.hairdressing.controller;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.mob2m.hairdressing.model.dao.ComandasMaster;
import com.mob2m.hairdressing.model.dao.CompanySubsidiaries;
import com.mob2m.hairdressing.model.dao.Customers;
import com.mob2m.hairdressing.model.service.SelectTagLists;
import com.mob2m.hairdressing.model.service.StringList;
import com.mob2m.hairdressing.model.service.UserAuthentication;
import com.mob2m.hairdressing.model.service.UtilUsage;
import com.mob2m.hairdressing.service.ComandasMasterService;
import com.mob2m.hairdressing.service.CompanySubsidiariesService;
import com.mob2m.hairdressing.service.CustomersService;

@RestController
public class HairdressingControllerComandas {

	@Autowired
	private UserAuthentication userAuthentication;

	@Autowired
	private CompanySubsidiariesService companySubsidiariesService;

	@Autowired
	private CustomersService customersService;

	@Autowired
	private ComandasMasterService comandasMasterService;

	@Autowired
	private SelectTagLists selectTagLists;

	@Autowired
	private UtilUsage utilUsage;

	@RequestMapping(path = "/adicionarcomanda", method = RequestMethod.GET)
	public ModelAndView addNewComanda(ComandasMaster comandasMaster) {
		ModelAndView mv = userAuthentication.getModelViewWithUser("comandasmaster");
		List<CompanySubsidiaries> listCompanySubsidiaries = companySubsidiariesService.findAll();
		List<Customers> listCustomers = customersService.findAll();
		mv.addObject("comandasStatus", selectTagLists.getComandasStatus());
		mv.addObject("comandasType", selectTagLists.getComandasType());
		mv.addObject("customersList", listCustomers);
		mv.addObject("companySubsidiaryList", listCompanySubsidiaries);
		mv.addObject("addComandasMaster", comandasMaster);
		mv.addObject("removeFindAll", "all");
		mv.addObject("removeAddComandasMaster", "none");
		mv.addObject("removeEditComandasMaster", "all");

		return mv;
	}

	@RequestMapping(path = "/comandasabertas", method = RequestMethod.GET)
	public ModelAndView goComandasAbertas() {
		ModelAndView mv = userAuthentication.getModelViewWithUser("comandasmaster");
		mv.addObject("removeFindAll", "none");
		mv.addObject("removeAddComandasMaster", "all");
		mv.addObject("removeEditComandasMaster", "all");
		mv.addObject("comandasMasterList", comandasMasterService.listAllComandasOpened(StringList.ABRIRCOMANDA));
		return mv;

	}

	@RequestMapping(path = "/comandasfechadas", method = RequestMethod.GET)
	public ModelAndView goComandasFechadas() {
		ModelAndView mv = userAuthentication.getModelViewWithUser("comandasmasterclosed");
		mv.addObject("removeFindAll", "none");
		mv.addObject("removeAddComandasMasterClosed", "all");
		mv.addObject("removeEditComandasMasterClosed", "all");
		mv.addObject("comandasMasterList", comandasMasterService.listAllComandasOpened(StringList.FECHARCOMANDA));
		return mv;

	}

	@RequestMapping(path = "/editarcomanda/{id}", method = RequestMethod.GET)
	public ModelAndView goDetailsComanda(@PathVariable("id") Long id) throws ParseException {
		ComandasMaster comandasMaster = comandasMasterService.findOne(id);
		ModelAndView mv = userAuthentication.getModelViewWithUser("comandasmaster");
		List<CompanySubsidiaries> listCompanySubsidiaries = companySubsidiariesService.findAll();
		List<Customers> listCustomers = customersService.findAll();
		Long companyNameId = comandasMaster.getCompanySubsidiaries().getId();
		Long customerNameId = comandasMaster.getCustomers().getId();
		comandasMaster.setDate_comanda(utilUsage.getCurrentTimeUsingDate(comandasMaster.getDate_comanda()));
		mv.addObject("comandasStatus", selectTagLists.getComandasStatus());
		mv.addObject("comandasType", selectTagLists.getComandasType());
		mv.addObject("comandaStatusEdit", comandasMaster.getStatus());
		mv.addObject("comandaTypeEdit", comandasMaster.getComanda_type());
		mv.addObject("companyId", companyNameId);
		mv.addObject("productId", customerNameId);
		mv.addObject("companySubsidiaryList", listCompanySubsidiaries);
		mv.addObject("customersList", listCustomers);
		mv.addObject("editComandasMaster", comandasMaster);
		mv.addObject("removeFindAll", "all");
		mv.addObject("removeAddComandasMaster", "all");
		mv.addObject("removeEditComandasMaster", "none");

		return mv;
	}

	@RequestMapping(path = "/salvarcomanda", method = RequestMethod.POST)
	public RedirectView save(@Valid ComandasMaster comandasMaster, BindingResult result) {
		if (result.hasErrors()) {
		List<FieldError> errors = result.getFieldErrors();
		for (FieldError error : errors) {
		System.out.println(error.getObjectName() + " - " + error.getDefaultMessage());
		}

		}
		comandasMaster.setStatus(selectTagLists.getComandasStatus().get(0));
		comandasMaster.setDate_comanda(new Date(System.currentTimeMillis()));
		comandasMasterService.save(comandasMaster);
		RedirectView rv = new RedirectView();
		rv.setContextRelative(true);
		rv.setUrl("/comandasabertas");
		return rv;
	}


}
