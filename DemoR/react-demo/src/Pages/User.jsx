import React from "react";
import { useParams } from "react-router-dom";
function UserPage()
{
    const {name} =useParams();
  return(
    <h1>Hi {name}, this is User page</h1>
    
  )   
} 
export default UserPage;    