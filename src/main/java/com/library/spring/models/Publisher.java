package com.library.spring.models;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Set;

@Entity
@Table(name = "PUBLISHER")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME")
    @NotNull(message = "should not be null")
    @NotBlank(message = "publisher cannot be blank")
    @Pattern(regexp = "^[A-Z][a-z]{2,254}", message = "Name is not correct. Example: Publ")
    @Length(min=3, max=255, message = "publisher length isn't correct (min=3, max=255)")
    private String publisherName;
    @ManyToOne( fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "CITY_ID", nullable = false)
    private City city;
    @OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Book> books;

    public Publisher() {
    }

    public Publisher(Long id, String publisherName, City city, Set<Book> books) {
        this.id = id;
        this.publisherName = publisherName;
        this.city = city;
        this.books = books;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City cities) {
        this.city = cities;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
