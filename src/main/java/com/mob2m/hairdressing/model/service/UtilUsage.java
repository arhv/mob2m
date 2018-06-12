package com.mob2m.hairdressing.model.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class UtilUsage {

	public Date getCurrentTimeUsingDate(Date dateValueFormat) throws ParseException {
		String strDateFormat = "dd/MM/yyyy HH:mm";
		SimpleDateFormat dateFormat = new SimpleDateFormat(strDateFormat);
		String formattedDate = dateFormat.format(dateValueFormat);
		//SimpleDateFormat formatStringToDate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date valueToDate = dateFormat.parse(formattedDate);
		return valueToDate;
	}

}
