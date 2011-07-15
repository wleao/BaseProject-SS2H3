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

package com.wleao.dao;


import java.util.List;


/**
 * @author wleao
 * @since
 */
public interface EntityDAO<T> {

    public void create(T entity);

    public void update(T entity);

    public void remove(T entity);

    public List<T> findAll();

    public T findById(Long id);
}
