package com.egg.identidades;

@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "isbn")
    private Long isbn;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "anio")
    private Integer anio;

    @Column(name = "ejemplares")
    private Integer ejemplares;

    @Column(name = "alta")
    private Boolean alta;

    @ManyToOne
    @JoinColumn(name = "autor")
    private Autor autor;

    @ManyToOne
    @JoinColumn(name = "editorial")
    private Editorial editorial;

    public Libro() {
    }

    public Libro(String titulo, Integer anio, Integer ejemplares, Boolean alta, Autor autor, Editorial editorial) {
        this.titulo = titulo;
        this.anio = anio;
        this.ejemplares = ejemplares;
        this.alta = alta;
        this.autor = autor;
        this.editorial = editorial;
    }

    public Libro(Long isbn, String titulo, Integer anio, Integer ejemplares, Boolean alta, Autor autor, Editorial editorial) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.anio = anio;
        this.ejemplares = ejemplares;
        this.alta = alta;
        this.autor = autor;
        this.editorial = editorial;
    }

    public getIsbn() {
        return isbn;
    }

    public setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public getTitulo() {
        return titulo;
    }

    public setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public getAnio() {
        return anio;
    }

    public setAnio(Integer anio) {
        this.anio = anio;
    }

    public getEjemplares() {
        return ejemplares;
    }

    public setEjemplares(Integer ejemplares) {
        this.ejemplares = ejemplares;
    }

    public getAlta() {
        return alta;
    }

    public setAlta(Boolean alta) {
        this.alta = alta;
    }

    public getAutor() {
        return autor;
    }

    public setAutor(Autor autor) {
        this.autor = autor;
    }

    public getEditorial() {
        return editorial;
    }

    public setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }
}
