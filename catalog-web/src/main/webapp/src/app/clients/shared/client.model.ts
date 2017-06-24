/**
 * Created by Nicu on 4/9/17.
 */
export class Client {
  id: number;
  cnp: number;
  name: string;
  movies:number[];
  constructor(id:number, cnp:number,name:string,movies:number[]){
    this.id=id;
    this.cnp=cnp;
    this.name=name;
    this.movies=movies;
  }
}
