package com.qa.ims.persistence.domain;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

public class ItemTest {

    @Test
    public void testEquals() {
        EqualsVerifier.simple().forClass(Item.class).verify();
    }
}
