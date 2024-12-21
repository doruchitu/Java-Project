package Clase;
import java.sql.Connection;


public class ManagerCursuri {
    Curs[] cursuri;

    public ManagerCursuri()
    {
        Connection conn = null;
        cursuri = new Curs[0];
    }

    public void AddCurs(Curs curs)
    {
        int noualungime = cursuri.length + 1;
        Curs[] aux = new Curs[noualungime];
        int index =0;
        for(Curs c : cursuri)
        {
            aux[index++] = c;
        }
//la final adaugam noul curs pe ultimul index
        aux[index] = curs;
//si realocam lista de curs cu aux;
        this.cursuri = new Curs[noualungime];
        System.arraycopy(aux, 0, cursuri, 0, noualungime);
    }

    //functie pentru a sterge un curs
    public void DeleteCurs (Curs curs) {
        int noualungime = cursuri.length - 1;
        Curs[] aux = new Curs[noualungime];
        int index = 0;
        for (Curs c: cursuri) {
            if(!c.equals(curs))
                aux[index++] = c;
        }
        this.cursuri = new Curs[noualungime];
        System.arraycopy(aux, 0, cursuri, 0, noualungime);
    }

    //functie pentru modificare cursuri
    public void ModificaCurs(Curs curs, Curs cursNou) {
        for (int i = 0; i < cursuri.length; i++) {
            if (cursuri[i].equals(curs)) {
                cursuri[i] = cursNou;
            }
        }
    }

    public void afisareCursuri() {
        System.out.println("Cursurile disponibile sunt: ");
        for (Curs c : this.cursuri) {
            System.out.println(c.nume + " ");
        }
    }

    public void AfiseazaCursuriLaConsola()
    {
        for(Curs c : cursuri)
            System.out.println(c);
    }

    public void MediaNoteProfesor(Profesor profesor) {
        int sumNote = 0;
        int numarNote = 0;
        for(Curs c : this.cursuri) {
            if(c.profu.equals(profesor)) {
                for(Integer nota : c.noteStudenti) {
                    sumNote += nota;
                    numarNote++;
                }
            }
        }
        System.out.println("Media notelor acordate de profesorul " + profesor.nume + " " + profesor.prenume + "este: " + sumNote + "/" + sumNote/numarNote);
    }

    public void AddProfesorCurs(String numeCurs, Profesor profesor) {
        for(Curs curs : cursuri) {
            if (curs.nume.equals(numeCurs)) {
                curs.AddProfesor(profesor);
                return;
            }
            System.out.println("Profesorul " + profesor + " a fost adaugat la cursul " + numeCurs + " .");
        }
        System.out.println("Cursul cu numele " + numeCurs + " nu a fost gasit.");
    }

    public void DeletProfesorCurs(String numeCurs) {
        for(Curs curs : cursuri) {
            if(curs.nume.equals(numeCurs)) {
                curs.DeletProfesor();
                return;
            }
        }
        System.out.println("Cursul cu numele " + numeCurs + " este de negasit.");
    }

    public void DeletProfesorDupaNume(String numeProfesor) {
        boolean ProfesorGasit = false;
        for(Curs curs : cursuri) {
            if(curs.profu != null && curs.profu.nume.equals(numeProfesor)) {
                curs.profu = null;
                ProfesorGasit = true;
                System.out.println("Profesorul " + numeProfesor + " a fost șters de la cursul " + curs.nume);
            }
        }
        if(!ProfesorGasit) {
            System.out.println("Profesorul " + numeProfesor + " nu a fost gasit.");
        }
    }
}

