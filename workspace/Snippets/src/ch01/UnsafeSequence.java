package ch01;

// not thread safe
public class UnsafeSequence {
	private int value;
	
	public int getNext() {
		return value++;
	}
}