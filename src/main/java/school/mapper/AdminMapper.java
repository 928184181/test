package school.mapper;
import school.pojo.Admin;
public interface AdminMapper {
    public Admin getAdmin(Admin admin);
    public int change(Admin admin);
    public Admin findAdmin(int id);
}
