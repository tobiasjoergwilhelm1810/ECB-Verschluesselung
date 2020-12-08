package interfaces;

public interface ECBVerschlüsselungInterface {

	public char[] symbolToString(char symbol);
	public char[] textToBits(String text);
	public char[] firstN(char[] bits, int zahl);
	public char[] restN(char[] bits, int zahl);
	public char[][] bitsToBlocks(char[] bits, int r);
	public char[][] encryptBlocks(char[][] blocks);
	public char[] blocksToBits(char[][] blocks);
	public char bitsToSymbol(char[] bits);
	public char[] bitsToText(char[] bits, int zahl);
	public String encryption(String text, int zahl);
	public char[][] decryptionBlocks(char[][] blocks);
	public String decryption(String text, int zahl);
	public String charToString(char[] bits);
	
}
