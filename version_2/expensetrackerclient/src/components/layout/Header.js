import React, { Component } from 'react';
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
                <li>Home</li>
                <li>About</li>
                <li>Login</li>
            </ul>

            </div>            
         );
    }
}
 
export default Header;