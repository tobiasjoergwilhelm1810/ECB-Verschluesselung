package interfaces;

import java.util.HashMap;

public interface VorgabenVonHerrnGastInterface {

	public void printCharArray(char[] bits);
	public char[] shiftRight(char[] bits);
	public char[] shiftLeft(char[] bits);
	public HashMap<Character, String> encryptionCodeMap();
	public HashMap<String, Character> decryptionCodeMap();
	
}
