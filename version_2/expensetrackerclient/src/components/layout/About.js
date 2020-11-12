import React, { Component } from 'react';

class About extends Component {
    state = { }

    showContent(field) {
        //how do i get return value from onclick button to other element?
        field = !field;
        return (field ? "hidden" : "block");
    }
    render() { 
        return (  
            <main>
                <h3>About Expense Tracker</h3>
                <span >For every day People</span>
                <p>A small application for tracking your expenses
                    first, register an account and sign into it.
                    then you can create transactions and transaction categories
                    organize them, search/ filter, make notes and (more, careful with this phrase...).
                </p>
                <span>For Software Professionals</span>
                <p>explain the inner workings, how to build and deploy</p>
            </main>
        );
    }
}
 
export default About;