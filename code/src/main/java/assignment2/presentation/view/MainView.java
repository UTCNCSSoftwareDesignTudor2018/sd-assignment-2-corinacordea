package assignment2.presentation.view;

import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import org.springframework.stereotype.Component;
@Component
public class MainView {
	private JFrame frame;
	private JPanel panel;
	private JRadioButton studentButton;
	private JRadioButton teacherButton;
	private ButtonGroup group;
	private JButton continueButton;
	
	public MainView() {
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
	    panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(100, 100, 600, 400);
		panel.setVisible(true);
		frame.getContentPane().add(panel);
		studentButton = new JRadioButton("Student");
		studentButton.setBounds(70, 0, 100, 15);
		teacherButton = new JRadioButton("Teacher");
		teacherButton.setBounds(170, 0, 100, 15);
		continueButton = new JButton("Continue");
		continueButton.setBounds(70, 60, 170, 30);
		group = new ButtonGroup();
		group.add(studentButton);
		group.add(teacherButton);
		panel.add(studentButton);
		panel.add(teacherButton);
		panel.add(continueButton);
		frame.repaint();
	}

	public void setContinueButtonActionListener(ActionListener actionListener) {
		continueButton.addActionListener(actionListener);
	}
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public JRadioButton getStudentButton() {
		return studentButton;
	}

	public void setStudentButton(JRadioButton studentButton) {
		this.studentButton = studentButton;
	}

	public JRadioButton getTeacherButton() {
		return teacherButton;
	}

	public void setTeacherButton(JRadioButton teacherButton) {
		this.teacherButton = teacherButton;
	}

	public ButtonGroup getGroup() {
		return group;
	}

	public void setGroup(ButtonGroup group) {
		this.group = group;
	}
	public JButton getContinueButton() {
		return continueButton;
	}
	public void setContinueButton(JButton continueButton) {
		this.continueButton = continueButton;
	}
	
}

