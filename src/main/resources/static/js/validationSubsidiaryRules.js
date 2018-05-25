$(document).ready(function () {
	             $("#formNewSubsidiary").validate({
	                 rules: {
	                     'companySubsidiaryName': {
	                         required: true,
	                        // minlength: 5,
	                        //maxlength: 100
	                     },
	                     'companySubsidiaryType': {
	                         required: true,
	                         //minlength: 8,
	                        // maxlength: 10000
	                     },
	                     'companySubsidiaryCnpj': {
	                         required: true,
	                         //minlength: 8,
	                        // maxlength: 10000
	                     },
	                     'companySubsidiaryAddress': {
	                         required: true,
	                         //minlength: 8,
	                        // maxlength: 10000
	                     },
	                     'companySubsidiaryCep': {
	                         required: true,
	                         //minlength: 8,
	                        // maxlength: 10000
	                     },
	                     'companySubsidiaryState': {
	                         required: true,
	                         //minlength: 8,
	                        // maxlength: 10000
	                     },
	                     'companySubsidiaryCity': {
	                         required: true,
	                         //minlength: 8,
	                        // maxlength: 10000
	                     }
	                 },
	                 /*messages: {
	                	 username: {
	                         required: "Por favor digitar seu nome de usuário !"
	                     },
	                     userEmail: {
	                         required: "Por favor digitar seu endereço de email !"
	                     },
	                     phonenumber: {
	                         required: "Por favor digitar seu número de telefone !"
	                     },
	                     userPassword: {
	                         required: "Por favor digitar sua senha !"
	                     },
	                     fullName: {
	                         required: "Por favor digitar seu nome completo !"
	                     }
	                 }*/
	             });
	         });