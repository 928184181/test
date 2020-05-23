package school.service;

import school.pojo.Comment;
import school.util.PageSupport;

public interface CommentService {
    public int addComment(Comment comment);
    public int count(int newsId);
    public PageSupport<Comment> getCommentList(int newsId,PageSupport pageSupport);
    public int delByNews(int newsId);
}
