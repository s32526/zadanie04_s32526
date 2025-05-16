import java.util.ArrayList;

public class SystemRezerwacji {

    private ArrayList<Wydarzenie> listaWydarzen;
    private ArrayList<Klient> listaKlientow;

    public SystemRezerwacji() {
        this.listaWydarzen = new ArrayList<>();
        this.listaKlientow = new ArrayList<>();
    }

    public void dodajWydarzenie(Wydarzenie wydarzenie) {
        listaWydarzen.add(wydarzenie);
    }

    public void dodajWydarzenie(String nazwa, double cena) {
        Wydarzenie wydarzenie = new Wydarzenie(nazwa, cena);
        listaWydarzen.add(wydarzenie);
    }

    public void dodajKlienta(Klient klient) {
        listaKlientow.add(klient);
    }

    public void dodajKlienta(String imie, String nazwisko, String email) {
        Klient klient = new Klient(imie, nazwisko, email);
        listaKlientow.add(klient);
    }

    public void dokonajRezerwacji(Klient klient, Wydarzenie wydarzenie) {
        if (wydarzenie.getDostepneMiejsca() > 0) {
            klient.dodajRezerwacje(wydarzenie);
            wydarzenie.zarezerwujMiejsce();
        } else {
            System.out.println("Brak miejsc na wydarzenie: " + wydarzenie.getNazwa());
        }
    }

    public Wydarzenie znajdzWydarzenie(String nazwa) {
        for (Wydarzenie wydarzenie : listaWydarzen) {
            if (wydarzenie.getNazwa().equals(nazwa)) {
                return wydarzenie;
            }
        }
        return null;
    }

    public Klient znajdzKlienta(String nazwisko) {
        for (Klient klient : listaKlientow) {
            if (klient.getNazwisko().equals(nazwisko)) {
                return klient;
            }
        }
        return null;
    }

    public void zmienCeneWydarzenia(String nazwa, double nowaCena) {
        Wydarzenie wydarzenie = znajdzWydarzenie(nazwa);
        if (wydarzenie != null) {
            wydarzenie.setCena(nowaCena);
        } else {
            System.out.println("Nie znaleziono wydarzenia o nazwie: " + nazwa);
        }
    }

}
