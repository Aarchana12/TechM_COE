import React, { useState } from 'react';

function CheckGovernmentCards() {
  const [hasAadhaar, setHasAadhaar] = useState(false);
  const [hasPan, setHasPan] = useState(false);

  return (
    <div>
      <h2>Government Card Checker</h2>
      <label>
        <input 
          type="checkbox" 
          checked={hasAadhaar} 
          onChange={() => setHasAadhaar(!hasAadhaar)}
        /> Aadhaar Card
      </label>
      <br />
      <label>
        <input 
          type="checkbox" 
          checked={hasPan} 
          onChange={() => setHasPan(!hasPan)}
        /> PAN Card
      </label>
      <p>
        {hasAadhaar || hasPan 
          ? `✅ You are eligible for government offers.` 
          : `❌ You need either Aadhaar or PAN.`}
      </p>
    </div>
  );
}

export default CheckGovernmentCards;
