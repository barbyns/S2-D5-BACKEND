package catalogo;

import catalogo.model.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Archivio archivio = new Archivio();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n1. Aggiungi libro\n2. Aggiungi rivista\n3. Ricerca ISBN\n4. Ricerca per autore\n5. Statistiche\n6. Esci");
            int scelta = Integer.parseInt(scanner.nextLine());

            try {
                switch (scelta) {
                    case 1 -> {
                        System.out.print("ISBN: ");
                        String isbn = scanner.nextLine();
                        System.out.print("Titolo: ");
                        String titolo = scanner.nextLine();
                        System.out.print("Anno: ");
                        int anno = Integer.parseInt(scanner.nextLine());
                        System.out.print("Pagine: ");
                        int pagine = Integer.parseInt(scanner.nextLine());
                        System.out.print("Autore: ");
                        String autore = scanner.nextLine();
                        System.out.print("Genere: ");
                        String genere = scanner.nextLine();

                        archivio.aggiungiElemento(new Libro(isbn, titolo, anno, pagine, autore, genere));
                    }
                    case 2 -> {
                        System.out.print("ISBN: ");
                        String isbn = scanner.nextLine();
                        System.out.print("Titolo: ");
                        String titolo = scanner.nextLine();
                        System.out.print("Anno: ");
                        int anno = Integer.parseInt(scanner.nextLine());
                        System.out.print("Pagine: ");
                        int pagine = Integer.parseInt(scanner.nextLine());
                        System.out.print("Periodicità (SETTIMANALE, MENSILE, SEMESTRALE): ");
                        Periodicita periodicita = Periodicita.valueOf(scanner.nextLine().toUpperCase());

                        archivio.aggiungiElemento(new Rivista(isbn, titolo, anno, pagine, periodicita));
                    }
                    case 3 -> {
                        System.out.print("ISBN: ");
                        String isbn = scanner.nextLine();
                        System.out.println(archivio.ricercaISBN(isbn));
                    }
                    case 4 -> {
                        System.out.print("Autore: ");
                        String autore = scanner.nextLine();
                        archivio.ricercaPerAutore(autore).forEach(System.out::println);
                    }
                    case 5 -> archivio.statisticheCatalogo();
                    case 6 -> running = false;
                    default -> System.out.println("Scelta non valida");
                }
            } catch (Exception e) {
                System.out.println("Errore: " + e.getMessage());
            }
        }
        scanner.close();
    }
}
