package org.eclipse.FirstSpringMvc.dao;

import org.eclipse.FirstSpringMvc.model.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonneRepository extends JpaRepository<Personne, Long> {

}
