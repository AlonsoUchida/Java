package com.valmar.ecommerce.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static Date getDateFromString(String dateString) {
		String[] formatStrings = {"yyyy-MM-dd hh:mm:ss", "dd/MM/yyyy"};
		for (String formatString : formatStrings) {
			DateFormat format = new SimpleDateFormat(formatString);
			try {
				Date date = format.parse(dateString);
				return date;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
}
