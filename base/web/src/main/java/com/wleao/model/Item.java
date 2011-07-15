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

package com.wleao.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * @author wleao
 * @since
 */
@Entity
@Table(name = "ITEM")
public class Item {

    private Long id;

    private String name;

    private String description;

    /**
     * DESCRIÇÃO
     * 
     * @return o valor da propriedade id
     * @since
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return this.id;
    }

    /**
     * @param id
     *            o novo valor de id
     * @see com.wleao.model.Item#getid
     * @since
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * DESCRIÇÃO
     * 
     * @return o valor da propriedade name
     * @since
     */
    public String getName() {
        return this.name;
    }

    /**
     * @param name
     *            o novo valor de name
     * @see com.wleao.model.Item#getname
     * @since
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * DESCRIÇÃO
     * 
     * @return o valor da propriedade description
     * @since
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * @param description
     *            o novo valor de description
     * @see com.wleao.model.Item#getdescription
     * @since
     */
    public void setDescription(String description) {
        this.description = description;
    }

}
