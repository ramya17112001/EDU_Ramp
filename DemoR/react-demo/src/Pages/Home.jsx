import React from "react";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
function HomePage() 
{
    const navigate=useNavigate();
    const[name,setName]= useState(); 
    function GoToUserPage()
    {
        navigate(`/User/${name}`) 
    }  
    return ( 
        <>
        
        <h1>Welcome, this is home page</h1>
        <input type="text" placeholder="enter name"
        onChange={(e)=>{
       setName(e.target.value)
   
        }} value={name}/>
        <button onClick={()=>{GoToUserPage()}}>  Proceed</button>
        </>     
    )  
}

export default HomePage;

      