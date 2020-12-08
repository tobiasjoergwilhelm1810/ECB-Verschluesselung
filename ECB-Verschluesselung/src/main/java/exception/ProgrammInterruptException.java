package exception;

import interfaces.ExceptionInterface;

public class ProgrammInterruptException extends Exception implements ExceptionInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String getErrorMessage() {

		String text = "";
		
		text += "Leider gab es einen Fehler im Programm welches das Programm zum Beenden gezwungen hat.";
		
		return text;
		
	}

}
