package org.ticketbookingapi.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.ticketbookingapi.model.Passenger;

public interface IPassengerRepo extends JpaRepository<Passenger,Long> {
}
