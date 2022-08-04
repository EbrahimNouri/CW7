package repository;

public interface BaseRepository <T, V> {
    T create(T t);
    T read();
    T update(T t);
    void delete(T t);
    T findByValue(V v);
}