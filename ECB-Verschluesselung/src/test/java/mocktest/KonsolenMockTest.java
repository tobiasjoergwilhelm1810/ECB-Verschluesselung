package mocktest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import mock.KonsolenMock;

class KonsolenMockTest {

	private KonsolenMock k = new KonsolenMock();
	
	@Test
	void test() {

		String [] args = new String [3];
		
		args[0] = "-d";
		args[1] = "TEST";
		args[2] = "2";
		
		String content = this.k.execute(args);
		
		assertEquals("TEST",content);
		assertEquals(args, this.k.args);
		assertTrue(this.k.executeIsCallable);
		
	}

}
