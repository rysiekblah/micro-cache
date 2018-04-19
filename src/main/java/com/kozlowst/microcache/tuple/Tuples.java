package com.kozlowst.microcache.tuple;

public class Tuples {

    private static final int MAX_TUPLE_PARAMS = 7;

    @SuppressWarnings("unchecked")
    public static <T> T tuple(Object... o) {
        if (o == null || o.length > MAX_TUPLE_PARAMS) throw new IllegalArgumentException();
        switch (o.length) {
            case 1: return ((Class<T>) T1.class).cast(new T1(o[0]));
            case 2: return ((Class<T>) T2.class).cast(new T2(o[0], o[1]));
            case 3: return ((Class<T>) T3.class).cast(new T3(o[0], o[1], o[2]));
            case 4: return ((Class<T>) T4.class).cast(new T4(o[0], o[1], o[2], o[3]));
            case 5: return ((Class<T>) T5.class).cast(new T5(o[0], o[1], o[2], o[3], o[4]));
            case 6: return ((Class<T>) T6.class).cast(new T6(o[0], o[1], o[2], o[3], o[4], o[5]));
            case 7: return ((Class<T>) T7.class).cast(new T7(o[0], o[1], o[2], o[3], o[4], o[5],o[6]));
        }
        return null;
    }

    public static class T1 {
        public Object _1;
        T1(Object _1) {
            this._1 = _1;
        }
    }

    public static class T2 {
        public Object _1;
        public Object _2;
        T2(Object _1, Object _2) {
            this._1 = _1;
            this._2 = _2;
        }
    }

    public static class T3 {
        public Object _1;
        public Object _2;
        public Object _3;

        T3(Object _1, Object _2, Object _3) {
            this._1 = _1;
            this._2 = _2;
            this._3 = _3;
        }
    }

    public static class T4 {
        public Object _1;
        public Object _2;
        public Object _3;
        public Object _4;

        T4(Object _1, Object _2, Object _3, Object _4) {
            this._1 = _1;
            this._2 = _2;
            this._3 = _3;
            this._4 = _4;
        }
    }

    public static class T5 {
        public Object _1;
        public Object _2;
        public Object _3;
        public Object _4;
        public Object _5;

        T5(Object _1, Object _2, Object _3, Object _4, Object _5) {
            this._1 = _1;
            this._2 = _2;
            this._3 = _3;
            this._4 = _4;
            this._5 = _5;
        }
    }

    public static class T6 {
        public Object _1;
        public Object _2;
        public Object _3;
        public Object _4;
        public Object _5;
        public Object _6;

        T6(Object _1, Object _2, Object _3, Object _4, Object _5, Object _6) {
            this._1 = _1;
            this._2 = _2;
            this._3 = _3;
            this._4 = _4;
            this._5 = _5;
            this._6 = _6;
        }
    }

    public static class T7 {
        public Object _1;
        public Object _2;
        public Object _3;
        public Object _4;
        public Object _5;
        public Object _6;
        public Object _7;

        T7(Object _1, Object _2, Object _3, Object _4, Object _5, Object _6, Object _7) {
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
