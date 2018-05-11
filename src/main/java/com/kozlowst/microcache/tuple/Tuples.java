package com.kozlowst.microcache.tuple;

import java.util.Objects;

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
        public final T1 _1;
        Tuple1(T1 _1) {
            this._1 = _1;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Tuple1<?> tuple1 = (Tuple1<?>) o;
            return Objects.equals(_1, tuple1._1);
        }

        @Override
        public int hashCode() {

            return Objects.hash(_1);
        }
    }

    public static class Tuple2<T1, T2> {
        public final T1 _1;
        public final T2 _2;
        Tuple2(T1 _1, T2 _2) {
            this._1 = _1;
            this._2 = _2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Tuple2<?, ?> tuple2 = (Tuple2<?, ?>) o;
            return Objects.equals(_1, tuple2._1) &&
                    Objects.equals(_2, tuple2._2);
        }

        @Override
        public int hashCode() {

            return Objects.hash(_1, _2);
        }
    }

    public static class Tuple3<T1, T2, T3> {
        public final T1 _1;
        public final T2 _2;
        public final T3 _3;

        Tuple3(T1 _1, T2 _2, T3 _3) {
            this._1 = _1;
            this._2 = _2;
            this._3 = _3;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Tuple3<?, ?, ?> tuple3 = (Tuple3<?, ?, ?>) o;
            return Objects.equals(_1, tuple3._1) &&
                    Objects.equals(_2, tuple3._2) &&
                    Objects.equals(_3, tuple3._3);
        }

        @Override
        public int hashCode() {

            return Objects.hash(_1, _2, _3);
        }
    }

    public static class Tuple4<T1, T2, T3, T4> {
        public final T1 _1;
        public final T2 _2;
        public final T3 _3;
        public final T4 _4;

        Tuple4(T1 _1, T2 _2, T3 _3, T4 _4) {
            this._1 = _1;
            this._2 = _2;
            this._3 = _3;
            this._4 = _4;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Tuple4<?, ?, ?, ?> tuple4 = (Tuple4<?, ?, ?, ?>) o;
            return Objects.equals(_1, tuple4._1) &&
                    Objects.equals(_2, tuple4._2) &&
                    Objects.equals(_3, tuple4._3) &&
                    Objects.equals(_4, tuple4._4);
        }

        @Override
        public int hashCode() {

            return Objects.hash(_1, _2, _3, _4);
        }
    }

    public static class Tuple5<T1, T2, T3, T4, T5> {
        public final T1 _1;
        public final T2 _2;
        public final T3 _3;
        public final T4 _4;
        public final T5 _5;

        Tuple5(T1 _1, T2 _2, T3 _3, T4 _4, T5 _5) {
            this._1 = _1;
            this._2 = _2;
            this._3 = _3;
            this._4 = _4;
            this._5 = _5;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Tuple5<?, ?, ?, ?, ?> tuple5 = (Tuple5<?, ?, ?, ?, ?>) o;
            return Objects.equals(_1, tuple5._1) &&
                    Objects.equals(_2, tuple5._2) &&
                    Objects.equals(_3, tuple5._3) &&
                    Objects.equals(_4, tuple5._4) &&
                    Objects.equals(_5, tuple5._5);
        }

        @Override
        public int hashCode() {

            return Objects.hash(_1, _2, _3, _4, _5);
        }
    }

    public static class Tuple6<T1, T2, T3, T4, T5, T6> {
        public final T1 _1;
        public final T2 _2;
        public final T3 _3;
        public final T4 _4;
        public final T5 _5;
        public final T6 _6;

        Tuple6(T1 _1, T2 _2, T3 _3, T4 _4, T5 _5, T6 _6) {
            this._1 = _1;
            this._2 = _2;
            this._3 = _3;
            this._4 = _4;
            this._5 = _5;
            this._6 = _6;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Tuple6<?, ?, ?, ?, ?, ?> tuple6 = (Tuple6<?, ?, ?, ?, ?, ?>) o;
            return Objects.equals(_1, tuple6._1) &&
                    Objects.equals(_2, tuple6._2) &&
                    Objects.equals(_3, tuple6._3) &&
                    Objects.equals(_4, tuple6._4) &&
                    Objects.equals(_5, tuple6._5) &&
                    Objects.equals(_6, tuple6._6);
        }

        @Override
        public int hashCode() {

            return Objects.hash(_1, _2, _3, _4, _5, _6);
        }
    }

    public static class Tuple7<T1, T2, T3, T4, T5, T6, T7> {
        public final T1 _1;
        public final T2 _2;
        public final T3 _3;
        public final T4 _4;
        public final T5 _5;
        public final T6 _6;
        public final T7 _7;

        Tuple7(T1 _1, T2 _2, T3 _3, T4 _4, T5 _5, T6 _6, T7 _7) {
            this._1 = _1;
            this._2 = _2;
            this._3 = _3;
            this._4 = _4;
            this._5 = _5;
            this._6 = _6;
            this._7 = _7;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Tuple7<?, ?, ?, ?, ?, ?, ?> tuple7 = (Tuple7<?, ?, ?, ?, ?, ?, ?>) o;
            return Objects.equals(_1, tuple7._1) &&
                    Objects.equals(_2, tuple7._2) &&
                    Objects.equals(_3, tuple7._3) &&
                    Objects.equals(_4, tuple7._4) &&
                    Objects.equals(_5, tuple7._5) &&
                    Objects.equals(_6, tuple7._6) &&
                    Objects.equals(_7, tuple7._7);
        }

        @Override
        public int hashCode() {

            return Objects.hash(_1, _2, _3, _4, _5, _6, _7);
        }
    }

}
