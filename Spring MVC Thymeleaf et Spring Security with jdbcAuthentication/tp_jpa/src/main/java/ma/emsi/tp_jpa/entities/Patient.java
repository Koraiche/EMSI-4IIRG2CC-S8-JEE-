package ma.emsi.tp_jpa.entities;

import java.util.Date;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.*;
@Entity
@Table(name="PATIENTS")
@Data @NoArgsConstructor @ToString @AllArgsConstructor
public class Patient {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="NOM",length=25)
	@NotNull @Size(min = 5, max = 15, message = "La taille du nom n'est pas correcte !")
	private String nom;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateNaissance;
	@DecimalMin("10")
	private int score;
	private boolean malade;
}

