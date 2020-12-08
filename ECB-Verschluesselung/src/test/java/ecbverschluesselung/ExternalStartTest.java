package ecbverschluesselung;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import exception.InputException;
import externalstart.ExternalStart;
import src.ErrorMessage;

class ExternalStartTest {

	private ExternalStart exstart = new ExternalStart();
	private ErrorMessage er = new ErrorMessage();
	
	@Test
	@DisplayName("Test mit -d")
	void testExternalStart1() {
		
		String [] args = new String[3];
		
		args[0]="-d";
		args[1]="TEST";
		args[2]="2";
		
		String test="YCVV";
		
		String content;
		try {
			content = this.exstart.handleStart(args);
			assertEquals(content, test);
		} catch (InputException e) {
			fail("Hier sollte keine Exception geschmissen werden");
		}
		
	}
	
	@Test
	@DisplayName("Test mit -decrypt")
	void testExternalStart2() {
		
		String [] args = new String[3];
		
		args[0]="-decrypt";
		args[1]="TEST";
		args[2]="2";
		
		String test="YCVV";
		
		String content;
		try {
			content = this.exstart.handleStart(args);
			assertEquals(content, test);
		} catch (InputException e) {
			fail("Hier sollte keine Exception geschmissen werden");
		}
		

		
	}
	
	@Test
	@DisplayName("Test mit -e")
	void testExternalStart3() {
		
		String [] args = new String[3];
		
		args[0]="-e";
		args[1]="YCVV";
		args[2]="2";
		
		String test="TEST";
		
		String content;
		try {
			content = this.exstart.handleStart(args);
			assertEquals(content, test);
		} catch (InputException e) {
			fail("Hier sollte keine Exception geschmissen werden");
		}
		
	}
	
	@Test
	@DisplayName("Test mit -encrypt")
	void testExternalStart4() {
		
		String [] args = new String[3];
		
		args[0]="-encrypt";
		args[1]="YCVV";
		args[2]="2";
		
		String test="TEST";
		
		String content;
		try {
			content = this.exstart.handleStart(args);
			assertEquals(content, test);
		} catch (InputException e) {
			fail("Hier sollte keine Exception geschmissen werden");
		}
		
	}
	
	@Test
	@DisplayName("Error Test mit String Array Größe 1")
	void testError1() {
		
		String [] args = new String [1];
		args[0] = "s0";
		
		try {
			this.exstart.handleStart(args);
		} catch (InputException e) {
			assertEquals(e.getErrorMessage(), this.er.getErrorMessage());
		}
		
	}
	
	@Test
	@DisplayName("Error Test mit String Array Größe 2")
	void testError2() {
		
		String [] args = new String [2];
		args[0] = "s0";
		args[1] = "s";
		
		try {
			this.exstart.handleStart(args);
		} catch (InputException e) {
			assertEquals(e.getErrorMessage(), this.er.getErrorMessage());
		}
		
	}
	
	@Test
	@DisplayName("Error Test mit String Array Größe 4")
	void testError4() {
		
		String [] args = new String [4];
		args[0] = "s0";
		args[1] = "TTT";
		args[2] = "TTT";
		args[3] = "X";
		
		try {
			this.exstart.handleStart(args);
		} catch (InputException e) {
			assertEquals(e.getErrorMessage(), this.er.getErrorMessage());
		}
		
	}
	
	@Test
	@DisplayName("Error Test Letzter Parameter mit String")
	void testErrorLetzeString() {
		
		String [] args = new String [3];
		args[0] = "-d";
		args[1] = "Test";
		args[2] = "W";
		
		try {
			this.exstart.handleStart(args);
		} catch (InputException e) {
			assertEquals(e.getErrorMessage(), this.er.getErrorMessage());
		}
		
	}
	
	@Test
	@DisplayName("Error Test Erster Parameter Falsch")
	void testErrorFalscherParameter() {
		
		String [] args = new String [3];
		args[0] = "-das";
		args[1] = "Test";
		args[2] = "2";
		
		try {
			this.exstart.handleStart(args);
		} catch (InputException e) {
			assertEquals(e.getErrorMessage(), this.er.getErrorMessage());
		}
		
	}

}
