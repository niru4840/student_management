package com.qsp.student_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.qsp.student_management.dao.StudentDao;
import com.qsp.student_management.dto.Student;
import com.qsp.student_management.exceptions.DataNotAvailable;
import com.qsp.student_management.exceptions.EmailNotFound;
import com.qsp.student_management.exceptions.IdNotFound;
import com.qsp.student_management.exceptions.PhoneNotAvailable;
import com.qsp.student_management.util.StudentResponse;

@Service
public class StudentService {
	@Autowired
	private StudentDao dao;

	public ResponseEntity<StudentResponse<Student>> saveStudent(Student student) {
		StudentResponse<Student> response = new StudentResponse<Student>();
		if(student.getObtainMarks()<student.getTotalMarks() && student.getObtainMarks()>0 && student.getTotalMarks()>0) {
			
			double percent = Math.round(calculatePercent(student.getObtainMarks(), student.getTotalMarks())*100.0)/100.0;
			//student.setPercentage(90);
			student.setPercentage(percent);
			if(percent<35) {
				student.setGrade("Fail");
			}
			else if(percent>=35 && percent<50) {
				student.setGrade("Pass");
			}
			else if(percent>=50 && percent<70) {
				student.setGrade("Second Class");
			}
			else if(percent>=70 && percent<85) {
				student.setGrade("First Class");
			}
			else if(percent>=85 && percent<101) {
				student.setGrade("Distinction");
			}
			response.setMessage("Data Saved Successfully");
			response.setStatus(HttpStatus.CREATED.value());
			response.setData(dao.saveStudent(student));
			//return response;
			return new ResponseEntity<StudentResponse<Student>>(response,HttpStatus.CREATED);
		}
		return null; 
	}
	
	private double calculatePercent(int obtainMarks , int totalMarks) {
		return (totalMarks>0)?((double)obtainMarks/totalMarks)*100:0.0;
	}
	
	public ResponseEntity<StudentResponse<Student>> findStudent(int id) {
		StudentResponse<Student> response = new StudentResponse<Student>();
		Student student = dao.findStudent(id);
		if(student!=null) {
			response.setMessage("Data Found");
			response.setStatus(HttpStatus.FOUND.value());
			response.setData(student);
//			return response;
			return new ResponseEntity<StudentResponse<Student>>(response,HttpStatus.FOUND);
		}
		else {
//			response.setMessage("Data Not Found");
//			response.setStatus(HttpStatus.NOT_FOUND.value());
//			response.setData(student);
//			return response;
			throw new IdNotFound("Student ID not Found");
		}
	}
	
	public ResponseEntity<StudentResponse<List<Student>>> findAllStudent(){
		StudentResponse<List<Student>> response = new StudentResponse<List<Student>>();
		List<Student> student = dao.findAllStudent();
		if(student.isEmpty()) {
//			response.setMessage("Data not Found");
//			response.setStatus(HttpStatus.NOT_FOUND.value());
//			response.setData(student);
////			return response;
			throw new DataNotAvailable("No Employee Found");
			
		}
		else {
			response.setMessage("Data Found");
			response.setStatus(HttpStatus.FOUND.value());
			response.setData(student);
//			return response;
			return new ResponseEntity<StudentResponse<List<Student>>>(response,HttpStatus.FOUND);
		}
	}
	
	public ResponseEntity<StudentResponse<Student>> deleteStudent(int id) {
		StudentResponse<Student> response = new StudentResponse<Student>();
		Student student = dao.findStudent(id);
		if (student!=null) {
			response.setMessage("Deleted SuccessFully");
			response.setStatus(HttpStatus.OK.value());
			response.setData(dao.deleteStudent(id));
//			return response;
			return new ResponseEntity<StudentResponse<Student>>(response,HttpStatus.OK);
			
		} else {
			throw new IdNotFound("Student id not found");
//			response.setMessage("Data Not Found");
//			response.setStatus(HttpStatus.NOT_FOUND.value());
//			response.setData(student);
//			return response;

		}
	}
	
