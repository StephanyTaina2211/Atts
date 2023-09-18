package tata.pi.eventos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tata.pi.eventos.models.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long>{

}
