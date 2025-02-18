const num = 7; // Example number
let isPrime = true;

for (let i = 2; i < num; i++) {
  if (num % i === 0) {
    isPrime = false;
    break;
  }
}

if (isPrime && num > 1) {
  console.log(num + " is a prime number.");
} else {
  console.log(num + " is not a prime number.");
}
