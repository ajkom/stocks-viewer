import React from 'react';
import StockInfo from "./components/StockInfo";


function App() {
    return (
        <div className="App">
            <header className="App-header">
                Data fetched from backend
            </header>

            <StockInfo/>
        </div>
    );
}

export default App;
