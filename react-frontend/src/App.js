import { Container } from '@material-ui/core';
import React from 'react';
import { Route } from 'react-router-dom';
import Header from './components/Header';
import Sidebar from './components/Sidebar';
function App() {
  return (
    <div>
      <Header />
      <Sidebar />
      <Container>
        <Route path="/" exact={true} component=""></Route>
        <Route path="/saveForm" exact={true} component=""></Route>
        <Route path="/PostBook/:id" exact={true} component=""></Route>
        <Route path="/loginForm" exact={true} component=""></Route>
        <Route path="/joinForm" exact={true} component=""></Route>
        <Route path="/updateBook/:id" exact={true} component=""></Route>
      </Container>
    </div>
  );
}

export default App;
