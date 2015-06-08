package se.educ.devmedia.jdbc.dao;

import java.util.List;

public interface GenericoDAO<T> {
	
	void insert(T object);
	
	void update(T object);
	
	void delete(Integer id);
	
	List<T> listarTodos();
	
	T buscarPorId(Integer id);

}
