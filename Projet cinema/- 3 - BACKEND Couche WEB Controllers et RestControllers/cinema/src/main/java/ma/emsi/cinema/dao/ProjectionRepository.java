package ma.emsi.cinema.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import ma.emsi.cinema.entities.Projection;

public interface ProjectionRepository extends JpaRepository<Projection, Long> {

}
