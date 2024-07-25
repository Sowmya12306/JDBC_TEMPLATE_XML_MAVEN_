package in.springJdbc.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoImpl implements IEmployeeDao {

	private static final String SQL_SELECT_QUERY = "Select count(*) from emp";
	private static final String SQL_SELECT_QUERY_BY_ID = "SELECT ENAME FROM EMP WHERE EMPNO = ?";
	private static final String GET_EMP_BY_ID = "SELECT EMPNO, ENAME, JOB,SAL, DEPTNO, MGR FROM EMP WHERE EMPNO=?";
	private static final String GET_EMP_BY_DESG = "SELECT EMPNO, ENAME, JOB, SAL, DEPTNO, MGR FROM EMP where JOB IN(?, ?) ORDER BY SAL";
	private static final String INSERT_EMP = "INSERT INTO EMP(ENAME, JOB, SAL, DEPTNO, MGR) VALUES (?,?,?,?,?)";
	private static final String ADD_EMP_BONUS_BY_JOB = "UPDATE EMP SET SAL=SAL+? WHERE JOB=?";
	
	@Autowired
	private JdbcTemplate template;
	
	
	@Override
	public int getEmpsCount() {
		System.out.println("template is :: "+ template);
		return template.queryForObject(SQL_SELECT_QUERY, Integer.class);
	}
	@Override
	public String toString() {
		return "EmployeeDaoImpl [template=" + template + "]";
	}
	@Override
	public String getEmployeeByNo(int eno) {
		return template.queryForObject(SQL_SELECT_QUERY_BY_ID, String.class, eno);
		
	}
	@Override
	public Map<String, Object> getEmpdetailsById(int eid) {
		Map<String,Object> map = template.queryForMap(GET_EMP_BY_ID, eid);
		return map;
	}
	@Override
	public List<Map<String, Object>> getEmpByJob(String desg1, String desg2) {
		return template.queryForList(GET_EMP_BY_DESG, desg1, desg2);
	}
	@Override
	public int insertEmp(String ename, String job, int sal, int deptno, int mgr) {
		return template.update(INSERT_EMP, ename,job,sal,deptno,mgr);
		
	}
	@Override
	public int addBonusToEmpbyJob(String job, int bonus) {
		return template.update(ADD_EMP_BONUS_BY_JOB, bonus, job);
	}
}
