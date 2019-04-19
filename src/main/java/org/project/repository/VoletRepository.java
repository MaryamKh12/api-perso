package org.project.repository;

import org.project.model.Volet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoletRepository extends JpaRepository<Volet, String> {
}
