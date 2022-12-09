package hu.mik.prog5.z7twzr.mediapatrik.dao;

import java.util.List;

public interface CrudDao<T, ID> {

    T create(T object);

    T findById(ID id);

    List<T> findAll();

    T update(T object);

    boolean delete(ID id);

}
