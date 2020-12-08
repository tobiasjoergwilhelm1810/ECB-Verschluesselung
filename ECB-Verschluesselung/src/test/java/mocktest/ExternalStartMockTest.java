package mocktest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import exception.InputException;
import mock.ExternalStartMock;

class ExternalStartMockTest {

	private ExternalStartMock esm = new ExternalStartMock();
	
	@Test
	@DisplayName("HandleExternal")
	void testHandleExternal()  {
		String [] args = new String [2];
		
		args[0] = "0";
		args[1] = "Test";
		
		try {
			String content = this.esm.handleStart(args);
			
			assertEquals("t", content);
			assertEquals(this.esm.args, args);
			assertTrue(this.esm.handleStartExceptionIsCallable);
		} catch (InputException e) {
			fail("Hier sollte keine Exception geworfen werden");
		}
		
		
	}
	
	@Test
	@DisplayName("HandleExternal")
	void testHandleExternalException() {
		String [] args = new String [2];
		
		args[0] = "1";
		args[1] = "Test";
		
		@SuppressWarnings("unused")
		String content;
		try {
			content = this.esm.handleStart(args);
		} catch (InputException e) {
			assertTrue(this.esm.exceptionIsCallable);
		}
	}

}
