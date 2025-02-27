import React, { useState } from "react";

function CheckDivisibility() {
  const [number, setNumber] = useState("");
  const [result, setResult] = useState("");

  const checkDivisible = () => {
    if (number % 16 === 0) {
      setResult(`${number} is divisible by 16`);
    } else {
      setResult(`${number} is not divisible by 16`);
    }
  };

  return (
    <div>
      <h2>Check Divisibility by 16</h2>
      <input
        type="number"
        value={number}
        onChange={(e) => setNumber(e.target.value)}
        placeholder="Enter a number"
      />
      <button onClick={checkDivisible}>Check</button>
      <p>{result}</p>
    </div>
  );
}

export default CheckDivisibility;
