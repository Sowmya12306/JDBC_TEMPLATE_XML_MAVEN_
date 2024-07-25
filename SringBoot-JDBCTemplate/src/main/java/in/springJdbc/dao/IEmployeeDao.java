package in.springJdbc.dao;

import java.util.List;
import java.util.Map;

public interface IEmployeeDao {
	public int getEmpsCount();
	public String getEmployeeByNo(int eno);
	public Map<String,Object> getEmpdetailsById(int eid);
	public List<Map<String,Object>> getEmpByJob(String desg1, String desg2);
	public int insertEmp(String ename, String job, int sal, int deptno, int mgr);
	public int addBonusToEmpbyJob(String job, int bonus);


}
