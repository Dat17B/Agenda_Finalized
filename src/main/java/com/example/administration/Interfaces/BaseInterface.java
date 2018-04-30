package com.example.administration.Interfaces;

import java.util.List;

public interface BaseInterface<T>
{
    List<T> get();
    T get(int id);
}
