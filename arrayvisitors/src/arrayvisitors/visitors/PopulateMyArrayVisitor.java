package arrayvisitors.visitors;

import arrayvisitors.adt.MyArrayI;
import arrayvisitors.adt.MyArrayListI;
import arrayvisitors.exception.ErrorCode;
import arrayvisitors.exception.PopulateMyArrayVisitorException;
import arrayvisitors.util.FileProcessor;
import arrayvisitors.util.MyLogger;
import arrayvisitors.util.MyLogger.DebugLevel;

public class PopulateMyArrayVisitor implements VisitorI {

	private FileProcessor fileProcessor;

	MyLogger LOGGER = MyLogger.getMyLoggerInstance();

	public PopulateMyArrayVisitor() {
	}

	/**
	 * @param fileProcessor
	 */
	public PopulateMyArrayVisitor(FileProcessor fileProcessor) {
		this.fileProcessor = fileProcessor;
	}

	@Override
	public void visit(MyArrayI myArrayVisit) throws PopulateMyArrayVisitorException {
		try {
			String instruction = fileProcessor.poll();

			if (instruction == null || instruction.isEmpty()) {
				String message = ErrorCode.INVALID_INPUT_EMPTY + ": " + "Input file is empty";
				LOGGER.writeMessage(message, DebugLevel.EXCEPTION);
				throw new PopulateMyArrayVisitorException(message);
			}

			while (instruction != null) {
				try {
					myArrayVisit.add(Integer.parseInt(instruction));
				} catch (Exception e) {
					String message = ErrorCode.INVALID_INPUT + ": " + "Input value " + instruction + " is invalid";
					LOGGER.writeMessage(message, DebugLevel.EXCEPTION);
					System.exit(0);
				}
				instruction = fileProcessor.poll();
			}
		} catch (Exception e) {

		}

	}

	@Override
	public void visit(MyArrayListI myArrayVisit) {
		// TODO throw an exception indicating that the the behavior is undefined
	}
	
	@Override
	public String toString() {
		return "PopulateMyArrayVisitor [fileProcessor=" + fileProcessor + "]";
	}

}
