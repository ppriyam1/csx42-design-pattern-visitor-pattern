package arrayvisitors.visitors;

import arrayvisitors.exception.VisitorException;

public interface ElementI {

	public void accept(VisitorI visitor) throws VisitorException;

}
