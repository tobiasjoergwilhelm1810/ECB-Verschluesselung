package exception;

import interfaces.ExceptionInterface;

public class NodeAllreadyExistException extends Exception implements ExceptionInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String buchstabe;
	private String bit;
	
	public NodeAllreadyExistException(String buchstabe, String bit) {
		
		this.buchstabe = buchstabe;
		this.bit = bit;
		
	}
	
	@Override
	public String getErrorMessage() {

		return "Der Node mit Buchstabe " + this.buchstabe + " und Bit " + this.bit + " existiert bereits";
		
	}

}
