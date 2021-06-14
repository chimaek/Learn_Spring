import { Container } from '@material-ui/core';
import React from 'react';
import { Route } from 'react-router-dom';
import Header from './components/Header';
import Sidebar from './components/Sidebar';
import Home from './pages/book/Home';
import LoginForm from './pages/user/LoginForm';
import JoinForm from './pages/user/JoinForm';
import UpdateForm from './pages/book/UpdateForm';
import Deatil from './pages/book/Detail';
import SaveForm from './pages/book/SaveForm';
function App() {
  return (
    <div>
      <Header />
      <Container>
        <Route path="/" exact={true} component={Home}></Route>
        <Route path="/saveForm" exact={true} component={SaveForm}></Route>
        <Route path="/book/:id" exact={true} component={Deatil}></Route>
        <Route path="/loginForm" exact={true} component={LoginForm}></Route>
        <Route path="/joinForm" exact={true} component={JoinForm}></Route>
        <Route
          path="/updateForm/:id"
          exact={true}
          component={UpdateForm}
        ></Route>
      </Container>
    </div>
  );
}

export default App;
