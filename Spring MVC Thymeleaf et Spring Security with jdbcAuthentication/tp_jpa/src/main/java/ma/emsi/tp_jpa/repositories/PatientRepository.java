package ma.emsi.tp_jpa.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ma.emsi.tp_jpa.entities.Patient;
import java.util.List;


public interface PatientRepository extends JpaRepository<Patient, Long>{
	public Page<Patient> findByNomContains(String str,Pageable pageable);
	public List<Patient> findByMalade(boolean bool);
	public List<Patient> findByNomContainsAndMalade(String str,boolean bool);
}
