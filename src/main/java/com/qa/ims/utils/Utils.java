package com.qa.ims.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Utils {
	
	private static final Logger LOGGER = LogManager.getLogger();

	private final Scanner scanner;

	public Utils(Scanner scanner) {
		super();
		this.scanner = scanner;
	}

	public Utils() {
		scanner = new Scanner(System.in);
	}

	public Long getLong() {
		String input = null;
		Long longInput = null;
		do {
			try {
				input = getString();
				longInput = Long.parseLong(input);
			} catch (NumberFormatException nfe) {
				LOGGER.info("Error - Please enter a number");
			}
		} while (longInput == null);
		return longInput;
	}

	public java.sql.Date getDate() {
		String input = null;
		Date dateInput = null;
		do {
			input = getString();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			try {
				dateInput = dateFormat.parse(input);
			}catch (ParseException e) {
				e.printStackTrace();
			}
		} while(dateInput == null);
		return new java.sql.Date(dateInput.getTime());
		//return dateInput;
	}

	public String getString() {
		return scanner.nextLine();
	}

	public Double getDouble() {
		String input = null;
		Double doubleInput = null;
		do {
			try {
				input = getString();
				doubleInput = Double.parseDouble(input);
			} catch (NumberFormatException nfe) {
				LOGGER.info("Error - Please enter a number");
			}
		} while (doubleInput == null);
		return doubleInput;
	}

	public Integer getInteger() {
		String input = null;
		Integer integerInput = null;
		do{
			try {
				input = getString();
				integerInput = Integer.parseInt(input);
			} catch (NumberFormatException nfe) {
				LOGGER.info("error - Please enter a number");
			}
		} while (integerInput == null);
		return integerInput;
	}

}
