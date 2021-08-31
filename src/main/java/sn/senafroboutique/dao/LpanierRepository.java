package sn.senafroboutique.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import sn.senafroboutique.model.Lpanier;

@Repository
public interface LpanierRepository extends JpaRepository<Lpanier, Long>{

}
