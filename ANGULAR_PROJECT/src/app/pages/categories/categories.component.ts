import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-categories',
  templateUrl: './categories.component.html',
  styleUrls: ['./categories.component.css']
})
export class CategoriesComponent implements OnInit {
  categories = [
    { name: 'Mathematics', image: 'assets/images/mathematics.jpeg' },
    { name: 'Engineering & Technology', image: 'assets/images/engineering.jpeg' }
  ];

  constructor(private router: Router) {}

  ngOnInit(): void {}

  viewNotes(category: string) {
    this.router.navigate(['/notes'], { queryParams: { category } });
  }
}
