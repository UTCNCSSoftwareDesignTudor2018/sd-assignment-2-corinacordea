package assignment2.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "exams")
public class Exam {
	@Id
	@SequenceGenerator(name = "seq_exam", sequenceName = "exams_exam_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_exam")
	@Column
	private Integer examId;
	
	@Column
	private String grade;
	
	public Integer getExamId() {
		return examId;
	}

	public void setExamId(Integer examId) {
		this.examId = examId;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	//public List<Student> getStudents() {
		//return students;
	//}

	//public void setStudents(List<Student> students) {
		//this.students = students;
	//}

	@Override
	public String toString() {
		return "Exam [examId=" + examId + ", grade=" + grade + "]";
	}
	
	
}
