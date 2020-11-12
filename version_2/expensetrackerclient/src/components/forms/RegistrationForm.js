import React, { Component } from 'react';

class RegistrationForm extends Component {
    state = {  }
    createAccount() {
        console.log("Doing some stuff!");
    }
    render() { 
        return (
            <form>
                <h3>Account Registration: </h3>
                <input placeholder="First name" />
                <input placeholder="Last name" />
                <input placeholder="Email" />
                <hr/>
                {/* Need validation all over here */}
                <input placeholder="Password"/>
                <input placeholder="Confirm Password..."/>
                <button onClick={this.createAccount()}>Create Account</button>
            </form>
          );
    }
}
 
export default RegistrationForm;