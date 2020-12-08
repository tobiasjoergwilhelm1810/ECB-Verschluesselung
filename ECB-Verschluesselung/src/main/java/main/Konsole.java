package main;

import exception.InputException;
import externalstart.ExternalStart;
import interfaces.KonsolenInterface;

public class Konsole implements KonsolenInterface {
	
	public ExternalStart exstart = new ExternalStart();
	
	public static void main(String[] args) {

		Konsole k = new Konsole();
		
		String content = k.execute(args);
		
		System.out.println(content);
		
		System.out.println("Danke fuer Ihre Nutzung und auf Wiedersehen!");

	}

	@Override
	public String execute(String[] args) {
		String content = "";
		
		try {
			content = this.exstart.handleStart(args);
		} catch (InputException e) {
			content = e.getErrorMessage();
		}	
		
		return content;
	}

}