	public ResponseEntity<StudentResponse<Student>> updateStudent(int id, Student student) {
		StudentResponse<Student> response = new StudentResponse<Student>();
		Student s1 = dao.findStudent(id);
		if(s1!=null) {
			if(student.getObtainMarks()<student.getTotalMarks() && student.getObtainMarks()>0 && student.getTotalMarks()>0) {
				
				double percent = Math.round(calculatePercent(student.getObtainMarks(), student.getTotalMarks())*100.0)/100.0;
				student.setId(id);
				student.setPercentage(percent);
				if(percent<35) {
					student.setGrade("Fail");
				}
				else if(percent>=35 && percent<50) {
					student.setGrade("Pass");
				}
				else if(percent>=50 && percent<70) {
					student.setGrade("Second Class");
				}
				else if(percent>=70 && percent<85) {
					student.setGrade("First Class");
				}
				else if(percent>=85 && percent<101) {
					student.setGrade("Distinction");
				}
			}
			response.setMessage("Updated Successfully");
			response.setStatus(HttpStatus.OK.value());
			response.setData(dao.updateStudent(id, student));
//			return response;
			return new ResponseEntity<StudentResponse<Student>>(HttpStatus.OK);
		}
		else {
			throw new IdNotFound("Student Id Not Found");
//			response.setMessage("Data Not Found");
//			response.setStatus(HttpStatus.NOT_FOUND.value());
//			response.setData(s1);
//			return response;
		}	
	}
	
	public ResponseEntity<StudentResponse<List<Student>>> saveAllStudent(List<Student> students){
		StudentResponse<List<Student>> response = new StudentResponse<List<Student>>();
		for (Student student : students) { 

		if(student.getObtainMarks()<student.getTotalMarks() && student.getObtainMarks()>0 && student.getTotalMarks()>0) {
			
			double percent = Math.round(calculatePercent(student.getObtainMarks(), student.getTotalMarks())*100.0)/100.0;
			student.setPercentage(percent);
			if(percent<35) {
				student.setGrade("Fail");
			}
			else if(percent>=35 && percent<50) {
				student.setGrade("Pass");
			}
			else if(percent>=50 && percent<70) {
				student.setGrade("Second Class");
			}
			else if(percent>=70 && percent<85) {
				student.setGrade("First Class");
			}
			else if(percent>=85 && percent<101) {
				student.setGrade("Distinction");
			}
			response.setMessage("Data Saved Successfully");
			response.setStatus(HttpStatus.CREATED.value());
			response.setData(dao.saveAllStudent(students));
//			return response;
			return new ResponseEntity<StudentResponse<List<Student>>>(response,HttpStatus.CREATED);
		}
		}
		return null;
	}
	
	public ResponseEntity<StudentResponse<Student>> updatePhone(int id, long phone) {
		StudentResponse<Student> response = new StudentResponse<Student>();
		Student student = dao.findStudent(id);
		if (student!=null) {
			student.setPhone(phone);
			response.setMessage("Phone Updated Succeed");
			response.setStatus(HttpStatus.OK.value());
			response.setData(dao.saveStudent(student));
//			return response;
			return new ResponseEntity<StudentResponse<Student>>(response,HttpStatus.OK);
			
		} else {
			throw new IdNotFound("Student Id not found");
//			response.setMessage("Data not found");
//			response.setStatus(HttpStatus.NOT_FOUND.value());
//			response.setData(student);
//			return response;
		}
	}
	
	public ResponseEntity<StudentResponse<Student>> updateEmail(int id, String email) {
		StudentResponse<Student> response = new StudentResponse<Student>();
		Student student = dao.findStudent(id);
		if (student!=null) {
			student.setEmail(email);
			response.setMessage("Email Updated Succeed");
			response.setStatus(HttpStatus.OK.value());
			response.setData(dao.saveStudent(student));
//			return response;
			return new ResponseEntity<StudentResponse<Student>>(response,HttpStatus.OK);
			
		} else {
			throw new IdNotFound("Student id not found");
//			response.setMessage("Data not found");
//			response.setStatus(HttpStatus.NOT_FOUND.value());
//			response.setData(student);
//			return response;
		}
	}
	
