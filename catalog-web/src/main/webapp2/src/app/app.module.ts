import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';

import {AppComponent} from './app.component';
import {StudentService} from "./students/shared/student.service";
import {AppRoutingModule} from "./app-routing.module";
import {StudentDetailComponent} from "./students/student-detail/student-detail.component";
import {StudentsComponent} from "./students/students.component";
import {StudentListComponent} from "./students/student-list/student-list.component";
import {DisciplinesComponent} from "./disciplines/disciplines.component";
import {DisciplineListComponent} from "./disciplines/discipline-list/discipline-list.component";
import {DisciplineService} from "./disciplines/shared/discipline.service";
import {DisciplineDetailComponent} from "./disciplines/discipline-detail/discipline-detail.component";

@NgModule({
    declarations: [
        AppComponent,
        StudentDetailComponent,
        StudentsComponent,
        StudentListComponent,

        DisciplinesComponent,
        DisciplineListComponent,
        DisciplineDetailComponent
    ],
    imports: [
        BrowserModule,
        FormsModule,
        HttpModule,
        AppRoutingModule,
    ],
    providers: [StudentService,DisciplineService],
    bootstrap: [AppComponent]
})
export class AppModule {
}


