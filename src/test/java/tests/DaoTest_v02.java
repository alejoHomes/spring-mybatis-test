package tests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ahomes.mybatis.example.IUserMgmtDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/spring-config.xml")
public class DaoTest_v02 {
	
	@Autowired
	private IUserMgmtDao mgmtDao;
	
	@Test
	public void testDepartmentExist(){
		
		Assert.assertNotNull(mgmtDao);
		
		Integer countForDepartment = mgmtDao.getCountForDepartment();
		Assert.assertEquals(new Integer(2), countForDepartment);
		
		Boolean result = mgmtDao.isUserExistsForDepartment("IT", "alejandro");
		Assert.assertEquals(true, result);
		
		result = mgmtDao.isUserExistsForDepartment("Support", "chris");
		Assert.assertEquals(true, result);
		
	}
	
	@Test
	public void testUserExist(){
		
		Assert.assertNotNull(mgmtDao);
		
		Boolean countUser = mgmtDao.isUserExist();
		Assert.assertEquals(false, countUser);
	}
	
	@Test
	public void testInserUser(){
		
		Assert.assertNotNull(mgmtDao);
		
		mgmtDao.InsertUser(99, "testname", 1);
		Integer idUser = mgmtDao.getUser(99);
		Assert.assertEquals(new Integer(99), idUser);
	}
	
	@Test 
	public void deleteUser(){
		
		Assert.assertNotNull(mgmtDao);
		
		mgmtDao.deleteUser(99);
	}
	
	

}