package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentTest {

	public static void main(String[] args) {
		DepartmentDao depDao = DaoFactory.createDepartmentDao();
		
		Department dep = depDao.findById(1);
		
		System.out.println(dep.toString());
		
		
		//falta teste de findAll

	}

}
