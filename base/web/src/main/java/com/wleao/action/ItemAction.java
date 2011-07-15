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

package com.wleao.action;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.Preparable;
import com.wleao.dao.ItemDAO;
import com.wleao.model.Item;


/**
 * @author wleao
 * @since
 */
@Controller
public class ItemAction implements Preparable {

    private List<Item> items;

    private Long id;

    private String name;

    private String description;

    private ItemDAO itemDAO;

    public String execute() {
        return Action.SUCCESS;
    }

    public String listAll() {
        if (this.itemDAO == null) {
            return Action.ERROR;
        }
        this.items = this.itemDAO.findAll();
        return Action.SUCCESS;
    }

    public String update() {
        if (this.itemDAO == null) {
            return Action.ERROR;
        }

        Item item = this.getItem(this.id);
        if (item == null) {
            return Action.ERROR;
        }

        item.setName(this.name);
        item.setDescription(this.description);

        this.itemDAO.update(item);

        return Action.SUCCESS;
    }

    public String delete() {
        if (this.itemDAO == null) {
            return Action.ERROR;
        }

        Item item = this.getItem(this.id);
        if (item == null) {
            return Action.ERROR;
        }

        this.itemDAO.remove(item);
        return Action.SUCCESS;
    }

    public String add() {
        if (this.itemDAO == null) {
            return Action.ERROR;
        }
        Item item = new Item();
        item.setName(this.name);
        item.setDescription(this.description);
        this.itemDAO.create(item);
        return Action.SUCCESS;
    }

    private Item getItem(Long id) {
        if (id != null) {
            return this.itemDAO.findById(id);
        }
        return null;
    }

    @Override
    public void prepare() throws Exception {
        // TODO Auto-generated method stub

    }

    /**
     * DESCRIÇÃO
     * 
     * @return o valor da propriedade items
     * @since
     */
    public List<Item> getItems() {
        return this.items;
    }

    /**
     * @param items
     *            o novo valor de items
     * @see com.wleao.action.ItemAction#getitems
     * @since
     */
    public void setItems(List<Item> items) {
        this.items = items;
    }

    /**
     * DESCRIÇÃO
     * 
     * @return o valor da propriedade id
     * @since
     */
    public Long getId() {
        return this.id;
    }

    /**
     * @param id
     *            o novo valor de id
     * @see com.wleao.action.ItemAction#getid
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
     * @see com.wleao.action.ItemAction#getname
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
     * @see com.wleao.action.ItemAction#getdescription
     * @since
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * DESCRIÇÃO
     * 
     * @return o valor da propriedade itemDAO
     * @since
     */
    public ItemDAO getItemDAO() {
        return this.itemDAO;
    }

    /**
     * @param itemDAO
     *            o novo valor de itemDAO
     * @see com.wleao.action.ItemAction#getitemDAO
     * @since
     */
    @Autowired
    public void setItemDAO(ItemDAO itemDAO) {
        this.itemDAO = itemDAO;
    }

}
