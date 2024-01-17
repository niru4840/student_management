package com.qsp.student_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.student_management.dto.Student;
import com.qsp.student_management.service.StudentService;
import com.qsp.student_management.util.StudentResponse;

@RestController
public class StudentController {
	
	
	@Autowired
	private StudentService service;
	
	@PostMapping("/save")
	public ResponseEntity<StudentResponse<Student>> saveStudent(@RequestBody Student student) {
		
		return service.saveStudent(student);
	}
	
	@GetMapping("/fetch")
	public ResponseEntity<StudentResponse<Student>> findStudent(@RequestParam int id) {
		
		return service.findStudent(id);
	}
	
	@GetMapping("/fetchAll")
	public ResponseEntity<StudentResponse<List<Student>>> findAllStudent() {
		
		return service.findAllStudent();
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<StudentResponse<Student>> deleteStudent(@PathVariable int  id) {
		
		return service.deleteStudent(id);
	}
	
	@PutMapping("/update")
	public ResponseEntity<StudentResponse<Student>> updateStudent(@RequestParam int id, @RequestBody Student student) {
		
		return service.updateStudent(id, student);
	}
	
	@PostMapping("/saveAll")
	public ResponseEntity<StudentResponse<List<Student>>> saveAllStudent(@RequestBody List<Student> students){
		
		return service.saveAllStudent(students);
	}
	
	@PatchMapping("/updatePhone")
	public ResponseEntity<StudentResponse<Student>> updatePhone(int id , long phone) {
		return service.updatePhone(id,phone);
	}
	
	@PatchMapping("/updateEmail")
	public ResponseEntity<StudentResponse<Student>> updateEmail(int id , String email) {
		return service.updateEmail(id,email);
	}
	
	@GetMapping("/findByPhone")
	public ResponseEntity<StudentResponse<Student>> findByPhone(long phone) {
		return service.findByPhone(phone);
		
	}
	
	@GetMapping("/findByEmail")
	public ResponseEntity<StudentResponse<Student>> findByEmail(String email) {
		return service.findByEmail(email);
		
	}
	
	@GetMapping("/findByName")
	public ResponseEntity<StudentResponse<List<Student>>> findByName(String name)
	{
		return service.findByName(name);
	}
	
	@GetMapping("/findByCity")
	public ResponseEntity<StudentResponse<List<Student>>> findByCity(String city)
	{
		return service.findByCity(city);
	}
	
	@GetMapping("/findByGrade")
	public ResponseEntity<StudentResponse<List<Student>>> findByGrade(String grade){
		return service.findByGrade(grade);
	}
	
	@GetMapping("/percentLessThan")
	public ResponseEntity<StudentResponse<List<Student>>> findByPercentLessThan(double percent) {
		return service.findPercentLessThan(percent);
	}
	
	@GetMapping("/percentGreaterThan")
	public ResponseEntity<StudentResponse<List<Student>>> findByPercentGreaterThan(double percent) {
		return service.findPercentGreaterThan(percent);
	}
	
	@GetMapping("/percentBetween")
	public ResponseEntity<StudentResponse<List<Student>>> percentBetween(double percent1 , double percent2) {
		return service.percentBetween(percent1, percent2);
	}
	
	@PatchMapping("/updatePercent")
	public ResponseEntity<StudentResponse<Student>> updatePercent(int id , int obtainMarks, int totalMarks) {
		return service.updatePercent(id, obtainMarks, totalMarks);
	}
}