package com.nextcoach.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.format.Formatter;

public class DateFormatter implements Formatter<Date> {

	private static final String YYYY_MM_DD = "yyyy-mm-dd";

	@Override
	public String print(Date date, Locale locale) {
		final SimpleDateFormat dateFormat = createDateFormat(locale);
		return dateFormat.format(date);
	}

	@Override
	public Date parse(String text, Locale locale) throws ParseException {
		final SimpleDateFormat dateFormat = createDateFormat(locale);
		return dateFormat.parse(text);
	}

	private SimpleDateFormat createDateFormat(final Locale locale) {
		final SimpleDateFormat dateFormat = new SimpleDateFormat(YYYY_MM_DD);
		dateFormat.setLenient(false);
		return dateFormat;
	}
}
