package arrayvisitors.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import arrayvisitors.exception.ResultException;
import arrayvisitors.util.MyLogger.DebugLevel;

public class Results implements FileDisplayInterface, StdoutDisplayInterface {

	MyLogger LOGGER = MyLogger.getMyLoggerInstance();

	private Set<String> commonIntegers = new LinkedHashSet<String>();
	private List<Set<String>> missingIntegers = new ArrayList<Set<String>>();

	private final Set<String> builder = new LinkedHashSet<String>();

	public Results() {
	}

	public void add(String message) {
		builder.add(message + " \n");
	}

	public Set<String> getCommonIntegers() {
		return commonIntegers;
	}

	public void setCommonIntegers(Set<String> commonIntegers) {
		this.commonIntegers = commonIntegers;
	}

	public void addCommonInt(String value) {
		this.commonIntegers.add(value);
		String message = "Common Integer = " + value;
		this.add(message);

	}

	public void addMissingInts(Set<String> value) {
		this.missingIntegers.add(value);
		String message = "Missing Integers in file" + (missingIntegers.size()) + " = " + value.toString();
		this.add(message);
	}

	public List<Set<String>> getMissingIntegers() {
		return missingIntegers;
	}

	@Override
	public void printToCommonIntFile(String fileName) throws ResultException {

		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
			String[] array = new String[0];
			array = commonIntegers.toArray(array);
			for (int i = 0; i < array.length; i++) {
				writer.write(array[i].toString() + "\n");
			}
			writer.close();
		} catch (IOException e) {
			throw new ResultException(e.getMessage());
		}
	}

	@Override
	public void printToMissingIntFile(String fileName) throws ResultException {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

			for (int i = 0; i < missingIntegers.size(); i++) {
				String[] array = new String[0];
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
	
	@Override
	public String toString() {
		return "Results [commonIntegers=" + commonIntegers + ", missingIntegers=" + missingIntegers + "]";
	}

}
