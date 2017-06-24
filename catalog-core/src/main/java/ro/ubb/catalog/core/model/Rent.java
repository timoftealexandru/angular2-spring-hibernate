package ro.ubb.catalog.core.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Nicu on 4/9/17.
 */

@Entity
@Table(name = "rents")
@IdClass(RentPK.class)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Rent implements Serializable {

    @Id
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private Client client;

    @Id
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @Column(name = "noCopies")
    private Integer noCopies;
}
