import './App.css';
import React, { Component } from 'react';
import Header from './components/layout/Header';
import Home from './components/layout/Home';
import About from './components/layout/About'
import {
    BrowserRouter as Router,
    Switch,
    Route,
  } from "react-router-dom";
import LoginForm from './components/forms/LoginForm';
import RegistrationForm from './components/forms/RegistrationForm';



class App extends Component {
    
    /* You'll first want to get the JW token from 
    auth header and put it into state. then use that state to determine

     */
    state = { 
        authorization: false,
        userId: "",
        transactions : [],
        categories: []
    }
    render() { 
        return (
            <Router class="App">
                <Header/>
                <div>
                    <Switch>
                        <Route path="/about">
                            <About />
                        </Route>
                        <Route path="/login">
                            <LoginForm />
                        </Route>
                        <Route path="/registration">
                            <RegistrationForm />
                        </Route>
                        <Route path="/">
                            <Home />
                        </Route>
                    </Switch>
                </div>
            </Router>

          );
    }
}
 
export default App;