package com.kozlowst.microcache.tuple;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TupleHashEqualsTest {

    @Test
    public void testTuple1() {

        // Given
        Tuples.Tuple1 tuple1 = Tuples.tuple(1);
        Tuples.Tuple1 tuple2 = Tuples.tuple(1);

        // Then
        assertEquals(tuple1, tuple2);
        assertEquals(tuple1.hashCode(), tuple2.hashCode());

    }

    @Test
    public void testTuple2() {
        // Given
        Tuples.Tuple2 tuple1 = Tuples.tuple(1, 2);
        Tuples.Tuple2 tuple2 = Tuples.tuple(1, 2);

        // Then
        assertEquals(tuple1, tuple2);
        assertEquals(tuple1.hashCode(), tuple2.hashCode());
    }

    @Test
    public void testTuple3() {
        // Given
        Tuples.Tuple3 tuple1 = Tuples.tuple(1, 2, 3);
        Tuples.Tuple3 tuple2 = Tuples.tuple(1, 2, 3);

        // Then
        assertEquals(tuple1, tuple2);
        assertEquals(tuple1.hashCode(), tuple2.hashCode());
    }

    @Test
    public void testTuple4() {
        // Given
        Tuples.Tuple4 tuple1 = Tuples.tuple(1, 2, 3, 4);
        Tuples.Tuple4 tuple2 = Tuples.tuple(1, 2, 3, 4);

        // Then
        assertEquals(tuple1, tuple2);
        assertEquals(tuple1.hashCode(), tuple2.hashCode());
    }

    @Test
    public void testTuple5() {
        // Given
        Tuples.Tuple5 tuple1 = Tuples.tuple(1, 2, 3, 4, 5);
        Tuples.Tuple5 tuple2 = Tuples.tuple(1, 2, 3, 4, 5);

        // Then
        assertEquals(tuple1, tuple2);
        assertEquals(tuple1.hashCode(), tuple2.hashCode());
    }

    @Test
    public void testTuple6() {
        // Given
        Tuples.Tuple6 tuple1 = Tuples.tuple(1, 2, 3, 4, 5, 6);
        Tuples.Tuple6 tuple2 = Tuples.tuple(1, 2, 3, 4, 5, 6);

        // Then
        assertEquals(tuple1, tuple2);
        assertEquals(tuple1.hashCode(), tuple2.hashCode());
    }

    @Test
    public void testTuple7() {
        // Given
        Tuples.Tuple7 tuple1 = Tuples.tuple(1, 2, 3, 4, 5, 6, 7);
        Tuples.Tuple7 tuple2 = Tuples.tuple(1, 2, 3, 4, 5, 6, 7);

        // Then
        assertEquals(tuple1, tuple2);
        assertEquals(tuple1.hashCode(), tuple2.hashCode());
    }

}
