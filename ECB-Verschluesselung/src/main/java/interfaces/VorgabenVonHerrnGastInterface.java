package interfaces;

import java.util.HashMap;

public interface VorgabenVonHerrnGastInterface {

	public void printCharArray(char[] text);
	public char[] shiftRight(char[] bits);
	public char[] shiftLeft(char[] bits);
	public int symbolLength();
	public HashMap<Character, String> encryptionCodeMap();
	public HashMap<String, Character> decryptionCodeMap();
	
}
