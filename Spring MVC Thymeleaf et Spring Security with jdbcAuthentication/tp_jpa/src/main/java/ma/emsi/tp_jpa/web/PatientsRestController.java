package ma.emsi.tp_jpa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import javax.validation.Valid;

import ma.emsi.tp_jpa.entities.Patient;
import ma.emsi.tp_jpa.repositories.PatientRepository;

@RestController
public class PatientsRestController {
	@Autowired // Injection des dependances
	private PatientRepository patientRepository;
	
	@GetMapping(path = "/listPatients") 
	//@ResponseBody pas besoin car on est dans @RestController
	public List<Patient> list(){
		return patientRepository.findAll();
	}
	@GetMapping(path = "/listPatients/{id}") 
	// @ResponseBody
	public Patient getOneById(@PathVariable Long id){
		return patientRepository.findById(id).get();
	}
}
