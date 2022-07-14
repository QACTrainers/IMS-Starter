package com.qa.ims.controllers;

import com.qa.ims.controller.ItemController;
import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.Utils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ItemControllerTest {

<<<<<<< HEAD
=======
    @Mock
    private Utils utils;

    @Mock
    private ItemDAO itemDAO;

    @InjectMocks
    private ItemController itemController;

    @Test
    public void testCreate() {
        final String ITEM_NAME = "MacBook Pro";
        final double ITEM_PRICE = 1599.99;
        final Item created = new Item(ITEM_NAME, ITEM_PRICE);

        Mockito.when(utils.getString()).thenReturn(ITEM_NAME);
        Mockito.when(utils.getDouble()).thenReturn(ITEM_PRICE);
        Mockito.when(itemDAO.create(created)).thenReturn(created);

        assertEquals(created, itemController.create());

        Mockito.verify(utils, Mockito.times(1)).getString();
        Mockito.verify(utils, Mockito.times(1)).getDouble();
        Mockito.verify(itemDAO, Mockito.times(1)).create(created);
    }

    @Test
    public void testReadAll() {
        List<Item> items = new ArrayList<>();
        items.add(new Item(1L, "MacBook Pro", 1599.99));

        Mockito.when(itemDAO.readAll()).thenReturn(items);

        assertEquals(items, itemController.readAll());

        Mockito.verify(itemDAO, Mockito.times(1)).readAll();

    }

    @Test
    public void testUpdate() {
        Item updated = new Item(1L, "MacBook Air", 999.99);

        Mockito.when(this.utils.getLong()).thenReturn(1L);
        Mockito.when(this.utils.getString()).thenReturn(updated.getItemName());
        Mockito.when(this.utils.getDouble()).thenReturn(updated.getItemPrice());
        Mockito.when(this.itemDAO.update(updated)).thenReturn(updated);

        assertEquals(updated, this.itemController.update());

        Mockito.verify(this.utils, Mockito.times(1)).getLong();
        Mockito.verify(this.utils, Mockito.times(1)).getString();
        Mockito.verify(this.utils, Mockito.times(1)).getDouble();
        Mockito.verify(this.itemDAO, Mockito.times(1)).update(updated);
    }

    @Test
    public void testDelete() {
        final long ID = 1L;

        Mockito.when(utils.getLong()).thenReturn(ID);
        Mockito.when(itemDAO.delete(ID)).thenReturn(1);

        assertEquals(1L, this.itemController.delete());

        Mockito.verify(utils, Mockito.times(1)).getLong();
        Mockito.verify(itemDAO, Mockito.times(1)).delete(ID);
    }
>>>>>>> test

}
