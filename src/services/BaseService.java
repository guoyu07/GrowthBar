package services;

import java.util.List;

/**
 * Version:v1.0 (description:  )
 */
public interface BaseService<T> {

	T select(int id);

	List<T> selectList();

	Boolean save(T entity);

	Boolean remove(int id);

}
