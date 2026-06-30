package org.ticketbookingapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ticketbookingapi.model.Ticket;

public interface ITicketRepo extends JpaRepository<Ticket,Long> {
}
