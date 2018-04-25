package assignment2.presentation.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import assignment2.business.dto.StudentDto;
import assignment2.business.service.StudentService;
import assignment2.presentation.view.StudentView;

@Controller
public class StudentController {
	@Autowired
	StudentView studentView;
	@Autowired
	StudentService studentService;
	public StudentController(StudentView sv) {
		super();
		this.studentView = sv;
		studentView.setViewButtonActionListener(new ViewButtonActionListener());
		studentView.setCreateProfileButtonActionListener(new CreateProfileButtonActionListener());
		studentView.setSaveButtonActionListener(new SaveButtonActionListener());
	}
	private class ViewButtonActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			int id = Integer.parseInt(studentView.getStudentIdTextField().getText());
			StudentDto student = studentService.findByStudentId(id);
			studentView.getViewPanel().setVisible(true);
			studentView.getStudentPanel().add(studentView.getViewPanel());
			studentView.getViewPanel().add(studentView.getSaveButton());
			studentView.getStudentFrame().repaint();
			studentView.getStudentNameTextField().setText(student.getStudentName());
			studentView.getStudentCardNumberTextField().setText(student.getStudentCardNumber());
			studentView.getStudentPersonalNumericalCodeTextField().setText(student.getStudentPersonalNumericalCode());
			studentView.getStudentAddressTextField().setText(student.getStudentAddress());
			studentView.getStudentGroupTextField().setText(student.getStudentGroup());
			
		}
		
	}
	private class CreateProfileButtonActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
		
			studentView.getViewPanel().setVisible(true);
			studentView.getStudentPanel().add(studentView.getViewPanel());
			studentView.getViewPanel().add(studentView.getSaveButton());
			studentView.getStudentFrame().repaint();
		
		}
		
	}
	
	private class SaveButtonActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			StudentDto studentDto = new StudentDto();
			studentDto.setStudentName(studentView.getStudentNameTextField().getText());
			studentDto.setStudentCardNumber(studentView.getStudentCardNumberTextField().getText());
			studentDto.setStudentPersonalNumericalCode(studentView.getStudentPersonalNumericalCodeTextField().getText());
			studentDto.setStudentAddress(studentView.getStudentAddressTextField().getText());
			studentDto.setStudentGroup(studentView.getStudentGroupTextField().getText());
			if (!studentView.getStudentIdTextField().getText().isEmpty()) {
				int id = Integer.parseInt(studentView.getStudentIdTextField().getText());
				studentService.updateStudent(studentDto, id);
			}else {
				studentService.saveStudent(studentDto);
			}
			
		}
		
	}
	
}
