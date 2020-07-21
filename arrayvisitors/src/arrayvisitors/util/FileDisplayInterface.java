package arrayvisitors.util;

import arrayvisitors.exception.ResultException;

public interface FileDisplayInterface{
	/**
	 * Method to print output to a file.
	 * @throws ResultException 
	 */
	public void printToMissingIntFile(String fileName) throws ResultException;
	
	public void printToCommonIntFile(String fileName);

}
