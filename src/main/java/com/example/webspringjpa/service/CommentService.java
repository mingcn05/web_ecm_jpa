package com.example.webspringjpa.service;

import com.example.webspringjpa.entity.Comment;
import com.example.webspringjpa.repository.IComment;
import com.example.webspringjpa.repository.IProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    IComment iComment;
    public List<Comment> getCommentByProductId(int id){
        return iComment.findAll();
    }
    public void saveComment(Comment c){
        iComment.save(c);
    }
}
