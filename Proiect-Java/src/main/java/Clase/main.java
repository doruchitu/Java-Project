package Clase;

import javax.swing.*;
import java.io.IOException;
import java.util.List;

public class main {
        public static void main(String[] args) throws IOException {
//definire studenti
                Student studenti = new Student("Andrei", "Negoita", 2231);
                Student studenti1 = new Student("Ionescu", "Georgel", 4223);
                Student studenti2 = new Student("Ion", "Mateescu", 4221);
                Student[] listaStudenti = {studenti, studenti1, studenti2};
//definire profesor
                Profesor prof = new Profesor("Anton", "Panaitescu","0");
                Profesor profNou = new Profesor("Pavel", "Marcel","1");
                Profesor profNou2 = new Profesor("Ionel", "Georgel","2");
//definire curs nou
                Curs curs = new Curs("Rezistenta Materialelor", "calculul reacţiunilor,diagramele de eforturi, calculul caracteristicilor geometrice, etc..\n"
                        + prof, listaStudenti);
                Curs curs1 = new Curs("Analiza Matematica", "Serii de numere reale,Limite,etc...\n"
                        + profNou, listaStudenti);
                Curs curs2 = new Curs("Programare JAVA", "Clase, Mostenire,Exceptii si generice, Fire de executie, etc...\n"
                        + profNou2, listaStudenti);

//adaugare curs in lista de cursuri
                ManagerCursuri cursuri = new ManagerCursuri();
                cursuri.AddCurs(curs);
                cursuri.AddCurs(curs1);
                // cursuri.DeleteCurs(curs1);
                // cursuri.ModificaCurs(curs1,curs);
                cursuri.afisareCursuri();
                System.out.println("--------------------");
                cursuri.AfiseazaCursuriLaConsola();
                System.out.println("---------------------");
                curs.afisareStudentiLaCurs();
                System.out.println("-------------------------");
                //am notat studentii de la curs
                curs.noteazaStudent(listaStudenti[0], 10);
                curs.noteazaStudent(listaStudenti[1], 8);
                curs.noteazaStudent(listaStudenti[2], 7);
                //am notat studentii de la curs1
                curs1.noteazaStudent(listaStudenti[0], 9);
                curs1.noteazaStudent(listaStudenti[1], 6);
                curs1.noteazaStudent(listaStudenti[2], 5);
                //am notat studentii de la curs2
                curs2.noteazaStudent(listaStudenti[0], 8);
                curs2.noteazaStudent(listaStudenti[1], 7);
                curs2.noteazaStudent(listaStudenti[2], 5);
                curs.afisareNoteStudent();
                System.out.println("---------------------");
                curs.MedieNote();
                System.out.println("----------------------");
                curs.DeleteStudent(studenti);
                System.out.println("-----------------------");
                System.out.println("Studentii ramasi dupa stergere:");
                curs.afisareStudentiLaCurs();
                System.out.println("---------------------");
                cursuri.AddProfesorCurs("Rezistenta Materialelor", profNou);
                System.out.println("-->Lista de cursuri actualizata:");
                cursuri.AfiseazaCursuriLaConsola();
                System.out.println("---------------------");
                cursuri.DeletProfesorDupaNume("Pavel");
                System.out.println("-->Lista de cursuri actualizata dupa stergerea profesorului:");
                cursuri.AfiseazaCursuriLaConsola();
                System.out.println("--------------------------");

                // Citirea studentilor din fisier
                String filepath = "C:\\Users\\ASUS\\Desktop\\JAVA\\Proiect-Java\\src\\main\\java\\Clase\\Students.txt";
                FileDataManager fileManager = new FileDataManager();
                List<Student> students = fileManager.Citire_Studenti(filepath);
                System.out.println("Lista studentilor din fisier:");
                for (Student s : students) {
                        System.out.println("Nume: " + s.getNume() + " Prenume: " + s.getPrenume() + " Grupa: " + s.getGrupa());
                }

                //Scrierea studentilor in fisier
                String caleFisier = "C:\\Users\\ASUS\\Desktop\\JAVA\\Proiect-Java\\src\\main\\java\\Clase\\Students.txt";
                Student student = new Student("Ionel", "Marcel", 1);
                FileDataManager.Scriere_Studenti(caleFisier, student);

                System.out.println("-----------------------");

                //Citirea profesorilor din fisier
                String filepath2 = "C:\\Users\\ASUS\\Desktop\\JAVA\\Proiect-Java\\src\\main\\java\\Clase\\Profesori.txt";
                FileDataManager fileManager2 = new FileDataManager();
                List<Profesor> profesors = fileManager2.Citire_Profesori(filepath2);
                System.out.println("Lista profesorilor din fisier:");
                for (Profesor p : profesors) {
                        System.out.println(" Nume: " + p.getNume() + " Prenume: " + p.getPrenume() + " Id: " + p.getId());
                }

                System.out.println("---------------------------");

                //Scrierea profesorilor in fisier
                String caleFisier2 = "C:\\Users\\ASUS\\Desktop\\JAVA\\Proiect-Java\\src\\main\\java\\Clase\\Profesori.txt";
                Profesor profesor = new Profesor("Ionel", "Marcel", "4");
                FileDataManager.Scriere_Profesori(caleFisier2, profesor);

                //Scrierea cursurilor in fisier
                Curs.Scriere_Cursuri("Cursuri.txt", curs);
                Curs.Scriere_Cursuri("Cursuri.txt", curs1);
                Curs.Scriere_Cursuri("Cursuri.txt", curs2);

                LoginFrame frame = new LoginFrame();
                frame.setVisible(true);

        }
}