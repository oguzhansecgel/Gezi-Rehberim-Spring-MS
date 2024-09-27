package com.gezi_rehberim.comment_service.core.dto.response.comment;

import com.gezi_rehberim.comment_service.model.Place;
import com.gezi_rehberim.comment_service.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCommentResponse {
    private String id;
    private String comment;
    private Place place;
    private User user;
}
