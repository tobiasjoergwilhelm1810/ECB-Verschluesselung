package mocktest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import exception.ProgrammInterruptException;
import mock.ECBVerschluesselungMock;

class ECBVerschluesselungMockTest {

	private ECBVerschluesselungMock ecb = new ECBVerschluesselungMock();
	
	@Test
	@DisplayName("SymbolToBits")
	void testSymbolToBits() {

		char [] test = new char[2];
		test[0]=1;
		test[1]=2;
		
		char symbol = 1;
		
		char [] content = this.ecb.symbolToBits(symbol);
		
		assertEquals(test[0], content[0]);
		assertEquals(test[1], content[1]);
		assertEquals(symbol, this.ecb.contentSymbolToBits);
		assertTrue(this.ecb.symbolToBitsIsCallable);
		
	}
	
	@Test
	@DisplayName("TextToBits")
	void testTextToBits() {
		
		char [] test = new char[2];
		test[0]=1;
		test[1]=2;
		
		String symbol = "TEST";
		
		char [] content = this.ecb.textToBits(symbol);
		
		assertEquals(test[0], content[0]);
		assertEquals(test[1], content[1]);
		assertEquals(symbol, this.ecb.contentTextToBits);
		assertTrue(this.ecb.textToBitsIsCallable);
		
	}
	
	@Test
	@DisplayName("FirstN")
	void testFirstN() {
		
		char [] test = new char[2];
		test[0]=1;
		test[1]=2;
		
		int n = 10;
		
		char [] content = this.ecb.firstN(test, n);
		
		assertEquals(test[0], content[0]);
		assertEquals(test[1], content[1]);
		assertEquals(n, this.ecb.contentFirstN);
		assertTrue(this.ecb.firstNIsCallable);
		
	}
	
	@Test
	@DisplayName("RestN")
	void testRestN() {
		
		char [] test = new char[2];
		test[0]=1;
		test[1]=2;
		
		int n = 10;
		
		char [] content = this.ecb.restN(test, n);
		
		assertEquals(test[0], content[0]);
		assertEquals(test[1], content[1]);
		assertEquals(n, this.ecb.contentRestN);
		assertTrue(this.ecb.restNIsCallable);
		
	}

	@Test
	@DisplayName("BitsToBlocks")
	void testBitsToBlocks() {
		
		char[][] test3dim = new char [2][2];
		
		test3dim[0][0] = 1;
		test3dim[0][1] = 2;
		test3dim[1][0] = 3;
		test3dim[1][1] = 4;
		
		char [] test2dim = new char[2];
		test2dim[0]=1;
		test2dim[1]=2;
		
		int size = 55230498;
		
		char[][] content;
		try {
			content = this.ecb.bitsToBlocks(test2dim, size);
			assertEquals(test3dim[0][0], content[0][0]);
			assertEquals(test3dim[0][1], content[0][1]);
			assertEquals(test3dim[1][0], content[1][0]);
			assertEquals(test3dim[1][1], content[1][1]);
		} catch (ProgrammInterruptException e1) {
			fail("Hier sollte keine Exception kommen");
		}
		
		
		assertEquals(test2dim[0], this.ecb.contentBitsToBlocksChar[0]);
		assertEquals(test2dim[1], this.ecb.contentBitsToBlocksChar[1]);
		assertEquals(size, this.ecb.contentBitsToBlocksInt);
		assertTrue(this.ecb.bitsToBlocksIsCallable);
		
		try {
			
			this.ecb.bitsToBlocks(test2dim, 0);
			
		} catch (ProgrammInterruptException e) {
			
			assertEquals("Leider gab es einen Fehler im Programm welches das Programm zum Beenden gezwungen hat.", e.getErrorMessage());
			
		}
		
	}
	
	@Test
	@DisplayName("EncryptBlocks")
	void testEncryptBlocks() {
		
		char[][] test3dim = new char [2][2];
		
		test3dim[0][0] = 1;
		test3dim[0][1] = 2;
		test3dim[1][0] = 3;
		test3dim[1][1] = 4;
		
		char [][] content = this.ecb.encryptBlocks(test3dim);
		
		assertEquals(test3dim[0][0], content[0][0]);
		assertEquals(test3dim[0][1], content[0][1]);
		assertEquals(test3dim[1][0], content[1][0]);
		assertEquals(test3dim[1][1], content[1][1]);
		assertTrue(this.ecb.encryptBlocksIsCallable);
		
	}
	
