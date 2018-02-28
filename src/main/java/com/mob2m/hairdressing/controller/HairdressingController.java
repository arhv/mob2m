package com.mob2m.hairdressing.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class HairdressingController {



	@RequestMapping("/")
	public ModelAndView findAll() {
		//ModelAndView mv = new ModelAndView("home");
		//mv.addObject("home", "<h2>Test h2 home</h2>");
		ModelAndView mv = new ModelAndView("home");
		//mv.addObject("styleValue", "display:none");
		return mv;
	}

	@RequestMapping(path = "${url.home}", method = RequestMethod.GET)
	public ModelAndView findAllHome() {
		//ModelAndView mv = new ModelAndView("home");
		//mv.addObject("home", "<h2>Test h2 home</h2>");
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("styleValue", "display:none");
		return mv;
	}

	@RequestMapping(path = "${url.administrativo.permissoes}", method = RequestMethod.GET)
	public ModelAndView goAdministrativoPermissoes() {
		ModelAndView mv = new ModelAndView("adminpermissoes");
		//mv.addObject("clientes", );
		return mv;
	}

	@RequestMapping(path = "${url.agenda}", method = RequestMethod.GET)
	public ModelAndView goAgenda() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName(); //get logged in username
		ModelAndView mv = new ModelAndView("agenda");
		mv.addObject("styleValue", "display:none");
		mv.addObject("fragmentRemove", "all");
		mv.addObject("userLogged", name);
		mv.addObject("agenda", ",<br/><br/><h1>Test Agenda</h1>");

		return mv;
	}

	@RequestMapping(path = "${url.cadastro.fornecedores}", method = RequestMethod.GET)
	public ModelAndView goCadastroFornecedores() {
		ModelAndView mv = new ModelAndView("cadastrofornecedores");
		return mv;
	}

	@RequestMapping(path = "${url.cadastro.profissionais}", method = RequestMethod.GET)
	public ModelAndView goCadastroProfissionais() {
		ModelAndView mv = new ModelAndView("cadastroprofissionais");
		return mv;
	}

	@RequestMapping(path = "${url.cadastro.clientes}",
			method = RequestMethod.GET)
	public ModelAndView goClientes() {
		ModelAndView mv = new ModelAndView("cadastroclientes");
		//mv.addObject("clientes", );
		return mv;
	}

	@RequestMapping(path = "${url.comandas}", method = RequestMethod.GET)
	public ModelAndView goComandas() {
		ModelAndView mv = new ModelAndView("comandas");
		mv.addObject("styleValue", "display:none");
		mv.addObject("comandas", ",<br/><br/><h1>Test Comandas</h1>");
		return mv;
	}

	@RequestMapping(path = "${url.financeiro}", method = RequestMethod.GET)
	public ModelAndView goFinanceiro() {
		ModelAndView mv = new ModelAndView("financeiro");
		//mv.addObject("clientes", );
		return mv;
	}


	@RequestMapping(path = "${url.login}", method = RequestMethod.GET)
	public ModelAndView goLogin() {
		ModelAndView mv = new ModelAndView("login");
		//mv.addObject("clientes", );
		return mv;
	}

	@RequestMapping(path = "${url.outros}", method = RequestMethod.GET)
	public ModelAndView goOutros() {
		ModelAndView mv = new ModelAndView("adminoutros");
		//mv.addObject("clientes", );
		return mv;
	}

	@RequestMapping(path = "${url.produtos.consumo}", method = RequestMethod.GET)
	public ModelAndView goProdutosInsumos() {
		ModelAndView mv = new ModelAndView("produtosconsumo");
		//mv.addObject("clientes", );
		return mv;
	}

	@RequestMapping(path = "${url.produtos.revenda}", method = RequestMethod.GET)
	public ModelAndView goProdutosRevenda() {
		ModelAndView mv = new ModelAndView("produtosrevenda");
		//mv.addObject("clientes", );
		return mv;
	}

	@RequestMapping(path = "${url.servicos.detalhes}", method = RequestMethod.GET)
	public ModelAndView goServicosDetalhes() {
		ModelAndView mv = new ModelAndView("servicosdetalhes");
		return mv;
	}

	@RequestMapping(path = "${url.servicos.promocoes}", method = RequestMethod.GET)
	public ModelAndView goServicosPromocoes() {
		ModelAndView mv = new ModelAndView("servicospromocoes");
		//mv.addObject("clientes", );
		return mv;
	}

}
