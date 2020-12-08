package ecbverschluesselung;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ecbverschluesselung.VorgabenVonHerrnGast;

class VorgabenVonHerrnGastTest {

	private VorgabenVonHerrnGast vorgabe = new VorgabenVonHerrnGast();
	
	@Test
	@DisplayName("Shift Left")
	void testShiftLeft() {
		
		char[] test1 = {1,1,0};
		char[] abgleich1 = {1,0,1};
		char[] rückgabe1 = this.vorgabe.shiftLeft(test1);
		
		assertEquals(this.charToString(abgleich1), this.charToString(rückgabe1));
		
		char[] test2 = {4,5,8,6,2,1};
		char[] abgleich2 = {5,8,6,2,1,4};
		char[] rückgabe2 = this.vorgabe.shiftLeft(test2);
		
		assertEquals(this.charToString(abgleich2), this.charToString(rückgabe2));
		
		char[] test3 = {33,44,55,9};
		char[] abgleich3 = {44,55,9,33};
		char[] rückgabe3 = this.vorgabe.shiftLeft(test3);
		
		assertEquals(this.charToString(abgleich3), this.charToString(rückgabe3));
		
	}
	
	@Test
	@DisplayName("Shift Right")
	void testShiftRight() {
		
		char[] test1 = {1,1,0};
		char[] abgleich1 = {0,1,1};
		char[] rückgabe1 = this.vorgabe.shiftRight(test1);
		
		assertEquals(this.charToString(abgleich1), this.charToString(rückgabe1));
		
		char[] test2 = {4,5,8,6,2,1};
		char[] abgleich2 = {1,4,5,8,6,2};
		char[] rückgabe2 = this.vorgabe.shiftRight(test2);
		
		assertEquals(this.charToString(abgleich2), this.charToString(rückgabe2));
		
		char[] test3 = {33,44,55,9};
		char[] abgleich3 = {9,33,44,55};
		char[] rückgabe3 = this.vorgabe.shiftRight(test3);
		
		assertEquals(this.charToString(abgleich3), this.charToString(rückgabe3));
		
	}
	
	@Test
	@DisplayName("DecryptionCodeMap")
	void testDecryptionCodeMap() {
		
		HashMap<String, Character> hm = this.vorgabe.decryptionCodeMap();
		HashMap<String, Character> codeMap = new HashMap<String, Character>();
        codeMap.put("00000", 'A');
        codeMap.put("00001", 'C');
        codeMap.put("00010", 'E');
        codeMap.put("00011", 'G');
        codeMap.put("00100", 'I');
        codeMap.put("00101", 'K');
        codeMap.put("00110", 'M');
        codeMap.put("00111", 'O');
        codeMap.put("01000", 'Q');
        codeMap.put("01001", 'S');
        codeMap.put("01010", 'U');
        codeMap.put("01011", 'W');
        codeMap.put("01100", 'Y');
        codeMap.put("01101", '!');
        codeMap.put("01110", '?');
        codeMap.put("01111", 'Z');

        codeMap.put("10000", 'X');
        codeMap.put("10001", 'V');
        codeMap.put("10010", 'T');
        codeMap.put("10011", 'R');
        codeMap.put("10100", 'P');
        codeMap.put("10101", 'N');
        codeMap.put("10110", 'L');
        codeMap.put("10111", 'J');
        codeMap.put("11000", 'H');
        codeMap.put("11001", 'F');
        codeMap.put("11010", 'D');
        codeMap.put("11011", 'B');
        codeMap.put("11100", '_');
        codeMap.put("11101", '=');
        codeMap.put("11110", '+');
        codeMap.put("11111", '-');
        
        assertEquals(codeMap, hm);
        assertEquals(codeMap.get("00000"), hm.get("00000"));
        assertEquals(codeMap.get("10101"), hm.get("10101"));
        assertEquals(codeMap.get("01111"), hm.get("01111"));
        assertEquals(codeMap.get("01001"), hm.get("01001"));
        assertEquals(codeMap.get("00001"), hm.get("00001"));
        assertEquals(codeMap.get("11111"), hm.get("11111"));
		
	}
	
	@SuppressWarnings("unlikely-arg-type")
	@Test
	@DisplayName("EncryptionCodeMap")
	void testEncryptionCodeMap() {
		
		HashMap<Character, String> hm = this.vorgabe.encryptionCodeMap();
		HashMap<Character, String> codeMap = new HashMap<Character, String>();
        codeMap.put('A', "00000");
        codeMap.put('C', "00001");
        codeMap.put('E', "00010");
        codeMap.put('G', "00011");
        codeMap.put('I', "00100");
        codeMap.put('K', "00101");
        codeMap.put('M', "00110");
        codeMap.put('O', "00111");
        codeMap.put('Q', "01000");
        codeMap.put('S', "01001");
        codeMap.put('U', "01010");
        codeMap.put('W', "01011");
        codeMap.put('Y', "01100");
        codeMap.put('!', "01101");
        codeMap.put('?', "01110");
        codeMap.put('Z', "01111");

        codeMap.put('X', "10000");
        codeMap.put('V', "10001");
        codeMap.put('T', "10010");
        codeMap.put('R', "10011");
        codeMap.put('P', "10100");
        codeMap.put('N', "10101");
        codeMap.put('L', "10110");
        codeMap.put('J', "10111");
        codeMap.put('H', "11000");
        codeMap.put('F', "11001");
        codeMap.put('D', "11010");
        codeMap.put('B', "11011");
        codeMap.put('_', "11100");
        codeMap.put('=', "11101");
        codeMap.put('+', "11110");
        codeMap.put('-', "11111");
        
        assertEquals(codeMap, hm);
        assertEquals(codeMap.get("+"), hm.get("+"));
        assertEquals(codeMap.get("A"), hm.get("A"));
        assertEquals(codeMap.get("Q"), hm.get("Q"));
        assertEquals(codeMap.get("_"), hm.get("_"));
        assertEquals(codeMap.get("F"), hm.get("F"));
        assertEquals(codeMap.get("="), hm.get("="));
		
	}
	
	public String charToString(char[] bits) {
		
		String text = "";
		
		for(int i = 0; i < bits.length; i ++) {
			
			text += bits[i];
			
		}
		
		return text;
		
	}

}
