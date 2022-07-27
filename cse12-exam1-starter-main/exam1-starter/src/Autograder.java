import java.util.ArrayList;

// TODO: Implement Autograder class

class Autograder {
	Exam_SQ<Ticket> tickets;
	
	public Autograder(Exam_SQ<Ticket> tickets) {
		this.tickets = tickets;
	}
	
	public void add(Ticket ticket) {
		this.tickets.add(ticket);
	}
	
	public void accept() throws Exception {
		if (this.tickets.empty()) {
			throw new Exception("Autograder is empty");
		}
		ArrayList<Ticket> popped = new ArrayList<>();
		while(!this.tickets.empty()) {
			popped.add(this.tickets.pop());
		}
		if (this.tickets instanceof Exam_Stack) {
			for (int i = popped.size() - 1; i >= 0; i --) {
				if (popped.get(i) != null && popped.get(i).status.equals("")) {
					popped.get(i).accept();
					break;
				}
			}
		} else if (this.tickets instanceof Exam_Queue) {
			for (int i = 0; i < popped.size(); i++) {
				if (popped.get(i) != null && popped.get(i).status.equals("")) {
					popped.get(i).accept();
					break;
				}
			}
		}
		if (this.tickets instanceof Exam_Stack) {
			for (int i = popped.size() - 1; i >= 0; i --) {
				this.tickets.add(popped.get(i));
			}
		} else if (this.tickets instanceof Exam_Queue) {
			for (int i = 0; i < popped.size(); i ++) {
				this.tickets.add(popped.get(i));
			}
		}
	}
	
	public void cancel() throws Exception {
		if (this.tickets.empty()) {
			throw new Exception("Autograder is empty");
		}
		ArrayList<Ticket> popped = new ArrayList<>();
		while(!this.tickets.empty()) {
			popped.add(this.tickets.pop());
		}
		if (this.tickets instanceof Exam_Stack) {
			for (int i = popped.size() - 1; i >= 0; i --) {
				if (popped.get(i) != null && popped.get(i).status.equals("")) {
					popped.get(i).cancel();
					break;
				}
			}
		} else if (this.tickets instanceof Exam_Queue) {
			for (int i = 0; i < popped.size(); i++) {
				if (popped.get(i) != null && popped.get(i).status.equals("")) {
					popped.get(i).cancel();
					break;
				}
			}
		}
		if (this.tickets instanceof Exam_Stack) {
			for (int i = popped.size() - 1; i >= 0; i --) {
				this.tickets.add(popped.get(i));
			}
		} else if (this.tickets instanceof Exam_Queue) {
			for (int i = 0; i < popped.size(); i ++) {
				this.tickets.add(popped.get(i));
			}
		}
		
	}
	
}

// TODO: Implement Ticket class

class Ticket {
	String status;
	
	public Ticket() {
		this.status = "";
	}
	
	public void accept() {
		this.status = "accepted";
	}
	
	public void cancel() {
		this.status = "canceled";
	}
	
	@Override
	public String toString() {
		if (this.status.equals("")) {
			return "Ticket on Autograder";
		} else {
			return "Ticket has been " + this.status;
		}
	}
}

// Provided Code - Do not change
interface Exam_SQ<E> {
    void add(E element);
    E pop();
    boolean empty();
}

class Exam_Stack<E> implements Exam_SQ<E> {
    ArrayList<E> stack;

    public Exam_Stack() {
        stack = new ArrayList<E>();
    }

    public void add(E element) {
        stack.add(element);
    }

    public E pop() {
        if (stack.size() == 0) {
            return null;
        }
        return stack.remove(stack.size() - 1);
    }

    public boolean empty() {
        return stack.size() == 0;
    }
}

class Exam_Queue<E> implements Exam_SQ<E> {
    ArrayList<E> queue;

    public Exam_Queue() {
        queue = new ArrayList<E>();
    }

    public void add(E element) {
        queue.add(element);
    }

    public E pop() {
        return queue.remove(0);
    }

    public boolean empty() {
        return queue.size() == 0;
    }
}