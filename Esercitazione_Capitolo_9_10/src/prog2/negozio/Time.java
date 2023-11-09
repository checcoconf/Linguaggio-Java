package prog2.negozio;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

/**
 * La classe Time fornisce metodi per formattare ed
 * analizzare le date quando rappresentate come stringhe
 * @author pasqualeardimento
 *
 */
class Time {

	private static final DateTimeFormatter dateFormatter = 
			DateTimeFormatter.ofPattern("yyyy-MM-dd");

	/**
	 * 
	 * @param date Data nel formato dd/MM/yyyy
	 * @return data nel formato ddMMyyy
	 */
	static String getDayMonthYear(String date) {

		// Get an instance of LocalTime
		// from date
		LocalDate currentDate
		= LocalDate.parse(date);

		// Get day from date
		int day = currentDate.getDayOfMonth();

		// Get month from date
		Month month = currentDate.getMonth();

		// Get year from date
		int year = currentDate.getYear();

		// Print the day, month, and year
		System.out.println(day+"/"+month.getValue()+"/"+year);

		return (day+"/"+month.getValue()+"/"+year);
	}

	/**
	 * Estrae l'anno da una Stringa che rappresenta
	 * una data
	 * @param date Data
	 * @return Anno
	 */
	public static int getYear(String date) {
		// Get an instance of LocalTime
		// from date
		LocalDate currentDate
		= LocalDate.parse(date);

		// Get year from date
		int year = currentDate.getYear();

		return (year);
	}

	/**
	 * Estrae il mese da una Stringa che rappresenta
	 * una data
	 * @param date Data
	 * @return Mese espresso con un intero 1-12
	 */
	static int getMonth(String date) {
		// Get an instance of LocalTime
		// from date
		LocalDate currentDate
		= LocalDate.parse(date);

		// Get year from date
		int month = currentDate.getMonthValue();

		return (month);
	}

	/**
	 * Estrae il giorno da una Stringa che rappresenta
	 * una data
	 * @param date Data
	 * @return Giorno
	 */
	static int getDay(String date) {
		// Get an instance of LocalTime
		// from date
		LocalDate currentDate
		= LocalDate.parse(date);

		// Get year from date
		int day = currentDate.getDayOfMonth();

		return (day);
	}

	/**
	 * Ottiene un'istanza di LocalDate da una stringa di 
	 * testo utilizzando un formattatore specifico.
	 * Il testo viene analizzato utilizzando il formattatore, restituendo una data.
	 * @param data La data da parserizzare
	 * @return
	 */
	public static LocalDate getLocalDate(String data) {
		return LocalDate.parse(data, dateFormatter);
	}

}