import './App.css';
import React, { Component } from 'react';
import Header from './components/layout/Header';
import Transactions from './components/Transactions';
import Categories from './components/Categories';
import TransactionForm from './components/forms/TransactionForm';
import CategoryForm from './components/forms/CategoryForm';



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
            <div className="App">
                <Header />
                <TransactionForm/>
                <Transactions/>

                <CategoryForm/>
                <Categories/>
            </div>

          );
    }
}
 
export default App;