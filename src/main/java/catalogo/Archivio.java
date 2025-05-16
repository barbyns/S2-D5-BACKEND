package catalogo;

import catalogo.model.*;
import java.util.*;
import java.util.stream.*;

public class Archivio {
    private Map<String, ElementoCatalogo> catalogo = new HashMap<>();

    public void aggiungiElemento(ElementoCatalogo e) throws CustomExceptions.ISBNAlreadyExistsException {
        if (catalogo.containsKey(e.getIsbn())) throw new CustomExceptions.ISBNAlreadyExistsException("ISBN già presente");
        catalogo.put(e.getIsbn(), e);
    }

    public ElementoCatalogo ricercaISBN(String isbn) throws CustomExceptions.ISBNNotFoundException {
        if (!catalogo.containsKey(isbn)) throw new CustomExceptions.ISBNNotFoundException("ISBN non trovato");
        return catalogo.get(isbn);
    }

    public void rimuoviElemento(String isbn) throws CustomExceptions.ISBNNotFoundException {
        if (!catalogo.containsKey(isbn)) throw new CustomExceptions.ISBNNotFoundException("ISBN non trovato");
        catalogo.remove(isbn);
    }

    public List<ElementoCatalogo> ricercaPerAnno(int anno) {
        return catalogo.values().stream()
                .filter(e -> e.getAnnoPubblicazione() == anno)
                .toList();
    }

    public List<Libro> ricercaPerAutore(String autore) {
        return catalogo.values().stream()
                .filter(e -> e instanceof Libro)
                .map(e -> (Libro) e)
                .filter(l -> l.getAutore().equalsIgnoreCase(autore))
                .toList();
    }

    public void aggiornaElemento(String isbn, ElementoCatalogo nuovo) throws CustomExceptions.ISBNNotFoundException {
        if (!catalogo.containsKey(isbn)) throw new CustomExceptions.ISBNNotFoundException("Elemento non esistente");
        catalogo.put(isbn, nuovo);
    }

    public void statisticheCatalogo() {
        long numLibri = catalogo.values().stream().filter(e -> e instanceof Libro).count();
        long numRiviste = catalogo.values().stream().filter(e -> e instanceof Rivista).count();
        Optional<ElementoCatalogo> maxPagine = catalogo.values().stream()
                .max(Comparator.comparingInt(ElementoCatalogo::getNumeroPagine));
        double mediaPagine = catalogo.values().stream()
                .mapToInt(ElementoCatalogo::getNumeroPagine).average().orElse(0);

        System.out.println("Libri: " + numLibri);
        System.out.println("Riviste: " + numRiviste);
        maxPagine.ifPresent(e -> System.out.println("Elemento con più pagine: " + e.getTitolo()));
        System.out.println("Media pagine: " + mediaPagine);
    }
}
