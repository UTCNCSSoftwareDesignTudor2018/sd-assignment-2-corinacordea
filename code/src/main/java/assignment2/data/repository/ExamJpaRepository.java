package assignment2.data.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import assignment2.data.entity.Exam;

@Repository
public interface ExamJpaRepository extends JpaRepository<Exam, Integer>{
	public Exam findByExamId(Integer examId);
}
