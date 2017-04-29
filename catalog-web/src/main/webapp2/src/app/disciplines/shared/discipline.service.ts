import {Injectable} from '@angular/core';
import {Http, Response} from "@angular/http";

import {Observable} from "rxjs";
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';

import {Discipline} from "./discipline.model";


@Injectable()
export class DisciplineService {
    private disciplinesUrl = 'http://localhost:8080/api/disciplines';

    constructor(private http: Http) {
    }

    getDisciplines(): Observable<Discipline[]> {
        return this.http.get(this.disciplinesUrl)
            .map(this.extractData)
            .catch(this.handleError);
    }

    private extractData(res: Response) {
        let body = res.json();
        return body.disciplines || {};
    }

    private handleError(error: Response | any) {
        let errMsg: string;
        if (error instanceof Response) {
            const body = error.json() || '';
            const err = body.error || JSON.stringify(body);
            errMsg = `${error.status} - ${error.statusText || ''} ${err}`;
        } else {
            errMsg = error.message ? error.message : error.toString();
        }
        console.error(errMsg);
        return Observable.throw(errMsg);
    }

    getDiscipline(id: number): Observable<Discipline> {
        return this.getDisciplines()
            .map(disciplines => disciplines.find(discipline => discipline.id === id));
    }

}
