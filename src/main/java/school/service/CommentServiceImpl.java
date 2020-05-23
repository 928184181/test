package school.service;

import org.springframework.stereotype.Service;
import school.mapper.CommentMapper;
import school.pojo.Comment;
import school.util.PageSupport;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("commentService")
public class CommentServiceImpl implements CommentService{
    @Resource
    private CommentMapper commentMapper;

    public int addComment(Comment comment) {
        Date time = new Date();
        comment.setTime(time);
        return commentMapper.addComment(comment);
    }


    public int count(int newsId) {
        return commentMapper.count(newsId);
    }

    public PageSupport<Comment> getCommentList(int newsId, PageSupport pageSupport) {
        int pageSize = pageSupport.getPageSize();
        int from = (pageSupport.getCurrentPage()- 1)*pageSize;
        Map map = new HashMap();
        map.put("from",from);
        map.put("pageSize",pageSize);
        map.put("newsId",newsId);
        List<Comment> comments = commentMapper.commentList(map);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (Comment comment:comments){
            String date = simpleDateFormat.format(comment.getTime());
            comment.setDate(date);
        }
        pageSupport.setList(comments);
        return pageSupport;
    }

    public int delByNews(int newsId) {
        return commentMapper.delComment(newsId);
    }
}
