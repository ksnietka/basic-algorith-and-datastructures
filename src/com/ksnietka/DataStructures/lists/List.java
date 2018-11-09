package com.ksnietka.DataStructures.lists;

import java.util.Collection;
import java.util.Collections;

public interface List<E> {
    E get(Integer index);
    void add(E element);
    void delete(Integer index);
    Integer indexOf(E element);
    Boolean contains(E element);
    void addAll(Collection<E> collection);

}
