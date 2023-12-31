import java.util.*;
class Club {
     private String Name;
    private List<Student> members;

    public Club(String clubName) {
        this.Name = clubName;
        this.members = new ArrayList<>();
    }
    public String getClubName() {
        return Name;
    }
    public List<Student> getMembers() {
        return members;
    }

    public void add_member(Student student) {
        members.add(student);
    }

     @Override
     public String toString() {
        return "Club [clubName=" + Name + "]";
    }}
