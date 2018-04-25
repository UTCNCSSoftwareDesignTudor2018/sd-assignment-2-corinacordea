package assignment2.presentation.view;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import org.springframework.stereotype.Component;

@Component
public class TeacherView {
	private JFrame teacherFrame;
	private JPanel teacherPanel;
	private JButton viewButton;
	private JButton enrollButton;
	private JButton generateReportButton;
	private JButton addCourse;
	private JButton giveGrade;
	private JButton updateButton;
	private JButton deleteButton;

	private JFrame viewFrame;
	private JPanel viewPanel;
	private JTable students;
	private JFrame deleteFrame;
	private JPanel deletePanel;
	private JTable deleteStudents;
	private JLabel deleteLabel;
	private JTextField deleteTextField;
	private JButton deleteStudentButton;
	private JFrame updateFrame;
	private JPanel updatePanel;
	private JTable updateStudents;
	private JButton updateStudentButton;
	private JLabel updateLabel;
	private JTextField updateTextField;
	private JLabel updateGroupLabel;
	private JTextField updateGroupTextField;
	private JFrame gradeFrame;
	private JPanel gradePanel;
	private JTable gradeStudents;
	private JButton addGradeButton;
	private JLabel idEnrolmentLabel;
	private JTextField idEnrolmentTextField;
	private JLabel gradeLabel;
	private JTextField gradeTextField;
	private JFrame accountFrame;
	private JPanel accountPanel;
	private JLabel teacherId;
	private JTextField teacherIdTextField;
	private JLabel teacherName;
	private JTextField teacherNameTextField;
	private JButton saveDataButton;
	private JLabel username;
	private JTextField usernameTextField;
	private JLabel password;
	private JPasswordField passwordTextField;
	private JFrame reportFrame;
	private JPanel reportPanel;
	private JTable studentsReport;
	private JButton reportStudentButton;
	private JLabel reportLabel;
	private JTextField reportTextField;
	public TeacherView() {
		initialize();
	}
	private void initialize() {
		teacherFrame = new JFrame("Teacher");
		teacherFrame.setBounds(0, 0, 600, 400);
		teacherFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		teacherFrame.setLocationRelativeTo(null);
		teacherFrame.getContentPane().setLayout(null);
		
		teacherPanel = new JPanel();
		teacherPanel.setLayout(null);
		teacherPanel.setBounds(0, 0, 600, 400);
		teacherPanel.setVisible(true);
		
		viewButton = new JButton("View Students");
		viewButton.setBounds(20, 20, 150, 20);
		teacherPanel.add(viewButton);
		
		updateButton = new JButton("Update Student");
		updateButton.setBounds(20, 50, 150, 20);
		teacherPanel.add(updateButton);
		
		deleteButton = new JButton("Delete Student");
		deleteButton.setBounds(20, 80, 150, 20);
		teacherPanel.add(deleteButton);
		
		enrollButton = new JButton("Enroll Student");
		enrollButton.setBounds(20, 110, 150, 20);
		teacherPanel.add(enrollButton);
		
		addCourse = new JButton("Add Course");
		addCourse.setBounds(20, 140, 150, 20);
		teacherPanel.add(addCourse);
		
		giveGrade = new JButton("Give grade");
		giveGrade.setBounds(20, 170, 150, 20);
		teacherPanel.add(giveGrade);
		
		generateReportButton = new JButton("Generate Report");
		generateReportButton.setBounds(20, 200, 150, 20);
		teacherPanel.add(generateReportButton);
		teacherFrame.add(teacherPanel);
		updateStudentButton = new JButton("Update");
		updateTextField = new JTextField();
		updateGroupTextField = new JTextField();
		deleteStudentButton = new JButton("Delete");
		deleteTextField = new JTextField();
		addGradeButton = new JButton("Give Grade");
		idEnrolmentTextField = new JTextField();
		gradeTextField = new JTextField();
		reportStudentButton = new JButton("Create Report");
		reportTextField = new JTextField();
	}
	public void viewStudents() {
		viewFrame = new JFrame("View Students");
		viewFrame.setBounds(0, 0, 600, 400);
		viewFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		viewFrame.setLocationRelativeTo(null);
		viewFrame.getContentPane().setLayout(null);
		
		viewPanel = new JPanel();
		viewPanel.setLayout(null);
		viewPanel.setBounds(0, 0, 600, 400);
		viewPanel.setVisible(true);
				
		students = new JTable();
		students.setBounds(50, 50, 400, 200);
		students.setVisible(true);	
		
		viewPanel.add(students);
		JScrollPane scrollPane = new JScrollPane(students);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(50, 50, 400, 200);
		viewFrame.add(scrollPane);
		viewFrame.add(viewPanel);
		
	}
	
