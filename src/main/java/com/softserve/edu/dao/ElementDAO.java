package com.softserve.edu.dao;

import java.util.List;

public interface ElementDAO<E> {
    public void addElement(E element);
    public void updateElement(E element);
    public List<E> getAllElements();
    public E getElementById(int elementId);
    public void deleteElement(E element);

}
