package assignment2.presentation.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import assignment2.business.dto.CourseDto;
import assignment2.business.dto.EnrolmentDto;
import assignment2.business.dto.StudentDto;
import assignment2.business.dto.TeacherDto;
import assignment2.business.service.CourseService;
import assignment2.business.service.EnrolmentService;
import assignment2.business.service.StudentService;
import assignment2.business.service.TeacherService;
import assignment2.presentation.view.CourseView;
import assignment2.presentation.view.EnrolmentView;
import assignment2.presentation.view.TeacherView;

@Controller
public class TeacherController {
	@Autowired
    TeacherView teacherView;
	@Autowired
	TeacherService teacher;
	@Autowired
	StudentService student;
	@Autowired
	EnrolmentView enrolmentView;
	@Autowired
	EnrolmentController enrolmentController;
	@Autowired
	CourseService course;
	@Autowired
	EnrolmentService enrolment;
	@Autowired
	CourseView courseView;
	@Autowired
	CourseController courseController;
	public TeacherController(TeacherView tv) {
		super();
		this.teacherView = tv;
		teacherView.setViewButtonActionListener(new ViewButtonActionListener());
		teacherView.setUpdateButtonActionListener(new UpdateButtonActionListener());
		teacherView.setUpdateStudentButtonActionListener(new UpdateStudentButtonActionListener());
		teacherView.setDeleteButtonActionListener(new DeleteButtonActionListener());
		teacherView.setDeleteStudentButtonActionListener(new DeleteStudentButtonActionListener());
		teacherView.setEnrollButtonActionListener(new EnrollButtonActionListener());
		teacherView.setAddCourseButtonActionListener(new AddCourseButtonActionListener());
		teacherView.setGiveGradeButtonActionListener(new GiveGradeButtonActionListener());
		teacherView.setAddGradeButtonActionListener(new AddGradeButtonActionListener());
		teacherView.setReportButtonActionListener(new ReportButtonActionListener());
		teacherView.setStudentReportButtonActionListener(new StudentReportButtonActionListener());
	}
	private class ViewButtonActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			List<StudentDto> studentsList = student.getStudents();
			try {
				teacherView.viewStudents();
				DefaultTableModel model = teacherView.getStudentCourseTableModel();
				teacherView.getStudents().setModel(model);
				for(StudentDto sDto: studentsList) {
					int id = sDto.getStudentId();
					String name = sDto.getStudentName();
					String cardNumber = sDto.getStudentCardNumber();
					String personalNumericalCode = sDto.getStudentPersonalNumericalCode();
					String address = sDto.getStudentAddress();
					String group = sDto.getStudentGroup();
					for(CourseDto c: sDto.getCourses()) {
					model.addRow(new Object[]{id, name, cardNumber, personalNumericalCode, address, group, c.getCourseId(), c.getCourseName()});
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			teacherView.getViewFrame().setVisible(true);
		}
		
	}
	
	private class UpdateButtonActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			List<StudentDto> studentsList = student.getStudents();
			try {
				teacherView.updateStudent();
				DefaultTableModel model = teacherView.getStudentTableModel();
				teacherView.getUpdateStudents().setModel(model);
				for(StudentDto sDto: studentsList) {
					int id = sDto.getStudentId();
					String name = sDto.getStudentName();
					String cardNumber = sDto.getStudentCardNumber();
					String personalNumericalCode = sDto.getStudentPersonalNumericalCode();
					String address = sDto.getStudentAddress();
					String group = sDto.getStudentGroup();
					model.addRow(new Object[]{id, name, cardNumber, personalNumericalCode, address, group });
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			teacherView.getUpdateFrame().setVisible(true);
		}
		
	}
	
	private class UpdateStudentButtonActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				int idStudent = Integer.parseInt(teacherView.getUpdateTextField().getText());
				String groupStudent = teacherView.getUpdateGroupTextField().getText();
				StudentDto studentDto = student.findByStudentId(idStudent);
				studentDto.setStudentGroup(groupStudent);
				student.updateStudent(studentDto, idStudent);
				List<StudentDto> studentsList = student.getStudents();
				DefaultTableModel model = teacherView.getStudentTableModel();
				teacherView.getUpdateStudents().setModel(model);
				for(StudentDto sDto: studentsList) {
					int id = sDto.getStudentId();
					String name = sDto.getStudentName();
					String cardNumber = sDto.getStudentCardNumber();
					String personalNumericalCode = sDto.getStudentPersonalNumericalCode();
					String address = sDto.getStudentAddress();
					String group = sDto.getStudentGroup();
					model.addRow(new Object[]{id, name, cardNumber, personalNumericalCode, address, group });
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			teacherView.getUpdateFrame().repaint();
		}
		
	}
	
