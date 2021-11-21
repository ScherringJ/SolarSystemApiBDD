package spring.scherring.solarsytembddapi.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.scherring.solarsytembddapi.dao.PlaneteRepository;
import spring.scherring.solarsytembddapi.model.Planete;

@RestController
@CrossOrigin("http://localhost:8081/")
public class PlaneteController {

    @Autowired
    private PlaneteRepository dao;

    @GetMapping(value = "/Planete")
    public Iterable<Planete> getLesPlantes() {
       return dao.findAll();
    }

    @GetMapping(value = "/Planete/{id}")
    public Planete getPlanete(@PathVariable("id") int id) {
        return dao.findById(id);
    }

    @DeleteMapping(value = "/Planete/{id}")
    public void deletePlanete(@PathVariable("id") int id) {
        dao.deleteById(id);
    }

    @PostMapping(value = "/Planete")
    public void addPlanete(@RequestBody Planete planete) {
        dao.save(planete);
    }
}
