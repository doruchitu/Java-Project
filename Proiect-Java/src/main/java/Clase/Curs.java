package Clase;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Curs {
    String nume;
    String descriere;
    Profesor profu;
    Student[] studenti;
    Integer[] noteStudenti;

    public Curs() {
        this.nume = "";
        this.descriere = "";
        this.profu = null;
        this.studenti = new Student[0];
        this.noteStudenti = new Integer[0];
    }

    public Curs(String nume, String descriere, Student[] studenti) {
        this.nume = nume;
        this.descriere = descriere;
        this.profu = profu;
        this.studenti = studenti;
        this.noteStudenti = new Integer[studenti.length];
    }

    public void UpdateProfesor(Profesor profu) {
        this.profu = profu;
    }

    public void AddStudent(Student student) {
//lucrand cu array trebuie inserat folosind un sir auxiliar
        int noualungime = studenti.length + 1;
        Student[] auxStudent = new Student[noualungime];
        Integer[] auxNote = new Integer[noualungime];
        int index = 0;
        for (Student s : studenti) {
            auxStudent[index++] = s;
        }
        index = 0;
        for (Integer n : noteStudenti) {
            auxNote[index++] = n;
        }
//la final adaugam noul student pe ultimul index
        auxStudent[index] = student;
        auxNote[index] = null;
//si realocam lista de studenti cu aux;
        this.studenti = new Student[noualungime];
        this.noteStudenti = new Integer[noualungime];
        System.arraycopy(auxStudent, 0, studenti, 0, noualungime);
        System.arraycopy(auxNote, 0, noteStudenti, 0, noualungime);
    }

    public void DeleteStudent(Student student) {
        int pozitia = -1;
        for (int i = 0; i < studenti.length; i++) {
            if (studenti[i].equals(student)) {
                pozitia = i;
                break;
            }
        }
        if (pozitia == -1) {
            System.out.println("Studentul nu a fost gasit");
            return;
        }
        int noualungime = studenti.length - 1;
        Student[] auxStudent = new Student[noualungime];
        Integer[] auxNote = new Integer[noualungime];
        int index = 0;
        for (int i = 0; i < studenti.length; i++) {
            if (i == pozitia) {
                continue;
            }
            auxStudent[index] = studenti[i];
            auxNote[index] = noteStudenti[i];
            index++;
        }
        this.studenti = auxStudent;
        this.noteStudenti = auxNote;
        System.out.println("Studentul " + student + " a fost sters.");
    }

    public void AddProfesor(Profesor profesor) {
        if (profesor == null) {
            System.out.println("Profesorul nu poate fi null!");
            return;
        }
        this.profu = profesor;
        System.out.println("Profesorul " + profesor + " a fost adaugat la cursul " + this.nume + " .");
    }

    public void DeletProfesor() {
        if (this.profu == null) {
            System.out.println("Cursul " + this.nume + " nu are profesor adaugat.");
            return;
        }
        System.out.println("Profesorul " + this.profu + " a fost sters de la cursul " + this.nume + " .");
        this.profu = null;
    }

    public void DeletProfesorDupaNume(String numeProfesor) {
        if (this.profu != null && this.profu.nume.equals(numeProfesor)) {
            System.out.println("Profesoeul " + this.profu + " a fost sters de la cursul " + this.nume + " .");
            this.profu = null;
        } else {
            System.out.println("Profesorul " + numeProfesor + " nu este gasit la cursul " + this.nume + " .");
        }
    }

    public void afisareStudentiLaCurs() {
        System.out.println("Studentii care participa la cursul " + this.nume + " sunt:");
        for (Student s : studenti) {
            System.out.println(s + " ");
        }
        System.out.println();
    }

    public void noteazaStudent(Student student, int nota) {
        for (int i = 0; i < studenti.length; i++) {
            if (studenti[i].equals(student)) {
                noteStudenti[i] = nota;
            }
        }
    }

    public void afisareNoteStudent() {
        System.out.println("Notele studentilor sunt urmatoarele: ");
        for (int i = 0; i < noteStudenti.length; i++) {
            System.out.println(studenti[i] + " are nota " + noteStudenti[i]);
        }
    }

    public void MedieNote() {
        int sum = 0;
        int numarStudenti = 0;
        for (int i = 0; i < studenti.length; i++) {
            if (noteStudenti[i] != null) {
                sum += noteStudenti[i];
                numarStudenti++;
            }
        }
        System.out.println("Media notelor studentilor la cursul " + nume + " este: " + sum / numarStudenti);
    }

    public static void Scriere_Cursuri(String filePath, Curs curs) {
        try {
            File file = new File(filePath);
            BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
            try {
                // Scrie numele cursului și descrierea
                bw.write("Nume curs: " + curs.nume + "\n");
                bw.write("Descriere: " + curs.descriere + "\n");

                // Scrie profesorul (dacă există)
                if (curs.profu != null) {
                    bw.write("Profesor: " + curs.profu.getNume() + " " + curs.profu.getPrenume() + "\n");
                }

                // Scrie lista de studenți și notele acestora
                if (curs.studenti.length > 0) {
                    bw.write("Studenti si note:\n");
                    for (int i = 0; i < curs.studenti.length; i++) {
                        String studentInfo = curs.studenti[i].getNume() + " " + curs.studenti[i].getPrenume();
                        String nota = (curs.noteStudenti[i] != null) ? String.valueOf(curs.noteStudenti[i]) : "N/A";
                        bw.write(" - " + studentInfo + " - Nota: " + nota + "\n");
                    }
                } else {
                    bw.write("Studenti: Niciun student înscris\n");
                }

                bw.write("---------------------------\n"); // Separator pentru claritate
                bw.flush();
            } catch (IOException e) {
                System.out.println("Eroare la scrierea în fișier: " + e.getMessage());
            } finally {
                bw.close();
            }
        } catch (Exception ex) {
            System.out.println("Eroare la manipularea fișierului: " + ex.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Curs{" +
                "nume='" + nume + '\'' +
                ", descriere='" + descriere + '\'' +
                ", profu=" + profu +
                ", studenti=" + Arrays.toString(studenti) +
                '}';
    }
}
