package arrayvisitors.driver;

import java.io.IOException;
import java.nio.file.InvalidPathException;

import arrayvisitors.adt.MyArray;
import arrayvisitors.adt.MyArrayI;
import arrayvisitors.adt.MyArrayList;
import arrayvisitors.adt.MyArrayListI;

import arrayvisitors.util.FileProcessor;
import arrayvisitors.util.Results;
import arrayvisitors.visitors.CommonIntsVisitor;
import arrayvisitors.visitors.MissingIntsVisitor;
//import arrayvisitors.util.Results;
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

		MyArrayI<Integer> myArrayI1 = new MyArray<Integer>();
		MyArrayI<Integer> myArrayI2 = new MyArray<Integer>();

		final String INPUT_FILE_PATH1 = "./" + args[0];
		final String INPUT_FILE_PATH2 = "./" + args[1];

		MyArrayListI<Object> myArrayListI = new MyArrayList<Object>();

		Results results = new Results();
		try {

			Visitor populateVisitor = new PopulateMyArrayVisitor();
			((PopulateMyArrayVisitor) populateVisitor).setFilePath(new FileProcessor(INPUT_FILE_PATH1));

			myArrayI1.accept(populateVisitor);
			System.out.println("inputFile1 = " + myArrayI1.toString());

			((PopulateMyArrayVisitor) populateVisitor).setFilePath(new FileProcessor(INPUT_FILE_PATH2));
			myArrayI2.accept(populateVisitor);

			System.out.println("inputFile2 = " + myArrayI2.toString());
		} catch (InvalidPathException | SecurityException | IOException e) {
			e.printStackTrace();
		}
		myArrayListI.add(myArrayI1);
		myArrayListI.add(myArrayI2);

		Visitor commonIntsVisitor = new CommonIntsVisitor(results);
		myArrayListI.accept(commonIntsVisitor);
		
		Visitor missingIntsVisitor = new MissingIntsVisitor(results);
		
		//missingIntsVisitor.visit(myArrayI1);
		//missingIntsVisitor.visit(myArrayI2);
		
		myArrayI1.accept(missingIntsVisitor);
		myArrayI2.accept(missingIntsVisitor);
		
		System.out.println(results.getMissingIntegers());
		
	}
}
