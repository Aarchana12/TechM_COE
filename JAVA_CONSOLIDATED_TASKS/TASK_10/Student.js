let student = {
    name: "Aarchana",
    age: 22,
    department: "IT",
    getDetails: function() {
        return this.name + " - " + this.department;
    }
};

console.log(student.getDetails());

student.address = {
    city: "Chennai",
    state: "Tamil Nadu"
};

student.updateAge = function(newAge) {
    this.age = newAge;
};

student.getAddress = function() {
    return this.address.city + ", " + this.address.state;
};

console.log(student.getAddress());

delete student.age;
delete student.getAddress;

console.log(student);
