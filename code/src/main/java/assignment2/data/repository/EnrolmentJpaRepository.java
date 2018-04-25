package assignment2.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import assignment2.data.entity.Enrolment;

@Repository
public interface EnrolmentJpaRepository extends JpaRepository<Enrolment, Integer>{
	public Enrolment findByEnrolmentId(Integer enrolmentId);
}
