package com.grang.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grang.model.Message;

public interface MessageRepository  extends JpaRepository<Message, Integer>{

}
