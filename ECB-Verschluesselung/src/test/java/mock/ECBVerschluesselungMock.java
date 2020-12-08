package mock;

import exception.ProgrammInterruptException;
import interfaces.ECBVerschluesselungInterface;

public class ECBVerschluesselungMock implements ECBVerschluesselungInterface {

	public char contentSymbolToBits;
	public String contentTextToBits;
	public int contentFirstN;
	public int contentRestN;
	public char [] contentBitsToBlocksChar;
	public int contentBitsToBlocksInt;
	public char[][] contentBlocksToBits;
	public char[] contentBitsToSymbol;
	public int contentBitsToText;
	public int contentEncryption;
	public int contentDecryption;
	public char[] contentCharToString;
	
	
	public boolean symbolToBitsIsCallable = false;
	public boolean textToBitsIsCallable = false;
	public boolean firstNIsCallable = false;
	public boolean restNIsCallable = false;
	public boolean bitsToBlocksIsCallable = false;
	public boolean encryptBlocksIsCallable = false;
	public boolean blocksToBitsIsCallable = false;
	public boolean bitsToSymbolIsCallable = false;
	public boolean bitsToTextIsCallable = false;
	public boolean encryptionIsCallable = false;
	public boolean decryptBlocksIsCallable = false;
	public boolean decryptionIsCallable = false;
	public boolean charToStringIsCallable = false;
	
	@Override
	public char[] symbolToBits(char symbol) {
		
		char [] test = new char[2];
		test[0]=1;
		test[1]=2;
		
		this.contentSymbolToBits = symbol;
		this.symbolToBitsIsCallable = true;
		
		return test;
	}

	@Override
	public char[] textToBits(String text) {
		
		char [] test = new char[2];
		test[0]=1;
		test[1]=2;
		
		this.contentTextToBits = text;
		this.textToBitsIsCallable = true;
		
		return test;
	}

	@Override
	public char[] firstN(char[] bits, int n) {
		
		this.contentFirstN = n;
		this.firstNIsCallable = true;
		
		return bits;
	}

	@Override
	public char[] restN(char[] bits, int n) {
		
		this.contentRestN = n;
		this.restNIsCallable = true;
		
		return bits;
	}

	@Override
	public char[][] bitsToBlocks(char[] bits, int size) throws ProgrammInterruptException {

		if (size == 0) {
			
			throw new ProgrammInterruptException();
			
		}
		
		char[][] test = new char [2][2];
		
		test[0][0] = 1;
		test[0][1] = 2;
		test[1][0] = 3;
		test[1][1] = 4;
		
		this.bitsToBlocksIsCallable = true;
		this.contentBitsToBlocksChar = bits;
		this.contentBitsToBlocksInt = size;
		
		return test;
		
	}

	@Override
	public char[][] encryptBlocks(char[][] blocks) {
		
		this.encryptBlocksIsCallable = true;
		
		return blocks;
	}

	@Override
	public char[] blocksToBits(char[][] blocks) {

		this.blocksToBitsIsCallable = true;
		this.contentBlocksToBits = blocks;
		
		char [] test2dim = new char[2];
		test2dim[0]=1;
		test2dim[1]=2;
		
		return test2dim;
	}

	@Override
	public char bitsToSymbol(char[] bits) {
		
		char test = 9;
		
		this.contentBitsToSymbol = bits;
		this.bitsToSymbolIsCallable = true;
		
		return test;
	}

	@Override
	public char[] bitsToText(char[] bits, int size) {

		this.bitsToTextIsCallable = true;
		this.contentBitsToText = size;
		
		return bits;
	}

	@Override
	public String encryption(String text, int blockSize) {

		this.contentEncryption = blockSize;
		this.encryptionIsCallable = true;
		
		return text;
	}

	@Override
	public char[][] decryptBlocks(char[][] blocks) {
		this.decryptBlocksIsCallable = true;
		return blocks;
	}

	@Override
	public String decryption(String text, int blockSize) {

		this.contentDecryption = blockSize;
		this.decryptionIsCallable = true;
		
		return text;
	}

	@Override
	public String charToString(char[] bits) {
		
		this.charToStringIsCallable = true;
		this.contentCharToString = bits;
		
		return "LOL";
	}

}
