package cz.rbenes.kukbuk.database.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

/**
 * Created by rostik on 12.2.17.
 */
@Repository
@Transactional
public class GenericDaoImpl<E, K extends Serializable> implements GenericDao<E, K>{
    @PersistenceContext
    protected EntityManager entityManager;
    protected Class<? extends E> entityClass;

    public GenericDaoImpl() {
    }

    public GenericDaoImpl(Class<E> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public E save(E entity) {
        entityManager.persist(entity);
        entityManager.flush();
        return entity;
    }

    @Override
    public E saveOrUpdate(E entity) {
        return entityManager.merge(entity);
    }

    @Override
    public E update(E etity) {
        return entityManager.merge(etity);
    }

    @Override
    public void remove(E entity) {
        entityManager.remove(entity);
    }

    @Override
    public E find(K key) {
        return (E) entityManager.find(entityClass, key);
    }

    @Override
    public List<E> getAll() {
        String jql = "select u from " + entityClass.getName() + " u";
        return entityManager.createQuery(jql).getResultList();
    }
}
