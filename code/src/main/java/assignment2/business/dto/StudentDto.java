package assignment2.business.dto;

import java.util.List;

public class StudentDto {

	private int studentId;
	
	private String studentName;

	private String studentCardNumber;

	private String studentPersonalNumericalCode;

	private String studentAddress;

	private String studentGroup;
	
	List<CourseDto> courses;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentCardNumber() {
		return studentCardNumber;
	}

	public void setStudentCardNumber(String studentCardNumber) {
		this.studentCardNumber = studentCardNumber;
	}

	public String getStudentPersonalNumericalCode() {
		return studentPersonalNumericalCode;
	}

	public void setStudentPersonalNumericalCode(String studentPersonalNumericalCode) {
		this.studentPersonalNumericalCode = studentPersonalNumericalCode;
	}

	public String getStudentAddress() {
		return studentAddress;
	}

	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}

	public String getStudentGroup() {
		return studentGroup;
	}

	public void setStudentGroup(String studentGroup) {
		this.studentGroup = studentGroup;
	}

	public List<CourseDto> getCourses() {
		return courses;
	}

	public void setCourses(List<CourseDto> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "StudentDto [ studentName=" + studentName + ", studentCardNumber="
				+ studentCardNumber + ", studentPersonalNumericalCode=" + studentPersonalNumericalCode
				+ ", studentAddress=" + studentAddress + ", studentGroup=" + studentGroup + "]";
	}
}
