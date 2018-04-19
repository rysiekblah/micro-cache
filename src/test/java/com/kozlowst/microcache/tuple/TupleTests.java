package com.kozlowst.microcache.tuple;

import static com.kozlowst.microcache.tuple.Tuples.tuple;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import com.kozlowst.microcache.tuple.Tuples.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

public class TupleTests {

    @Test
    public void testCreatedTypes() {
        assertThat(tuple(1), instanceOf(T1.class));
        assertThat(tuple(1, 2), instanceOf(T2.class));
        assertThat(tuple(1, 2, 3), instanceOf(T3.class));
        assertThat(tuple(1, 2, 3, 4), instanceOf(T4.class));
        assertThat(tuple(1, 2, 3, 4, 5), instanceOf(T5.class));
        assertThat(tuple(1, 2, 3, 4, 5, 6), instanceOf(T6.class));
        assertThat(tuple(1, 2, 3, 4, 5, 6, 7), instanceOf(T7.class));
    }

    @Test
    public void testTuple1Param() {
        T1 t = tuple("John");
        assertEquals("John", t._1);
    }

    @Test(expected = ClassCastException.class)
    public void testCastingError() {
        T1 t = tuple("John", "Boom");
    }

    @Test(expected = ClassCastException.class)
    public void testCastingError2() {
        T2 t = tuple("John");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExceededNumberOfParams() {
        tuple(1, 2, 3, 4, 5, 6, 7, 8);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullObjectList() {
        Object object = null;
        tuple(object);
    }

}
