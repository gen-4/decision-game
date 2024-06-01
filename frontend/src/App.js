import './App.css';

import Configuration from './modules/configurationModule/Configuration';
import Header from './modules/header/Header';
import Screen from './modules/screen/Screen';

function App() {
    return (
        <div className="App body-font">
            <Header />
            <Configuration />
            <Screen />
        </div>
    );
}

export default App;
