package ecbverschluesselung;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import exception.ProgrammInterruptException;

class ProgrammInterruptExceptionTest {

	private ProgrammInterruptException exc = new ProgrammInterruptException();
	
	@Test
	@DisplayName("GetErrorMessage")
	void testGetErrorMessage() {

		String text=this.exc.getErrorMessage();
		
		String content = "Leider gab es einen Fehler im Programm welches das Programm zum Beenden gezwungen hat.";
		
		assertEquals(content, text);
		
	}

}
