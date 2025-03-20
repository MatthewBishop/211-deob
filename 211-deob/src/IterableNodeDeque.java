import java.util.Collection;
import java.util.Iterator;

public class IterableNodeDeque implements Iterable, Collection {

    Node sentinel = new Node();

    Node field3558;

    public IterableNodeDeque() {
        this.sentinel.previous = this.sentinel;
        this.sentinel.next = this.sentinel;
    }

    public void rsClear() {
        while (this.sentinel.previous != this.sentinel) {
            this.sentinel.previous.remove();
        }

    }

    public void addFirst(Node var1) {
        if (var1.next != null) {
            var1.remove();
        }

        var1.next = this.sentinel.next;
        var1.previous = this.sentinel;
        var1.next.previous = var1;
        var1.previous.next = var1;
    }

    public void addLast(Node var1) {
        if (var1.next != null) {
            var1.remove();
        }

        var1.next = this.sentinel;
        var1.previous = this.sentinel.previous;
        var1.next.previous = var1;
        var1.previous.next = var1;
    }

    public Node last() {
        return this.method1905((Node) null);
    }

    Node method1905(Node var1) {
        Node var2;
        if (var1 == null) {
            var2 = this.sentinel.previous;
        } else {
            var2 = var1;
        }

        if (var2 == this.sentinel) {
            this.field3558 = null;
            return null;
        } else {
            this.field3558 = var2.previous;
            return var2;
        }
    }

    public Node previous() {
        Node var1 = this.field3558;
        if (var1 == this.sentinel) {
            this.field3558 = null;
            return null;
        } else {
            this.field3558 = var1.previous;
            return var1;
        }
    }

    int method1907() {
        int var1 = 0;

        for (Node var2 = this.sentinel.previous; var2 != this.sentinel; var2 = var2.previous) {
            ++var1;
        }

        return var1;
    }

    public boolean method1912() {
        return this.sentinel.previous == this.sentinel;
    }

    Node[] method1908() {
        Node[] var1 = new Node[this.method1907()];
        int var2 = 0;

        for (Node var3 = this.sentinel.previous; var3 != this.sentinel; var3 = var3.previous) {
            var1[var2++] = var3;
        }

        return var1;
    }

    boolean method1909(Node var1) {
        this.addFirst(var1);
        return true;
    }

    public int size() {
        return this.method1907();
    }

    public boolean isEmpty() {
        return this.method1912();
    }

    public boolean contains(Object var1) {
        throw new RuntimeException();
    }

    public Object[] toArray() {
        return this.method1908();
    }

    public boolean remove(Object var1) {
        throw new RuntimeException();
    }

    public boolean containsAll(Collection var1) {
        throw new RuntimeException();
    }

    public boolean retainAll(Collection var1) {
        throw new RuntimeException();
    }

    public void clear() {
        this.rsClear();
    }

    public boolean add(Object var1) {
        return this.method1909((Node) var1);
    }

    public boolean equals(Object var1) {
        return super.equals(var1);
    }

    public int hashCode() {
        return super.hashCode();
    }

    public Object[] toArray(Object[] var1) {
        int var2 = 0;

        for (Node var3 = this.sentinel.previous; var3 != this.sentinel; var3 = var3.previous) {
            var1[var2++] = var3;
        }

        return var1;
    }

    public Iterator iterator() {
        return new IterableNodeDequeDescendingIterator(this);
    }

    public boolean removeAll(Collection var1) {
        throw new RuntimeException();
    }

    public boolean addAll(Collection var1) {
        throw new RuntimeException();
    }

    public static void IterableNodeDeque_addBefore(Node var0, Node var1) {
        if (var0.next != null) {
            var0.remove();
        }

        var0.next = var1;
        var0.previous = var1.previous;
        var0.next.previous = var0;
        var0.previous.next = var0;
    }
}
