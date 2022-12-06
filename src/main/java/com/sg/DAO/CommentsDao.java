package com.sg.DAO;

import com.sg.DTO.Comments;

public interface CommentsDao {
    public Comments addComment(Comments comment);

    public void updateComment (Comments comment);

    public void deleteComment(Comments comment);
}
