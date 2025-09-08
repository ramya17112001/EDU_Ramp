import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import HomePage from './Pages/Home';
import ContactPage from './Pages/Contact';
import AboutPage from './Pages/About';    
import { Routes,Route } from 'react-router-dom'; 
import UserPage from './Pages/User';
import Navbar from './Component/Navbar';
import Dashboard from './Pages/Dashboard';
// import Settings from './Pages/Settings';
import Profile from './Pages/Profile';
function App() {
       

  return (
    <>
    <Navbar/>    
     <Routes>
       <Route path="/" element={<HomePage />} />
      

      <Route path="/home" element={<HomePage />} /> 
      <Route path="/about" element={<AboutPage />} /> 
      <Route path="/contact" element={<ContactPage />} /> 
      <Route path="/User/:name"element={<UserPage/>}/> 
      <Route path="/Dashboard/:name" element={<Dashboard/>} > 
      <Route path="Settings" element={<h1>Settings</h1>}/> 
            <Route path="Profile" element={<Profile/>}/>  
    
      </Route>   
    </Routes>     
    </>         
  ) 
}    
 
  
export default App
 