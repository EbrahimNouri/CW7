package repository;

import entity.Books;

public interface BookRepository {

 boolean changeStatus(long id);
 boolean checkStatus(long id);


}
