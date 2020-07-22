package arrayvisitors.visitors;

import java.io.IOException;

import arrayvisitors.adt.MyArrayI;
import arrayvisitors.adt.MyArrayListI;
import arrayvisitors.exception.ErrorCode;
import arrayvisitors.exception.VisitorException;
import arrayvisitors.util.FileProcessor;
import arrayvisitors.util.MyLogger;
import arrayvisitors.util.MyLogger.DebugLevel;

/**
 * @author preetipriyam
 *
 */
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
	public void visit(MyArrayI myArrayVisit) throws VisitorException {
		try {
			String instruction = fileProcessor.poll();

			if (instruction == null || instruction.isEmpty()) {
				String message = ErrorCode.INVALID_INPUT_EMPTY + ": " + "Input file is empty";
				LOGGER.writeMessage(message, DebugLevel.EXCEPTION);
				System.exit(0);
			}

			while (instruction != null) {
				try {
					if (Integer.parseInt(instruction) < 0 || Integer.parseInt(instruction) > 99) {
						String message = ErrorCode.INVALID_INPUT_FORMAT + ": " + "Input value " + instruction
								+ " is invalid";
						LOGGER.writeMessage(message, DebugLevel.EXCEPTION);
						instruction = fileProcessor.poll();
						continue;
					}
					myArrayVisit.add(instruction);
				} catch (NumberFormatException e) {
					String message = ErrorCode.INVALID_INPUT + ": " + "Input value " + instruction + " is invalid";
					LOGGER.writeMessage(message, DebugLevel.EXCEPTION);
					System.exit(0);
				}
				instruction = fileProcessor.poll();
			}
		} catch (IOException e) {
			throw new VisitorException(e.getMessage());
		}

	}

	@Override
	public void visit(MyArrayListI myArrayVisit) throws VisitorException {
		String message = ErrorCode.EMPTY_METHOD + ": " + "Behaviour is undefined";
		LOGGER.writeMessage(message, DebugLevel.EXCEPTION);
		throw new VisitorException(message);
	}

	@Override
	public String toString() {
		return "PopulateMyArrayVisitor [fileProcessor=" + fileProcessor + "]";
	}

}
