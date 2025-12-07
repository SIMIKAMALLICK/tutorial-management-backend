package edu.tutorial.controller;
import edu.tutorial.entity.Tutorial;
import edu.tutorial.service.TutorialService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tutorials")
@AllArgsConstructor
public class TutorialController {

    //@Autowired --> This annotation is used to inject the dependencies into the controller.
    //but we will not use autowire because we cannot use final keyword so we will use constructor injection.
    private final TutorialService tutorialService;

    //http://localhost:8888/api/tutorials
    @GetMapping
    public ResponseEntity<List<Tutorial>> getAllTutorials()
    {
        return new ResponseEntity<>(tutorialService.getCompleteTutorials(), HttpStatus.OK);
    }
    //http://localhost:8888/api/tutorials/(id)
    @GetMapping("{id}")
    public ResponseEntity<Tutorial> fetchAnyTutorial(@PathVariable int id)
    {
        return ResponseEntity.ok(tutorialService.getAnyTutorial(id));
    }
    //http://localhost:8888/api/tutorials
    @PostMapping
    public ResponseEntity<Tutorial> newTutorial(@RequestBody Tutorial tutorial)
    {
        return new ResponseEntity<>(tutorialService.createTutorial(tutorial), HttpStatus.CREATED);

    }
    //http://localhost:8888/api/tutorials/{id}
    @PutMapping("{id}")
    public ResponseEntity<Tutorial> updateAnyTutorial(@PathVariable int id, @RequestBody Tutorial tutorial)
    {
        return ResponseEntity.ok(tutorialService.updateTutorial(id,tutorial));

    }
    //http://localhost:8888/api/tutorials/{id}
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAnyTutorial(@PathVariable int id){
        return ResponseEntity.ok(tutorialService.deleteTutorial(id));
    }

}
