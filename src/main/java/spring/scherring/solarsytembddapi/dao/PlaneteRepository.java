package spring.scherring.solarsytembddapi.dao;

import org.springframework.data.repository.CrudRepository;
import spring.scherring.solarsytembddapi.model.Planete;

public interface PlaneteRepository extends CrudRepository<Planete, Integer> {

   Planete findById(int id);

   void deleteById(int id);
}
