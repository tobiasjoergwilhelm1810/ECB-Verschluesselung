package exception;

import interfaces.ExceptionInterface;

public class NodeNotExistException extends Exception implements ExceptionInterface {

	private String input;
	private boolean bitorbuch;
	
	public NodeNotExistException(String input, boolean bitorbuch) {
		
		this.input = input;
		this.bitorbuch = bitorbuch;
		
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getErrorMessage() {
		
		String text = "";
		
		if(this.bitorbuch) {
			
			text = "Leider wurde eine Node mit dem Buchstaben " + this.input + " nicht gefunden. Bitte überprüfen Sie Ihre angaben.";
			
		}
		
		if(!this.bitorbuch) {
			
			text = "Leider wurde eine Node mit dem Bit " + this.input + " nicht gefunden. Bitte überprüfen Sie Ihre angaben.";
			
		}
		
		return text;
		
	}

}
