package com.microblog.service;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.io.Serializable;

public class GenericServiceImpl<T, ID extends Serializable> implements GenericService<T, ID> {

	private MongoRepository<T, ID> repository;

	GenericServiceImpl(MongoRepository<T, ID> repository) {
		this.repository = repository;
	}
}
