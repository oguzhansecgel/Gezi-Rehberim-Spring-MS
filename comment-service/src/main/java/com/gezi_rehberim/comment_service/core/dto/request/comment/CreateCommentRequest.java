package com.gezi_rehberim.comment_service.core.dto.request.comment;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateCommentRequest {
    private String comment;
    private int placeId;
    private int userId;
}
