package assignment2.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import assignment2.data.entity.Teacher;

@Repository
public interface TeacherJpaRepository  extends JpaRepository<Teacher, Integer>{
	public Teacher findByTeacherId(Integer teacherId);
	public List<Teacher> findAll();
}
