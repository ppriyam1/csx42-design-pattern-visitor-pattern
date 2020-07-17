package arrayvisitors.visitors;

import arrayvisitors.adt.MyArray;
import arrayvisitors.util.FileProcessor;

public class PopulateMyArrayVisitor implements Visitor {
	
	//private static final String ALPHANUMERIC_PATTERN = "^[a-zA-Z0-9.]*$";
	private FileProcessor fileProcessor;
	
	@Override
	public void visit(MyArray myArrayVisit) {
		try {
		String instruction = fileProcessor.poll();
		while(instruction != null) {
			//String[] formatter = instruction.split(ALPHANUMERIC_PATTERN);
			//for(int i = 0; i < formatter.length; i++) {
				myArrayVisit.add(Integer.parseInt(instruction));
				
				instruction = fileProcessor.poll();
			//}
		}
		}
		catch(Exception e){
		//TODO
		}
		
	}

	public FileProcessor getFileProcessor() {
		return fileProcessor;
	}

	public void setFileProcessor(FileProcessor fileProcessorI) {
		this.fileProcessor = fileProcessorI;
	}
	
	
}
