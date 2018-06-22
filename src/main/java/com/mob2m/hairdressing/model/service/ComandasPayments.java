package com.mob2m.hairdressing.model.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mob2m.hairdressing.model.dao.ComandasDetailsProductsUsage;
import com.mob2m.hairdressing.model.dao.ComandasDetailsServices;
import com.mob2m.hairdressing.model.dao.ComandasExpensesServices;
import com.mob2m.hairdressing.model.dao.ComandasMaster;
import com.mob2m.hairdressing.model.dao.ComandasPaymentsTypes;
import com.mob2m.hairdressing.model.dao.ComandasReceivables;
import com.mob2m.hairdressing.model.dao.ComandasReceivablesDetails;
import com.mob2m.hairdressing.model.dao.Professionals;
import com.mob2m.hairdressing.model.dao.Services;
import com.mob2m.hairdressing.service.ComandasDetailsProductsUsageService;
import com.mob2m.hairdressing.service.ComandasDetailsService;
import com.mob2m.hairdressing.service.ComandasExpensesServicesService;
import com.mob2m.hairdressing.service.ComandasMasterService;
import com.mob2m.hairdressing.service.ComandasPaymentsTypesService;
import com.mob2m.hairdressing.service.ComandasReceivablesDetailsService;
import com.mob2m.hairdressing.service.ProfessionalsService;
import com.mob2m.hairdressing.service.ServicesService;



@Component
public class ComandasPayments {

	@Autowired
	private ComandasDetailsService comandasDetailsService;

	@Autowired
	private ComandasDetailsProductsUsageService comandasDetailsProductsUsageService;

	@Autowired
	private ComandasReceivablesDetailsService comandasReceivablesDetailsService; 

	@Autowired
	private ComandasPaymentsTypesService comandasPaymentsTypesService;

	/*@Autowired
	private ComandasReceivablesDetails comandasReceivablesDetails;*/

	@Autowired
	private  ComandasMasterService  comandasMasterService;

	/*@Autowired
	private ComandasExpensesServices comandasExpensesServices;	*/

	@Autowired
	private ServicesService servicesService;

	@Autowired
	private ComandasExpensesServicesService comandasExpensesServicesService;

	@Autowired
	private ProfessionalsService professionalsService;


	public List<ComandasDetailsServices> getComandasAllDetailsServices(){
		List<ComandasDetailsServices> comandasAllDetailsServices = comandasDetailsService.findAll();
		return comandasAllDetailsServices;
	}

	public List<ComandasDetailsProductsUsage> getComandasAllProductsUsage(){
		List<ComandasDetailsProductsUsage> comandasAllDetailsProductsUsage = comandasDetailsProductsUsageService.findAll();
		return comandasAllDetailsProductsUsage;
	}

	public List<ComandasDetailsProductsUsage> getComandasDetailsProductsUsageListById(Long id){
		List<ComandasDetailsProductsUsage> comandasDetailsProductsUsageListById = comandasDetailsProductsUsageService
				.listAllComandasDetailsProductsUsagesById(id);
		return comandasDetailsProductsUsageListById;
	}

	public List<ComandasDetailsServices> getComandasDetailsServicesListById(Long id){
		List<ComandasDetailsServices> comandasDetailsServicesListById = comandasDetailsService.listAllComandasDetailsServicesById(id);
		return comandasDetailsServicesListById;
	}

	public Date getDateCompensationDaysAdded(Date comandaPaymentDate, int daysAdded) {
		LocalDateTime comandaPaymentDateAddDaysTemp = comandaPaymentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();	
		comandaPaymentDateAddDaysTemp=comandaPaymentDateAddDaysTemp.plusDays(daysAdded);
		Date comandaPaymentDateAddDays = Date.from(comandaPaymentDateAddDaysTemp.atZone(ZoneId.systemDefault()).toInstant());
		return comandaPaymentDateAddDays;
	}	

