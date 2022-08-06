package repository;

public interface BookRepository {

 boolean changeStatus(long id);
 boolean checkStatus(long id);


}
