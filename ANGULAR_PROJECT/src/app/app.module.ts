import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { HomeComponent } from './pages/home/home.component';
import { NotesComponent } from './pages/notes/notes.component';
import { CategoriesComponent } from './pages/categories/categories.component';
import { AddNoteComponent } from './pages/add-note/add-note.component';
import { ContactFormComponent } from './components/contact-form/contact-form.component';
import { HeroSectionComponent } from './components/hero-section/hero-section.component';
import { AdvantagesComponent } from './components/advantages/advantages.component';
import { CategoriesSectionComponent } from './components/categories-section/categories-section.component';
import { FeaturesComponent } from './components/features/features.component';
import { NotesService } from './services/notes.service';
import { FormsModule, ReactiveFormsModule } from '@angular/forms'; 

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomeComponent,
    NotesComponent,
    CategoriesComponent,
    AddNoteComponent,
    ContactFormComponent,
    HeroSectionComponent,
    AdvantagesComponent,
    CategoriesSectionComponent,
    FeaturesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [
    provideClientHydration()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
