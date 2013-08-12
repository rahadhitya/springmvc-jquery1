/**
 * 
 */
package org.springframework.standard.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.standard.dao.DepartmentDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.standard.model.Department;

/**
 * @author Radhit
 *
 */
@Service("departmentDao")
public class HibernateDepartmentDao implements DepartmentDao {

	/* (non-Javadoc)
	 * @see com.spring.hibernate.dao.DepartmentDao#getAllDepartment()
	 */
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public List<Department> getAllDepartment() {
		
		Session session = sessionFactory.getCurrentSession();		
		@SuppressWarnings("unchecked")
		List<Department> department = (List<Department>) session
				.createQuery("from Department").list();
				//.createQuery( "select i from Item i");
		//		.find("from " + Item.class.getName());
		return department;
	}

	@Transactional
	public Department getSingleDepartment(Department department) {
		
		Session session = sessionFactory.getCurrentSession();		

		Department departmenti = new Department();

		departmenti.setTitle(department.getTitle());
		departmenti.setDescription(department.getDescription());

		return departmenti;
	}

	/* (non-Javadoc)
	 * @see com.spring.hibernate.dao.DepartmentDao#findDepartmentById(java.lang.Long)
	 */
	
	@Transactional
	public Department findDepartmentById(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		Department department = (Department) session.get(Department.class, id);
		return department;
	}

	/* (non-Javadoc)
	 * @see com.spring.hibernate.dao.DepartmentDao#saveDepartment(com.spring.hibernate.Department)
	 */

	@Transactional
	public void saveDepartment(Department department) {
		
		Session session = sessionFactory.getCurrentSession();
		Department departmentNew = new Department();
		departmentNew.setDescription(department.getDescription());
		departmentNew.setTitle(department.getTitle());
		session.save(departmentNew);
		session.flush();
		session.clear();

	}

	/* (non-Javadoc)
	 * @see com.spring.hibernate.dao.DepartmentDao#updateDepartment(com.spring.hibernate.Department)
	 */

	@Transactional
	public void updateDepartment(Department department) {

		Session session = sessionFactory.getCurrentSession();
		Department departmentNew = (Department) session.get(Department.class, department.getDepartmentID());
		departmentNew.setDescription(department.getDescription());
		departmentNew.setTitle(department.getTitle());
		session.save(departmentNew);
		session.flush();
		session.clear();

	}

	/* (non-Javadoc)
	 * @see com.spring.hibernate.dao.DepartmentDao#deleteDepartment(java.lang.Long)
	 */

	@Transactional
	public void deleteDepartment(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		Department department = (Department) session.get(Department.class, id);
		session.delete(department);
		session.flush();
		session.clear();
	}

}
