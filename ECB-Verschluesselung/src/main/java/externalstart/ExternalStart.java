package externalstart;

import ecbverschluesselung.ECBVerschluesselung;
import exception.InputException;
import gui.GUI;
import interfaces.ExternalStartInterface;

public class ExternalStart implements ExternalStartInterface{

	private ECBVerschluesselung ecb = new ECBVerschluesselung();
	
	public String handleStart(String [] args) throws InputException {
		
		String content = "";
		
		switch (args.length) {
		
		case 0:
			content = ecb.startECBVerschluesselung();
			break;
		case 1:
			this.startGui(args);
			content = "Gui geschlossen";
			break;
		case 3:
			content = this.checkUserInput(args);
			break;
		default:
			throw new InputException();
		}
		
		return content;
		
	}
	
	@SuppressWarnings("unused")
	private String[] checkStringArray(String [] args) throws InputException {
		
		try {
			Integer.parseInt(args[2]);
		} catch (NumberFormatException e) {
			throw new InputException();
		}
		
		return args;
		
	}
	
	private String checkUserInput(String [] args) throws InputException {
		
		String content = "";
		
		if(args[0].equals("") || args[1].equals("") || args[2].equals("")) {
			
			throw new InputException();
			
		}
		
		try {
			
			switch (args[0]) {
			
			case "-d":
			case "-decrypt":
				content = ecb.decryption(args[1], Integer.parseInt(args[2]));
				break;
			case "-e":
			case "-encrypt":
				content = ecb.encryption(args[1], Integer.parseInt(args[2]));
				break;
			default:
				throw new InputException();
			
			}
			
		} catch(NumberFormatException e) {
			
			throw new InputException();
			
		}
		
		return content;
		
	}
	
	private void startGui(String [] args) throws InputException {
		
		GUI gui = new GUI();
		
		switch (args[0]) {
		case "-g":
		case "-gui":
			gui.handleGui();
			break;
		case "-e":
		case "-d":
			throw new InputException();
		default:
			throw new InputException();
		}
		
	}
	
}
