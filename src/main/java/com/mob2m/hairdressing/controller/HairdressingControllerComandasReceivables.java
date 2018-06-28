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

import com.mob2m.hairdressing.model.dao.ComandasMaster;
import com.mob2m.hairdressing.model.dao.ComandasPaymentsTypes;
import com.mob2m.hairdressing.model.dao.ComandasReceivables;
import com.mob2m.hairdressing.model.dao.CompanySubsidiaries;
import com.mob2m.hairdressing.model.service.ComandasPayments;
import com.mob2m.hairdressing.model.service.SelectTagLists;
import com.mob2m.hairdressing.model.service.StringList;
import com.mob2m.hairdressing.model.service.UserAuthentication;
import com.mob2m.hairdressing.model.service.UtilUsage;
import com.mob2m.hairdressing.service.ComandasMasterService;
import com.mob2m.hairdressing.service.ComandasPaymentsTypesService;
import com.mob2m.hairdressing.service.ComandasReceivablesService;
import com.mob2m.hairdressing.service.CompanySubsidiariesService;

@RestController
public class HairdressingControllerComandasReceivables {

	@Autowired
	private UserAuthentication userAuthentication;

	@Autowired
	private CompanySubsidiariesService companySubsidiariesService;


	@Autowired
	private ComandasPaymentsTypesService comandasPaymentsTypesService;

	@Autowired
	private ComandasReceivablesService comandasReceivablesService;

	@Autowired
	private ComandasMasterService comandasMasterService;

	@Autowired
	private ComandasPayments comandasPayments;

	@Autowired
	private SelectTagLists selectTagLists;

	@Autowired
	private UtilUsage utilUsage;

	@RequestMapping(path = "/adicionarpagamentodecomanda/{comandaId}/{customerName}", method = RequestMethod.GET)
	public ModelAndView addNewComandasPaymentsTypes(@PathVariable("comandaId") Long comandaId, @PathVariable("customerName") String customerName,
			ComandasReceivables comandasReceivables) {
		ModelAndView mv = userAuthentication.getModelViewWithUser("comandasreceivables");
		List<CompanySubsidiaries> listCompanySubsidiaries = companySubsidiariesService.findAll();
		ComandasMaster comandasMaster = comandasMasterService.findOne(comandaId);
		Long subsidiaryId = comandasMaster.getCompanySubsidiaries().getId();
		//String customerName = comandasMaster.getCustomers().getCustomer_name();
		String subsidiaryName = comandasMaster.getCompanySubsidiaries().getCompanySubsidiaryName();
		comandasReceivables.setComanda_id(comandaId);
		mv.addObject("sumAllcomandaId", comandasPayments.getSumDetailsServices(comandaId));
		mv.addObject("paymentsTypesList", comandasPaymentsTypesService.findAll());
		mv.addObject("numberParcelsList", selectTagLists.getDisplayParcels());
		mv.addObject("subsidiaryId", subsidiaryId);
		mv.addObject("subsidiaryName", subsidiaryName);
		mv.addObject("comandaId", comandaId);
		mv.addObject("companySubsidiaryList", listCompanySubsidiaries);
		mv.addObject("customerName", customerName);
		mv.addObject("addComandasReceivables", comandasReceivables);
		mv.addObject("removeFindAll", "all");
		mv.addObject("removeAddComandasReceivables", "none");
		mv.addObject("removeEditComandasReceivables", "all");
		return mv;
	}

