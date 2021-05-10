package ma.emsi.tp_jpa.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Entity
@Table(name="PATIENTS")
@Data 
@NoArgsConstructor 
@AllArgsConstructor 
@ToString
public class Patient {
	@Id @GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	@Column(name="name", length=25)
	private String name;
	@Temporal(TemporalType.DATE)
	private Date birthDate;
	private int score;
	boolean isSick;
	
	
}
