package arrayvisitors.driver;

import java.io.IOException;
import java.nio.file.InvalidPathException;

import arrayvisitors.adt.MyArray;
import arrayvisitors.adt.MyArrayI;
import arrayvisitors.util.FileProcessor;
import arrayvisitors.util.Results;
import arrayvisitors.visitors.PopulateMyArrayVisitor;
import arrayvisitors.visitors.Visitor;

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
		if ((args.length != 2) || (args[0].equals("${input1}")) || (args[1].equals("${input2}"))) {
			System.err.println("Error: Incorrect number of arguments. Program accepts 2 arguments.");
			System.exit(0);
		}
		System.out.println("Hello World! Lets get started with the assignment");
		String inputFileName1 = null;
		String inputFileName2 = null;
		FileProcessor fileProcessor = null;
		
		MyArrayI myArrayI1 = new MyArray();
		MyArrayI myArrayI2 = new MyArray();
		
		try {
			inputFileName1 = args[0];
			inputFileName2 = args[1];
		} catch (Exception e) {
			// TODO
		}
		
		final String PATH1 = "./" + inputFileName1;
		final String PATH2 = "./" + inputFileName2;

		try {
			 fileProcessor = new FileProcessor(PATH1);
		} catch (InvalidPathException | SecurityException | IOException e) {
			e.printStackTrace();
		}

		// Results results = new Results();
		Visitor populateVisitor = new PopulateMyArrayVisitor();
		((PopulateMyArrayVisitor) populateVisitor).setFileProcessor(fileProcessor);
		myArrayI1.accept(populateVisitor);
		System.out.println("inputFile1 = " + myArrayI1.toString());
		
		try {
			fileProcessor= new FileProcessor(PATH2);
		} catch (InvalidPathException | SecurityException | IOException e) {
			e.printStackTrace();
		}
		
		((PopulateMyArrayVisitor) populateVisitor).setFileProcessor(fileProcessor);
		myArrayI2.accept(populateVisitor);
		System.out.println("inputFile2 = " + myArrayI2.toString());

	}
}