	public void updateStudent() {
		updateFrame = new JFrame("Update");
		updateFrame.setBounds(0, 0, 600, 400);
		updateFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		updateFrame.setLocationRelativeTo(null);
		updateFrame.getContentPane().setLayout(null);
		
		updatePanel = new JPanel();
		updatePanel.setLayout(null);
		updatePanel.setBounds(0, 0, 600, 400);
		updatePanel.setVisible(true);
				
		updateStudents = new JTable();
		updateStudents.setBounds(50, 90, 400, 200);
		updateStudents.setVisible(true);
		updatePanel.add(updateStudents);
		
		JScrollPane scrollPane = new JScrollPane(updateStudents);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(50, 90, 400, 200);
		updateFrame.add(scrollPane);
		
		
		updateStudentButton.setBounds(250, 20, 100, 20);
		updatePanel.add(updateStudentButton);
		
		updateLabel = new JLabel("Student id");
		updateLabel.setBounds(50, 20, 70, 20);
		updatePanel.add(updateLabel);
		
		updateTextField.setBounds(130, 20, 70, 20);
		updatePanel.add(updateTextField);
		
		updateGroupLabel = new JLabel("Group");
		updateGroupLabel.setBounds(50, 40, 70, 20);
		updatePanel.add(updateGroupLabel);
		
		
		updateGroupTextField.setBounds(130, 40, 70, 20);
		updatePanel.add(updateGroupTextField);
		
		updateFrame.add(updatePanel);
		
	}
	
	public void deleteStudent() {
		deleteFrame = new JFrame("Delete");
		deleteFrame.setBounds(0, 0, 600, 400);
		deleteFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		deleteFrame.setLocationRelativeTo(null);
		deleteFrame.getContentPane().setLayout(null);
		
		deletePanel = new JPanel();
		deletePanel.setLayout(null);
		deletePanel.setBounds(0, 0, 600, 400);
		deletePanel.setVisible(true);
				
		deleteStudents = new JTable();
		deleteStudents.setBounds(50, 70, 400, 200);
		deleteStudents.setVisible(true);
		deletePanel.add(deleteStudents);
		
		JScrollPane scrollPane = new JScrollPane(deleteStudents);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(50, 70, 400, 200);
		deleteFrame.add(scrollPane);
		
		deleteStudentButton.setBounds(250, 20, 100, 20);
		deletePanel.add(deleteStudentButton);
		
		deleteLabel = new JLabel("Student id");
		deleteLabel.setBounds(50, 20, 70, 20);
		deletePanel.add(deleteLabel);
		
		deleteTextField.setBounds(130, 20, 70, 20);
		deletePanel.add(deleteTextField);
		
		deleteFrame.add(deletePanel);
		
	}

	public void giveGrade() {
		gradeFrame = new JFrame("Grade");
		gradeFrame.setBounds(0, 0, 600, 400);
		gradeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		gradeFrame.setLocationRelativeTo(null);
		gradeFrame.getContentPane().setLayout(null);
		
		gradePanel = new JPanel();
		gradePanel.setLayout(null);
		gradePanel.setBounds(0, 0, 600, 400);
		gradePanel.setVisible(true);
		
		gradeStudents = new JTable();
		gradeStudents.setBounds(50, 90, 400, 200);
		gradeStudents.setVisible(true);
		gradePanel.add(gradeStudents);
		
		JScrollPane scrollPane = new JScrollPane(gradeStudents);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(50, 90, 400, 200);
		gradeFrame.add(scrollPane);
		
		addGradeButton.setBounds(250, 20, 100, 20);
		gradePanel.add(addGradeButton);
		
		idEnrolmentLabel = new JLabel("Enrolment id");
		idEnrolmentLabel.setBounds(50, 20, 80, 20);
		gradePanel.add(idEnrolmentLabel);
		
		idEnrolmentTextField.setBounds(130, 20, 70, 20);
		gradePanel.add(idEnrolmentTextField);
		
		gradeLabel = new JLabel("Grade");
		gradeLabel.setBounds(50, 40, 80, 20);
		gradePanel.add(gradeLabel);
		
		gradeTextField.setBounds(130, 40, 70, 20);
		gradePanel.add(gradeTextField);
		
		gradeFrame.add(gradePanel);	
		
	}
		