	public double getSumDetailsProductsUsage(Long id) {		
		/*List<ComandasDetailsProductsUsage> comandasDetailsProductsUsageListById = comandasDetailsProductsUsageService
				.listAllComandasDetailsProductsUsagesById(id);*/
		double sumDetailsProductsUsageListById = 0;
		for (int i = 0; i < getComandasDetailsProductsUsageListById(id).size(); i++) {
		sumDetailsProductsUsageListById = sumDetailsProductsUsageListById + getComandasDetailsProductsUsageListById(id).get(i).getProduct_usage_cost();
		}		
		return sumDetailsProductsUsageListById;
	}

	public double getSumDetailsServices(Long id) {
		//List<ComandasDetailsServices> comandasDetailsServicesListById = comandasDetailsService.listAllComandasDetailsServicesById(id);		
		double sumDetailsServicesListById = 0;
		for (int i = 0; i < getComandasDetailsServicesListById(id).size(); i++) {
		sumDetailsServicesListById = sumDetailsServicesListById + getComandasDetailsServicesListById(id).get(i).getService_value();
		}

		return sumDetailsServicesListById;
	}


	public double professionalTotalReceivable(Long professionalId, Date startDate, Date endDate) {
		List<ComandasExpensesServices> comandasExpensesServicesList = comandasExpensesServicesService.listAllComandasPaymentsPerProfessional(professionalId, startDate, endDate );

		double sumProfessionalValue=0;
		for (int i=0;i<comandasExpensesServicesList.size();i++) {
		sumProfessionalValue = sumProfessionalValue + comandasExpensesServicesList.get(i).getTotal_professional_discounted();			
		}
		return sumProfessionalValue;
	}

	public double savePayment(ComandasReceivables comandasReceivables, double sumAllcomandaId, Long comandaId) {
		ComandasReceivablesDetails comandasReceivablesDetails = new ComandasReceivablesDetails();
		double totalComandaValueReceived = comandasReceivables.getTotal_receivable_value(); 
		int numberOfParcelsReceived = comandasReceivables.getNumber_parcels();
		Date comandaPaymentDate = comandasReceivables.getReceivable_date();				
		Long paymentTypeId = comandasReceivables.getPaymentsTypes().getId();
		ComandasPaymentsTypes comandasPaymentsTypes = comandasPaymentsTypesService.findOne(paymentTypeId);
		int daysOfCompensation = comandasPaymentsTypes.getCompensation_days();
		Date comandaPaymentDateAddDays = getDateCompensationDaysAdded(comandaPaymentDate,daysOfCompensation);
		double parcelValue = totalComandaValueReceived/numberOfParcelsReceived;		

		for (int i=0;i<numberOfParcelsReceived;i++) {
		comandasReceivablesDetails.setComandasReceivables(comandasReceivables);
		comandasReceivablesDetails.setEffective_receivable_value(parcelValue);
		comandasReceivablesDetails.setEffective_receivable_date(comandaPaymentDateAddDays);
		comandasReceivablesDetailsService.save(comandasReceivablesDetails);	
		comandaPaymentDateAddDays = getDateCompensationDaysAdded(comandaPaymentDateAddDays,daysOfCompensation);
		}

		Long comandaReceivableId = comandasReceivablesDetails.getComandasReceivables().getId();

		double sumRemainingComandasPaymentTmp = 0;
		for (int i = 0; i < comandasReceivablesDetailsService.listAllRemainingComandaPayment(comandaReceivableId).size(); i++) {
		sumRemainingComandasPaymentTmp = sumRemainingComandasPaymentTmp + comandasReceivablesDetailsService.listAllRemainingComandaPayment(comandaReceivableId).get(i).getEffective_receivable_value();			
		}
		double sumRemainingComandasPayment = totalComandaValueReceived - sumRemainingComandasPaymentTmp;

		return sumRemainingComandasPayment;		

	}

