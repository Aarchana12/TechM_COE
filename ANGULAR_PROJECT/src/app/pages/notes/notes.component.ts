import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { NotesService } from '../../services/notes.service';

@Component({
  selector: 'app-notes',
  templateUrl: './notes.component.html',
  styleUrls: ['./notes.component.css']
})
export class NotesComponent implements OnInit {
  notes: any[] = []; 
  filteredNotes: any[] = [];

  constructor(private notesService: NotesService, private route: ActivatedRoute) {}

  ngOnInit(): void {
    this.notesService.getNotes().subscribe((data) => {
      console.log('Fetched Notes:', data); 
  
   
      if (Array.isArray(data)) {
        this.notes = data;
        this.filteredNotes = [...this.notes];
      } else {
        console.error('Expected an array but got:', data);
        this.notes = [];
        this.filteredNotes = [];
      }
  
      this.route.queryParams.subscribe((params) => {
        const selectedCategory = params['category'];
        this.filteredNotes = selectedCategory
          ? this.notes.filter((note) => note.category === selectedCategory)
          : [...this.notes];
      });
  
      console.log('Final Filtered Notes:', this.filteredNotes);
    });
  }
}
