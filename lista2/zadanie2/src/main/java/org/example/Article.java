package org.example;

/**.
 * Klasa towaru.
 */
public class Article  {
    /** Nazwa towaru. */
    protected String article;
    /** cena towaru. */
    protected double prize;

    /**
     * Konstruktor towaru z niezbednymi informacjami charakteryzujacymi go.
     * @param article nazwa towaru
     * @param prize cena netto towaru
     */
    Article(final String article, final double prize) {
        this.article = article;
        this.prize = prize;
    }
}
