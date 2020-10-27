package exception;

public class WrongInputException extends Throwable {

	private int sizeBits = 0;
	private int sizeBlocks = 0;
	
	public WrongInputException(int sizeBits, int sizeBlocks) {
		
		this.sizeBits = sizeBits;
		this.sizeBlocks = sizeBlocks;
				
		
	}
	
	public String getErrorMessage() {
		
		return "Leider ist ein Fehler bei der Verarbeitung passiert. => " + this.sizeBits + "/" + this.sizeBlocks + "=" + (this.sizeBits/this.sizeBlocks) + " => Es darf lediglich nur eine Ganze Zahl raus kommen." ;
		
	}
	
}
