package ro.ubb.catalog.core.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Nicu on 4/9/17.
 */

@Entity
@Table(name = "movie")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Movie extends BaseEntity<Long> {


    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "director", nullable = false)
    private String director;

    @Column(name = "genre", nullable = false)
    private String genre;

    @Column(name = "availableCopies", nullable = false)
    private int availableCopies;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<Rent> rents = new HashSet<>();

    public Set<Client> getClients() {
        return Collections.unmodifiableSet(
                this.rents.stream().
                        map(r -> r.getClient()).
                        collect(Collectors.toSet()));
    }

    public void addClient(Client client) {
        Rent rent = new Rent();
        rent.setClient(client);
        rent.setMovie(this);
        rents.add(rent);
    }

    public void addClients(Set<Client> clients) {
        clients.stream()
                .forEach(c -> addClient(c));
    }

    public void addNoCopies(Client client, Integer noCopies) {
        Rent rent = new Rent();
        rent.setClient(client);
        rent.setNoCopies(noCopies);
        rent.setMovie(this);
        rents.add(rent);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        return name.equals(movie.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "Movie{" +
              //  "id='" + id + '\'' +
                "name='" + name + '\'' +
                ", director='" + director + '\'' +
                ", genre='" + genre + '\'' +
                ", available copies =" + availableCopies +
                "} " + super.toString();
    }
}
