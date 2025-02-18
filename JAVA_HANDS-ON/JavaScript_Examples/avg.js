let prices = [40, 50, 55, 60, 45, 48, 52]; // Example prices for the week
let total = prices.reduce((sum, price) => sum + price, 0);
let average = total / prices.length;

if (average > 50) {
  console.log("Tomato has given good profit.");
} else {
  console.log("No profit from tomato.");
}