	public ResponseEntity<StudentResponse<Student>> findByPhone(long phone) {
		
		StudentResponse<Student> response = new StudentResponse<Student>();
		Student student = dao.findByPhone(phone);
		if(student!=null) {
			response.setMessage("Data Found");
			response.setStatus(HttpStatus.FOUND.value());
			response.setData(dao.findByPhone(phone));
//			return response;
			return new ResponseEntity<StudentResponse<Student>>(response,HttpStatus.FOUND);
		}
		else {
			throw new PhoneNotAvailable("Student Phone not Found");
//			response.setMessage("Data Not Found");
//			response.setStatus(HttpStatus.NOT_FOUND.value());
//			response.setData(student);
//			return response;
		}
	}
	
public ResponseEntity<StudentResponse<Student>> findByEmail(String email) {
		
		StudentResponse<Student> response = new StudentResponse<Student>();
		Student student = dao.findByEmail(email);
		if(student!=null) {
			response.setMessage("Data Found");
			response.setStatus(HttpStatus.FOUND.value());
			response.setData(dao.findByEmail(email));
//			return response;
			return new ResponseEntity<StudentResponse<Student>>(response,HttpStatus.FOUND);
		}
		else {
			throw new EmailNotFound("Student Mail not found");
//			response.setMessage("Data Not Found");
//			response.setStatus(HttpStatus.NOT_FOUND.value());
//			response.setData(student);
//			return response;
		}
	}

public ResponseEntity<StudentResponse<List<Student>>> findByName(String name) {
	
	StudentResponse<List<Student>> response = new StudentResponse<List<Student>>();
	List<Student> student = dao.findByName(name);
	if(student.isEmpty()) {
		throw new DataNotAvailable("NNo data avaialble");
//		response.setMessage("Data Not Found");
//		response.setStatus(HttpStatus.NOT_FOUND.value());
//		response.setData(student);
//		return response;
	}
	else {
		response.setMessage("Data Found");
		response.setStatus(HttpStatus.FOUND.value());
		response.setData(dao.findByName(name));
//		return response;
		return new ResponseEntity<StudentResponse<List<Student>>>(response,HttpStatus.FOUND);
	}
}

	public ResponseEntity<StudentResponse<List<Student>>> findByCity(String city) {
	
		StudentResponse<List<Student>> response = new StudentResponse<List<Student>>();
		List<Student> student = dao.findByCity(city);
		if(student.isEmpty()) {
//		response.setMessage("Data Not Found");
//		response.setStatus(HttpStatus.NOT_FOUND.value());
//		response.setData(student);
//		return response;
			throw new DataNotAvailable("No Data Avilable");
	}
		else {
			response.setMessage("Data Found");
			response.setStatus(HttpStatus.FOUND.value());
			response.setData(dao.findByCity(city));
//			return response;
			return new ResponseEntity<StudentResponse<List<Student>>>(response,HttpStatus.FOUND);
		}
	}	
	
	public ResponseEntity<StudentResponse<List<Student>>> findByGrade(String grade) {
		
		StudentResponse<List<Student>> response = new StudentResponse<List<Student>>();
		List<Student> student = dao.findByGrade(grade);
		if(student.isEmpty()) {
			throw new DataNotAvailable("Datanot available");
//		response.setMessage("Data Not Found");
//		response.setStatus(HttpStatus.NOT_FOUND.value());
//		response.setData(student);
//		return response;
	}
		else {
			response.setMessage("Data Found");
			response.setStatus(HttpStatus.FOUND.value());
			response.setData(dao.findByGrade(grade));
//			return response;
			return new ResponseEntity<StudentResponse<List<Student>>>(response,HttpStatus.FOUND);
		}
	}	
	
