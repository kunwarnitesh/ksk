package com.ksk.java;

@FunctionalInterface
public interface BiFunction<T,U,V> {

    V apply(T t, U u);
}
