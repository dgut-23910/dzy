package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import Tool.PageInformation;
import bean.Good;
import dao.DataBaseDao;
import dao.GoodDao;

public class firsttest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	@Test
	public void testCount() throws Exception {
		GoodDao goodDao=new GoodDao();
		PageInformation page=new PageInformation();
		DataBaseDao databaseDao=new DataBaseDao();
		
		int count=goodDao.count(page, databaseDao);
	}
	@Test
	public void testListAll() throws Exception {
		GoodDao goodDao=new GoodDao();
		DataBaseDao databaseDao=new DataBaseDao();
		
		List<Good> goodList=goodDao.listAll(databaseDao);
		//假设数据库中有12条数据
		assertNotNull(goodList);				
	}
	@Test
	public void testGetPage() throws Exception {
		GoodDao goodDao=new GoodDao();
		PageInformation page=new PageInformation();
		page.setPage(1);
		page.setPageSize(2);
		//假设数据库中有12条数据
		page.setTotalPageCount(12);
		DataBaseDao databaseDao=new DataBaseDao();		
		List<Good> goodList=goodDao.getPage(page,databaseDao);		
		assertEquals(new Integer(goodList.size()),page.getPageSize());				
	}
}
