package assignment2.presentation.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import assignment2.presentation.view.MainView;
import assignment2.presentation.view.StudentView;
import assignment2.presentation.view.TeacherView;

@Component
public class MainController {
	@Autowired
	MainView mainView;
	@Autowired
	StudentView studentView; 
	@Autowired
	StudentController studentController;
	@Autowired
	TeacherView teacherView; 
	@Autowired
	TeacherController teacherController;

	public MainController(MainView mv) {
		super();
		this.mainView = mv;
		mainView.setContinueButtonActionListener(new ContinueButtonActionListener());
	}
	
	private class ContinueButtonActionListener implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent event){
			if(mainView.getStudentButton().isSelected()) {
				try {
						studentView.getStudentFrame().setVisible(true);
						studentView.getStudentPanel().add(studentView.getViewButton());
				}
				catch (Exception e) {
					JOptionPane.showMessageDialog(mainView.getFrame(),"Error");
				}
			}
			else if(mainView.getTeacherButton().isSelected()) {

				try {
						teacherView.getTeacherFrame().setVisible(true);
				}
				catch (Exception e) {
					JOptionPane.showMessageDialog(mainView.getFrame(),"Error");
				}
			}
		}
	}
	
	public MainView getMainView() {
		return mainView;
	}

	public void setMainView(MainView mainView) {
		this.mainView = mainView;
	}

}

