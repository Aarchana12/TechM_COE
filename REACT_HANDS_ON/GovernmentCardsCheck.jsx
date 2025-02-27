import React, { useState } from "react";

function GovernmentCardsCheck() {
  const [hasAadhar, setHasAadhar] = useState(false);
  const [hasPAN, setHasPAN] = useState(false);
  const [result, setResult] = useState("");

  const checkCards = () => {
    if (hasAadhar || hasPAN) {
      let message = "Available cards: ";
      if (hasAadhar) message += "Aadhar Card ";
      if (hasPAN) message += "PAN Card";
      setResult(message);
    } else {
      setResult("No government cards available");
    }
  };

  return (
    <div>
      <h2>Check Government Cards</h2>
      <label>
        <input
          type="checkbox"
          checked={hasAadhar}
          onChange={() => setHasAadhar(!hasAadhar)}
        />
        Aadhar Card
      </label>
      <br />
      <label>
        <input
          type="checkbox"
          checked={hasPAN}
          onChange={() => setHasPAN(!hasPAN)}
        />
        PAN Card
      </label>
      <br />
      <button onClick={checkCards}>Check Cards</button>
      <p>{result}</p>
    </div>
  );
}

export default GovernmentCardsCheck;
