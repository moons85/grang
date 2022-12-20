package com.grang.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grang.model.Board;

public interface BoardRepository  extends JpaRepository<Board, Integer>{

}