	public void saveProfessionalsReceivablesServices(ComandasReceivables comandasReceivables, double sumAllcomandaId, Long comandaId) {		
		ComandasExpensesServices comandasExpensesServices = new ComandasExpensesServices();
		if (getComandasDetailsServicesListById(comandaId).size()!=0) {
		for (int i=0;i<getComandasDetailsServicesListById(comandaId).size();i++) {	

		setComandaExpensesServices(comandasExpensesServices, comandasReceivables, sumAllcomandaId, comandaId, i);

		// #### NEED TO HAVE FOR EACH PROFESSIONAL ####
		//Set professional_principal_id
		comandasExpensesServices.setProfessionals(getComandasDetailsServicesListById(comandaId).get(i).getProfessionals());	

		// #### NEED TO HAVE FOR EACH PROFESSIONAL ####
		//Set professional_service_percentage				
		Long serviceId = getComandasDetailsServicesListById(comandaId).get(i).getServices().getId();
		Services services = servicesService.findOne(serviceId);
		double professionalPercentage = services.getPercentage_professional();				
		comandasExpensesServices.setProfessional_service_percentage(professionalPercentage);		

		// #### NEED TO HAVE FOR EACH PROFESSIONAL ####
		//Set professional_service_total_value
		double professional_service_total_value_tmp = getComandasDetailsServicesListById(comandaId).get(i).getService_value();
		double professional_service_total_value = professional_service_total_value_tmp*(professionalPercentage/100);
		comandasExpensesServices.setProfessional_service_total_value(professional_service_total_value);

		// #### NEED TO HAVE FOR EACH PROFESSIONAL ####
		//Set total_professional_discounted
		Long paymentId = comandasReceivables.getPaymentsTypes().getId();
		ComandasPaymentsTypes comandasPaymentsTypes = comandasPaymentsTypesService.findOne(paymentId);
		double payment_type_discount_percentage = comandasPaymentsTypes.getTax_percentage();
		comandasExpensesServices.setPayment_type_discount_percentage(payment_type_discount_percentage);
		double parcialCrediDebitAmountFromComandasReceivablePayment = comandasReceivables.getTotal_receivable_value();
		double payment_type_discount_value = parcialCrediDebitAmountFromComandasReceivablePayment*(payment_type_discount_percentage/100);
		double total_professional_discounted = professional_service_total_value - payment_type_discount_value;
		comandasExpensesServices.setTotal_professional_discounted(total_professional_discounted);	

		comandasExpensesServicesService.save(comandasExpensesServices);

		//ProfessionalsService professionalsService = new ProfessionalsService();
		Long professional_aux_1_id = getComandasDetailsServicesListById(comandaId).get(i).getProfessionals1().getId();
		Professionals professionals1 = professionalsService.findOne(professional_aux_1_id);
		String professional1Selection = professionals1.getUser().getUsername();


		if (professional1Selection!="-") {		

		setComandaExpensesServices(comandasExpensesServices, comandasReceivables, sumAllcomandaId, comandaId, i);
		// #### NEED TO HAVE FOR EACH PROFESSIONAL ####
		//Set professional_principal_id
		comandasExpensesServices.setProfessionals(getComandasDetailsServicesListById(comandaId).get(i).getProfessionals1());

		// #### NEED TO HAVE FOR EACH PROFESSIONAL ####
		//Set professional_service_percentage						
		double professionalAux1Percentage = services.getPercentage_aux_1();				
		comandasExpensesServices.setProfessional_service_percentage(professionalAux1Percentage);

		// #### NEED TO HAVE FOR EACH PROFESSIONAL ####
		//Set professional_service_total_value
		double professional_service_total_value_aux_1 = professional_service_total_value_tmp*(professionalPercentage/100);
		comandasExpensesServices.setProfessional_service_total_value(professional_service_total_value_aux_1);

		// #### NEED TO HAVE FOR EACH PROFESSIONAL ####
		//Set total_professional_discounted	
		//PROFESSIONAL AUX DOES NOT HAVE PAYMENT TAX DISCOUNTED, VALUE IS 0
		double payment_type_discount_value_aux_1 = parcialCrediDebitAmountFromComandasReceivablePayment*(0);
		double total_professional_discounted_aux_1 = professional_service_total_value - payment_type_discount_value_aux_1;
		comandasExpensesServices.setTotal_professional_discounted(total_professional_discounted_aux_1);	

		comandasExpensesServicesService.save(comandasExpensesServices);					

		}


		Long professional_aux_2_id = getComandasDetailsServicesListById(comandaId).get(i).getProfessionals2().getId();
		Professionals professionals2 = professionalsService.findOne(professional_aux_2_id);
		String professional2Selection = professionals2.getUser().getUsername();
		if (professional2Selection!="-") {		

		setComandaExpensesServices(comandasExpensesServices, comandasReceivables, sumAllcomandaId, comandaId, i);
		// #### NEED TO HAVE FOR EACH PROFESSIONAL ####
		//Set professional_principal_id
		comandasExpensesServices.setProfessionals(getComandasDetailsServicesListById(comandaId).get(i).getProfessionals2());

		// #### NEED TO HAVE FOR EACH PROFESSIONAL ####
		//Set professional_service_percentage						
		double professionalAux1Percentage = services.getPercentage_aux_2();				
		comandasExpensesServices.setProfessional_service_percentage(professionalAux1Percentage);

		// #### NEED TO HAVE FOR EACH PROFESSIONAL ####
		//Set professional_service_total_value
		double professional_service_total_value_aux_2 = professional_service_total_value_tmp*(professionalPercentage/100);
		comandasExpensesServices.setProfessional_service_total_value(professional_service_total_value_aux_2);

		// #### NEED TO HAVE FOR EACH PROFESSIONAL ####
		//Set total_professional_discounted	
		//PROFESSIONAL AUX DOES NOT HAVE PAYMENT TAX DISCOUNTED, VALUE IS 0
		double payment_type_discount_value_aux_2 = parcialCrediDebitAmountFromComandasReceivablePayment*(0);
		double total_professional_discounted_aux_2 = professional_service_total_value - payment_type_discount_value_aux_2;
		comandasExpensesServices.setTotal_professional_discounted(total_professional_discounted_aux_2);	

		comandasExpensesServicesService.save(comandasExpensesServices);					

		}
		}

		}

	}

