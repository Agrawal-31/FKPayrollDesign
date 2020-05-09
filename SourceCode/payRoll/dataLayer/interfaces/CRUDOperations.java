package payRoll.dataLayer.interfaces;

public interface CRUDOperations<T> {
    void add(T obj);
    void update(T obj);
    void delete(T obj);
    void read(T obj);
}
