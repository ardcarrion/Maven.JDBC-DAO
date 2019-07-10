package daos;

import java.util.List;

public interface DAOInterface<T> {
    public T findById(int id);
    public List<T> findALL();
    public T update(T dto);
    public T create (T dto);
    public void delete(int id);

}
