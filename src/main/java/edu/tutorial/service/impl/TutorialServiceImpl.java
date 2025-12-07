package edu.tutorial.service.impl;

import edu.tutorial.entity.Tutorial;
import edu.tutorial.repository.TutorialRepository;
import edu.tutorial.service.TutorialService;
import lombok.AllArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class TutorialServiceImpl implements TutorialService {
    private final TutorialRepository tutorialRepository;
    @Override
    public List<Tutorial> getCompleteTutorials(){
        return tutorialRepository.findAll();
    }

    @Override
    public Tutorial getAnyTutorial(int id) {
        return tutorialRepository.findById(id).get();
    }

    @Override
    public Tutorial createTutorial(Tutorial tutorial) {
        return tutorialRepository.save(tutorial);
    }

    @Override
    public Tutorial updateTutorial(Integer id, Tutorial tutorial) {
        Tutorial temp= tutorialRepository.findById(id).get();
        temp.setTitle(tutorial.getTitle());
        temp.setDescription(tutorial.getDescription());
        temp.setPublish_status(tutorial.isPublish_status());
        tutorialRepository.save(temp);
        return temp;
    }

    @Override
    public String deleteTutorial(Integer id) {
        tutorialRepository.deleteById(id);
        return "Tutorial Id"+id+" Deleted Successfully...";
    }


}
