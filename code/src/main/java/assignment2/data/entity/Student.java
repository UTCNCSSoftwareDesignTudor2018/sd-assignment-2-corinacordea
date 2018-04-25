package assignment2.data.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student
{
	@Id
	@SequenceGenerator(name = "seq", sequenceName = "students_inc", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	@Column
	private Integer studentId;
	
	@Column
	private String studentName;
	
	@Column
	private String studentCardNumber;

	@Column
	private String studentPersonalNumericalCode;
	
	@Column
	private String studentAddress;
	
	@Column
	private String studentGroup;

	@ManyToMany(cascade = { CascadeType.ALL },fetch = FetchType.EAGER)
    @JoinTable(
        name = "enrolments", 
        joinColumns = { @JoinColumn(name = "student_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "course_id") }
    )
	List<Course> courses;
	
	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
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

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentCardNumber="
				+ studentCardNumber + ", studentPersonalNumericalCode=" + studentPersonalNumericalCode
				+ ", studentAddress=" + studentAddress + ", studentGroup=" + studentGroup + "]";
	}
	
}