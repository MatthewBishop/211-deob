import java.util.Iterator;

public class IterableNodeDequeDescendingIterator implements Iterator {

	IterableNodeDeque deque;

	Node field3556;

	Node last = null;

	IterableNodeDequeDescendingIterator(IterableNodeDeque var1) {
		this.setDeque(var1);
	}

	void setDeque(IterableNodeDeque var1) {
		this.deque = var1;
		this.start();
	}

	void start() {
		this.field3556 = this.deque != null ? this.deque.sentinel.previous : null;
		this.last = null;
	}

	public Object next() {
		Node var1 = this.field3556;
		if (var1 == this.deque.sentinel) {
			var1 = null;
			this.field3556 = null;
		} else {
			this.field3556 = var1.previous;
		}

		this.last = var1;
		return var1;
	}

	public void remove() {
		if (this.last == null) {
			throw new IllegalStateException();
		} else {
			this.last.remove();
			this.last = null;
		}
	}

	public boolean hasNext() {
		return this.deque.sentinel != this.field3556 && this.field3556 != null;
	}
}
