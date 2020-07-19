package arrayvisitors.util;

import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.TreeSet;

public class Results implements FileDisplayInterface, StdoutDisplayInterface{
	
	private Set<Integer> commonIntegers = new TreeSet<Integer>();
	private List<Set<Integer>> missingIntegers = new ArrayList<Set<Integer>>();

	public Set<Integer> getCommonIntegers() {
		return commonIntegers;
	}

	public void setCommonIntegers(Set<Integer> commonIntegers) {
		this.commonIntegers = commonIntegers;
	}
	
	public void addCommonInt(int value) {
		this.commonIntegers.add(value);
	}
	
	public void addMissingInts(Set<Integer> value) {
		this.missingIntegers.add(value);
	}
	
	public List<Set<Integer>> getMissingIntegers() {
		return missingIntegers;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		
	}
	
	
}
