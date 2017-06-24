/**
 * Created by Nicu on 4/9/17.
 */

export class Rent {
  movieId: number;
  clientId: number;
  noCopies: number;

  constructor(clientId: number, movieId: number, noCopies: number) {
    this.movieId=movieId;
    this.clientId=clientId;
    this.noCopies=noCopies;
  }
}
