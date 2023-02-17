package collections;

public class Task<T> {
    public T job;
    public int priority;

    Task(T job) {
        this(job, 0);
    }

    Task(T item, int priority) {
        this.job = item;
        this.priority = priority;
    }
}
