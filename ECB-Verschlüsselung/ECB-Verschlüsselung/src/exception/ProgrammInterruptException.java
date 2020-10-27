package exception;

public class ProgrammInterruptException extends Throwable {

	public String getErrorMessage() {
		
		String text = "";
		
		text += "Leider gab es einen Fehler im Programm welches das Programm zum Beenden gezwungen hat.";
		
		return text;
		
	}
	
}
