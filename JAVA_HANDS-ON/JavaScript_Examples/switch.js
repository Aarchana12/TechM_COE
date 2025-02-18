let day = "Monday"; // Example day of the week

switch (day) {
  case "Monday":
    console.log("Start of the week!");
    break;
  case "Tuesday":
  case "Wednesday":
  case "Thursday":
    console.log("Mid of the week!");
    break;
  case "Friday":
    console.log("Last working day of the week!");
    break;
  case "Saturday":
    console.log("WeekEnd - Saturday!");
    break;
  case "Sunday":
    console.log("WeekEnd - Sunday!");
    break;
  default:
    console.log("Invalid input!");
}
