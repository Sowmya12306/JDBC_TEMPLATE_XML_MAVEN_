package in.springJdbc.service;

import java.util.List;
import java.util.Map;

import in.springJdbc.dao.IEmployeeDao;

public class EmployeeServiceImpl implements IEmployeeManagementService {

	private IEmployeeDao dao;
	
	public EmployeeServiceImpl(IEmployeeDao dao) {
		this.dao = dao;
	}

	@Override
	public int fetchEmpsCount() {
		System.out.println("Dao name is :: " +dao.getClass().getName());
		return dao.getEmpsCount();
	}

	@Override
	public String toString() {
		return "EmployeeServiceImpl [dao=" + dao + "]";
	}

	@Override
	public String getEmployeeByNo(int eno) {
		return dao.getEmployeeByNo(eno);
	}

	@Override
	public Map<String, Object> getEmpdetailsById(int eid) {
		return dao.getEmpdetailsById(eid);
	}

	@Override
	public List<Map<String, Object>> getEmpByJob(String desg1, String desg2) {
		return dao.getEmpByJob(desg1, desg2);
	}

	@Override
	public int insertEmp(String ename, String job, int sal, int deptno, int mgr) {
		return dao.insertEmp(ename, job, sal, deptno, mgr);
	}

	@Override
	public int addBonusToEmpbyJob(String job, int bonus) {
		return dao.addBonusToEmpbyJob(job, bonus);
	}
	

}
