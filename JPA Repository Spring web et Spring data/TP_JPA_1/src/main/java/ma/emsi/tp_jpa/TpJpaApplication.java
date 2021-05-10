package ma.emsi.tp_jpa;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import ma.emsi.tp_jpa.entities.Patient;
import ma.emsi.tp_jpa.repositories.PatientRepository;

@SpringBootApplication
public class TpJpaApplication implements CommandLineRunner{
	@Autowired
	private PatientRepository patientRepository;
	public static void main(String[] args) {
		SpringApplication.run(TpJpaApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		/*patientRepository.save(new Patient(null, "Hassan", new Date(),2300,false));
		patientRepository.save(new Patient(null, "Farah", new Date(),1200,false));
		patientRepository.save(new Patient(null, "Janna", new Date(),7600,false));
		patientRepository.save(new Patient(null, "Imane", new Date(),8500,false));
		patientRepository.save(new Patient(null, "Yassine", new Date(),2300,true));*/
		System.out.println("********************ALL*********************");
		patientRepository.findAll().forEach(p->{
			System.out.println(p.toString());
		});
		System.out.println("*******************By Id**********************");
		Patient p = patientRepository.findById(4L).get();
		System.out.println(p.toString());
		System.out.println("*********************by name********************");
		Page<Patient> p2 = patientRepository.findByNameContains("a", PageRequest.of(0, 2));
		p2.forEach(pp->{
			System.out.println(pp.toString());
		});
		System.out.println("*******************by sickness**********************");
		List<Patient> p3  = patientRepository.findByIsSick(true);
		p3.forEach(ps->{
			System.out.println(ps.toString());
		});
		//patientRepository.deleteById(5L);
		System.out.println("*********************by name and sickness********************");
		List<Patient> p4 = patientRepository.findByNameContainsAndIsSick("H",true);
		p4.forEach(pp4->{
			System.out.println(pp4.toString());
		});
		
		System.out.println("*********************Test pages********************");
		Page<Patient> pagePatients = patientRepository.findAll(PageRequest.of(0,2));
		System.out.println("Nombre des pages ->"+pagePatients.getTotalPages());
		List<Patient> listeP = pagePatients.getContent();		
		listeP.forEach(ppp->{
			System.out.println(ppp.toString());
		});
	}
}
