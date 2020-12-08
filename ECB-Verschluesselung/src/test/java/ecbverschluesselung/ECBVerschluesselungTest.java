package ecbverschluesselung;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import exception.ProgrammInterruptException;

class ECBVerschluesselungTest {

	private ECBVerschluesselung ecb = new ECBVerschluesselung();
	
	@Test
	@DisplayName("SymbolToBits")
	void testSymbolToBits() {
		char[] a1 = this.ecb.symbolToBits('A');
        char[] e1 = {'0','0','0','0','0'};
        assertEquals(true, Arrays.equals(e1, a1), "Eingabe -> A Erwartete Ausgabe -> " + new String(e1) + " Erhaltene Ausgabe -> " +  new String(a1));
        
        char[] a2 = this.ecb.symbolToBits('H');
        char[] e2 = {'1','1','0','0','0'};        
        assertEquals(true, Arrays.equals(e2, a2),"Eingabe -> H Erwartete Ausgabe -> " + new String(e2) + " Erhaltene Ausgabe -> " + new String(a2));

        char[] a3 = this.ecb.symbolToBits('S');
        char[] e3 = {'0','1','0','0','1'};
        assertEquals(true, Arrays.equals(e3, a3),"Eingabe -> S Erwartete Ausgabe -> " + new String(e3) + " Erhaltene Ausgabe -> " + new String(a3));
	}
	
	@Test
    @DisplayName("TextToBits")
    void testTextToBits() {
        char[] a1 = this.ecb.textToBits("ABC");
        char[] e1 = {'0','0','0','0','0','1','1','0','1','1','0','0','0','0','1'};
        assertEquals(true, Arrays.equals(e1, a1), "Eingabe -> ABC Erwartete Ausgabe -> " + new String(e1) + " Erhaltene Ausgabe -> " + new String(a1));

        char[] a2 = this.ecb.textToBits("HJKLO");
        char[] e2 = {'1','1','0','0','0','1','0','1','1','1','0','0','1','0','1','1','0','1','1','0','0','0','1','1','1'};
        assertEquals(true, Arrays.equals(e2, a2), "Eingabe -> HJKLO Erwartete Ausgabe -> " + new String(e2) + " Erhaltene Ausgabe -> " + new String(a2));

        char[] a3 = this.ecb.textToBits("");
        char[] e3 = {};
        assertEquals(true, Arrays.equals(e3, a3), "Eingabe -> '' Erwartete Ausgabe -> '' Erhaltene Ausgabe -> " + new String(a3));        
    }
	
	@Test
    @DisplayName("FirstN")
    void testFirstN() {
        char[] a1 = this.ecb.firstN(new char[]{'A','B','C','D'}, 1);
        char[] e1 = {'A'};
        assertEquals(true, Arrays.equals(e1, a1), "Eingabe -> A,B,C,D | n=1 Erwartete Ausgabe -> " + new String(e1) +" Erhaltene Ausgabe -> " + new String(a1));

        char[] a2 = this.ecb.firstN(new char[]{'A','B','C','D'}, 3);
        char[] e2 = {'A','B','C'};
        assertEquals(true, Arrays.equals(e2, a2), "Eingabe -> A,B,C,D | n=3 Erwartete Ausgabe -> " + new String(e2) + " Erhaltene Ausgabe -> " + new String(a2));

        char[] a3 = this.ecb.firstN(new char[]{'A','B','C','D'}, 0);
        char[] e3 = {};
        assertEquals(true, Arrays.equals(e3, a3), "Eingabe -> A,B,C,D | n=0 Erwartete Ausgabe -> '' Erhaltene Ausgabe -> " + new String(a3));
    }

