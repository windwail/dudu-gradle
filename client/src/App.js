import React from 'react';
import DuduNavbar from "./components/DuduNavbar";
import Register from "./components/Register";

import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';
import Home from "./components/Home";
import NotFound from "./components/NotFound";
import Toasts from "./components/Toasts";
import ConfirmCode from "./components/ConfirmCode";

function App() {
    return (
        <Router>
            <DuduNavbar/>

            <Toasts/>

            <div className="container">
                <Switch>
                    <Route exact path='/' component={Home}/>
                    <Route exact path='/register' component={Register}/>
                    <Route exact path='/confirm' component={ConfirmCode}/>
                    <Route component={NotFound}/>
                </Switch>
            </div>
        </Router>
    );
}

export default App;
