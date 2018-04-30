package com.example.administration.Static;

import com.example.administration.Models.StudentModel;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Handles everything from creating fake/premade/gather DB/static list of models
 */
public class ModelsHandler
{
    private List<StudentModel> studentsList;
    private final String[] fNames = {"Troels", "Kristina", "Simon", "Martin", "Børge", "Preben"};
    private final String[] lNames = {"Jensen", "Kristensen", "Hansen", "somesen", "Mercedes", "Jørgensen"};

    public ModelsHandler()
    {
        this.studentsList = new ArrayList<>();

        // generate models
        gatherStudentModels();
    }

    // Getters
    public List<StudentModel> getStudentsList() { return this.studentsList; }

    // Generate models methods
    private void gatherStudentModels() {
        for (int i = 0; i < 6; i++)
            this.studentsList.add(
                    new StudentModel(
                        0, fNames[randomInt(fNames.length)],
                            lNames[randomInt(lNames.length)], generateCPR(),
                            new Date(2018-01-29)
            ));
    }

    private String generateCPR() {
        return "" + (randomInt(3)) + (randomInt(10)) + (randomInt(10)) +
                    (randomInt(10)) + (randomInt(10)) + (randomInt(10)) + "-" +
                    (randomInt(10)) + (randomInt(10)) + (randomInt(10)) +
                    (randomInt(10));
    }

    private double random(int range) {
        return Math.random() * range + 1;
    }

    private int randomInt(int range) {
    return (int)(Math.random() * range);
    }
}
