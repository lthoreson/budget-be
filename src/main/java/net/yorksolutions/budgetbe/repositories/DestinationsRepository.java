package net.yorksolutions.budgetbe.repositories;

import net.yorksolutions.budgetbe.models.Destination;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DestinationsRepository extends CrudRepository<Destination, Long> {
    public Optional<Destination> findDestinationByName(String name);
}
