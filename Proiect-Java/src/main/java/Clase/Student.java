package Clase;

public class Student extends Persoana {

    private int grupa;

    public Student() {
        this.nume = "";
        this.prenume = "";
        this.grupa = 0;
    }

    public Student(String nume, String prenume, int grupa)
    {
        this.nume = nume;
        this.prenume = prenume;
        this.grupa = grupa;
    }

    public int getGrupa() {
        return grupa;
    }

    public void setGrupa(int grupa) {
        this.grupa = grupa;
    }

    @Override
    public String toString() {
        return "Student{" +
                "grupa=" + grupa +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                '}';
    }
}

