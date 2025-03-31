import React from "react";
import NoteCard from "./NoteCard";

const NotesList = ({ notes }) => {
  return (
    <div className="row">
      {notes.map(note => (
        <div key={note.id} className="col-md-4">
          <NoteCard note={note} />
        </div>
      ))}
    </div>
  );
};

export default NotesList;
