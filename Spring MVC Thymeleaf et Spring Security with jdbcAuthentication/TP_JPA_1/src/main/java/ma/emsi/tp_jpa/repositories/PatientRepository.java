package ma.emsi.tp_jpa.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.emsi.tp_jpa.entities.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
	public Page<Patient> findByNameContains(String name, Pageable pageable);
	public List<Patient> findByIsSick(boolean isSick);
	public List<Patient> findByNameContainsAndIsSick(String name,boolean isSick);
}
