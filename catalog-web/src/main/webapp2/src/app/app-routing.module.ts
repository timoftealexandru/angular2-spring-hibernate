import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {StudentDetailComponent} from "./students/student-detail/student-detail.component";
import {StudentsComponent} from "./students/students.component";
import {DisciplinesComponent} from "./disciplines/disciplines.component";
import {DisciplineDetailComponent} from "./disciplines/discipline-detail/discipline-detail.component";


const routes: Routes = [
    // { path: '', redirectTo: '/home', pathMatch: 'full' },
    { path: 'students',     component: StudentsComponent },
    { path: 'student/detail/:id', component: StudentDetailComponent},

    { path: 'disciplines',     component: DisciplinesComponent },
    { path: 'discipline/detail/:id', component: DisciplineDetailComponent},
];
@NgModule({
    imports: [ RouterModule.forRoot(routes) ],
    exports: [ RouterModule ]
})
export class AppRoutingModule {}