	public void generateReport() {
		reportFrame = new JFrame("Report");
		reportFrame.setBounds(0, 0, 600, 400);
		reportFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		reportFrame.setLocationRelativeTo(null);
		reportFrame.getContentPane().setLayout(null);
		
		reportPanel = new JPanel();
		reportPanel.setLayout(null);
		reportPanel.setBounds(0, 0, 600, 400);
		reportPanel.setVisible(true);
				
		studentsReport = new JTable();
		studentsReport.setBounds(50, 50, 400, 200);
		studentsReport.setVisible(true);	
		
		reportPanel.add(studentsReport);
		JScrollPane scrollPane = new JScrollPane(studentsReport);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(50, 50, 400, 200);
		reportFrame.add(scrollPane);
		
		reportStudentButton.setBounds(250, 20, 120, 20);
		reportPanel.add(reportStudentButton);
		
		reportLabel = new JLabel("Student id");
		reportLabel.setBounds(50, 20, 70, 20);
		reportPanel.add(reportLabel);
		
		reportTextField.setBounds(130, 20, 70, 20);
		reportPanel.add(reportTextField);
		
		reportFrame.add(reportPanel);
	}
	public void  setViewButtonActionListener(ActionListener actionListener) {
		viewButton.addActionListener(actionListener);
	}
	public void  setUpdateButtonActionListener(ActionListener actionListener) {
		updateButton.addActionListener(actionListener);
	}
	public void  setUpdateStudentButtonActionListener(ActionListener actionListener) {
		updateStudentButton.addActionListener(actionListener);
	}
	public void  setDeleteButtonActionListener(ActionListener actionListener) {
		deleteButton.addActionListener(actionListener);
	}
	public void  setDeleteStudentButtonActionListener(ActionListener actionListener) {
		deleteStudentButton.addActionListener(actionListener);
	}
	public void  setEnrollButtonActionListener(ActionListener actionListener) {
		enrollButton.addActionListener(actionListener);
	}
	public void  setAddCourseButtonActionListener(ActionListener actionListener) {
		addCourse.addActionListener(actionListener);
	}
	public void  setGiveGradeButtonActionListener(ActionListener actionListener) {
		giveGrade.addActionListener(actionListener);
	}
	public void  setAddGradeButtonActionListener(ActionListener actionListener) {
		addGradeButton.addActionListener(actionListener);
	}
	public void  setReportButtonActionListener(ActionListener actionListener) {
		generateReportButton.addActionListener(actionListener);
	}
	public void  setStudentReportButtonActionListener(ActionListener actionListener) {
		reportStudentButton.addActionListener(actionListener);
	}
	public JFrame getTeacherFrame() {
		return teacherFrame;
	}
	public void setTeacherFrame(JFrame teacherFrame) {
		this.teacherFrame = teacherFrame;
	}
	public JButton getViewButton() {
		return viewButton;
	}
	public void setViewButton(JButton viewButton) {
		this.viewButton = viewButton;
	}
	public JButton getEnrollButton() {
		return enrollButton;
	}
	public void setEnrollButton(JButton enrollButton) {
		this.enrollButton = enrollButton;
	}
	public JButton getGenerateReportButton() {
		return generateReportButton;
	}
	public void setGenerateReportButton(JButton generateReportButton) {
		this.generateReportButton = generateReportButton;
	}
	public JButton getAddCourse() {
		return addCourse;
	}
	public void setAddCourse(JButton addCourse) {
		this.addCourse = addCourse;
	}
	public JButton getGiveGrade() {
		return giveGrade;
	}
	public void setGiveGrade(JButton giveGrade) {
		this.giveGrade = giveGrade;
	}
	public JButton getUpdateButton() {
		return updateButton;
	}
	public void setUpdateButton(JButton updateButton) {
		this.updateButton = updateButton;
	}
	public JButton getDeleteButton() {
		return deleteButton;
	}
	public void setDeleteButton(JButton deleteButton) {
		this.deleteButton = deleteButton;
	}
	public JPanel getTeacherPanel() {
		return teacherPanel;
	}
	public void setTeacherPanel(JPanel teacherPanel) {
		this.teacherPanel = teacherPanel;
	}
	public JFrame getViewFrame() {
		return viewFrame;
	}
	public void setViewFrame(JFrame viewFrame) {
		this.viewFrame = viewFrame;
	}
	public JPanel getViewPanel() {
		return viewPanel;
	}
	public void setViewPanel(JPanel viewPanel) {
		this.viewPanel = viewPanel;
	}
	public JTable getStudents() {
		return students;
	}
	public void setStudents(JTable students) {
		this.students = students;
	}
	public JFrame getDeleteFrame() {
		return deleteFrame;
	}
	public void setDeleteFrame(JFrame deleteFrame) {
		this.deleteFrame = deleteFrame;
	}
	public JPanel getDeletePanel() {
		return deletePanel;
	}
	public void setDeletePanel(JPanel deletePanel) {
		this.deletePanel = deletePanel;
	}
	public JTable getDeleteStudents() {
		return deleteStudents;
	}
	public void setDeleteStudents(JTable deleteStudents) {
		this.deleteStudents = deleteStudents;
	}
	public JLabel getDeleteLabel() {
		return deleteLabel;
	}
	public void setDeleteLabel(JLabel deleteLabel) {
		this.deleteLabel = deleteLabel;
	}
	public JTextField getDeleteTextField() {
		return deleteTextField;
	}
	public void setDeleteTextField(JTextField deleteTextField) {
		this.deleteTextField = deleteTextField;
	}
	public JButton getDeleteStudentButton() {
		return deleteStudentButton;
	}
	public void setDeleteStudentButton(JButton deleteStudentButton) {
		this.deleteStudentButton = deleteStudentButton;
	}
	public JFrame getUpdateFrame() {
		return updateFrame;
	}
	public void setUpdateFrame(JFrame updateFrame) {
		this.updateFrame = updateFrame;
	}
	public JPanel getUpdatePanel() {
		return updatePanel;
	}
	public void setUpdatePanel(JPanel updatePanel) {
		this.updatePanel = updatePanel;
	}
	public JTable getUpdateStudents() {
		return updateStudents;
	}
	public void setUpdateStudents(JTable updateStudents) {
		this.updateStudents = updateStudents;
	}
	public JButton getUpdateStudentButton() {
		return updateStudentButton;
	}
	public void setUpdateStudentButton(JButton updateStudentButton) {
		this.updateStudentButton = updateStudentButton;
	}
	public JLabel getUpdateLabel() {
		return updateLabel;
	}
	public void setUpdateLabel(JLabel updateLabel) {
		this.updateLabel = updateLabel;
	}
	public JTextField getUpdateTextField() {
		return updateTextField;
	}
	public void setUpdateTextField(JTextField updateTextField) {
		this.updateTextField = updateTextField;
	}
	public JLabel getUpdateGroupLabel() {
		return updateGroupLabel;
	}
	public void setUpdateGroupLabel(JLabel updateGroupLabel) {
		this.updateGroupLabel = updateGroupLabel;
	}
	public JTextField getUpdateGroupTextField() {
		return updateGroupTextField;
	}
	public void setUpdateGroupTextField(JTextField updateGroupTextField) {
		this.updateGroupTextField = updateGroupTextField;
	}
	public JFrame getGradeFrame() {
		return gradeFrame;
	}
	public void setGradeFrame(JFrame gradeFrame) {
		this.gradeFrame = gradeFrame;
	}
	public JPanel getGradePanel() {
		return gradePanel;
	}
	public void setGradePanel(JPanel gradePanel) {
		this.gradePanel = gradePanel;
	}
	public JTable getGradeStudents() {
		return gradeStudents;
	}
	public void setGradeStudents(JTable gradeStudents) {
		this.gradeStudents = gradeStudents;
	}
	public JButton getAddGradeButton() {
		return addGradeButton;
	}
	public void setAddGradeButton(JButton addGradeButton) {
		this.addGradeButton = addGradeButton;
	}
	public JLabel getIdEnrolmentLabel() {
		return idEnrolmentLabel;
	}
	public void setIdEnrolmentLabel(JLabel idEnrolmentLabel) {
		this.idEnrolmentLabel = idEnrolmentLabel;
	}
	public JTextField getIdEnrolmentTextField() {
		return idEnrolmentTextField;
	}
	public void setIdEnrolmentTextField(JTextField idEnrolmentTextField) {
		this.idEnrolmentTextField = idEnrolmentTextField;
	}
	public JLabel getGradeLabel() {
		return gradeLabel;
	}
	public void setGradeLabel(JLabel gradeLabel) {
		this.gradeLabel = gradeLabel;
	}
	public JTextField getGradeTextField() {
		return gradeTextField;
	}
	public void setGradeTextField(JTextField gradeTextField) {
		this.gradeTextField = gradeTextField;
	}
	public JFrame getAccountFrame() {
		return accountFrame;
	}
	public void setAccountFrame(JFrame accountFrame) {
		this.accountFrame = accountFrame;
	}
	public JPanel getAccountPanel() {
		return accountPanel;
	}
	public void setAccountPanel(JPanel accountPanel) {
		this.accountPanel = accountPanel;
	}
	public JLabel getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(JLabel teacherId) {
		this.teacherId = teacherId;
	}
	public JTextField getTeacherIdTextField() {
		return teacherIdTextField;
	}
	public void setTeacherIdTextField(JTextField teacherIdTextField) {
		this.teacherIdTextField = teacherIdTextField;
	}
	public JLabel getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(JLabel teacherName) {
		this.teacherName = teacherName;
	}
	public JTextField getTeacherNameTextField() {
		return teacherNameTextField;
	}
	public void setTeacherNameTextField(JTextField teacherNameTextField) {
		this.teacherNameTextField = teacherNameTextField;
	}
	public JButton getSaveDataButton() {
		return saveDataButton;
	}
	public void setSaveDataButton(JButton saveDataButton) {
		this.saveDataButton = saveDataButton;
	}
	public JLabel getUsername() {
		return username;
	}
	public void setUsername(JLabel username) {
		this.username = username;
	}
	public JTextField getUsernameTextField() {
		return usernameTextField;
	}
	public void setUsernameTextField(JTextField usernameTextField) {
		this.usernameTextField = usernameTextField;
	}
	public JLabel getPassword() {
		return password;
	}
	public void setPassword(JLabel password) {
		this.password = password;
	}
	public JPasswordField getPasswordTextField() {
		return passwordTextField;
	}
	public void setPasswordTextField(JPasswordField passwordTextField) {
		this.passwordTextField = passwordTextField;
	}
	public JFrame getReportFrame() {
		return reportFrame;
	}
	public void setReportFrame(JFrame reportFrame) {
		this.reportFrame = reportFrame;
	}
	public JPanel getReportPanel() {
		return reportPanel;
	}
	public void setReportPanel(JPanel reportPanel) {
		this.reportPanel = reportPanel;
	}
	public JTable getStudentsReport() {
		return studentsReport;
	}
	public void setStudentsReport(JTable studentsReport) {
		this.studentsReport = studentsReport;
	}
	public JButton getReportStudentButton() {
		return reportStudentButton;
	}
	public void setReportStudentButton(JButton reportStudentButton) {
		this.reportStudentButton = reportStudentButton;
	}
	public JLabel getReportLabel() {
		return reportLabel;
	}
	public void setReportLabel(JLabel reportLabel) {
		this.reportLabel = reportLabel;
	}
	public JTextField getReportTextField() {
		return reportTextField;
	}
	public void setReportTextField(JTextField reportTextField) {
		this.reportTextField = reportTextField;
	}
	public DefaultTableModel getTeacherTableModel() {
		DefaultTableModel tableModel = new DefaultTableModel(new Object[]{"Teacher Id","Name", "Address", "Personal Numerical Code"},0);
		return tableModel;
	}
	public DefaultTableModel getStudentTableModel() {
		DefaultTableModel tableModel = new DefaultTableModel(new Object[]{"Student Id","Name", "Card No", "Personal Numerical Code", "Address", "Group"},0);
		return tableModel;
	}
	public DefaultTableModel getStudentCourseTableModel() {
		DefaultTableModel tableModel = new DefaultTableModel(new Object[]{"Student Id","Name", "Card No", "Personal Numerical Code", "Address", "Group","CourseId","CourseName"},0);
		return tableModel;
	}
	public DefaultTableModel getStudentPartialTableModel() {
		DefaultTableModel tableModel = new DefaultTableModel(new Object[]{"Student Id","Name", "Group"},0);
		return tableModel;
	}
	public DefaultTableModel getCourseTableModel() {
		DefaultTableModel tableModel = new DefaultTableModel(new Object[]{ "Teacher Id", "TeacherName","Course Id","Name" },0);
		return tableModel;
	}
}
