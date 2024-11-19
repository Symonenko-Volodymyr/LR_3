package Symonenko.V;

import Symonenko.V.controller.*;
import Symonenko.V.model.*;

public class Run {
    public static void main(String[] args) {
        Run run = new Run();
        University university = run.createTypicalUniversity();
        run.printUniversityStructure(university);
    }

    public University createTypicalUniversity() {
        UniversityCreator universityCreator = new UniversityCreator();
        FacultyCreator facultyCreator = new FacultyCreator();
        DepartmentCreator departmentCreator = new DepartmentCreator();
        GroupCreator groupCreator = new GroupCreator();
        StudentCreator studentCreator = new StudentCreator();

        // Створення директора університету
        Human universityHead = new Human("Volodymyr", "Symonenko", "Andreyovych", Sex.MALE) {};

        // Створення університету
        University university = universityCreator.createUniversity("NTU(DP)", universityHead);

        // Створення факультету університету
        Human facultyHead = new Human("Kyrylo", "Bublyk", "Olegovych", Sex.MALE) {};
        Faculty faculty = facultyCreator.createFaculty("Faculty of Computer Informatics", facultyHead);

        // Створення кафедри університету
        Human departmentHead = new Human("Angelina", "Jolie", "Voight", Sex.FEMALE) {};
        Department department = departmentCreator.createDepartment("Department of System Analysis", departmentHead);

        // Створення групи університету
        Human groupHead = new Human("Leonardo", "Wilhelm", "DiCaprio", Sex.MALE) {};
        Group group = groupCreator.createGroup("Group 124-21-1", groupHead);

        // Додавання студентів
        group.addStudent(studentCreator.createStudent("Christopher", "Robert", "Evans", Sex.MALE));
        group.addStudent(studentCreator.createStudent("Scarlett", "Ingrid", "Johansson", Sex.FEMALE));

        // Додавання підрозділів
        department.addGroup(group);
        faculty.addDepartment(department);
        university.addFaculty(faculty);

        return university;
    }

    public void printUniversityStructure(University university) {
        System.out.println("Університет: " + university.getName());
        System.out.println("Голова університету: " + university.getHead().getFullName());
        for (Faculty faculty : university.getFaculties()) {
            System.out.println("\tФакультет: " + faculty.getName());
            System.out.println("\tГолова факультету: " + faculty.getHead().getFullName());
            for (Department department : faculty.getDepartments()) {
                System.out.println("\t\tКафедра: " + department.getName());
                System.out.println("\t\tГолова кафедри: " + department.getHead().getFullName());
                for (Group group : department.getGroups()) {
                    System.out.println("\t\t\tГрупа: " + group.getName());
                    System.out.println("\t\t\tСтароста групи: " + group.getHead().getFullName());
                    System.out.println("\t\t\tСтуденти:");
                    for (Student student : group.getStudents()) {
                        System.out.println("\t\t\t\t| " + student.getFullName() + " (" + student.getGender() + ")");
                    }
                }
            }
        }
    }
}