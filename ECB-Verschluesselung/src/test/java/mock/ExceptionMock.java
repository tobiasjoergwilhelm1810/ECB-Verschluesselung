package mock;

import interfaces.ExceptionInterface;

public class ExceptionMock implements ExceptionInterface {

	public boolean getErrorMessageIsCallable = false;
	
	public String getErrorMessage() {
		this.getErrorMessageIsCallable = true;
		return "T";
	}

}
