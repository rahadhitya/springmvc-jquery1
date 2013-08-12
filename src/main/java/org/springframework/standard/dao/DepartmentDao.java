/**
 * 
 */
package org.springframework.standard.dao;

import java.util.List;

import org.springframework.standard.model.Department;

/**
 * @author Radhit
 *
 */
public interface DepartmentDao {
	public List<Department> getAllDepartment();
	public Department getSingleDepartment(Department department);
	public Department findDepartmentById(int iRowIndx);
	public void saveDepartment(Department department);
	public void updateDepartment(Department department);
	public void deleteDepartment(int id);
}
