package org.uca.gii.mybatis.dao;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import org.uca.gii.mybatis.data.Book;

public interface ConsultaBD {
	List<Book> getBooks();
	List<Book> getByCategory(@Param("description")String description);
}
