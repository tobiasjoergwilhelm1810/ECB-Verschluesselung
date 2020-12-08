package mocktest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import mock.ExceptionMock;

class ExceptionMockTest {

	private ExceptionMock exc = new ExceptionMock();
	
	@Test
	@DisplayName("GetErrorMessage")
	void testGetErrorMessage() {
		String text = this.exc.getErrorMessage();
		
		assertEquals("T", text);
		assertTrue(this.exc.getErrorMessageIsCallable);
	}

}
