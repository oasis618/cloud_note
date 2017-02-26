package test.dao;

import org.junit.Before;
import org.junit.Test;

import cn.tedu.cloud_note.dao.EmpDao;
import cn.tedu.cloud_note.entity.Emp;
import test.service.TestBase;

public class TestEmpDao extends TestBase{
	private EmpDao empDao;
	@Before
	public void init(){
		empDao = getContext().getBean("empDao",EmpDao.class);
	}
	@Test
	public void test1(){
		Emp emp = new Emp();
		emp.setAge(18);
		emp.setName("jack");
		empDao.save(emp);
		int id = emp.getId();
		System.out.println("newId---->"+id);
	}
}
