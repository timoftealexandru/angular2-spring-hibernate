package ro.ubb.catalog.core.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by macbookpro on 4/9/17.
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

//public class Rent extends BaseEntity<Long>{
//    //region Fields
////    @Id
////    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "movietitle", nullable = false)
//    private String movieTitle;
//
//    @Column(name = "clientcnp", nullable = false)
//    private int clientcnp;
//
//    @Column(name = "noCopies", nullable = false)
//    private int noCopies;
//
//
//    //endregion
//
//    //region Constructor
//
//    public Rent(){
//
//    }
//
//    public Rent(int clientcnp, String movieTitle, int noCopies) {
//        this.clientcnp = clientcnp;
//        this.movieTitle = movieTitle;
//        this.noCopies = noCopies;
//    }
//    //endregion
//
//    //region Methods
//
//    public int getClientCnp() {
//        return this.clientcnp;
//    }
//
//    public String getMovieTitle() {
//        return this.movieTitle;
//    }
//
//    public void setClientCnp(int cnp){
//        this.clientcnp=cnp;
//    }
//
//    public void setMovieTitle(String movieTitle){
//        this.movieTitle =movieTitle;
//    }
//
//    public void setNoCopies(int noCopies){
//        this.noCopies=noCopies;
//    }
//
//    public int getNoCopies() {
//        return this.noCopies;
//    }
//
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Rent that = (Rent) o;
//
//        if (movieTitle != that.movieTitle) return false;
//        if (clientcnp!=that.clientcnp) return false;
//        return noCopies == that.noCopies;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = this.toString().hashCode();
//        return result;
//    }
//
//    public String toString() {
//        return "Rent{" +
//                "clientCnp='" + clientcnp + '\'' +
//                ", movieTitle='" + movieTitle + '\'' +
//                ", no of copies='" + noCopies + '\'' +
//                "} " + super.toString();
//    }
//    //endregion
//}
