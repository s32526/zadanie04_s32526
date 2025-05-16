public class Main {
    public static void main(String[] args) {

        SystemRezerwacji system = new SystemRezerwacji();

        // Dodaj wydarzenia
        Wydarzenie koncert = new Wydarzenie("Koncert Symphony", 120.0);
        Wydarzenie teatr = new Wydarzenie("Hamlet", 85.0);
        koncert.setDostepneMiejsca(50);
        teatr.setDostepneMiejsca(30);

        system.dodajWydarzenie(koncert);
        system.dodajWydarzenie(teatr);

        // Dodaj klientów
        Klient klient1 = new Klient("Jan", "Kowalski", "jan@example.com");
        Klient klient2 = new Klient("Anna", "Nowak", "anna@example.com");

        system.dodajKlienta(klient1);
        system.dodajKlienta(klient2);

        // Rezerwacje
        system.dokonajRezerwacji(klient1, koncert);
        system.dokonajRezerwacji(klient1, teatr);
        system.dokonajRezerwacji(klient2, koncert);

        // Wyświetlanie rezerwacji
        System.out.println("\nRezerwacje klienta " + klient1.getImie() + " " + klient1.getNazwisko() + ":");
        klient1.wyswietlRezerwacje();

        // Zmiana ceny wydarzenia przez referencję
        Wydarzenie koncertRef = system.znajdzWydarzenie("Koncert Symphony");
        System.out.println("\nZmiana ceny koncertu z " + koncertRef.getCena() + " na 150.0 zł");
        koncertRef.setCena(150.0);

        // Sprawdzenie zmian
        System.out.println("\nRezerwacje klienta " + klient1.getImie() + ":");
        klient1.wyswietlRezerwacje();

        System.out.println("\nRezerwacje klienta " + klient2.getImie() + ":");
        klient2.wyswietlRezerwacje();

        // Anulowanie rezerwacji
        System.out.println("\nKlient " + klient1.getImie() + " anuluje rezerwację na teatr:");
        klient1.anulujRezerwacje(teatr);
        klient1.wyswietlRezerwacje();

        // Liczba miejsc po rezerwacjach
        System.out.println("\nDostępne miejsca na koncercie: " +
                koncert.getDostepneMiejsca() + " z " + koncert.getMaxLiczbaMiejsc());
    }
}
