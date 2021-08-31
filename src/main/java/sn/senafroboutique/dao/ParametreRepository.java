package sn.senafroboutique.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sn.senafroboutique.model.Parametre;


@Repository
public interface ParametreRepository extends JpaRepository<Parametre, Long>{


}
