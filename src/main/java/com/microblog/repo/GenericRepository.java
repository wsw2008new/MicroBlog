package com.microblog.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
interface GenericRepository<T, ID extends Serializable> extends MongoRepository<T, ID> {
}
