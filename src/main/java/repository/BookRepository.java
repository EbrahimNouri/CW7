package repository;

import java.sql.SQLException;

public interface BookRepository {

 boolean changeStatus(long id) throws SQLException;
 boolean checkStatus(long id) throws SQLException;


}
