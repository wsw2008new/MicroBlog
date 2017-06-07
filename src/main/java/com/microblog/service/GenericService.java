package com.microblog.service;

import java.io.Serializable;
import java.util.List;

public interface GenericService<T, ID extends Serializable> {

  void add(T t);

  void delete(T t);

  List<T> findAll();
}
