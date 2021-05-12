package ma.emsi.cinema.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ma.emsi.cinema.entities.Ticket;


@RepositoryRestResource
public interface TicketRepository extends JpaRepository<Ticket, Long> {

}
