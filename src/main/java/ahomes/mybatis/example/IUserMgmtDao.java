package ahomes.mybatis.example;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;

public interface IUserMgmtDao {
	
	@Select("select count(1) from department")
	public Integer getCountForDepartment();
	
	@Autowired
	@Select("select count(1) from user_detail u, department d " +
			"where u.department_id=d.id and username = #{username} " +
			"and department_name = #{deptName}")
	public Boolean isUserExistsForDepartment(
			@Param("deptName") final String deptName, 
			@Param("username") final String username
			);
	
	
	@Select("select count(1) from user_detail")
	public Boolean isUserExist();
	
	@Autowired
	@Select("select id from user_detail " +
			"where id = #{id_user}")
	public Integer getUser(
			@Param("id_user") final int id_user
			);
	
	@Autowired
	@Delete("delete from user_detail "+
			"where id = #{id_user}")
	public void deleteUser(
			@Param("id_user") final int id_user
			);
	
	
	@Autowired
	@Select("INSERT INTO user_detail( " +
            "id, username, department_id) " +
			"VALUES (#{id_user}, #{username}, #{department_id});")
	public void InsertUser(
			@Param("id_user") final int id_user,
			@Param("username") final String username,
			@Param("department_id") final int department_id
			);
	
}