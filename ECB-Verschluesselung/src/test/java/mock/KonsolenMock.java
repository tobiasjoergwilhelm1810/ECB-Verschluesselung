package mock;

import interfaces.KonsolenInterface;

public class KonsolenMock implements KonsolenInterface {

	public String[] args;
	public boolean executeIsCallable = false;
	
	@Override
	public String execute(String[] args) {
		
		this.executeIsCallable = true;
		this.args = args;
		
		return "TEST";
	}
	
	
}
