package in.springJdbc.service;

import java.util.List;
import java.util.Map;

public interface IEmployeeManagementService {
	public int fetchEmpsCount();
	public String getEmployeeByNo(int eno);
	public Map<String,Object> getEmpdetailsById(int eid);
	public List<Map<String,Object>> getEmpByJob(String desg1, String desg2);
	public int insertEmp(String ename, String job, int sal, int deptno, int mgr);
	public int addBonusToEmpbyJob(String job, int bonus);

}
