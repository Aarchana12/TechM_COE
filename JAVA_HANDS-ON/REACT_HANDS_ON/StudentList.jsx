import React from "react";

function StudentList() {
  const students = [
    { name: "Amit", department: "Computer Science" },
    { name: "Priya", department: "Electronics" },
    { name: "Rahul", department: "Mechanical" },
    { name: "Sara", department: "Civil" },
    { name: "John", department: "IT" },
  ];

  return (
    <div>
      <h2>Student List with Department Details</h2>
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
