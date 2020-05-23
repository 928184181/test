package school.service;

import school.pojo.Job;
import school.pojo.News;
import school.util.PageSupport;

import java.util.List;

public interface JobService {
    public List<Job> getJob();
    public int count(Job job);
    public PageSupport<Job> getJobList(Job job,PageSupport pageSupport);
    public int addJob(Job job);
    public int myCount(Job job);
    public PageSupport<Job> getMyJobList(Job job,PageSupport pageSupport);
    public Job findJobById(int id);
    public void updateSum(int id);
    public int delJob(int id);
    public Job lookJob(int id);

    public PageSupport<Job> getJobListAdmin(Job job, PageSupport pageSupport);
    public int countAdmin(Job job);
    public int pass(int id);
    public int noPass(int id);
    public int delByUser(int userId);
}
