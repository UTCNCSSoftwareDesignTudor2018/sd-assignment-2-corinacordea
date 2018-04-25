package assignment2.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import assignment2.data.entity.Course;

@Repository
public interface CourseJpaRepository extends JpaRepository<Course, Integer> {
	public Course findByCourseId(Integer courseId);
}
