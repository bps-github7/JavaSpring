import React, { Component } from 'react';
import {
    Link
  } from "react-router-dom";

import './Header.css';


class Header extends Component {
    state = { title: "" }
    render() { 
        return (
            <div id="header"> 
            {/* to make this reusable component
            title should be passed in thru props. */} 
            <h2>Expense Tracker</h2>
            <ul>
                {/* <li><a>Home</a></li>
                <li><a>About</a></li>
                <li><a>Login</a></li> */}
                <li><Link to="/">Home</Link></li>
                <li><Link to="/About">About</Link></li>
                <li><Link to="/Login">Sign in</Link></li>
            </ul>

            </div>            
         );
    }
}
 
export default Header;