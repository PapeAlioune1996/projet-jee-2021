package sn.senafroboutique.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import sn.senafroboutique.model.Compteur;

@Repository
public interface CompteurRepository extends JpaRepository<Compteur, Long>{

	Optional<Compteur> findByAnnee(int annee);
	@Query(value = "SELECT count(*) FROM Compteur  where annee  = :annee")
	public int nbre(@Param("annee") int annee);
	
}
