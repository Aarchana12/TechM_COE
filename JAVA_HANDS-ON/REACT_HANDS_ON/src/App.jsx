import React, { useState } from "react";
import "./App.css"; // Ensure you're using external styles

function App({ components }) {
  const [selectedComponent, setSelectedComponent] = useState(null);

  return (
    <div className="app-container">
      <h1 className="app-title">React App with Five Components</h1>

      {/* Buttons */}
      <div className="button-container">
        {Object.keys(components).map((componentName) => (
          <button
            key={componentName}
            onClick={() => setSelectedComponent(componentName)}
            className="nav-button"
          >
            {componentName}
          </button>
        ))}
      </div>

      {/* Display Selected Component */}
      <div className="component-display">
        {selectedComponent ? (
          <div>
            <h2 className="component-title">{selectedComponent}</h2>
            {components[selectedComponent]}
          </div>
        ) : (
          <p className="placeholder-text">Select a component to display</p>
        )}
      </div>
    </div>
  );
}

export default App;
