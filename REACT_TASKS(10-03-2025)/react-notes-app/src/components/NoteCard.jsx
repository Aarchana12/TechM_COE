import React from "react";

const NoteCard = ({ note }) => {
  return (
    <div className="card mb-3">
      <img src={note.image} className="card-img-top" alt={note.title} />
      <div className="card-body">
        <h5 className="card-title">{note.title}</h5>
        <p className="card-text">{note.description}</p>
        <p><strong>Category:</strong> {note.category}</p>
        <a href={note.link} target="_blank" rel="noopener noreferrer" className="btn btn-primary">
          📄 View Note
        </a>
      </div>
    </div>
  );
};

export default NoteCard;
