import React from 'react';
import DuduNavbar from "./components/DuduNavbar";
import List from "./components/List";
import Forms from "./components/Forms";
import Post from "./components/Post";
import Register from "./components/Register";

import {BrowserRouter as Router, Switch, Route} from 'react-router-dom';
import Home from "./components/Home";
import NotFound from "./components/NotFound";
import {Toast} from "react-bootstrap";
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
