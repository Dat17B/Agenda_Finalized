package com.example.administration.Interfaces;

public interface BaseCRUDInterface<T>
{
    boolean insert(T entity);
    boolean update(T entity);
    boolean delete(int id);
}
