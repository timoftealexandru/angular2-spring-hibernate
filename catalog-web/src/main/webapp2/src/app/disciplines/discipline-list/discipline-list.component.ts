import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";

import {Discipline} from "../shared/discipline.model";
import {DisciplineService} from "../shared/discipline.service";


@Component({
    moduleId: module.id,
    selector: 'ubb-discipline-list',
    templateUrl: './discipline-list.component.html',
    styleUrls: ['./discipline-list.component.css'],
})
export class DisciplineListComponent implements OnInit {
    errorMessage: string;
    disciplines: Discipline[];
    selectedDiscipline: Discipline;

    constructor(private disciplineService: DisciplineService,
                private router: Router) {
    }

    ngOnInit(): void {
        this.getDisciplines();
    }

    getDisciplines() {
        this.disciplineService.getDisciplines()
            .subscribe(
                disciplines => this.disciplines = disciplines,
                error => this.errorMessage = <any>error
            );
    }

    onSelect(discipline: Discipline): void {
        this.selectedDiscipline = discipline;
    }

    gotoDetail(): void {
        this.router.navigate(['/discipline/detail', this.selectedDiscipline.id]);
    }

}
