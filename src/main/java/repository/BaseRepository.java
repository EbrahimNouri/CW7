package repository;

public interface BaseRepository <T> {
    T create(T t);
    T read();
    T update(T t);
   default void delete(T t){}

}