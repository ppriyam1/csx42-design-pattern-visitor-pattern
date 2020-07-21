package arrayvisitors.driver;

import java.io.IOException;
import java.nio.file.InvalidPathException;

import arrayvisitors.adt.MyArray;
import arrayvisitors.adt.MyArrayI;
import arrayvisitors.adt.MyArrayList;
import arrayvisitors.adt.MyArrayListI;
import arrayvisitors.exception.ResultException;
import arrayvisitors.util.FileDisplayInterface;
import arrayvisitors.util.FileProcessor;
import arrayvisitors.util.MyLogger;
import arrayvisitors.util.Results;
import arrayvisitors.visitors.CommonIntsVisitor;
import arrayvisitors.visitors.MissingIntsVisitor;
//import arrayvisitors.util.Results;
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

		// sList<Integer> list = new ArrayList<>();

		MyArrayI myArray1 = new MyArray();
		MyArrayI myArray2 = new MyArray();

		final String INPUT_FILE_PATH1 = "./" + args[0];
		final String INPUT_FILE_PATH2 = "./" + args[1];

		MyArrayListI myArrayList = new MyArrayList();

		Results results = new Results();

		try {

			VisitorI populateVisitor1 = new PopulateMyArrayVisitor(new FileProcessor(INPUT_FILE_PATH1));
			myArray1.accept(populateVisitor1);

			// System.out.println("inputFile1 = " + myArray1.toString());

			VisitorI populateVisitor2 = new PopulateMyArrayVisitor(new FileProcessor(INPUT_FILE_PATH2));
			myArray2.accept(populateVisitor2);

			// System.out.println("inputFile2 = " + myArray2.toString());

		} catch (InvalidPathException | SecurityException | IOException e) {
			e.printStackTrace();
		}

		myArrayList.add(myArray1);
		myArrayList.add(myArray2);

		VisitorI commonIntsVisitor = new CommonIntsVisitor(results);
		myArrayList.accept(commonIntsVisitor);

		VisitorI missingIntsVisitor = new MissingIntsVisitor(results);

		myArray1.accept(missingIntsVisitor);
		myArray2.accept(missingIntsVisitor);

		FileDisplayInterface fileout = results;
		((Results) fileout).printToCommonIntFile(args[2]);
		try {
			((Results) fileout).printToMissingIntFile(args[3]);
		} catch (ResultException e) {
			e.printStackTrace();
		}

		results.printToStdout();

	}
}
