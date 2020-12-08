package mock;

import java.util.HashMap;

import interfaces.VorgabenVonHerrnGastInterface;

public class VorgabenVonHerrnGastMock implements VorgabenVonHerrnGastInterface {

	public boolean printCharArrayIsCallable = false;
	public char[] printCharArrayArray = null;
	public boolean shiftRightIsCallable = false;
	public boolean shiftLeftIsCallable = false;
	public boolean encryptionCodeMapIsCallable = false;
	public boolean decryptionCodeMapIsCallable = false;
	public boolean symbolLengthIsCallable = false;
	
	@Override
	public void printCharArray(char[] text) {
		this.printCharArrayIsCallable = true;
		this.printCharArrayArray = text;

	}

	@Override
	public char[] shiftRight(char[] bits) {
		this.shiftRightIsCallable = true;
		return bits;
	}

	@Override
	public char[] shiftLeft(char[] bits) {
		this.shiftLeftIsCallable = true;
		return bits;
	}

	@Override
	public HashMap<Character, String> encryptionCodeMap() {
		this.encryptionCodeMapIsCallable = true;
		return new HashMap<Character, String>(); 
	}

	@Override
	public HashMap<String, Character> decryptionCodeMap() {
		this.decryptionCodeMapIsCallable = true;
		return new HashMap<String, Character>();
	}

	@Override
	public int symbolLength() {
		this.symbolLengthIsCallable = true;
		return 5;
	}

}
