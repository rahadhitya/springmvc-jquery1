/**
 * 
 */
package org.springframework.standard.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Radhit
 *
 */

	@Entity
	@Table(name = "tbl_departments")

	public class Department implements Serializable {
		private static final long serialVersionUID = 1L;
		
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		
		@Column(name = "DepartmentID", nullable = false)
		private Integer departmentID;
		
		@Column(name = "Title")
		private String title;
		
		@Column(name = "Description")	
		private String description;

		public Integer getDepartmentID() {
			return departmentID;
		}

		public void setDepartmentID(Integer departmentID) {
			this.departmentID = departmentID;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}
		
		
	}



