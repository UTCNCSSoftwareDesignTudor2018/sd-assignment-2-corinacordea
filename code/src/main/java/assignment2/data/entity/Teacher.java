package assignment2.data.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="teachers")
public class Teacher {
	@Id
	@SequenceGenerator(name = "seq_teacher", sequenceName = "teachers_techer_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_teacher")
	@Column
	private Integer teacherId;
	
	@Column
	private String teacherName;

	@Column
	private String teacherAddress;
	
	@Column
	private String teacherPersonalNumericalCode;
	
	@OneToMany(mappedBy = "teacher", fetch = FetchType.EAGER)
	private List<Course> courses;

	public Integer getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getTeacherAddress() {
		return teacherAddress;
	}

	public void setTeacherAddress(String teacherAddress) {
		this.teacherAddress = teacherAddress;
	}

	public String getTeacherPersonalNumericalCode() {
		return teacherPersonalNumericalCode;
	}

	public void setTeacherPersonalNumericalCode(String teacherPersonalNumericalCode) {
		this.teacherPersonalNumericalCode = teacherPersonalNumericalCode;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Teacher [teacherId=" + teacherId + ", teacherName=" + teacherName + ", teacherAddress=" + teacherAddress
				+ ", teacherPersonalNumericalCode=" + teacherPersonalNumericalCode + "]";
	}
	
}
