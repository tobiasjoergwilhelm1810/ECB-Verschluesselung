package exception;

import interfaces.ExceptionInterface;

/**
 * Dies ist eine InputException.
 * 
 * Diese Exception wird immer dann geworfen, wenn irgendwo eine Falschen eingaben war.
 */
public class InputException extends Exception implements ExceptionInterface {

	private static final long serialVersionUID = 1L;

	/**
	 * Diese Methode gibt eine ErrorMessage zurück
	 * 
	 * @return String
	 */
	@Override
	public String getErrorMessage() {
		String text = "";
		
		text += "##############################################################\n";
		text += "#                                                            #\n";
		text += "#        Hoppla!!! Da ist wohl was schief gelaufen!!!        #\n";
		text += "#                                                            #\n";
		text += "##############################################################\n";
		text += "\n\n\n";
		text += "Es wurde eine Falsche Eingabe getätigt.";
		text += "\n\n\n";
		text += "Aufruf:\n";
		text += "==============================================================\n\n";
		text += "Aufruf des Programms: java -jar ECB-Verschluesselung.jar [-d|-e] [TEXT] [BLOCKSIZE]\n";
		text += "\n\n\n";
		text += "Folgende Eingaben sind erlaubt:\n";
		text += "==============================================================\n\n";
		text += "-d | -decrypt            => Verschlüsselung\n";
		text += "-e | -encrypt            => Entschlüsselung\n";
		text += "-g | -gui                => GUI Anwendung  \n";
		
		return text;
	}
	
	public String getErrorMessageGui() {
		
		String text = "";
		
		text += "##############################################################\n";
		text += "#                                                            #\n";
		text += "#        Hoppla!!! Da ist wohl was schief gelaufen!!!        #\n";
		text += "#                                                            #\n";
		text += "##############################################################\n";
		text += "\n\n\n";
		text += "Es können Folgende Fehler Auftreten!\n\n";
		text += "==============================================================\n\n";
		text += "- Falsche Eingabe des Textes\n";
		text += "- Falsche Eingabe der Zahl\n";
		text += "\n==============================================================\n\n";
		text += "Bitte überprüfen Sie Ihre eingaben";
		
		return text;
		
	}

}