    @Test
    @DisplayName("RestN")
    void testRestN() {
        char[] a1 = this.ecb.restN(new char[]{'A','B','C','D'}, 1);
        char[] e1 = {'B','C','D'};
        assertEquals(true, Arrays.equals(e1, a1), "Eingabe -> A,B,C,D | n=1 Erwartete Ausgabe -> " + new String(e1) + " Erhaltene Ausgabe -> " + new String(a1));

        char[] a2 = this.ecb.restN(new char[]{'A','B','C','D'}, 3);
        char[] e2 = {'D'};
        assertEquals(true, Arrays.equals(e2, a2), "Eingabe -> A,B,C,D | n=3 Erwartete Ausgabe -> " + new String(e2) + " Erhaltene Ausgabe -> " + new String(a2));

        char[] a3 = this.ecb.restN(new char[]{'A','B','C','D'}, 0);
        char[] e3 = {'A','B','C','D'};
        assertEquals(true, Arrays.equals(e3, a3), "Eingabe -> A,B,C,D | n=0 Erwartete Ausgabe -> "+ new String(e3) + " Erhaltene Ausgabe -> " + new String(a3));
    }

    @Test
    @DisplayName("BitsToBlocks")
    void BitsToBlocks() throws ProgrammInterruptException {
        
        char[][] a1 = this.ecb.bitsToBlocks(new char[] { '1', '1', '0', '1', '1', '0', '0', '1', '0' }, 3);
        char[][] e1 = { { '1', '1', '0' }, { '1', '1', '0' }, { '0', '1', '0' } };
        assertEquals(true, equal(a1, e1), "Eingabe -> 110110010 | size=3 Erwartete Ausgabe -> " + twoDimCharArrayToString(e1) + " Erhaltene Ausgabe -> " + twoDimCharArrayToString(a1));

        char[][] a2 = this.ecb.bitsToBlocks(new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H' }, 2);
        char[][] e2 = { { 'A', 'B' }, { 'C', 'D' }, { 'E', 'F', }, { 'G', 'H' } };
        assertEquals(true, equal(a2, e2), "Eingabe -> ABCDEFGH | size=2 Erwartete Ausgabe -> " + twoDimCharArrayToString(e2) + " Erhaltene Ausgabe -> " + twoDimCharArrayToString(a2));

        char[][] a3 = this.ecb.bitsToBlocks(new char[] { '0', '1', '2' }, 1);
        char[][] e3 = { { '0' }, { '1' }, { '2' } };
        assertEquals(true, equal(a3, e3), "Eingabe -> 012 | size=1 Erwartete Ausgabe -> " + twoDimCharArrayToString(e3) + " Erhaltene Ausgabe -> " + twoDimCharArrayToString(e3));
    }

    @Test
    @DisplayName("EncryptBlocks")
    void testEncryptBlocks() {
        char[][] a1 = this.ecb.encryptBlocks(new char[][] {{'1','1','0'},{'1','1','0'},{'0','1','0'}});
        char[][] e1 = {{'0','1','1'},{'0','1','1'},{'0','0','1'}};
        assertEquals(true, equal(a1, e1),"Eingabe -> {110}{110}{010} Erwartete Ausgabe -> " + twoDimCharArrayToString(e1) + " Erhaltene Ausgabe -> " + twoDimCharArrayToString(a1));
        
        char[][] a2 = this.ecb.encryptBlocks(new char[][] {{'A','B'},{'C','D'},{'E','F'},{'G','H'}});
        char[][] e2 = {{'B','A'},{'D','C'},{'F','E'},{'H','G'}};
        assertEquals(true, equal(a2, e2),"Eingabe -> {A,B}{C,D}{E,F}{G,H} Erwartete Ausgabe -> " + twoDimCharArrayToString(e2) + " Erhaltene Ausgabe -> " + twoDimCharArrayToString(a2));
        
        char[][] a3 = this.ecb.encryptBlocks(new char[][] {{'0'},{'1'},{'2'}});
        char[][] e3 = {{'0'},{'1'},{'2'}};
        assertEquals(true, equal(a3, e3),"Eingabe -> {0}{1}{2} Erwartete Ausgabe -> " + twoDimCharArrayToString(e3) + " Erhaltene Ausgabe -> " + twoDimCharArrayToString(a3));
    }

    @Test
    @DisplayName("BlocksToBits")
    void testBlocksToBits() {
        char[] a1 = this.ecb.blocksToBits(new char[][]{{'1','1','0'},{'1','1','0'},{'0','1','0'}});
        char[] e1 = new char[]{'1','1','0','1','1','0','0','1','0'};
        assertEquals(true, Arrays.equals(a1, e1), "Eingabe -> {1,1,0}{1,1,0}{0,1,0} Erwartete Ausgabe -> " + new String(e1) + " Erhaltene Ausgabe -> " + new String(a1));

        char[] a2 = this.ecb.blocksToBits(new char[][]{{'A','B'},{'C','D'},{'E','F'},{'G','H'}});
        char[] e2 = new char[]{'A','B','C','D','E','F','G','H'};
        assertEquals(true, Arrays.equals(a2, e2), "Eingabe -> {A,B}{C,D}{E,F}{G,H} Erwartete Ausgabe -> " + new String(e2) + " Erhaltene Ausgabe -> " + new String(a2));

        char[] a3 = this.ecb.blocksToBits(new char[][]{{'0'},{'1'},{'2'}});
        char[] e3 = new char[]{'0','1','2'};
        assertEquals(true, Arrays.equals(a3, e3), "Eingabe -> {0}{1}{2} Erwartete Ausgabe -> " + new String(e3) + " Erhaltene Ausgabe -> " + new String(a3));
    }

    @Test
    @DisplayName("BitsToSymbol")
    void testBitsToSymbol() {
        char a1 = this.ecb.bitsToSymbol(new char[]{'0','0','0','0','1'});
        char e1 = 'C';
        assertEquals(e1, a1, "Eingabe -> {0,0,0,0,1} Erwartete Ausgabe -> " + e1 + " Erhaltene Ausgabe -> " + a1);

        char a2 = this.ecb.bitsToSymbol(new char[]{'1','0','0','0','0'});
        char e2 = 'X';
        assertEquals(e2, a2, "Eingabe -> {1,0,0,0,0} Erwartete Ausgabe -> " + e1 + " Erhaltene Ausgabe -> " + a2);

        char a3 = this.ecb.bitsToSymbol(new char[]{'0','1','1','1','0'});
        char e3 = '?';
        assertEquals(e3, a3, "Eingabe -> {0,1,1,1,0} Erwartete Ausgabe -> " + e1 + " Erhaltene Ausgabe -> " + a3);
    }

    @Test
    @DisplayName("BitsToText")
    void testBitsToText() {
        char[] a1 = this.ecb.bitsToText(new char[]{'0','0','0','0','0','1','1','0','1','1','0','0','0','0','1'},5);
        char[] e1 = {'A','B','C'};
        assertEquals(true, Arrays.equals(e1, a1), "Eingabe -> 000001101100001 Erwartete Ausgabe -> " + new String(e1) + " Erhaltene Ausgabe -> " + new String(a1));

        char[] a2 = this.ecb.bitsToText(new char[]{'1','1','0','0','0','1','0','1','1','1','0','0','1','0','1','1','0','1','1','0','0','0','1','1','1'},5);
        char[] e2 = {'H','J','K','L','O'};
        assertEquals(true, Arrays.equals(e2, a2), "Eingabe -> 1100010111001011011000111 Erwartete Ausgabe -> " + new String(e2) + " Erhaltene Ausgabe -> " + new String(a2));

        char[] a3 = this.ecb.bitsToText(new char[]{},5);
        char[] e3 = {};
        assertEquals(true, Arrays.equals(e3, a3), "Eingabe -> '' Erwartete Ausgabe -> '' Erhaltene Ausgabe -> " + new String(a3));    
    }

    @Test
    @DisplayName("Encryption")
    void testEncryption() {
        String a1 = this.ecb.encryption("HALLO", 5);
        String e1 = "YAWWR";
        assertEquals(e1, a1, "Eingabe -> HALLO | r=5 Erwartete Ausgabe -> " + e1 + " Erhaltene Ausgabe -> " + a1);

        String a2 = this.ecb.encryption("ICH_BIN_EIN_TEST", 4);
        String e2 = "EE_M=X?LVA?LHGIV";
        assertEquals(e2, a2, "Eingabe -> ICH_BIN_EIN_TEST | r=4 Erwartete Ausgabe -> " + e2 + " Erhaltene Ausgabe + " + a2);

        String a3 = this.ecb.encryption("TEST", 1);
        String e3 = "TEST";
        assertEquals(e3, a3, "Eingabe TEST | r=1 Erwartete Ausgabe -> " + e3 + " Erhaltene Ausgabe -> " + a3);
    }

    @Test
    @DisplayName("DecryptBlocks")
    void DecryptBlocks() {
        char[][] a1 = this.ecb.decryptBlocks(new char[][] {{'1','1','0'},{'1','1','0'},{'0','1','0'}});
        char[][] e1 = {{'1','0','1'},{'1','0','1'},{'1','0','0'}};
        assertEquals(true, equal(a1, e1),"Eingabe -> {110}{110}{010} Erwartete Ausgabe -> " + twoDimCharArrayToString(e1) + " Erhaltene Ausgabe -> " + twoDimCharArrayToString(a1));
        
        char[][] a2 = this.ecb.decryptBlocks(new char[][] {{'A','B'},{'C','D'},{'E','F'},{'G','H'}});
        char[][] e2 = {{'B','A'},{'D','C'},{'F','E'},{'H','G'}};
        assertEquals(true, equal(a2, e2),"Eingabe -> {A,B}{C,D}{E,F}{G,H} Erwartete Ausgabe -> " + twoDimCharArrayToString(e2) + " Erhaltene Ausgabe -> " + twoDimCharArrayToString(a2));
        
        char[][] a3 = this.ecb.decryptBlocks(new char[][] {{'0'},{'1'},{'2'}});
        char[][] e3 = {{'0'},{'1'},{'2'}};
        assertEquals(true, equal(a3, e3),"Eingabe -> {0}{1}{2} Erwartete Ausgabe -> " + twoDimCharArrayToString(e3) + " Erhaltene Ausgabe -> " + twoDimCharArrayToString(a3));
    }

    @Test
    @DisplayName("Decryption")
    void testDecryption() {
        String a1 = this.ecb.decryption("YAWWR", 5);
        String e1 = "HALLO";
        assertEquals(e1, a1, "Eingabe -> YAWWR | r=5 Erwartete Ausgabe -> " + e1 + " Erhaltene Ausgabe -> " + a1);

        String a2 = this.ecb.decryption("EE_M=X?LVA?LHGIV", 4);
        String e2 = "ICH_BIN_EIN_TEST";
        assertEquals(e2, a2, "Eingabe -> EE_M=X?LVA?LHGIV | r=4 Erwartete Ausgabe -> " + e2 + " Erhaltene Ausgabe + " + a2);

        String a3 = this.ecb.decryption("TEST", 1);
        String e3 = "TEST";
        assertEquals(e3, a3, "Eingabe TEST | r=1 Erwartete Ausgabe -> " + e3 + " Erhaltene Ausgabe -> " + a3);
    }

    public static String twoDimCharArrayToString(char[][] arr){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.length; i++){
            sb.append("{");
            for(int j = 0; j < arr[i].length; j++){
                sb.append(arr[i][j]);
            }
            sb.append("}");
        }
        return sb.toString();
    }

    public static boolean equal(final char[][] arr1, final char[][] arr2) {
        if (arr1 == null || arr2 == null) {
            return false;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (!Arrays.equals(arr1[i], arr2[i])) {
                return false;
            }
        }
        return true;
    }

}
