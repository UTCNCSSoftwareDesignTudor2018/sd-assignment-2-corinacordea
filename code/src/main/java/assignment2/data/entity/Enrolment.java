package assignment2.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "enrolments")
public class Enrolment {

	@Id
	@SequenceGenerator(name = "seq_enrol", sequenceName = "enrolments_enrolment_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_enrol")
	@Column
	private Integer enrolmentId;
	@ManyToOne
    @JoinColumn(name = "student_id")
	private Student student;
	
	@ManyToOne
    @JoinColumn(name = "course_id")
	private Course course;
	
	@ManyToOne
    @JoinColumn(name = "exam_id")
	private Exam exam;
	
	public Integer getEnrolmentId() {
		return enrolmentId;
	}
	public void setEnrolmentId(Integer enrolmentId) {
		this.enrolmentId = enrolmentId;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Exam getExam() {
		return exam;
	}
	public void setExam(Exam exam) {
		this.exam = exam;
	}
	
	@Override
	public String toString() {
		return "Enrolment [enrolmentId=" + enrolmentId + ", student=" + student + ", course=" + course + "]";
	}
	
}
