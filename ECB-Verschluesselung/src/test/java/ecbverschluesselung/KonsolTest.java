package ecbverschluesselung;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.Konsole;
import src.ErrorMessage;

class KonsolTest {

	private ErrorMessage er = new ErrorMessage();
	private Konsole k = new Konsole();
	
	@Test
	@DisplayName("Test mit -d")
	void testKonsole1() {
		
		String [] args = new String[3];
		
		args[0]="-d";
		args[1]="TEST";
		args[2]="2";
		
		String test="YCVV";
		
		String content = k.execute(args);
		
		assertEquals(content, test);
		
	}
	
	@Test
	@DisplayName("Test mit -decrypt")
	void testKonsole2() {
		
		String [] args = new String[3];
		
		args[0]="-decrypt";
		args[1]="TEST";
		args[2]="2";
		
		String test="YCVV";
		
		String content = k.execute(args);
		
		assertEquals(content, test);
		
	}
	
	@Test
	@DisplayName("Test mit -e")
	void testKonsole3() {
		
		String [] args = new String[3];
		
		args[0]="-e";
		args[1]="YCVV";
		args[2]="2";
		
		String test="TEST";
		
		String content = k.execute(args);
		
		assertEquals(content, test);
		
	}
	
	@Test
	@DisplayName("Test mit -encrypt")
	void testKonsole4() {
		
		String [] args = new String[3];
		
		args[0]="-encrypt";
		args[1]="YCVV";
		args[2]="2";
		
		String test="TEST";
		
		String content = k.execute(args);
		
		assertEquals(content, test);
		
	}
	
	@Test
	@DisplayName("Error Test mit String Array Größe 1")
	void testError1() {
		
		String [] args = new String [1];
		args[0] = "s0";
		
		assertEquals(this.k.execute(args), this.er.getErrorMessage());
		
	}
	
	@Test
	@DisplayName("Error Test mit String Array Größe 2")
	void testError2() {
		
		String [] args = new String [2];
		args[0] = "s0";
		args[1] = "s";
		
		assertEquals(this.k.execute(args), this.er.getErrorMessage());
		
	}
	
	@Test
	@DisplayName("Error Test mit String Array Größe 4")
	void testError4() {
		
		String [] args = new String [4];
		args[0] = "s0";
		args[1] = "TTT";
		args[2] = "TTT";
		args[3] = "X";
		
		assertEquals(this.k.execute(args), this.er.getErrorMessage());
		
	}
	
	@Test
	@DisplayName("Error Test Letzter Parameter mit String")
	void testErrorLetzeString() {
		
		String [] args = new String [3];
		args[0] = "-d";
		args[1] = "Test";
		args[2] = "W";
		
		assertEquals(this.k.execute(args), this.er.getErrorMessage());
		
	}
	
	@Test
	@DisplayName("Error Test Erster Parameter Falsch")
	void testErrorFalscherParameter() {
		
		String [] args = new String [3];
		args[0] = "-das";
		args[1] = "Test";
		args[2] = "2";
		
		assertEquals(this.k.execute(args), this.er.getErrorMessage());
		
	}

}
