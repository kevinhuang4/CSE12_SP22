/*
 * Class to implement SearchWorklist as a Stack and a Queue.
 * You can use any built-in Java collections for this class.
 */
import java.util.ArrayList;

class StackWorklist implements SearchWorklist {
	ArrayList<Square> contents;

	StackWorklist() {
		this.contents = new ArrayList<Square>();
	}

	public void add(Square c) {
		this.contents.add(c);
	}
	public Square remove(){
		if (this.contents.isEmpty()) {
			return null;
		}
		return this.contents.remove(this.contents.size() - 1);
	}
	public boolean isEmpty(){
		return this.contents.size() == 0;
	}
}

class QueueWorklist implements SearchWorklist {
	ArrayList<Square> contents;

	QueueWorklist() {
		this.contents = new ArrayList<Square>();
	}

	public void add(Square c) {
		this.contents.add(c);
	}
	public Square remove(){
		if (this.contents.isEmpty()) {
			return null;
		}
		return this.contents.remove(0);
	}
	public boolean isEmpty(){
		return this.contents.size() == 0;
	}
}

public interface SearchWorklist {
	void add(Square c);
	Square remove();
	boolean isEmpty();
}
