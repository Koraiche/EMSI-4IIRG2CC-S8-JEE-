package ma.emsi.tp_jpa;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import ma.emsi.tp_jpa.entities.Patient;
import ma.emsi.tp_jpa.repositories.PatientRepository;
import java.util.List;



@SpringBootApplication
public class TpJpaApplication implements CommandLineRunner{

	@Autowired // Injection des dependances
	private PatientRepository patientRepository;
	public static void main(String[] args) {
		SpringApplication.run(TpJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*patientRepository.save(new Patient(null,"Fahd",new Date(), 2300, false));
		patientRepository.save(new Patient(null,"Naoufal ",new Date(), 1200, false));
		patientRepository.save(new Patient(null,"Zakaria",new Date(), 400, false));
		patientRepository.save(new Patient(null,"Walid",new Date(), 8000, false));*/
		System.out.println("*********************************");
		patientRepository.findAll().forEach(p->{
			System.out.println(p.toString());
		});
		System.out.println("*********************************");
		//Patient p1 = patientRepository.findById(2L).get();
		//System.out.println(p1.getNom().toString());
		System.out.println("*********************************");
		Page<Patient> p2 = patientRepository.findByNomContains("Fa", PageRequest.of(0, 2));
		p2.getContent().forEach(p->{
			System.out.println(p.toString());
		});
		System.out.println("*********************************");
		List<Patient> p3 = patientRepository.findByMalade(false);
		p3.forEach(p->{
			System.out.println(p.toString());
		});
		System.out.println("*********************************");
		List<Patient> p4 = patientRepository.findByNomContainsAndMalade("Fa",true);
		p4.forEach(p->{
			System.out.println(p.toString());
		});
		System.out.println("*********************************");
		//patientRepository.deleteById(4L);
		patientRepository.findAll().forEach(p->{
			System.out.println(p.toString());
		});
		System.out.println("*********************************");
		Page<Patient> pagePatients = patientRepository.findAll(PageRequest.of(0,2));
		System.out.println("Nombre de pages -> " + pagePatients.getTotalPages());
		pagePatients.getContent().forEach(p->{
			System.out.println(p.toString());
		});
	}

}