	private class DeleteButtonActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			List<StudentDto> studentsList = student.getStudents();
			try {
				teacherView.deleteStudent();
				DefaultTableModel model = teacherView.getStudentTableModel();
				teacherView.getDeleteStudents().setModel(model);
				for(StudentDto sDto: studentsList) {
					int id = sDto.getStudentId();
					String name = sDto.getStudentName();
					String cardNumber = sDto.getStudentCardNumber();
					String personalNumericalCode = sDto.getStudentPersonalNumericalCode();
					String address = sDto.getStudentAddress();
					String group = sDto.getStudentGroup();
					model.addRow(new Object[]{id, name, cardNumber, personalNumericalCode, address, group });
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			teacherView.getDeleteFrame().setVisible(true);
		}
		
	}
	
	private class DeleteStudentButtonActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				int idStudent = Integer.parseInt(teacherView.getDeleteTextField().getText());
				student.deleteStudent(idStudent);
				List<StudentDto> studentsList = student.getStudents();
				DefaultTableModel model = teacherView.getStudentTableModel();
				teacherView.getDeleteStudents().setModel(model);
				for(StudentDto sDto: studentsList) {
					int id = sDto.getStudentId();
					String name = sDto.getStudentName();
					String cardNumber = sDto.getStudentCardNumber();
					String personalNumericalCode = sDto.getStudentPersonalNumericalCode();
					String address = sDto.getStudentAddress();
					String group = sDto.getStudentGroup();
					model.addRow(new Object[]{id, name, cardNumber, personalNumericalCode, address, group });
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			teacherView.getDeleteFrame().repaint();
		}
		
	}
	private class EnrollButtonActionListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			enrolmentView.getEnrolFrame().setVisible(true);
			try {
				List<StudentDto> studentsList = student.getStudents();
				DefaultTableModel model = teacherView.getStudentPartialTableModel();
				enrolmentView.getViewStudents().setModel(model);
				for(StudentDto sDto: studentsList) {
					int id = sDto.getStudentId();
					String name = sDto.getStudentName();
					String cardNumber = sDto.getStudentCardNumber();
					String personalNumericalCode = sDto.getStudentPersonalNumericalCode();
					String address = sDto.getStudentAddress();
					String group = sDto.getStudentGroup();
					model.addRow(new Object[]{id, name, cardNumber, personalNumericalCode, address, group });
				}
				List<CourseDto> coursesList = course.getCourses();
				DefaultTableModel modelCourses = teacherView.getCourseTableModel();
				enrolmentView.getViewCourses().setModel(modelCourses);
				for(CourseDto cDto: coursesList) {
					int id = cDto.getCourseId();
					String name = cDto.getCourseName();
					int teacherId = cDto.getTeacherId();
					String teacherName = cDto.getTeacher().getTeacherName();
					modelCourses.addRow(new Object[]{teacherId, teacherName,id, name});
				}
				List<EnrolmentDto> enrolmentsList = enrolment.getEnrolments();
				DefaultTableModel modelEnrolments = enrolmentView.getEnrolmentTableModel();
				enrolmentView.getEnrolStudents().setModel(modelEnrolments);
				for(EnrolmentDto eDto: enrolmentsList) {
					int id = eDto.getEnrolmentId();
					int studentId = eDto.getStudent().getStudentId();
					String studentName = eDto.getStudent().getStudentName();
					int courseId = eDto.getCourse().getCourseId();
					String courseName = eDto.getCourse().getCourseName();
					int teacherId = eDto.getCourse().getTeacher().getTeacherId();
					String teacherName = eDto.getCourse().getTeacher().getTeacherName();
					String grade= eDto.getExam().getGrade();
					modelEnrolments.addRow(new Object[]{id,studentId, studentName, courseId, courseName, teacherId, teacherName, grade});
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private class AddCourseButtonActionListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			courseView.getCourseFrame().setVisible(true);
			try {
				List<TeacherDto> teachersList = teacher.getTeachers();
				DefaultTableModel modelTeacher = teacherView.getTeacherTableModel();
				courseView.getViewTeachers().setModel(modelTeacher);
				for(TeacherDto tDto: teachersList) {
					int id = tDto.getTeacherId();
					String name = tDto.getTeacherName();
					String personalNumericalCode = tDto.getTeacherPersonalNumericalCode();
					String address = tDto.getTeacherAddress();
					modelTeacher.addRow(new Object[]{id, name, personalNumericalCode, address});
				}
				List<CourseDto> courses = course.getCourses();
				DefaultTableModel model = courseView.getCourseTableModel();
				courseView.getViewCourses().setModel(model);
				for(CourseDto course: courses) {
					int id = course.getCourseId();
					String name = course.getCourseName();
					model.addRow(new Object[]{id, name});
				}
				List<CourseDto> coursesList = course.getCourses();
				DefaultTableModel modelCourses = teacherView.getCourseTableModel();
				courseView.getCourses().setModel(modelCourses);
				for(CourseDto courseDto: coursesList) {
					int id = courseDto.getCourseId();
					String courseName = courseDto.getCourseName();
					int teacherId = courseDto.getTeacherId();
					String teacherName = courseDto.getTeacher().getTeacherName();
					modelCourses.addRow(new Object[]{teacherId, teacherName,id, courseName});
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	private class GiveGradeButtonActionListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			teacherView.giveGrade();
			try {				
				List<EnrolmentDto> enrolmentsList = enrolment.getEnrolments();
				DefaultTableModel modelEnrolments = enrolmentView.getEnrolmentTableModel();
				teacherView.getGradeStudents().setModel(modelEnrolments);
				for(EnrolmentDto eDto: enrolmentsList) {
					int id = eDto.getEnrolmentId();
					int studentId = eDto.getStudent().getStudentId();
					String studentName = eDto.getStudent().getStudentName();
					int courseId = eDto.getCourse().getCourseId();
					String courseName = eDto.getCourse().getCourseName();
					int teacherId = eDto.getCourse().getTeacher().getTeacherId();
					String teacherName = eDto.getCourse().getTeacher().getTeacherName();
					String grade= eDto.getExam().getGrade();
					modelEnrolments.addRow(new Object[]{id,studentId, studentName, courseId, courseName, teacherId, teacherName, grade});
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			teacherView.getGradeFrame().setVisible(true);
		}
	}
	private class AddGradeButtonActionListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			try {				
				int idEnrolment = Integer.parseInt(teacherView.getIdEnrolmentTextField().getText());
				int gradeGiven = Integer.parseInt(teacherView.getGradeTextField().getText());
				EnrolmentDto enrolmentDto = new EnrolmentDto();
				enrolmentDto.setEnrolmentId(idEnrolment);
				enrolmentDto.setExamId(gradeGiven);
				enrolment.updateGrade(enrolmentDto);
				List<EnrolmentDto> enrolmentsList = enrolment.getEnrolments();
				DefaultTableModel modelEnrolments = enrolmentView.getEnrolmentTableModel();
				teacherView.getGradeStudents().setModel(modelEnrolments);
				for(EnrolmentDto eDto: enrolmentsList) {
					int id = eDto.getEnrolmentId();
					int studentId = eDto.getStudent().getStudentId();
					String studentName = eDto.getStudent().getStudentName();
					int courseId = eDto.getCourse().getCourseId();
					String courseName = eDto.getCourse().getCourseName();
					int teacherId = eDto.getCourse().getTeacher().getTeacherId();
					String teacherName = eDto.getCourse().getTeacher().getTeacherName();
					String grade= eDto.getExam().getGrade();
					modelEnrolments.addRow(new Object[]{id,studentId, studentName, courseId, courseName, teacherId, teacherName, grade});
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			teacherView.getGradeFrame().repaint();
		}
	}
	private class ReportButtonActionListener implements ActionListener{

		public void actionPerformed(ActionEvent event){
			teacherView.generateReport();
			try {		
				DefaultTableModel model = teacherView.getStudentTableModel();
				teacherView.getStudentsReport().setModel(model);
				List<StudentDto> studentsList = student.getStudents();
				for(StudentDto sDto: studentsList) {
					int id = sDto.getStudentId();
					String name = sDto.getStudentName();
					String cardNumber = sDto.getStudentCardNumber();
					String personalNumericalCode = sDto.getStudentPersonalNumericalCode();
					String address = sDto.getStudentAddress();
					String group = sDto.getStudentGroup();
					model.addRow(new Object[]{id, name, cardNumber, personalNumericalCode, address, group });
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			teacherView.getReportFrame().setVisible(true);
		}
	}
	private class StudentReportButtonActionListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			try {				
				int id = Integer.parseInt(teacherView.getReportTextField().getText());
				teacher.createReport(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
			teacherView.getReportFrame().dispose();
		}
	}	
}
