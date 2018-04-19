package com.kozlowst.microcache;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CacheTest {

    @Test
    public void testFirstDataLoad() {

        Cache<Integer, Account> cache = new Cache<>(Account.class, "id");

        List<MetaData> delta = cache.addAll(Arrays.asList(
                new Account(1, "client1", 1234566L, true),
                new Account(2, "client2", 22233344L, true)));

        assertEquals(2, delta.size());
        Optional<MetaData> md1 = delta.stream().findFirst();

        assertTrue(md1.isPresent());
        List<MetaData> data = md1.get().getData();
        assertEquals(4, data.size());

        List<String> clientNames = MetaDataUtils.getParamsAsList(delta, "clientName");
        assertThat(clientNames, containsInAnyOrder("client1", "client2"));

    }

    @Test
    public void testAddOneItem() {
        Cache<Integer, Account> cache = new Cache<>(Account.class, "id");

        List<MetaData> delta = cache.addAll(Arrays.asList(
                new Account(1, "client1", 12345L, true),
                new Account(2, "client2", 22334455L, true)
        ));

        assertEquals(2, delta.size());

        delta = cache.addAll(Arrays.asList(
                new Account(3, "client3", 44211L, true)
        ));

        assertEquals(1, delta.size());

        List<String> names = MetaDataUtils.getParamsAsList(delta, "clientName");
        assertEquals("client3", names.stream().findFirst().orElse(null));
    }

    @Test
    public void testOneItem3Updates() {
        Cache<Integer, Account> cache = new Cache<>(Account.class, "id");
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
