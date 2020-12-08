package mocktest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import mock.VorgabenVonHerrnGastMock;

class VorgabenVonHerrnGastMockTest {

	private VorgabenVonHerrnGastMock vorgaben = new VorgabenVonHerrnGastMock();
	
	@Test
	@DisplayName("PrintCharArrayMock")
	void testPrintCharArrayMock() {
		
		char[] test = {1,1,1,0};
		this.vorgaben.printCharArray(test);
		
		assertTrue(this.vorgaben.printCharArrayIsCallable);
		assertEquals(test, this.vorgaben.printCharArrayArray);
		
	}
	
	@Test
	@DisplayName("ShiftLeftMock")
	void testShiftLeftMock() {
		
		char[] test = {1,1,1,0};
		char[] back;
		
		back = this.vorgaben.shiftLeft(test);
		
		assertTrue(this.vorgaben.shiftLeftIsCallable);
		assertEquals(test, back);
		
	}
	
	@Test
	@DisplayName("ShiftRightMock")
	void testShiftRightMock() {
		
		char[] test = {1,1,1,0};
		char[] back;
		
		back = this.vorgaben.shiftRight(test);
		
		assertTrue(this.vorgaben.shiftRightIsCallable);
		assertEquals(test, back);
		
	}
	
	@Test
	@DisplayName("EncryptionCodeMapMock")
	void testEncryptionCodeMapMock() {
		
		HashMap<Character, String> hm = this.vorgaben.encryptionCodeMap();
		
		assertEquals(hm, new HashMap<Character, String>());
		assertTrue(this.vorgaben.encryptionCodeMapIsCallable);
		
	}
	
	@Test
	@DisplayName("DecryptionCodeMapMock")
	void testDecryptionCodeMapMock() {
		
		HashMap<String, Character> hm = this.vorgaben.decryptionCodeMap();
		
		assertEquals(hm, new HashMap<String, Character>());
		assertTrue(this.vorgaben.decryptionCodeMapIsCallable);
		
	}
	
	@Test
	@DisplayName("SymbolLength")
	void testSymbolLength() {
		
		assertEquals(this.vorgaben.symbolLength(),5);
		assertTrue(this.vorgaben.symbolLengthIsCallable);
		
	}

}
