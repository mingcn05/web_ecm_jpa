package com.example.webspringjpa.repository;

import com.example.webspringjpa.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IComment extends JpaRepository<Comment, Integer> {

}
