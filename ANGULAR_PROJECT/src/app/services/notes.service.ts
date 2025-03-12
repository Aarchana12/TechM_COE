import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { map, catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class NotesService {
  private apiUrl = 'http://localhost:3000/notes'; 


  private notes: any[] = [];

  constructor(private http: HttpClient) {}

  getNotes(): Observable<any[]> {
    return this.http.get<any[]>(this.apiUrl).pipe( 
      catchError(error => {
        console.error('Error fetching notes:', error);
        return of([]); 
      })
    );
  }
  
  

  addNote(note: any): Observable<any> {
    console.log('Adding Note:', note); 
  
    return this.http.post<any>(this.apiUrl, note).pipe( 
      catchError(error => {
        console.error('Error adding note:', error);
        return of({ success: false });
      })
    );
  }
}  
