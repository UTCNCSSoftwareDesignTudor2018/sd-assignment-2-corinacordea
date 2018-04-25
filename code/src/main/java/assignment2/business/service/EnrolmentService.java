package assignment2.business.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import assignment2.business.dto.EnrolmentDto;
import assignment2.data.entity.Enrolment;
import assignment2.data.repository.CourseJpaRepository;
import assignment2.data.repository.EnrolmentJpaRepository;
import assignment2.data.repository.ExamJpaRepository;
import assignment2.data.repository.StudentJpaRepository;

@Service
public class EnrolmentService {
	@Autowired
	EnrolmentJpaRepository enrolmentJpaRepository;
	@Autowired
	CourseJpaRepository courseJpaRepository;
	@Autowired
	StudentJpaRepository studentJpaRepository;
	@Autowired
	ExamJpaRepository examJpaRepository;
	public void saveEnrolment(EnrolmentDto enrolmentDto) {
		 Enrolment enrolment= new Enrolment();
		 enrolment.setStudent(studentJpaRepository.findByStudentId(enrolmentDto.getStudentId()));
		 enrolment.setCourse(courseJpaRepository.findByCourseId(enrolmentDto.getCourseId()));
		 enrolment.setExam(examJpaRepository.findByExamId(enrolmentDto.getExamId()));
		 enrolmentJpaRepository.save(enrolment);
	}
	public void updateGrade(EnrolmentDto enrolmentDto) {
		 Enrolment enrolment=  enrolmentJpaRepository.findByEnrolmentId(enrolmentDto.getEnrolmentId());
		 enrolment.setExam(examJpaRepository.findByExamId(enrolmentDto.getExamId()));
		 enrolmentJpaRepository.save(enrolment);
	}
	public List<EnrolmentDto> getEnrolments(){
		List<EnrolmentDto> enrolmentsDto = new ArrayList<>();
		List<Enrolment> enrolments =  enrolmentJpaRepository.findAll();
		for(Enrolment e: enrolments) {
			EnrolmentDto eDto = new EnrolmentDto();
			eDto.setEnrolmentId(e.getEnrolmentId());
			eDto.setStudent(e.getStudent());
			eDto.setCourse(e.getCourse());
			eDto.setExam(e.getExam());
			enrolmentsDto.add(eDto);
		}
		return enrolmentsDto;
	}
}
