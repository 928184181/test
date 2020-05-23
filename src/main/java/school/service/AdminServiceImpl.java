package school.service;

import org.springframework.stereotype.Service;
import school.mapper.AdminMapper;
import school.pojo.Admin;

import javax.annotation.Resource;

@Service("adminService")
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminMapper adminMapper;
    public Admin login(Admin admin) {
        Admin admin1 = adminMapper.getAdmin(admin);
        return admin1;
    }

    public int change(Admin admin) {
        return adminMapper.change(admin);
    }

    public Admin findAdmin(int id) {
        return adminMapper.findAdmin(id);
    }
}
