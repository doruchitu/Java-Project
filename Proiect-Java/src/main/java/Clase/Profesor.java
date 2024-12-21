package Clase;

public class Profesor extends Persoana {
    String id;
    public Profesor() {
        this.nume = "";
        this.prenume = "";
        this.id = "";
    }

    public Profesor(String nume, String prenume, String id)
    {
        super(nume, prenume);
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "id='" + id + '\'' +
                ", prenume='" + prenume + '\'' +
                ", nume='" + nume + '\'' +
                '}';
    }
}
