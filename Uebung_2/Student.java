public class Student {
    private String name;
    private String emailStudent;
    private int noteStudent;
    private boolean aufgerufen;

    Student (String name, String emailStudent, int noteStudent, boolean aufgerufen) {
        this.name = name;
        this.emailStudent = emailStudent;
        this.noteStudent = noteStudent;
        this.aufgerufen = aufgerufen;
    }

    public int getNoteStudent() {
        return noteStudent;
    }
    public String getEmailStudent() {
        return emailStudent;
    }

    // Getter method for the name
    public String getName() {
        return name;
    }

    public boolean getStatus() {
        return aufgerufen;
    }

    public void setStatus(boolean n){
        this.aufgerufen =n;
    }
}
