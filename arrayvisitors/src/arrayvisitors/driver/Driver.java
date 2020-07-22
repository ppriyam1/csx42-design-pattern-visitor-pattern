package arrayvisitors.driver;

import java.io.IOException;
import java.nio.file.InvalidPathException;

import arrayvisitors.adt.MyArray;
import arrayvisitors.adt.MyArrayI;
import arrayvisitors.adt.MyArrayList;
import arrayvisitors.adt.MyArrayListI;
import arrayvisitors.exception.ResultException;
import arrayvisitors.exception.VisitorException;
import arrayvisitors.util.FileDisplayInterface;
import arrayvisitors.util.FileProcessor;
import arrayvisitors.util.MyLogger;
import arrayvisitors.util.MyLogger.DebugLevel;
import arrayvisitors.util.Results;
import arrayvisitors.visitors.CommonIntsVisitor;
import arrayvisitors.visitors.MissingIntsVisitor;
import arrayvisitors.visitors.PopulateMyArrayVisitor;
import arrayvisitors.visitors.VisitorI;

/**
 * @author preeti priyam
 *
 */
public class Driver {
	public static void main(String[] args) {

		/*
		 * As the build.xml specifies the arguments as input,output or metrics, in case
		 * the argument value is not given java takes the default value specified in
		 * build.xml. To avoid that, below condition is used
		 */
		if ((args.length != 5) || (args[0].equals("${input1}")) || (args[1].equals("${input2}"))
				|| (args[2].equals("${commonintsout}")) || (args[3].equals("${missingintsout}"))
				|| (args[4].contains("${debug}"))) {
			System.err.println("Error: Incorrect number of arguments. Program accepts 5 arguments.");
			System.exit(0);
		}

		String debugLevel = args[4];
		MyLogger.setDebugValue(Integer.parseInt(debugLevel));

		MyLogger LOGGER = MyLogger.getMyLoggerInstance();

		if (args[0].equals(args[1])) {
			LOGGER.writeMessage("Input files cannot be of same name", DebugLevel.EXCEPTION);
		}

		if (args[2].equals(args[3])) {
			LOGGER.writeMessage("Output files cannot be of same name", DebugLevel.EXCEPTION);
		}

		MyArrayI myArray1 = new MyArray();
		MyArrayI myArray2 = new MyArray();

		final String INPUT_FILE_PATH1 = "./" + args[0];
		final String INPUT_FILE_PATH2 = "./" + args[1];

		MyArrayListI myArrayList = new MyArrayList();

		try {

			VisitorI populateVisitor1 = new PopulateMyArrayVisitor(new FileProcessor(INPUT_FILE_PATH1));
			try {
				myArray1.accept(populateVisitor1);
			} catch (VisitorException e) {
				e.printStackTrace();
				LOGGER.writeMessage(e.getMessage(), DebugLevel.EXCEPTION);
			}

			VisitorI populateVisitor2 = new PopulateMyArrayVisitor(new FileProcessor(INPUT_FILE_PATH2));
			try {
				myArray2.accept(populateVisitor2);
			} catch (VisitorException e) {
				e.printStackTrace();
				LOGGER.writeMessage(e.getMessage(), DebugLevel.EXCEPTION);
			}

		} catch (InvalidPathException | SecurityException | IOException e) {
			e.printStackTrace();
		}

		myArrayList.add(myArray1);
		myArrayList.add(myArray2);

		Results results = new Results();

		try {

			VisitorI commonIntsVisitor = new CommonIntsVisitor(results);
			myArrayList.accept(commonIntsVisitor);

			VisitorI missingIntsVisitor = new MissingIntsVisitor(results);
			myArray1.accept(missingIntsVisitor);
			myArray2.accept(missingIntsVisitor);

		} catch (VisitorException e) {
			e.printStackTrace();
			LOGGER.writeMessage(e.getMessage(), DebugLevel.EXCEPTION);
		}

		FileDisplayInterface fileout = results;
		try {
			((Results) fileout).printToCommonIntFile(args[2]);
			((Results) fileout).printToMissingIntFile(args[3]);
		} catch (ResultException e) {
			e.printStackTrace();
		}

		results.printToStdout();

	}
}
