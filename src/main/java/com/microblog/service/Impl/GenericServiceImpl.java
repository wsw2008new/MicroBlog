package com.microblog.service.Impl;

import com.microblog.service.GenericService;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class GenericServiceImpl<T, ID extends Serializable> implements GenericService<T, ID> {

  private MongoRepository<T, ID> repository;

  @Override
  public void add(T t) {
    repository.save(t);
  }

  @Override
  public void delete(T t) {
    repository.delete(t);
  }

  public List<T> findAll() {
    return repository.findAll();
  }
}
