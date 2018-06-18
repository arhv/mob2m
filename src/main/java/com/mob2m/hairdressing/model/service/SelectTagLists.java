package com.mob2m.hairdressing.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class SelectTagLists {

	public List<String> getComandasStatus() {
		List<String> optionDisplay = new ArrayList<>();
		optionDisplay.add("Aberta");
		optionDisplay.add("Fechada");
		return optionDisplay;
	}

	public List<String> getComandasType() {
		List<String> optionDisplay = new ArrayList<>();
		optionDisplay.add("Padrão");
		optionDisplay.add("Pacote");
		optionDisplay.add("Entrada de Caixa");
		optionDisplay.add("Saida de Caixa");
		return optionDisplay;
	}

	public List <String> getDisplayCnpjCpfSelection(){
		List<String> optionDisplay1 = new ArrayList<>();
		optionDisplay1.add("CPF");
		optionDisplay1.add("CNPJ");
		return optionDisplay1;
	}

	public List <String> getDisplayCpfCnpjSelection(){
		List<String> optionDisplay = new ArrayList<>();
		optionDisplay.add("CNPJ");
		optionDisplay.add("CPF");
		return optionDisplay;
	}

	public List<String> getDisplayInOut() {
		List<String> optionDisplay = new ArrayList<>();
		optionDisplay.add("Entrada");
		optionDisplay.add("Saida");
		return optionDisplay;
	}

	public List<Integer> getDisplayParcels() {
		List<Integer> optionDisplay = new ArrayList<>();
		optionDisplay.add(1);
		optionDisplay.add(2);
		optionDisplay.add(3);
		optionDisplay.add(4);
		optionDisplay.add(5);
		optionDisplay.add(6);
		optionDisplay.add(7);
		optionDisplay.add(8);
		optionDisplay.add(9);
		optionDisplay.add(10);
		return optionDisplay;
	}

	public List<String> getDisplayProductGoal() {
		List<String> optionDisplay = new ArrayList<>();
		optionDisplay.add("Revenda");
		optionDisplay.add("Uso Interno");
		return optionDisplay;
	}

	
}
