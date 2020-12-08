package ecbverschluesselung;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import exception.InputException;
import src.ErrorMessage;

class InputExceptionTest {

	private InputException ie = new InputException();
	private ErrorMessage er = new ErrorMessage();
	@Test
	@DisplayName("GetErrorMessage")
	void test() {
		
		assertEquals(er.getErrorMessage(), ie.getErrorMessage());
		
	}
	
	@Test
	@DisplayName("GetErrorMessageGui")
	void test2() {
		
		assertEquals(this.ie.getErrorMessageGui(), this.er.getErrorMessageGui());
		
	}

}