	public ResponseEntity<StudentResponse<List<Student>>> findPercentLessThan(double percent) {
		
		StudentResponse<List<Student>> response = new StudentResponse<List<Student>>();
		List<Student> student = dao.percentLessThan(percent);
		if(student.isEmpty()) {
//		response.setMessage("Data Not Found");
//		response.setStatus(HttpStatus.NOT_FOUND.value());
//		response.setData(student);
//		return response;
			throw new DataNotAvailable("No Student Found");
	}
		else {
			response.setMessage("Data Found");
			response.setStatus(HttpStatus.FOUND.value());
			response.setData(dao.percentLessThan(percent));
//			return response;
			return new ResponseEntity<StudentResponse<List<Student>>>(response,HttpStatus.FOUND);
		}
	}
	
public ResponseEntity<StudentResponse<List<Student>>> findPercentGreaterThan(double percent) {
		
		StudentResponse<List<Student>> response = new StudentResponse<List<Student>>();
		List<Student> student = dao.percentGreaterThan(percent);
		if(student.isEmpty()) {
//		response.setMessage("Data Not Found");
//		response.setStatus(HttpStatus.NOT_FOUND.value());
//		response.setData(student);
//		return response;
			throw new DataNotAvailable("No Daata Available");
	}
		else {
			response.setMessage("Data Found");
			response.setStatus(HttpStatus.FOUND.value());
			response.setData(dao.percentGreaterThan(percent));
//			return response;
			return new ResponseEntity<StudentResponse<List<Student>>>(response,HttpStatus.FOUND);
		}
	}

public ResponseEntity<StudentResponse<List<Student>>> percentBetween(double percent1,double percent2) {
	
	StudentResponse<List<Student>> response = new StudentResponse<List<Student>>();
	List<Student> student = dao.percentBetween(percent1,percent2);
	if(student.isEmpty()) {
//	response.setMessage("Data Not Found");
//	response.setStatus(HttpStatus.NOT_FOUND.value());
//	response.setData(student);
//	return response;
		throw new DataNotAvailable("No data Available");
}
	else {
		response.setMessage("Data Found");
		response.setStatus(HttpStatus.FOUND.value());
		response.setData(dao.percentBetween(percent1,percent2));
//		return response;
		return new ResponseEntity<StudentResponse<List<Student>>>(response,HttpStatus.FOUND);
	}
}

public ResponseEntity<StudentResponse<Student>> updatePercent(int id , int obtainMarks , int totalMarks ) {
	StudentResponse<Student> response = new StudentResponse<Student>();
	Student student = dao.findStudent(id);
	if(student!=null) {
		if(student.getObtainMarks()<student.getTotalMarks() && student.getObtainMarks()>0 && student.getTotalMarks()>0) {
			
			student.setObtainMarks(obtainMarks);
			student.setTotalMarks(totalMarks);
			double percent = Math.round(calculatePercent(student.getObtainMarks(), student.getTotalMarks())*100.0)/100.0;

			student.setPercentage(percent);
			if(percent<35) {
				student.setGrade("Fail");
			}
			else if(percent>=35 && percent<50) {
				student.setGrade("Pass");
			}
			else if(percent>=50 && percent<70) {
				student.setGrade("Second Class");
			}
			else if(percent>=70 && percent<85) {
				student.setGrade("First Class");
			}
			else if(percent>=85 && percent<101) {
				student.setGrade("Distinction");
			}
		}
		response.setMessage("Updated Successfully");
		response.setStatus(HttpStatus.OK.value());
		response.setData(dao.saveStudent(student));
//		return response;
		return new ResponseEntity<StudentResponse<Student>>(response,HttpStatus.OK);
	}
	else {
		throw new IdNotFound("Student Id Not Found");
//		response.setMessage("Data Not Found");
//		response.setStatus(HttpStatus.NOT_FOUND.value());
//		response.setData(student);
//		return response;
	}	
}
}
