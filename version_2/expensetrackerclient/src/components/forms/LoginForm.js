import React, { Component } from 'react';
import {
    Link
  } from "react-router-dom";

class LoginForm extends Component {
    state = {  }
    signIn() {
        console.log("access values from within formgroup shweetie");
    }
    render() { 
        return (
        <form>
            <h3>Sign in to your account:</h3>
            <input placeholder="Email"/> <br/>
            <input placeholder="Password"/> <br />
            <button onClick={this.signIn()}>Submit</button>
            <br/>
            <Link to="/registration">Need to make an account? Click Here!</Link>

        </form> 
        

        );
    }
}
 
export default LoginForm;