	@Test
	@DisplayName("BlocksToBits")
	void testBlcoksToBits() {
		
		char[][] test3dim = new char [2][2];
		
		test3dim[0][0] = 1;
		test3dim[0][1] = 2;
		test3dim[1][0] = 3;
		test3dim[1][1] = 4;
		
		char [] test2dim = new char[2];
		test2dim[0]=1;
		test2dim[1]=2;
		
		char [] content = this.ecb.blocksToBits(test3dim);
		
		assertEquals(test2dim[0], content[0]);
		assertEquals(test2dim[1], content[1]);
		assertEquals(test3dim[0][0], this.ecb.contentBlocksToBits[0][0]);
		assertEquals(test3dim[0][1], this.ecb.contentBlocksToBits[0][1]);
		assertEquals(test3dim[1][0], this.ecb.contentBlocksToBits[1][0]);
		assertEquals(test3dim[1][1], this.ecb.contentBlocksToBits[1][1]);
		assertTrue(this.ecb.blocksToBitsIsCallable);
		
	}
	
	@Test
	@DisplayName("BitsToSymbol")
	void testBitsToSymbol() {
		
		char [] test2dim = new char[2];
		test2dim[0]=1;
		test2dim[1]=2;
		
		char test = 9;
		
		char content = this.ecb.bitsToSymbol(test2dim);
		
		assertEquals(test, content);
		assertEquals(test2dim[0], this.ecb.contentBitsToSymbol[0]);
		assertEquals(test2dim[1], this.ecb.contentBitsToSymbol[1]);
		assertTrue(this.ecb.bitsToSymbolIsCallable);
		
	}
	
	@Test
	@DisplayName("BitsToText")
	void testBitsToText() {
		
		char [] test2dim = new char[2];
		test2dim[0]=1;
		test2dim[1]=2;
		
		int size = 12653;
		
		char [] content = this.ecb.bitsToText(test2dim, size);
		
		assertEquals(test2dim[0], content[0]);
		assertEquals(test2dim[1], content[1]);
		assertEquals(size, this.ecb.contentBitsToText);
		assertTrue(this.ecb.bitsToTextIsCallable);
		
	}
	
	@Test
	@DisplayName("Encryption")
	void testEncryption() {
		
		String test = "LOL";
		
		int blockSize = 152353;
		
		String content = this.ecb.encryption(test, blockSize);
		
		assertEquals(content, test);
		assertEquals(blockSize, this.ecb.contentEncryption);
		assertTrue(this.ecb.encryptionIsCallable);
		
	}
	
	@Test
	@DisplayName("DecryptBlocks")
	void testDecryptBlocks() {
		
		char[][] test3dim = new char [2][2];
		
		test3dim[0][0] = 1;
		test3dim[0][1] = 2;
		test3dim[1][0] = 3;
		test3dim[1][1] = 4;
		
		char [][] content = this.ecb.decryptBlocks(test3dim);
		
		assertEquals(test3dim[0][0], content[0][0]);
		assertEquals(test3dim[0][1], content[0][1]);
		assertEquals(test3dim[1][0], content[1][0]);
		assertEquals(test3dim[1][1], content[1][1]);
		assertTrue(this.ecb.decryptBlocksIsCallable);
		
	}
	
	@Test
	@DisplayName("Decryption")
	void testDecryption() {
		
		String test = "LOL";
		
		int blockSize = 152353;
		
		String content = this.ecb.decryption(test, blockSize);
		
		assertEquals(content, test);
		assertEquals(blockSize, this.ecb.contentDecryption);
		assertTrue(this.ecb.decryptionIsCallable);
		
	}
	
	@Test
	@DisplayName("CharToString")
	void testCharToString() {
		
		String test = "LOL";
		
		char [] test2dim = new char[2];
		test2dim[0]=1;
		test2dim[1]=2;
		
		String content = this.ecb.charToString(test2dim);
		
		assertEquals(content, test);
		assertEquals(test2dim[0], this.ecb.contentCharToString[0]);
		assertEquals(test2dim[1], this.ecb.contentCharToString[1]);
		assertTrue(this.ecb.charToStringIsCallable);
		
	}
	
}
