import React from 'react';
import StocksInfo from "./components/StocksInfo";


function App() {
    return (
        <div className="App">
            <header className="App-header">
                Data fetched from backend
            </header>

            <StocksInfo/>
        </div>
    );
}

export default App;
