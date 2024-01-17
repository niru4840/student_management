package com.qsp.student_management.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.student_management.dto.Student;
import com.qsp.student_management.repo.StudentRepo;

@Repository
public class StudentDao {
	
	@Autowired
	private StudentRepo repo;
	
	
	public Student saveStudent(Student student) {
		
		//if(student.getObtainMarks()<student.getTotalMarks()) {
//			int student2 = student.getPercentage();
//			student2=((student.getObtainMarks()/student.getTotalMarks())*100);//
//			student.setPercentage(student2);
			return repo.save(student);
//		}
//		return null;
	}
	
	public Student findStudent(int id) {
		
		Optional<Student> optional = repo.findById(id);
		if(optional.isPresent()) {
			
			return optional.get();
		}
		return null;
	}
	
	public List<Student> findAllStudent(){
		
		return repo.findAll();
	}

	
	public Student deleteStudent(int id) {
		
		Optional<Student> optional = repo.findById(id);
		if(optional.isPresent()) {
			
			repo.deleteById(id);
			return optional.get();
		}
		return null;
	}
	
	
	public Student updateStudent(int id, Student student) {
		
		Optional<Student> optional = repo.findById(id);
		if(optional.isPresent()) {
			
			student.setId(id);
			return repo.save(student);
			
		}
		return null;
		
	}
	
	public List<Student> saveAllStudent(List<Student> students){

		//Student s1 = students.get(0);
		for (Student student : students) {
		
			if(student.getObtainMarks()<student.getTotalMarks()) {
				
				return repo.saveAll(students);
			}
		}
		
		return null;
	}
	
//	public Student updatePhone(int id, long phone) {
//		
//		Optional<Student> optional = repo.findById(id);
//		if(optional.isPresent()) {
//			
//			Student student = optional.get();
//			student.setPhone(phone);
//			return repo.save(student);
//		}
//		return null;
//	}
	
public Student updateEmail(int id, String email) {
		
		Optional<Student> optional = repo.findById(id);
		if(optional.isPresent()) {
			
			Student student = optional.get();
			student.setEmail(email);
			return repo.save(student);
		}
		return null;
	}
	
	public Student findByPhone(long phone) {
		
		return repo.findStudentByPhone(phone);
	}
	
	public Student findByEmail(String email) {
		return repo.findStudentByEmail(email);
	}
	
	public List<Student> findByName(String name){
		return repo.findStudentByName(name);
	}
	
	public List<Student> findByCity(String city){
		
		return repo.findStudentByCity(city);
	}
	
	public List<Student> findByGrade(String grade){
		return repo.findStudentByGrade(grade);
	}
	
	public List<Student> percentLessThan(double percent){
		return repo.findStudentsByPercentageLessThan(percent);
	}
	
	public List<Student> percentGreaterThan(double percent){
		return repo.findStudentsByPercentageGreaterThan(percent);
	}
	
	public List<Student> percentBetween(double percent1, double percent2){
		return repo.studentPercentageBetween(percent1, percent2);
	}
	
//	public Student updatePercent(int id, int obtainMarks, int totalMarks) {
//		return repo.save(student)
//	}
}
