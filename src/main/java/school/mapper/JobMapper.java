package school.mapper;
import school.pojo.Job;
import school.pojo.News;

import java.util.List;
import java.util.Map;
public interface JobMapper {
    public List<Job> getJob();
    public List<Job> getJobList(Map map);
    public int count(Job job);
    public int insertJob(Job job);
    public List<Job> getMyJobList(Map map);
    public int myCount(Job job);
    public Job findJobId(int id);
    public int updateClick(Map map);
    public int delJob(int id);
    public Job findJob(int id);
    public int countAdmin(Job job);
    public List<Job> getJobListAdmin(Map map);
    public int pass(int id);
    public int noPass(int id);
    public int delByUser(int userId);
}
