package assignment2.presentation.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import assignment2.business.dto.EnrolmentDto;
import assignment2.business.service.EnrolmentService;
import assignment2.business.service.TeacherService;
import assignment2.presentation.view.EnrolmentView;

@Controller
public class EnrolmentController {
	@Autowired
	EnrolmentView enrolmentView;
	@Autowired
	EnrolmentService enrolmentService;
	@Autowired
	TeacherService teacher;
	@Autowired
	EnrolmentService enrolment;
	public EnrolmentController(EnrolmentView ev) {
		super();
		this.enrolmentView = ev;
		enrolmentView.setEnrolStudentActionListener(new EnrolStudentActionListener());
	}
	
	private class EnrolStudentActionListener implements ActionListener{
			public void actionPerformed(ActionEvent event){
				try {				
					int studentId = Integer.parseInt(enrolmentView.getEnrolStudentTextField().getText());
					int courseId = Integer.parseInt(enrolmentView.getEnrolCourseTextField().getText());
					EnrolmentDto enrolmentDto = new EnrolmentDto();
					enrolmentDto.setStudentId(studentId);
					enrolmentDto.setCourseId(courseId);
					enrolmentDto.setExamId(11);
					enrolmentService.saveEnrolment(enrolmentDto);
					List<EnrolmentDto> enrolmentsList = enrolment.getEnrolments();
					DefaultTableModel modelEnrolments = enrolmentView.getEnrolmentTableModel();
					enrolmentView.getEnrolStudents().setModel(modelEnrolments);
					for(EnrolmentDto eDto: enrolmentsList) {
						int id = eDto.getEnrolmentId();
						int sId = eDto.getStudent().getStudentId();
						String studentName = eDto.getStudent().getStudentName();
						int cId = eDto.getCourse().getCourseId();
						String courseName = eDto.getCourse().getCourseName();
						int teacherId = eDto.getCourse().getTeacher().getTeacherId();
						String teacherName = eDto.getCourse().getTeacher().getTeacherName();
						String grade= eDto.getExam().getGrade();
						modelEnrolments.addRow(new Object[]{id, sId, studentName, cId, courseName, teacherId, teacherName, grade});
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				enrolmentView.getEnrolFrame().repaint();			
			}
	}
}
