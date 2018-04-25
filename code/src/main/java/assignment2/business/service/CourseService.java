package assignment2.business.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import assignment2.business.dto.CourseDto;
import assignment2.data.entity.Course;
import assignment2.data.repository.CourseJpaRepository;

@Service
public class CourseService {
	@Autowired
	CourseJpaRepository courseJpaRepository;
	@Autowired
	CourseService courseService;
	@Autowired
	TeacherService teacherService;
	public List<CourseDto> getCourses(){
		List<CourseDto> courseDtoList = new ArrayList<>();
		List<Course> courses = courseJpaRepository.findAll();
		for(Course c: courses) {
			courseDtoList.add(courseService.getCourseDto(c));
		}
		return courseDtoList;
	}
	public CourseDto getCourseDto(Course course) {
		CourseDto courseDto= new CourseDto();
		courseDto.setCourseId(course.getCourseId());
		courseDto.setCourseName(course.getCourseName());
		courseDto.setTeacherId(course.getTeacher().getTeacherId());
		courseDto.setTeacher(course.getTeacher());
		return courseDto;
	}
	public void saveCourse(CourseDto courseDto) {
		Course course= new Course();
		course.setCourseName(courseDto.getCourseName());
		course.setTeacher(teacherService.findById(courseDto.getTeacherId()));
		courseJpaRepository.save(course);
	}
}
