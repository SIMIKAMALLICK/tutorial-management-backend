package edu.tutorial.service;

import edu.tutorial.entity.Tutorial;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface TutorialService
{
    public List<Tutorial> getCompleteTutorials();
    public Tutorial getAnyTutorial(int id);
    public Tutorial createTutorial(Tutorial tutorial);
    public Tutorial updateTutorial(Integer id, Tutorial tutorial);
    public String deleteTutorial(Integer id);
}