	public void setComandaExpensesServices(ComandasExpensesServices comandasExpensesServices, ComandasReceivables comandasReceivables,
			double sumAllcomandaId, Long comandaId, int i) {

		//Set company_subsidiary
		comandasExpensesServices.setCompanySubsidiaries(comandasReceivables.getCompanySubsidiaries());

		//Set expense_type
		comandasExpensesServices.setExpense_type(StringList.PROFISSIONAL);

		//Set comanda_id
		comandasExpensesServices.setComanda_id(comandaId);

		//Set payment_date
		comandasExpensesServices.setPayment_date(comandasReceivables.getReceivable_date());				

		//Set comanda_total_value
		comandasExpensesServices.setComanda_total_value(getComandasDetailsServicesListById(comandaId).get(i).getService_value());

		//Set Payment Type
		comandasExpensesServices.setComandasPaymentsTypes(comandasReceivables.getPaymentsTypes());

		//Set payment_type_discount_percentage
		Long paymentId = comandasReceivables.getPaymentsTypes().getId();
		ComandasPaymentsTypes comandasPaymentsTypes = comandasPaymentsTypesService.findOne(paymentId);
		double payment_type_discount_percentage = comandasPaymentsTypes.getTax_percentage();

		//Total amount received from ComandasReceivable object may be parcial in Credit or Debit Card, this is the value that should be charged the tax from PaymentsTypes Class
		double parcialCrediDebitAmountFromComandasReceivablePayment = comandasReceivables.getTotal_receivable_value();
		double payment_type_discount_value = parcialCrediDebitAmountFromComandasReceivablePayment*(payment_type_discount_percentage/100);
		comandasExpensesServices.setPayment_type_discount_value(payment_type_discount_value);				

		//Set customer_id
		ComandasMaster comandasMasterCustomer = comandasMasterService.findOne(comandaId);				
		comandasExpensesServices.setCustomers(comandasMasterCustomer.getCustomers());

		//Set service_id				
		Long serviceId = getComandasDetailsServicesListById(comandaId).get(i).getServices().getId();
		Services services = servicesService.findOne(serviceId);
		comandasExpensesServices.setServices(services);		
	}
}
