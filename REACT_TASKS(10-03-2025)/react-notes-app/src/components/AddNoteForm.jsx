import React, { useState } from "react";

const AddNoteForm = ({ onAddNote }) => {
  const [title, setTitle] = useState("");
  const [description, setDescription] = useState("");
  const [category, setCategory] = useState("Engineering & Technology"); 
  const [image, setImage] = useState("");
  const [link, setLink] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();
    const newNote = {
      id: Date.now().toString(), 
      title,
      description,
      category,
      image: image, 
      link
    };
    onAddNote(newNote);
    setTitle("");
    setDescription("");
    setCategory("Engineering & Technology");
    setImage("");
    setLink("");
  };

  return (
    <form onSubmit={handleSubmit} className="mb-4">
      <div className="mb-3">
        <label className="form-label">Title</label>
        <input type="text" className="form-control" value={title} onChange={(e) => setTitle(e.target.value)} required />
      </div>
      <div className="mb-3">
        <label className="form-label">Description</label>
        <input type="text" className="form-control" value={description} onChange={(e) => setDescription(e.target.value)} required />
      </div>
      <div className="mb-3">
        <label className="form-label">Category</label>
        <select className="form-control" value={category} onChange={(e) => setCategory(e.target.value)} required>
          <option value="Mathematics">Mathematics</option>
          <option value="Engineering & Technology">Engineering & Technology</option>
          <option value="Computer Science">Computer Science</option>
        </select>
      </div>
      <div className="mb-3">
        <label className="form-label">Image URL</label>
        <input type="url" className="form-control" value={image} onChange={(e) => setImage(e.target.value)} />
      </div>
      <div className="mb-3">
        <label className="form-label">PDF Link</label>
        <input type="url" className="form-control" value={link} onChange={(e) => setLink(e.target.value)} required />
      </div>
      <button type="submit" className="btn btn-success">➕ Add Note</button>
    </form>
  );
};

export default AddNoteForm;
