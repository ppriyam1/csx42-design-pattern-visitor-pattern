package arrayvisitors.util;

import java.util.List;
import java.util.Set;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeSet;

import arrayvisitors.exception.ResultException;
import arrayvisitors.util.MyLogger.DebugLevel;

import java.lang.Integer;

public class Results implements FileDisplayInterface, StdoutDisplayInterface {
	
	MyLogger LOGGER = MyLogger.getMyLoggerInstance();

	private Set<Integer> commonIntegers = new TreeSet<Integer>();
	private List<Set<Integer>> missingIntegers = new ArrayList<Set<Integer>>();
	
	private final StringBuilder builder = new StringBuilder();

	public Results() {
	}
	
	public void add(String message) {
		builder.append(message + " \n");
	}

	public Set<Integer> getCommonIntegers() {
		return commonIntegers;
	}

	public void setCommonIntegers(Set<Integer> commonIntegers) {
		this.commonIntegers = commonIntegers;
	}

	public void addCommonInt(int value) {
		this.commonIntegers.add(value);
		String message = "Common Integer = "+value;
		this.add(message);
		
	}

	public void addMissingInts(Set<Integer> value) {
		this.missingIntegers.add(value);
		String message = "Missing Integers in file" + (missingIntegers.size()) + " = " +value.toString();
		this.add(message);
	}

	public List<Set<Integer>> getMissingIntegers() {
		return missingIntegers;
	}

	@Override
	public void printToCommonIntFile(String fileName) {
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
			Integer[] array = new Integer[0];
			array = commonIntegers.toArray(array);
			for (int i = 0; i < array.length; i++) {
				writer.write(array[i].toString() + "\n");
			}
			writer.close();
		} catch (IOException e) {

		}
	}

	@Override
	public void printToMissingIntFile(String fileName) throws ResultException {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

			for (int i = 0; i < missingIntegers.size(); i++) {
				Integer[] array = new Integer[0];
				array = missingIntegers.get(i).toArray(array);
				writer.append("inputFile " + (i + 1) + "\n");

				for (int j = 0; j < array.length; j++) {
					writer.append(array[j].toString() + "\n");
				}
				writer.append("\n");
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
			throw new ResultException(e.getMessage());
		}

	}

	@Override
	public void printToStdout() {
		LOGGER.writeMessage(builder.toString(), DebugLevel.RESULTS);		
	}

}
