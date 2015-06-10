package se.educ.devmedia.jdbc.dao;

import java.util.List;

import se.educ.devmedia.jdbc.exception.PersistenceExceptions;

public interface GenericoDAO<T> {
	
	void insert(T object) throws PersistenceExceptions;
	
	void update(T object) throws PersistenceExceptions;
	
	void delete(Integer id) throws PersistenceExceptions;
	
	List<T> listarTodos() throws PersistenceExceptions;
	
	T buscarPorId(Integer id) throws PersistenceExceptions;

}
