package com.qsp.student_management.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.qsp.student_management.dto.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {
	
	Student findStudentByPhone(long phone);
	
	Student findStudentByEmail(String email);
	
	List<Student> findStudentByName(String name);
	
	List<Student> findStudentByCity(String city);
	
	List<Student> findStudentByGrade(String grade);
	
	List<Student> findStudentsByPercentageLessThan(double percent);
	
	List<Student> findStudentsByPercentageGreaterThan(double percent);
//	
	@Query("SELECT s FROM Student s WHERE s.percentage>=?1 AND s.percentage<=?2")
	//SELECT e FROM Employee e WHERE e.salary Between ?1 AND ?2
	List<Student> studentPercentageBetween(double percent1, double percent2);
		
}
