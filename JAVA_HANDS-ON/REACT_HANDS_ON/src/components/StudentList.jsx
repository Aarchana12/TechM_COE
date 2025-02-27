import React from 'react';

function StudentList() {
  const students = [
    { name: 'Aarchana', department: 'IT' },
    { name: 'Rahul', department: 'CS' },
    { name: 'Sneha', department: 'AI & ML' },
    { name: 'Vikram', department: 'ECE' },
  ];

  return (
    <div>
      <h2>Student List</h2>
      <ul>
        {students.map((student, index) => (
          <li key={index}>
            {student.name} - {student.department}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default StudentList;
