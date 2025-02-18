function displayFactors(num) {
  let factors = [];
  for (let i = 1; i <= num; i++) {
    if (num % i === 0) {
      factors.push(i);
    }
  }
  console.log(`Factors of ${num}: ${factors.join(", ")}`);
}

displayFactors(12);
