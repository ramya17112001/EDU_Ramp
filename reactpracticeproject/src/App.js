import logo from './logo.svg';
import './App.css';
import React from 'react';
import { BrowserRouter as Router, Routes, Route} from "react-router-dom";
import EmployeeList from './components/EmployeeList';
import AddEmployee  from './components/AddEmployee';
import UpdateEmployee from './components/UpdateEmployee';   

function App() {  
  return (
    <Router>
      <Routes>
        <Route path="/" element={<EmployeeList />}/>
        <Route path="/add" element={<AddEmployee />}/>
        <Route path="/update/:id" element={<UpdateEmployee />}/>
      </Routes>
    </Router>
    // <div className="App">
    //   <h2>Hello Ramya </h2>
    // </div>
  );
}

export default App;
