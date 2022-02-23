package dao;

import java.util.List;

public interface IDAO<T> {

	public boolean create (T Object);
	public List <T> read();
	public Boolean update(T Object);
	public Boolean delete(T Object);
}
