package cz.rbenes.kukbuk.database.dao;

import java.util.List;

/**
 * Created by rostik on 7.2.17.
 */
public interface GenericDao<E, K> {
    E save(E entity);
    E saveOrUpdate(E entity);
    E update(E etity);
    void remove(E entity);
    E find(K key);
    List<E> getAll();
}
