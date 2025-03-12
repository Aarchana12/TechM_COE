import { Component } from '@angular/core';

@Component({
  selector: 'app-categories-section',
  templateUrl: './categories-section.component.html',
  styleUrls: ['./categories-section.component.css']
})
export class CategoriesSectionComponent {
  categories = [
    { name: 'Mathematics', icon: 'bi-calculator' },
    { name: 'Engineering & Technology', icon: 'bi-cpu' },
    { name: 'Science', icon: 'bi-lightning-fill' },
    { name: 'Programming', icon: 'bi-code-slash' },
    { name: 'Business & Management', icon: 'bi-briefcase' }
  ];
  
  
  
}
