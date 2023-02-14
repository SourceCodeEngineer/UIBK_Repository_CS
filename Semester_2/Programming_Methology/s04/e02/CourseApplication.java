package at.ac.uibk.pm.gXX.zidUsername.s04.e02;

public class CourseApplication {

    public static void main(String[] args) {
        Course course = new Course();
        String[] students = {"Donald Duck", "Donald Duck", "Uncle Scrooge", "Gyro Gearloose"};

        for (String student : students) {
            if (course.addStudent(student)) {
                System.out.println("Successfully added " + student);
            } else {
                System.out.println("Failed to add " + student);
            }
        }
    }
}