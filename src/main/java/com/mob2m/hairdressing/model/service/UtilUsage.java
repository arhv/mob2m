package com.mob2m.hairdressing.model.service;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class UtilUsage {

	public Date getCurrentTimeUsingDate(Date dateValueFormat) throws ParseException {
		LocalDateTime localDateTime = dateValueFormat.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

		String strDateFormat = "dd/MM/yyyy";
		SimpleDateFormat dateFormat = new SimpleDateFormat(strDateFormat);
		//DateTimeFormatter dateFormat8 = DateTimeFormatter.ofPattern(strDateFormat);
		//String formattedDate = dateFormat.format(dateValueFormat);

		int originalMonthValue = localDateTime.getMonthValue();
		int originalDayValue = localDateTime.getDayOfMonth();
		int yearValue = localDateTime.getYear();

		//Need to switch between Day and Month because of Spring uses default MM/dd/yyyy as input parameter
		//int correctDayValue = originalMonthValue;
		//int correctMonthValue = originalDayValue;

		String correctFormattedDate = originalDayValue + "/" + originalMonthValue + "/" + yearValue;

		System.out.println("formattedDate value: " + correctFormattedDate);
		//SimpleDateFormat formatStringToDate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date valueToDate = dateFormat.parse(correctFormattedDate);
		System.out.println("valueToDate parsed value: " + valueToDate);
		return valueToDate;
	}

	public String getCurrentTimeUsingString(Date dateValueFormat) throws ParseException {
		String strDateFormat = "yyyy-MM-dd";
		DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
		DateTimeFormatter dateFormat8 = DateTimeFormatter.ofPattern(strDateFormat);

		String formattedDate = dateFormat.format(dateValueFormat);
		//System.out.println("formattedDate value: " + formattedDate);
		//SimpleDateFormat formatStringToDate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date valueToDate = dateFormat.parse(formattedDate);
		//System.out.println("valueToDate parsed value: " + valueToDate);
		return formattedDate;
	}

	public Date setCurrentDateToTimeZone(Date dateTimeZone) {
		System.out.println("dateTimeZone: " + dateTimeZone);
		String strDateFormat = "dd/MM/yyyy HH:mm:ss";
		LocalDateTime localDateTime = dateTimeZone.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		int originalMonthValue = localDateTime.getMonthValue();
		int originalDayValue = localDateTime.getDayOfMonth();
		int yearValue = localDateTime.getYear();
		int hoursValue = localDateTime.getHour();
		int minutesValue = localDateTime.getMinute();
		int secondsValue = localDateTime.getSecond();
		DecimalFormat mFormat = new DecimalFormat("00");
		String correctFormattedDate = mFormat.format(Double.valueOf(originalDayValue)) + "/" + mFormat.format(Double.valueOf(originalMonthValue))
				+ "/" + yearValue + " " + mFormat.format(Double.valueOf(hoursValue)) + ":" + mFormat.format(Double.valueOf(minutesValue)) + ":"
				+ mFormat.format(Double.valueOf(secondsValue));
		LocalDateTime ldt = LocalDateTime.parse(correctFormattedDate, DateTimeFormatter.ofPattern(strDateFormat));
		ZoneId newYorkZoneId = ZoneId.of("America/New_York");
		ZonedDateTime newYorkZonedDateTime = ldt.atZone(newYorkZoneId);
		ZoneId saoPauloZoneId = ZoneId.of("America/Sao_Paulo");
		//Changed to the current Day Light Saving Time in New York
		ZonedDateTime spDateTime = newYorkZonedDateTime.withZoneSameInstant(saoPauloZoneId).minusHours(2);
		System.out.println("spDateTime: " + spDateTime);
		Instant instant = spDateTime.toInstant();
		Date date = Date.from(instant);
		System.out.println("date: " + date);
		//DateTimeFormatter spDateTime = DateTimeFormatter.ofPattern(strDateFormat);
		//LocalDate.parse(spDateTime, spDateTime);		
		return date;
	}

}
