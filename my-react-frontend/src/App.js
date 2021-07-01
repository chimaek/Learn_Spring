import logo from './logo.svg';
import './App.css';
import ListEmployeeComponent from './components/ListEmployeeComponent';
import HeaderComponent from './components/HeaderComponent';
import FooterComponent from './components/FooterComponent';
import { Router, Switch, Route } from 'react-router-dom';
function App() {
  return (
    <div>
      <HeaderComponent />
      <div className="container">
        <Switch>
          <Route path="/" component={ListEmployeeComponent}></Route>
          <Route path="/employees" component={ListEmployeeComponent}></Route>
          <ListEmployeeComponent />
        </Switch>
      </div>
      <FooterComponent />
    </div>
  );
}

export default App;
