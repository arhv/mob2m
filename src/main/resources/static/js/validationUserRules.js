$(document).ready(function () {
	             $("#formNewUser").validate({
	                 rules: {
	                     'username': {
	                         required: true,
	                        // minlength: 5,
	                        //maxlength: 100
	                     },
	                     'userEmail': {
	                         required: true,
	                         //minlength: 8,
	                        // maxlength: 10000
	                     },
	                     'phonenumber': {
	                         required: true,
	                         //minlength: 8,
	                        // maxlength: 10000
	                     },
	                     'userPassword': {
	                         required: true,
	                         //minlength: 8,
	                        // maxlength: 10000
	                     },
	                     'fullName': {
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