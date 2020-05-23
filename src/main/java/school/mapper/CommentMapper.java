package school.mapper;
import school.pojo.Comment;

import java.util.List;
import java.util.Map;
public interface CommentMapper {
    public int addComment(Comment comment);
    public List<Comment> commentList(Map map);
    public int count(int newsId);
    public int delComment(int newsId);
}