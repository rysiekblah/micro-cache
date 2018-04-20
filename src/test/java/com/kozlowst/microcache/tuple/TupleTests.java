package com.kozlowst.microcache.tuple;

import static com.kozlowst.microcache.tuple.Tuples.tuple;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import com.kozlowst.microcache.tuple.Tuples.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

public class TupleTests {

    @Test
    public void testCreatedTypes() {
        assertThat(tuple(1), instanceOf(Tuple1.class));
        assertThat(tuple(1, 2), instanceOf(Tuple2.class));
        assertThat(tuple(1, 2, 3), instanceOf(Tuple3.class));
        assertThat(tuple(1, 2, 3, 4), instanceOf(Tuple4.class));
        assertThat(tuple(1, 2, 3, 4, 5), instanceOf(Tuple5.class));
        assertThat(tuple(1, 2, 3, 4, 5, 6), instanceOf(Tuple6.class));
        assertThat(tuple(1, 2, 3, 4, 5, 6, 7), instanceOf(Tuple7.class));
    }

    @Test
    public void testTuple1Param() {
        Tuple1 t = tuple("John");
        assertEquals("John", t._1);
    }

    @Test(expected = ClassCastException.class)
    public void testCastingError() {
        Tuple1 t = tuple("John", "Boom");
    }

    @Test(expected = ClassCastException.class)
    public void testCastingError2() {
        Tuple2 t = tuple("John");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExceededNumberOfParams() {
        tuple(1, 2, 3, 4, 5, 6, 7, 8);
    }

    @Test
    public void testNullObjectList() {
        Object object = null;
        Tuple1 tuple = tuple(object);
        assertNull(tuple._1);
    }

}
