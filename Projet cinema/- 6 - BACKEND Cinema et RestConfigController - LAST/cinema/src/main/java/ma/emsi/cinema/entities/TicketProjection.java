package ma.emsi.cinema.entities;
import javax.persistence.Column;
import javax.persistence.ManyToOne;

import org.springframework.data.rest.core.config.Projection;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Projection(name = "ticketProj", types= {ma.emsi.cinema.entities.Ticket.class})
public interface TicketProjection {
	public Long getId();
	public String getNomClient();
	public double getPrix();

	public Integer getCodePayement();
	public boolean getReserve();
	public Place getPlace();	
}
