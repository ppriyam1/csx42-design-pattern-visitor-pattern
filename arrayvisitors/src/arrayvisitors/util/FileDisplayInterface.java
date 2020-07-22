package arrayvisitors.util;

import arrayvisitors.exception.ResultException;
import arrayvisitors.exception.VisitorException;

public interface FileDisplayInterface {
	/**
	 * Method to print output to a file.
	 * 
	 * @throws ResultException
	 */
	public void printToMissingIntFile(String fileName) throws ResultException;

	/**
	 * Method to print output to a file.
	 * 
	 * @param fileName
	 * @throws VisitorException
	 * @throws ResultException
	 */
	public void printToCommonIntFile(String fileName) throws ResultException;

}
