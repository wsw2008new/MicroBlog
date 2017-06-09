package com.microblog.service;

import java.io.Serializable;
import java.util.List;

public interface GenericService<T, ID extends Serializable> {
  void saveOrUpdate(T model);

  void delete(T model);

  T find(String id);

  List<T> findByFirstName(String name);

  List<T> findAll();
}
