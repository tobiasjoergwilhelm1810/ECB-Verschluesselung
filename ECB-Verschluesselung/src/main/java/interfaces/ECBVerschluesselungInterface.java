package interfaces;

import exception.ProgrammInterruptException;

public interface ECBVerschluesselungInterface {

	public char[] symbolToBits(char symbol);
	public char[] textToBits(String text);
	public char[] firstN(char[] bits, int n);
	public char[] restN(char[] bits, int n);
	public char[][] bitsToBlocks(char[] bits, int size) throws ProgrammInterruptException;
	public char[][] encryptBlocks(char[][] blocks);
	public char[] blocksToBits(char[][] blocks);
	public char bitsToSymbol(char[] bits);
	public char[] bitsToText(char[] bits, int size);
	public String encryption(String text, int blockSize);
	public char[][] decryptBlocks(char[][] blocks);
	public String decryption(String text, int blockSize);
	public String charToString(char[] bits);
	
}
