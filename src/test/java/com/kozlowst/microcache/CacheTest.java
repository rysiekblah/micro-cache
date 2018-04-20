package com.kozlowst.microcache;

import com.kozlowst.microcache.annotations.DeltaIgnore;
import com.kozlowst.microcache.tuple.Tuples;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CacheTest {

    @Test
    public void testFirstDataLoad() {

        // Given
        Cache<Integer, Account> cache = new Cache<>(Account.class, "id");

        // When
        List<MetaData> delta = cache.addAll(Arrays.asList(
                new Account(1, "client1", 1234566L, true),
                new Account(2, "client2", 22233344L, true)));

        // Then
        assertEquals(2, delta.size());
        Optional<MetaData> md1 = delta.stream().findFirst();

        assertTrue(md1.isPresent());
        List<Tuples.Tuple2> data = md1.get().getData();
        assertEquals(4, data.size());

        List<String> clientNames = MetaDataUtils.getParamsAsList(delta, "clientName");
        assertThat(clientNames, containsInAnyOrder("client1", "client2"));

        List<Integer> ids = MetaDataUtils.getParamsAsList(delta, "id");
        assertThat(ids, containsInAnyOrder(1, 2));

        List<Long> accountNumbers = MetaDataUtils.getParamsAsList(delta, "number");
        assertThat(accountNumbers, containsInAnyOrder(1234566L, 22233344L));

        List<Boolean> accountActiveFlgs = MetaDataUtils.getParamsAsList(delta, "active");
        assertThat(accountActiveFlgs, containsInAnyOrder(true, true));
    }

    @Test
    public void testAddOneItem() {

        // Given
        Cache<Integer, Account> cache = new Cache<>(Account.class, "id");

        // When
        List<MetaData> delta = cache.addAll(Arrays.asList(
                new Account(1, "client1", 12345L, true),
                new Account(2, "client2", 22334455L, true)
        ));

        // Then
        assertEquals(2, delta.size());

        delta = cache.addAll(Collections.singletonList(
                new Account(3, "client3", 44211L, true)
        ));

        assertEquals(1, delta.size());

        List<String> names = MetaDataUtils.getParamsAsList(delta, "clientName");
        assertEquals("client3", names.stream().findFirst().orElse(null));
    }

    @Test
    public void testUpdateOneProperty() {

        // Given
        Cache<Integer, Account> cache = new Cache<>(Account.class);

        // When
        cache.addAll(Collections.singletonList(new Account(24, "client_1", 22334455L, true)));
        List<MetaData> delta2 = cache.addAll(Collections.singletonList(new Account(24, "client_1", 44223355L, true)));

        // Then
        assertEquals(1, delta2.size());
        Optional<MetaData> metaData2 = delta2.stream().findFirst();
        assertTrue(metaData2.isPresent());
        assertEquals(2, metaData2.get().getData().size());

        int id = (int) metaData2.get().getData().stream().filter(x -> x._1.equals("id")).collect(Collectors.toList()).get(0)._2;
        assertEquals(24, id);

        long number = (long) metaData2.get().getData().stream().filter(x -> x._1.equals("number")).collect(Collectors.toList()).get(0)._2;
        assertEquals(44223355L, number);
    }

    @Test
    public void testUpdateProperties() {

        // Given
        Cache<Integer, Account> cache = new Cache<>(Account.class);

        // When
        cache.addAll(Collections.singletonList(new Account(24, "client_1", 22334455L, true)));
        List<MetaData> delta2 = cache.addAll(Collections.singletonList(new Account(24, "client_1_NEW", 44223355L, true)));

        // Then
        assertEquals(1, delta2.size());
        Optional<MetaData> metaData2 = delta2.stream().findFirst();
        assertTrue(metaData2.isPresent());
        assertEquals(3, metaData2.get().getData().size());

        int id = (int) metaData2.get().getData().stream().filter(x -> x._1.equals("id")).collect(Collectors.toList()).get(0)._2;
        assertEquals(24, id);

        String clientName = (String) metaData2.get().getData().stream().filter(x -> x._1.equals("clientName")).collect(Collectors.toList()).get(0)._2;
        assertEquals("client_1_NEW", clientName);

        long number = (long) metaData2.get().getData().stream().filter(x -> x._1.equals("number")).collect(Collectors.toList()).get(0)._2;
        assertEquals(44223355L, number);

    }

    @Test
    public void testUpdatePropertySameValue() {

        // Given
        Cache<Integer, Account> cache = new Cache<>(Account.class);

        // When
        cache.addAll(Collections.singletonList(new Account(24, "client_1", 22334455L, true)));
        List<MetaData> delta2 = cache.addAll(Collections.singletonList(new Account(24, "client_1", 22334455L, true)));

        // Then
        assertEquals(0, delta2.size());

    }

    @Test
    public void testIgnoringAnnotatedFields() {

        // Given
        Cache<Integer, User> cache = new Cache<>(User.class);

        // When
        List<MetaData> metaData = cache.addAll(Collections.singletonList(new User(21, "John", 2, 5)));

        // Then
        List<String> propertyNames = metaData.get(0).getData().stream().map(x -> (String)x._1).collect(Collectors.toList());

        assertEquals(3, propertyNames.size());
        assertThat(propertyNames, containsInAnyOrder("id", "name", "accounts"));

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

    static class User {
        private Integer id;
        private String name;
        @DeltaIgnore
        private int loans;
        private int accounts;

        public User(Integer id, String name, int loans, int accounts) {
            this.id = id;
            this.name = name;
            this.loans = loans;
            this.accounts = accounts;
        }
    }

}
