package arrayvisitors.visitors;

import arrayvisitors.adt.MyArrayI;
import arrayvisitors.adt.MyArrayListI;
import arrayvisitors.util.FileProcessor;

public class PopulateMyArrayVisitor implements VisitorI {

	// private static final String ALPHANUMERIC_PATTERN = "^[a-zA-Z0-9.]*$";
	private FileProcessor fileProcessor;

	public PopulateMyArrayVisitor() {
	}

	/**
	 * @param fileProcessor
	 */
	public PopulateMyArrayVisitor(FileProcessor fileProcessor) {
		this.fileProcessor = fileProcessor;
	}

	@Override
	public void visit(MyArrayI<Integer> myArrayVisit) {
		try {
			String instruction = fileProcessor.poll();
			while (instruction != null) {
				myArrayVisit.add(Integer.parseInt(instruction));
				instruction = fileProcessor.poll();
			}
		} catch (Exception e) {
			// TODO
		}

	}

	@Override
	public void visit(MyArrayListI<MyArrayI<Integer>> myArrayVisit) {
		// TODO throw an exception indicating that the the behavior is undefined
	}

}
