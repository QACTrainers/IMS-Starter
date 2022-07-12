package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.ItemController;
import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class ItemControllerTest {

    @Mock
    private Utils utils;

    @Mock
    private ItemDAO dao;

    @InjectMocks
    private ItemController controller;

    @Test
    public void testReadAll() {
        List<Item> items = new ArrayList<>();
        items.add(new Item(1L, "spoon", 2L, 10L, "silver" ));

        Mockito.when(dao.readAll()).thenReturn(items);

        assertEquals(items, controller.readAll());

        Mockito.verify(dao, Mockito.times(1)).readAll();
    }

    @Test
    public void testCreate() {
        final String ITEM_NAME = "berry crate", COLOUR = "blue";
        final Long ITEM_VALUE = 6L, QUANTITY = 10L;
        final Item created = new Item(ITEM_NAME, ITEM_VALUE, QUANTITY, COLOUR);

        Mockito.when(utils.getString()).thenReturn(ITEM_NAME);
        Mockito.when(utils.getLong()).thenReturn(ITEM_VALUE, QUANTITY);
        Mockito.when(utils.getString()).thenReturn(COLOUR);
        Mockito.when(dao.create(created)).thenReturn(created);

        assertEquals(created, controller.create());

        Mockito.verify(utils, Mockito.times(2)).getString();
        Mockito.verify(dao, Mockito.times(1)).create(created);
    }

    /*@Test
    public void testUpdate() {
        final String ITEM_NAME = "coffee mug", COLOUR = "green";
        final Long ITEM_VALUE = 6L, QUANTITY = 25L;
        Item updated = new Item(1L, ITEM_NAME, ITEM_VALUE, QUANTITY, COLOUR);

        Mockito.when(utils.getLong()).thenReturn(1L);
        Mockito.when(utils.getString()).thenReturn(ITEM_NAME);
        Mockito.when(utils.getLong()).thenReturn(ITEM_VALUE, QUANTITY);
        Mockito.when(utils.getString()).thenReturn(COLOUR);
        Mockito.when(dao.update(updated)).thenReturn(updated);

        assertEquals(updated, updated);

        Mockito.verify(utils, Mockito.times(3)).getLong();
        Mockito.verify(utils, Mockito.times(2)).getString();
        Mockito.verify(dao, Mockito.times(1)).update(updated);
    }*/

    @Test
    public void testDelete() {
        final long ID = 1L;

        Mockito.when(utils.getLong()).thenReturn(ID);
        Mockito.when(dao.delete(ID)).thenReturn(1);

        assertEquals(1L, this.controller.delete());

        Mockito.verify(utils, Mockito.times(1)).getLong();
        Mockito.verify(dao, Mockito.times(1)).delete(ID);
    }
}
