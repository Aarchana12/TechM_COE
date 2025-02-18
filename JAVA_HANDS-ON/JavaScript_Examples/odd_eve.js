function checkSumOfDigits(num) {
  let sum = 0;
  while (num > 0) {
    sum += num % 10;
    num = Math.floor(num / 10);
  }
  if (sum % 2 === 0) {
    console.log(`The sum of digits is even: ${sum}`);
  } else {
    console.log(`The sum of digits is odd: ${sum}`);
  }
}

checkSumOfDigits(123);
