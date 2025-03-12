import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NotesService } from '../../services/notes.service';

@Component({
  selector: 'app-add-note',
  templateUrl: './add-note.component.html',
  styleUrls: ['./add-note.component.css']
})
export class AddNoteComponent implements OnInit {
  noteForm: FormGroup;
  categories = ['Mathematics', 'Engineering & Technology']; 

  constructor(private fb: FormBuilder, private notesService: NotesService) {
    this.noteForm = this.fb.group({
      title: ['', Validators.required],
      description: ['', Validators.required],
      image: [''], 
      category: ['', Validators.required],
      link: ['', [Validators.required, Validators.pattern('https?://.+')]]
    });
  }

  ngOnInit(): void {}

  onSubmit() {
    if (this.noteForm.valid) {
      const newNote = this.noteForm.value;
      console.log('Submitting Note:', newNote); 
  
      this.notesService.addNote(newNote).subscribe(
        (response) => {
          console.log('✅ Note Added:', response);
          alert('✅ Note Added Successfully!');
          this.noteForm.reset();
        },
        (error) => {
          console.error('❌ Error adding note:', error);
          alert('❌ Failed to add note. Please try again.');
        }
      );
    } else {
      alert('⚠️ Please fill all required fields.');
    }
  }
}  