	@RequestMapping(path = "/pagamentodecomanda/{comandaId}/{customerName}", method = RequestMethod.GET)
	public ModelAndView goComandasReceivables(@PathVariable("comandaId") Long comandaId, @PathVariable("customerName") String customerName) {
		ModelAndView mv = userAuthentication.getModelViewWithUser("comandasreceivables");
		ComandasMaster comandasMaster = comandasMasterService.findOne(comandaId);
		Long subsidiaryId = comandasMaster.getCompanySubsidiaries().getId();
		//String customerName = comandasMaster.getCustomers().getCustomer_name();
		String subsidiaryName = comandasMaster.getCompanySubsidiaries().getCompanySubsidiaryName();
		mv.addObject("paymentsTypesList", comandasPaymentsTypesService.findAll());
		mv.addObject("sumAllcomandaId", comandasPayments.getSumDetailsServices(comandaId));
		mv.addObject("subsidiaryId", subsidiaryId);
		mv.addObject("subsidiaryName", subsidiaryName);
		mv.addObject("comandaId", comandaId);
		mv.addObject("customerName", customerName);
		mv.addObject("removeFindAll", "none");
		mv.addObject("removeAddComandasReceivables", "all");
		mv.addObject("removeEditComandasReceivables", "all");
		mv.addObject("comandasReceivablesList", comandasReceivablesService.listAllComandasPaymentsSaved(comandaId));
		return mv;

	}

	@RequestMapping(path = "/editarpagamentodecomanda/{comandaId}/{customerName}", method = RequestMethod.GET)
	public ModelAndView goDetailsComanda(@PathVariable("comandaId") Long comandaId, @PathVariable("customerName") String customerName)
			throws ParseException {
		ComandasPaymentsTypes comandasPaymentsTypes = comandasPaymentsTypesService.findOne(comandaId);
		ModelAndView mv = userAuthentication.getModelViewWithUser("comandaspaymentstypes");
		List<CompanySubsidiaries> listCompanySubsidiaries = companySubsidiariesService.findAll();
		mv.addObject("sumAllcomandaId", comandasPayments.getSumDetailsServices(comandaId));
		mv.addObject("comandaId", comandaId);
		mv.addObject("customerName", customerName);
		mv.addObject("numberParcelsList", selectTagLists.getDisplayParcels());
		mv.addObject("companySubsidiaryList", listCompanySubsidiaries);
		mv.addObject("editComandasPaymentsTypes", comandasPaymentsTypes);
		mv.addObject("removeFindAll", "all");
		mv.addObject("removeAddComandasPaymentsTypesService", "all");
		mv.addObject("removeEditComandasPaymentsTypesService", "none");
		return mv;
	}

	@RequestMapping(path = "/salvarpagamentodecomanda/{sumAllcomandaId}/{comandaId}", method = RequestMethod.POST)
	public ModelAndView save(@Valid ComandasReceivables comandasReceivables, BindingResult result,
			@PathVariable("sumAllcomandaId") double sumAllcomandaId, @PathVariable("comandaId") Long comandaId) {
		if (result.hasErrors()) {
		List<FieldError> errors = result.getFieldErrors();
		for (FieldError error : errors) {
		System.out.println(error.getObjectName() + " - " + error.getDefaultMessage());
		}

		}		
		//comandasReceivables.setComanda_id(comandaId);
		//comandasReceivables.setTotal_receivable_value(sumAllcomandaId);
		Date comandaDate = new Date(System.currentTimeMillis());
		comandasReceivables.setReceivable_date(utilUsage.setCurrentDateToTimeZone(comandaDate));
		comandasReceivablesService.save(comandasReceivables);
		double comandaRemainingValue = comandasPayments.savePayment(comandasReceivables, sumAllcomandaId, comandaId);

		if (comandaRemainingValue == 0) {
		/*RedirectView rv = new RedirectView();
			rv.setContextRelative(true);
			rv.setUrl("/pagamentodecomanda/{comandaId}");
			return rv;*/
		ComandasMaster comandasMaster = comandasMasterService.findOne(comandaId);
		comandasMaster.setStatus(StringList.FECHARCOMANDA);
		comandasMasterService.save(comandasMaster);
		comandasPayments.saveProfessionalsReceivablesServices(comandasReceivables, sumAllcomandaId, comandaId);
		return new ModelAndView("redirect:/comandasfechadas");
		}

		comandasPayments.saveProfessionalsReceivablesServices(comandasReceivables, sumAllcomandaId, comandaId);
		return new ModelAndView("redirect:/comandasabertas");
	}


}
