package lab3;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;

public class MyQueue<T> {
    private final Queue<T> queue;

    public MyQueue(int size) {
        queue = new ArrayDeque<>(size);
    }

    public boolean add(T element) {
        return queue.offer(element);
    }

    public T get() {
        return queue.peek();
    }

    public T remove() {
        return queue.remove();
    }

    public boolean empty() {
        return queue.isEmpty();
    }

    public int size() {
        return queue.size();
    }

    @Override
    public String toString() {
        Iterator<T> it = queue.iterator();
        StringBuilder sb = new StringBuilder();
        while(it.hasNext()) {
            T tmp = it.next();
            sb.append(tmp.getClass()).append('\n');
        }
        return String.valueOf(sb);
    }
}
