package com.spring.mongo.api.respository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spring.mongo.api.model.Book;

public interface BookRepository extends MongoRepository<Book, Integer> {

}
