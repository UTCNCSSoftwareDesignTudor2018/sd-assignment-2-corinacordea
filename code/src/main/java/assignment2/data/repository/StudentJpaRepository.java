package assignment2.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import assignment2.data.entity.Student;

 @Repository
public interface StudentJpaRepository extends JpaRepository<Student, Integer>
{
	public List<Student> findAllByStudentName(String studentName);
	public List<Student> findAll();
	@SuppressWarnings("unchecked")
	public Student save(Student s);
	public Student findByStudentId(Integer studentId);
}
