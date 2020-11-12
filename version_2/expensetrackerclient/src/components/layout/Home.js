import React, { Component } from 'react';
import TransactionForm from './../forms/TransactionForm';
import Transactions from './../Transactions';
import CategoryForm from './../forms/CategoryForm';
import Categories from './../Categories';



class Home extends Component {
    state = {  }
    render() { 
        return ( 
            <main>
                <div Style={{float:'right'}} id="transactions">
                    <TransactionForm/>
                    <Transactions/>
                </div>
                
                <div id="categories">
                    <CategoryForm/>
                    <Categories/>
                </div>
                
            </main>
            );
    }
}
 
export default Home;