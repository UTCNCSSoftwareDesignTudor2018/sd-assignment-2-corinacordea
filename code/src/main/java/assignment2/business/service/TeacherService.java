package assignment2.business.service;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import assignment2.business.dto.TeacherDto;
import assignment2.data.entity.Course;
import assignment2.data.entity.Report;
import assignment2.data.entity.Student;
import assignment2.data.entity.Teacher;
import assignment2.data.repository.StudentJpaRepository;
import assignment2.data.repository.TeacherJpaRepository;
@Service
public class TeacherService {
	@Autowired
	TeacherJpaRepository teacherJpaRepository;
	@Autowired
	StudentJpaRepository studentJpaRepository;
	@Autowired
	TeacherService teacherService;
	public TeacherDto findByTeacherId(int teacherId) {
		Teacher teacher = teacherJpaRepository.findByTeacherId(teacherId);
		return teacherService.getTeacherDto(teacher);
	}
	public Teacher findById(int teacherId) {
		return teacherJpaRepository.findByTeacherId(teacherId);
	}
	public Teacher getTeacher(TeacherDto teacherDto, Teacher teacher) {
		teacher.setTeacherName(teacherDto.getTeacherName());
		teacher.setTeacherAddress(teacherDto.getTeacherAddress());
		teacher.setTeacherPersonalNumericalCode(teacherDto.getTeacherPersonalNumericalCode());
		return teacher;
	}
	public TeacherDto getTeacherDto(Teacher teacher) {
		TeacherDto teacherDto= new TeacherDto();
		teacherDto.setTeacherId(teacher.getTeacherId());
		teacherDto.setTeacherName(teacher.getTeacherName());
		teacherDto.setTeacherAddress(teacher.getTeacherAddress());
		teacherDto.setTeacherPersonalNumericalCode(teacher.getTeacherPersonalNumericalCode());
		return teacherDto;
	}
	
	public List<TeacherDto> getTeachers() {
		List<TeacherDto> listTeacherDto = new ArrayList<>();
		List<Teacher> teachers = teacherJpaRepository.findAll();
		for(Teacher t: teachers) {
			listTeacherDto.add(teacherService.getTeacherDto(t));
		}
		return listTeacherDto;
	}
	
	public void createReport(int studentId) {
		
		Student student = studentJpaRepository.findByStudentId(studentId);
		List<Course> courses = student.getCourses();
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase database = mongoClient.getDatabase("student_reports");
		MongoCollection<Document> reports = database.getCollection("reports"+studentId);
		for(Course course: courses) {
			Report report = new Report.ReportBuilder().studentName(student.getStudentName()).
					studentGroup(student.getStudentGroup()).
					courseId(course.getCourseId().toString()).
					courseName(course.getCourseName()).create();
			Document doc = new Document().append("Student Name", report.getStudentName()).
					append("Student Group", report.getStudentGroup()).
					append("Course Id", report.getCourseId()).
					append("Course Name", report.getCourseName());
			
			reports.insertOne(doc);
		}
		mongoClient.close();
	}
}
