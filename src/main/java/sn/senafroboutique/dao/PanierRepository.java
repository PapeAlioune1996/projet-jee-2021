package sn.senafroboutique.dao;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import sn.senafroboutique.model.Panier;

@Repository
public interface PanierRepository extends JpaRepository<Panier, Long>{

	List<Panier> findAllByNom(String nom);

}
