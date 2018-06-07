$(document).ready(function() {
	if ($("#select_cpf_cnpj_drop").val()=="CNPJ"){		
		$("#cpf_cnpj").mask("999.999.999/9999-99");
	}else{		
		$("#cpf_cnpj").mask("999.999.999-99");
	}		
	
	$("#select_cpf_cnpj_drop").change(function() {		
		if ($("#select_cpf_cnpj_drop").val()=="CNPJ"){
			$("#cpf_cnpj").val('');
			$("#cpf_cnpj").mask("999.999.999/9999-99");
		}else{
			$("#cpf_cnpj").val('');
			$("#cpf_cnpj").mask("999.999.999-99");
		}		
		
	});
});



