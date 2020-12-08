package mock;

import exception.InputException;
import interfaces.ExternalStartInterface;

public class ExternalStartMock implements ExternalStartInterface {

	public String[] args;
	public boolean exceptionIsCallable = false;
	public boolean handleStartExceptionIsCallable = false;
	
	@Override
	public String handleStart(String[] args) throws InputException {
		if(args[0].equals("1")) {
			
			this.exceptionIsCallable = true;
			throw new InputException();
			
		} else {
			
			this.handleStartExceptionIsCallable = true;
			this.args = args;
			
		}
		
		return "t";
	}

}
