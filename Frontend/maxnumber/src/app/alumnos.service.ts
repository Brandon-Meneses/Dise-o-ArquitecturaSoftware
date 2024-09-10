import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AlumnosService {
  private apiUrl = 'http://localhost:8080/api/alumnos';  // URL del backend

  constructor(private http: HttpClient) { }

  getAlumnos(): Observable<any[]> {
    return this.http.get<any[]>(this.apiUrl);
  }

  createAlumno(alumno: any): Observable<any> {
    return this.http.post<any>(this.apiUrl, alumno);
  }

  deleteAlumno(id: number): Observable<any> {
    return this.http.delete<any>(`${this.apiUrl}/${id}`);
  }
  updateAlumno(id: number, alumno: any): Observable<any> {
    return this.http.put<any>(`${this.apiUrl}/${id}`, alumno);
  }
  
}
