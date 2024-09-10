import { Component, OnInit } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common'; 
import { AlumnosService } from '../alumnos.service';  


@Component({
  selector: 'app-alumnos',
  standalone: true,
  imports: [HttpClientModule, FormsModule, CommonModule],
  templateUrl: './alumnos.component.html',
  styleUrl: './alumnos.component.css'
})
export class AlumnosComponent implements OnInit {
  alumnos: any[] = [];
  nuevoAlumno = { nombre: '', apellido: '', edad: 0, email: '' };
  alumnoEditado: any = null;

  constructor(private alumnosService: AlumnosService) { }

  ngOnInit(): void {
    console.log('AlumnosComponent loaded');
    this.obtenerAlumnos();
  }


  obtenerAlumnos() {
    this.alumnosService.getAlumnos().subscribe(data => {
      this.alumnos = data;
    });
  }

  crearAlumno() {
    if (this.alumnoEditado) {
      // Si hay un alumno siendo editado, entonces actualizar
      this.alumnosService.updateAlumno(this.alumnoEditado.id, this.nuevoAlumno).subscribe(() => {
        this.obtenerAlumnos();
        this.alumnoEditado = null;
        this.nuevoAlumno = { nombre: '', apellido: '', edad: 0, email: '' };
      });
    } else {
      // Si no hay alumno siendo editado, entonces crear
      this.alumnosService.createAlumno(this.nuevoAlumno).subscribe(() => {
        this.obtenerAlumnos();
        this.nuevoAlumno = { nombre: '', apellido: '', edad: 0, email: '' };
      });
    }
  }
  editarAlumno(alumno: any) {
    this.alumnoEditado = alumno;
    this.nuevoAlumno = { ...alumno };  // Clonamos los datos del alumno en el formulario
  }

  eliminarAlumno(id: number) {
    this.alumnosService.deleteAlumno(id).subscribe(() => {
      this.obtenerAlumnos();
    });
  }
}
