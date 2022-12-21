package net.yorksolutions.budgetbe.services;

import net.yorksolutions.budgetbe.models.Destination;
import net.yorksolutions.budgetbe.repositories.DestinationsRepository;
import org.springframework.stereotype.Service;

@Service
public class DestinationsService {
    private final DestinationsRepository repository;

    public DestinationsService(DestinationsRepository repository) {
        this.repository = repository;
    }

    public Iterable<Destination> getDestinations() {
        return repository.findAll();
    }
}
