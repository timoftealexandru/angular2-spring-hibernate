/**
 * Created by Nicu on 4/11/17.
 */
export class Movie {
  id: number
  name: string;
  director: string;
  genre: string;
  availableCopies: number;
  clients: number[];

  constructor(name:string,director:string,genre:string,availableCopies:number){
    this.name=name;
    this.director=director;
    this.genre=genre;
    this.availableCopies=availableCopies;
  }
}
