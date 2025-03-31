import React, { useEffect, useState } from "react";
import axios from "axios";
import NotesList from "./components/NotesList";
import AddNoteForm from "./components/AddNoteForm";
import "bootstrap/dist/css/bootstrap.min.css";

function App() {
  const [notes, setNotes] = useState([]);

  useEffect(() => {
    axios.get("/api.json")
      .then(response => {
        setNotes(response.data.notes);
      })
      .catch(error => {
        console.error("Error fetching notes:", error);
      });
  }, []);

  const addNote = (newNote) => {
    setNotes([...notes, newNote]);
  };

  return (
    <div className="container">
      <h1 className="text-center my-4">📚 Notes Sharing Platform</h1>
      <NotesList notes={notes} />
      <AddNoteForm onAddNote={addNote} />
    </div>
  );
}

export default App;
