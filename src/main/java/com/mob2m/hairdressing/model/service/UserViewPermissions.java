package com.mob2m.hairdressing.model.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.mob2m.hairdressing.model.dao.UserCompany;
import com.mob2m.hairdressing.model.dao.UserRoles;
import com.mob2m.hairdressing.service.UserCompanyService;
import com.mob2m.hairdressing.service.UserRolesService;

@Component
public class UserViewPermissions {

	@Autowired
	UserCompanyService userCompanyService;

	@Autowired
	UserRolesService userRolesService;

	@Autowired
	private SelectTagLists selectTagLists;

	public ModelAndView getUserDetails(String currentUserName, ModelAndView mv) {
		List<UserCompany> userCompanyByUsername = userCompanyService.listUserCompanyByUsername(currentUserName);
		Long userSubisidiaryId = userCompanyByUsername.get(0).getCompanySubsidiaries().getId();
		Long userRoleId = userCompanyByUsername.get(0).getUserRoles().getId();
		UserRoles userRolesByUsername = userRolesService.findOne(userRoleId);
		HashMap<String, String> getStylesValues = selectTagLists.getDisplayRole();
		String style_value_agenda = getStylesValues.get(userRolesByUsername.getStyle_value_agenda());
		String style_value_comandas = getStylesValues.get(userRolesByUsername.getStyle_value_comandas());
		String style_value_cadastro = getStylesValues.get(userRolesByUsername.getStyle_value_cadastro());
		String style_value_servicos = getStylesValues.get(userRolesByUsername.getStyle_value_servicos());
		String style_value_produtos = getStylesValues.get(userRolesByUsername.getStyle_value_produtos());
		String style_value_administrativo = getStylesValues.get(userRolesByUsername.getStyle_value_administrativo());
		String style_value_financeiro = getStylesValues.get(userRolesByUsername.getStyle_value_financeiro());

		mv.addObject("userSubisidiaryId", userSubisidiaryId);
		mv.addObject("styleValueAgenda", style_value_agenda);
		mv.addObject("styleValueComandas", style_value_comandas);
		mv.addObject("styleValueCadastro", style_value_cadastro);
		mv.addObject("styleValueServicos", style_value_servicos);
		mv.addObject("styleValueProdutos", style_value_produtos);
		mv.addObject("styleValueAdministrativo", style_value_administrativo);
		mv.addObject("styleValueFinanceiro", style_value_financeiro);

		HashMap<String, String> getRemoveValues = selectTagLists.getDisplayRemove();
		mv.addObject("removeAgenda", getRemoveValues.get(userRolesByUsername.getStyle_value_agenda()));
		mv.addObject("removeComandas", getRemoveValues.get(userRolesByUsername.getStyle_value_comandas()));
		mv.addObject("removeCadastro", getRemoveValues.get(userRolesByUsername.getStyle_value_cadastro()));
		mv.addObject("removeServicos", getRemoveValues.get(userRolesByUsername.getStyle_value_servicos()));
		mv.addObject("removeProdutos", getRemoveValues.get(userRolesByUsername.getStyle_value_produtos()));
		mv.addObject("removeAdministrativo", getRemoveValues.get(userRolesByUsername.getStyle_value_administrativo()));
		mv.addObject("removeFinanceiro", getRemoveValues.get(userRolesByUsername.getStyle_value_financeiro()));

		return mv;
	}

	public int getUserLoggedin(String currentUserName) {
		List<UserCompany> userCompanyByUsername = userCompanyService.listUserCompanyByUsername(currentUserName);
		return userCompanyByUsername.size();
	}
}
