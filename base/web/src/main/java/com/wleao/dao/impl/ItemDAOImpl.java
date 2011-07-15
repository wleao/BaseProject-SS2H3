/*
 * Copyright (c) 1999-2009 Touch Tecnologia e Informatica Ltda.
 * Gomes de Carvalho, 1666, 3o. Andar, Vila Olimpia, Sao Paulo, SP, Brasil.
 * Todos os direitos reservados.
 * 
 * Este software e confidencial e de propriedade da Touch Tecnologia e
 * Informatica Ltda. (Informacao Confidencial). As informacoes contidas neste
 * arquivo nao podem ser publicadas, e seu uso esta limitado de acordo com os
 * termos do contrato de licenca.
 */

package com.wleao.dao.impl;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wleao.dao.ItemDAO;
import com.wleao.model.Item;


/**
 * @author wleao
 * @since
 */
@Repository
@Scope("singleton")
@Transactional
public class ItemDAOImpl implements ItemDAO {

    private static final Logger LOGGER = Logger.getLogger(ItemDAOImpl.class.getName());

    private EntityManager entityManager;

    @Override
    public void create(Item entity) {
        LOGGER.debug("ItemDAOImpl Adding the following entity: " + entity.getClass().getSimpleName());
        this.entityManager.persist(entity);

    }

    @Override
    public void remove(Item entity) {
        LOGGER.debug("ItemDAOImpl Removing the following entity: " + entity.getClass().getSimpleName());
        this.entityManager.remove(this.entityManager.merge(entity));
    }

    @Override
    public List<Item> findAll() {
        LOGGER.debug("Getting all items");
        return this.entityManager.createQuery("Select i from Item i").getResultList();
    }

    /**
     * @param entityManager
     *            o novo valor de entityManage
     * @see com.wleao.dao.impl.ItemDAOImpl#getEntityManager
     * @since
     */
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Item findById(Long id) {

        Item item = null;
        LOGGER.debug("Getting item by id=" + id);
        List<Item> items =
                this.entityManager.createQuery("from Item i where i.id = :id").setParameter("id", id).getResultList();

        if (items.size() == 1) {
            return items.get(0);
        }

        return item;
    }

    @Override
    public void update(Item entity) {
        LOGGER.debug("ItemDAOImpl Merging the following entity: " + entity.getClass().getSimpleName() + " with id = "
                + entity.getId());
        this.entityManager.merge(entity);
    }
}
