const chooseOperation = () => {
  const operation = prompt("Choose operation: add, subtract, multiply, divide");
  const num1 = parseInt(prompt("Enter first number:"));
  const num2 = parseInt(prompt("Enter second number:"));

  switch (operation) {
    case "add":
      console.log(`Sum: ${num1 + num2}`);
      break;
    case "subtract":
      console.log(`Difference: ${num1 - num2}`);
      break;
    case "multiply":
      console.log(`Product: ${num1 * num2}`);
      break;
    case "divide":
      console.log(`Quotient: ${num1 / num2}`);
      console.log(`Remainder: ${num1 % num2}`);
      break;
    default:
      console.log("Invalid operation");
  }
};

chooseOperation();
