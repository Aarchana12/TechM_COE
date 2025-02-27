import React, { useState } from 'react';

function CheckDivisibility() {
  const [number, setNumber] = useState('');

  const checkDivisibility = () => {
    return number % 16 === 0 ? '✅ Divisible by 16' : '❌ Not divisible by 16';
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
      <p>{number && checkDivisibility()}</p>
    </div>
  );
}

export default CheckDivisibility;
