package se.iths.validations;

import se.iths.entity.Teacher;
import se.iths.exceptions.SchoolAppException;

public abstract class ApplicationValidation {

    public static void checkIfTeacherExist(Teacher teacherToFind) {
        if (teacherToFind == null) {
            throw new SchoolAppException("Teacher does not exist.. please try another one :)");
        }
    }
}
