package org.RestTouristManagement.repo;

import org.RestTouristManagement.model.Tourist;
import org.springframework.data.repository.CrudRepository;

public interface IToursitRepo extends CrudRepository<Tourist,Long> {
}
