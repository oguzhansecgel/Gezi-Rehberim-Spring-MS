package com.gezi_rehberim.comment_service.repository;

import com.gezi_rehberim.comment_service.model.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentRepositories extends MongoRepository<Comment, String> {
}
