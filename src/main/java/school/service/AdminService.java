package school.service;

import school.pojo.Admin;

public interface AdminService {
    public Admin login(Admin admin);
    public int change(Admin admin);
    public Admin findAdmin(int id);
}
