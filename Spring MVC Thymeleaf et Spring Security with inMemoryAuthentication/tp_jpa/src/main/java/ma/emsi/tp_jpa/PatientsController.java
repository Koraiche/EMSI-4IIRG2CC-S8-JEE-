package ma.emsi.tp_jpa;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ma.emsi.tp_jpa.entities.Patient;
import ma.emsi.tp_jpa.repositories.PatientRepository;

@RestController
public class PatientsController {
	@Autowired
	private PatientRepository patientsRepsitory;
	@GetMapping("/patients")
	public List<Patient> patients(){
		return patientsRepsitory.findAll();
	}
	@GetMapping("/patients/{id}")
	public Patient patients(@PathVariable Long id){
		return patientsRepsitory.findById(id).get();
	}
}
