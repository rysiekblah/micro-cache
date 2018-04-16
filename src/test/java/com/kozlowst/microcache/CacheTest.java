package com.kozlowst.microcache;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CacheTest {

    @Test
    public void test() {

        Cache<Integer, Account> cache = new Cache<>(Account.class, "id");

        List<MetaData> delta = cache.addAll(Arrays.asList(
                new Account(1, "client1", 1234566L, true),
                new Account(2, "client2", 22233344L, true)));

        assertEquals(2, delta.size());
        Optional<MetaData> md1 = delta.stream().findFirst();

        assertTrue(md1.isPresent());
        List data = md1.get().getData();
        assertEquals(4, data.size());

    }

    static class Account {
        private Integer id;
        private String clientName;
        private Long number;
        private Boolean active;

        public Account(Integer id, String clientName, Long number, Boolean active) {
            this.id = id;
            this.clientName = clientName;
            this.number = number;
            this.active = active;
        }

    }

}
