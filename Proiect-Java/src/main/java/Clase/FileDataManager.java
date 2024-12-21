package Clase;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileDataManager {
    public List<Student> Citire_Studenti(String filepath) {
        List<Student> students = new ArrayList<Student>();
        try {

            File f = new File(filepath);
            BufferedReader br = new BufferedReader(new FileReader(f));
            String line = br.readLine();
            if (line != null) {
                line = br.readLine();
            }
            while (line != null) {
                String[] splituri = line.split(",");

                Student s = new Student(splituri[0], splituri[1].trim(), Integer.parseInt(splituri[2].trim()));
                students.add(s);
                line = br.readLine();
            }
            return students;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return students;
    }

    public List<Profesor> Citire_Profesori(String filepath2) {
        List<Profesor> profesors = new ArrayList<Profesor>();
        try {
            File f2 = new File(filepath2);
            BufferedReader br2 = new BufferedReader(new FileReader(f2));
            String line = br2.readLine();
            if (line != null) {
                line = br2.readLine();
            }
            while (line != null) {
                String[] splituri = line.split(",");
                Profesor p = new Profesor(splituri[0], splituri[1].trim(), splituri[2].trim());
                profesors.add(p);
                line = br2.readLine();
            }
        } catch (Exception ex){
            System.out.println(ex);
        }
        return profesors;
    }

        public static void Scriere_Studenti (String filepath, Student student){
            try {
                File f = new File(filepath);
                BufferedWriter bw = new BufferedWriter(new FileWriter(f, true));
                try {
                    bw.write(student.getNume() + "," + student.getPrenume() + "," + student.getGrupa() + "\r\n");
                    bw.flush();
                } catch (IOException e) {
                    System.out.println(e);
                } finally {
                    bw.close();
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }

    public static void Scriere_Profesori(String filepath2, Profesor profesor) {
        try {
            File f2 = new File(filepath2);
            BufferedWriter bw2 = new BufferedWriter(new FileWriter(f2,true));
            try{
                bw2.write(profesor.getNume() + "," + profesor.getPrenume() + "," + profesor.id + "\r\n");
                bw2.flush();
            }catch (IOException e){
                System.out.println(e);
            }finally{
                bw2.close();
            }
        }catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
