package com.gezi_rehberim.comment_service.controller;

import com.gezi_rehberim.comment_service.core.dto.request.comment.CreateCommentRequest;
import com.gezi_rehberim.comment_service.core.dto.request.comment.UpdateCommentRequest;
import com.gezi_rehberim.comment_service.core.dto.response.comment.CreateCommentResponse;
import com.gezi_rehberim.comment_service.core.dto.response.comment.UpdateCommentResponse;
import com.gezi_rehberim.comment_service.service.abstracts.CommentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/comment")
public class CommentController {

     private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/create/comment")
    public CreateCommentResponse createComment(@RequestBody CreateCommentRequest request)
    {
        return commentService.createComment(request);
    }
    @PutMapping("/update/comment/{commentId}")
    public UpdateCommentResponse updateComment(@PathVariable String commentId, @RequestBody UpdateCommentRequest request)
    {
        return commentService.updateComment(request,commentId);
    }
}
