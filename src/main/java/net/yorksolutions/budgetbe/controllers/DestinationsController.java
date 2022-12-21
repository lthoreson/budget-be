package net.yorksolutions.budgetbe.controllers;

import net.yorksolutions.budgetbe.models.Destination;
import net.yorksolutions.budgetbe.services.DestinationsService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/destinations")
@CrossOrigin
public class DestinationsController {
    private DestinationsService service;

    public DestinationsController(DestinationsService service) {
        this.service = service;
    }

    @GetMapping
    public Iterable<Destination> getDestinations() {
        try {
            return service.getDestinations();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }
}
