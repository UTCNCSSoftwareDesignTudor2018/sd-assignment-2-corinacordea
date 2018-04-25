package assignment2.business.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import assignment2.business.dto.CourseDto;
import assignment2.business.dto.StudentDto;
import assignment2.data.entity.Course;
import assignment2.data.entity.Student;
import assignment2.data.repository.StudentJpaRepository;

@Service
public class StudentService {
	@Autowired
	StudentJpaRepository studentJpaRepository;
	@Autowired
	StudentService studentService;
	@Autowired
	CourseService courseService;
	public List<StudentDto> getStudents()
	{
		List<StudentDto> studentDtoList = new ArrayList<>();
		List<Student> studentEntityList = studentJpaRepository.findAll(); 
		for (Student s: studentEntityList)
		{
			studentDtoList.add(studentService.getStudentDto(s));
		}
		
		return studentDtoList;
	}
	public StudentDto findByStudentId(int studentId) {
		Student student = studentJpaRepository.findByStudentId(studentId);
		return studentService.getStudentDto(student);
	}
	
	public void saveStudent(StudentDto studentDto) {
		Student student= new Student();
		 studentJpaRepository.save(studentService.getStudent(studentDto, student));
	}
	
	public void updateStudent(StudentDto studentDto, int studentId) {
		Student student = studentJpaRepository.findByStudentId(studentId);
		studentJpaRepository.save(studentService.getStudent(studentDto, student));
	}
	
	public void deleteStudent(int studentId) {
		studentJpaRepository.deleteById(studentId);
	}
	
	public Student getStudent(StudentDto studentDto, Student student) {
		student.setStudentName(studentDto.getStudentName());
		student.setStudentCardNumber(studentDto.getStudentCardNumber());
		student.setStudentPersonalNumericalCode(studentDto.getStudentPersonalNumericalCode());
		student.setStudentAddress(studentDto.getStudentAddress());
		student.setStudentGroup(studentDto.getStudentGroup());
		return student;
	}
	public StudentDto getStudentDto(Student student) {
		StudentDto studentDto= new StudentDto();
		studentDto.setStudentId(student.getStudentId());
		studentDto.setStudentName(student.getStudentName());
		studentDto.setStudentCardNumber(student.getStudentCardNumber());
		studentDto.setStudentPersonalNumericalCode(student.getStudentPersonalNumericalCode());
		studentDto.setStudentAddress(student.getStudentAddress());
		studentDto.setStudentGroup(student.getStudentGroup());
		List<CourseDto> cDto = new ArrayList<>();
		for(Course c: student.getCourses()) {
			cDto.add(courseService.getCourseDto(c));
		}
		studentDto.setCourses(cDto);
		return studentDto;
	}
}
