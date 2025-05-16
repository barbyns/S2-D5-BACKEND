package catalogo.model;

public class ElementoCatalogo {
    protected String isbn;
    protected String titolo;
    protected int annoPubblicazione;
    protected int numeroPagine;

    public ElementoCatalogo(String isbn, String titolo, int annoPubblicazione, int numeroPagine){
        this.isbn= isbn;
        this.titolo = titolo;
        this.annoPubblicazione= annoPubblicazione;
        this.numeroPagine=numeroPagine;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public String getTitolo() {
        return titolo;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }
}
