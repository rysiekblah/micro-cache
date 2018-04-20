package com.kozlowst.microcache.tuple.mutable;

public class Tuples {

    @SuppressWarnings("unchecked")
    public static <T> T tuple(Object... o) {
        switch (o.length) {
            case 1: return ((Class<T>) Tuple1.class).cast(new Tuple1(o[0]));
            case 2: return ((Class<T>) Tuple2.class).cast(new Tuple2(o[0], o[1]));
            case 3: return ((Class<T>) Tuple3.class).cast(new Tuple3(o[0], o[1], o[2]));
            case 4: return ((Class<T>) Tuple4.class).cast(new Tuple4(o[0], o[1], o[2], o[3]));
            case 5: return ((Class<T>) Tuple5.class).cast(new Tuple5(o[0], o[1], o[2], o[3], o[4]));
            case 6: return ((Class<T>) Tuple6.class).cast(new Tuple6(o[0], o[1], o[2], o[3], o[4], o[5]));
            case 7: return ((Class<T>) Tuple7.class).cast(new Tuple7(o[0], o[1], o[2], o[3], o[4], o[5],o[6]));
            default: throw new IllegalArgumentException();
        }
    }

    public static class Tuple1<T1> {
        public T1 _1;
        Tuple1(T1 _1) {
            this._1 = _1;
        }
    }

    public static class Tuple2<T1, T2> {
        public T1 _1;
        public T2 _2;
        Tuple2(T1 _1, T2 _2) {
            this._1 = _1;
            this._2 = _2;
        }
    }

    public static class Tuple3<T1, T2, T3> {
        public T1 _1;
        public T2 _2;
        public T3 _3;

        Tuple3(T1 _1, T2 _2, T3 _3) {
            this._1 = _1;
            this._2 = _2;
            this._3 = _3;
        }
    }

    public static class Tuple4<T1, T2, T3, T4> {
        public T1 _1;
        public T2 _2;
        public T3 _3;
        public T4 _4;

        Tuple4(T1 _1, T2 _2, T3 _3, T4 _4) {
            this._1 = _1;
            this._2 = _2;
            this._3 = _3;
            this._4 = _4;
        }
    }

    public static class Tuple5<T1, T2, T3, T4, T5> {
        public T1 _1;
        public T2 _2;
        public T3 _3;
        public T4 _4;
        public T5 _5;

        Tuple5(T1 _1, T2 _2, T3 _3, T4 _4, T5 _5) {
            this._1 = _1;
            this._2 = _2;
            this._3 = _3;
            this._4 = _4;
            this._5 = _5;
        }
    }

    public static class Tuple6<T1, T2, T3, T4, T5, T6> {
        public T1 _1;
        public T2 _2;
        public T3 _3;
        public T4 _4;
        public T5 _5;
        public T6 _6;

        Tuple6(T1 _1, T2 _2, T3 _3, T4 _4, T5 _5, T6 _6) {
            this._1 = _1;
            this._2 = _2;
            this._3 = _3;
            this._4 = _4;
            this._5 = _5;
            this._6 = _6;
        }
    }

    public static class Tuple7<T1, T2, T3, T4, T5, T6, T7> {
        public T1 _1;
        public T2 _2;
        public T3 _3;
        public T4 _4;
        public T5 _5;
        public T6 _6;
        public T7 _7;

        Tuple7(T1 _1, T2 _2, T3 _3, T4 _4, T5 _5, T6 _6, T7 _7) {
            this._1 = _1;
            this._2 = _2;
            this._3 = _3;
            this._4 = _4;
            this._5 = _5;
            this._6 = _6;
            this._7 = _7;
        }
    }

}
