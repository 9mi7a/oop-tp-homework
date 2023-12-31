import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create lists to store objects
        List<Student> students = new ArrayList<>();
        List<Teacher> teachers = new ArrayList<>();
        List<Club> clubs = new ArrayList<>();
        List<Subject> subjects = new ArrayList<>();
        List<Exam> exams = new ArrayList<>();

        System.out.println("Enter student information (name and ID), type 'done' to finish:");
           while (true) {
            System.out.print("Name: ");
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("done")) {
                break;
            }
            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            students.add(new Student(name, id));
        }

        // Get user input for teachers
        System.out.println("\nEnter teacher information (name and ID), type 'done' to finish:");
        while (true) {
            System.out.print("Name: ");
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("done")) {
                break;
            }
            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            teachers.add(new Teacher(name, id));
        }

        // Get user input for clubs
        System.out.println("\nEnter club information (name), type 'done' to finish:");
        while (true) {
            System.out.print("Name: ");
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("done")) {
                break;
            }
            Club club = new Club(name);
            System.out.println("Enter club members (name and ID), type 'done' to finish:");
            while (true) {
                System.out.print("Member Name: ");
                String memberName = scanner.nextLine();
                if (memberName.equalsIgnoreCase("done")) {
                    break;
                }
                System.out.print("Member ID: ");
                int memberId = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
                Student member = new Student(memberName, memberId);
                club.add_member(member);
            }
            clubs.add(club);
        }

        // Get user input for subjects
        System.out.println("\nEnter subject information (name), type 'done' to finish:");
        while (true) {
            System.out.print("Name: ");
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("done")) {
                break;
            }
            Subject subject = new Subject(name);
            System.out.println("Enter teacher information for the subject (name and ID), type 'done' to finish:");
            while (true) {
                System.out.print("Teacher Name: ");
                String teacherName = scanner.nextLine();
                if (teacherName.equalsIgnoreCase("done")) {
                     break;
                 }
                System.out.print("Teacher ID: ");
                int teacherId = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
                Teacher teacher = new Teacher(teacherName, teacherId);
                subject.addTeacher(teacher);
            }
            subjects.add(subject);
        }

        // Get user input for exams
        System.out.println("\nEnter exam information (name), type 'done' to finish:");
        while (true) {
            System.out.print("Name: ");
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("done")) {
                break;
            }
            System.out.println("Select a subject for the exam:");
            for (int i = 0; i < subjects.size(); i++) {
                System.out.println((i + 1) + ". " + subjects.get(i).getSubjectName());
            }
            int subjectChoice = scanner.nextInt();
            Subject selectedSubject = subjects.get(subjectChoice - 1);
            scanner.nextLine();
            Exam exam = new Exam(name, selectedSubject);
            System.out.println("Enter enrolled students for the exam (name and ID), type 'done' to finish:");
            while (true) {
                System.out.print("Student Name: ");
                 String studentName = scanner.nextLine();
                if (studentName.equalsIgnoreCase("done")) {
                    break;
                }
                System.out.print("Student ID: ");
                int studentId = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
                Student student = new Student(studentName, studentId);
                exam.enrollStudent(student);
            }
            exams.add(exam);
        }

        // Display information
        System.out.println("\nUniversity System");
         System.out.println("----------------------------");
        System.out.println("\nStudents:");
        for (Student student : students) {
             System.out.println(student);
        }
        System.out.println("\nTeachers:");
        for (Teacher teacher : teachers) {
            System.out.println(teacher);
        }
        System.out.println("\nClubs:");
        for (Club club : clubs) {
            System.out.println(club);
            displayClubMembers(club);
        }
        System.out.println("\nSubjects:");
        for (Subject subject : subjects) {
            System.out.println(subject);
        }
        System.out.println("\nExams:");
        for (Exam exam : exams) {
            System.out.println(exam);
            displayEnrolledStudents(exam);
        }

        scanner.close();
    }
////////////////////////
    private static void displayClubMembers(Club club) {
        System.out.println("Members of the " + club.getClubName() + ":");
        for (Student member : club.getMembers()) {
            System.out.println("- " + member.getName());
        }
        System.out.println("----------------------------");
    }



    private static void displayEnrolledStudents(Exam exam) {
        System.out.println("Enrolled Students for " + exam.getExamName() + ":");
        for (Student student : exam.getEnrolledStudents()) {
            System.out.println("- " + student.getName());
        }
        System.out.println("----------------------------");


    }}
