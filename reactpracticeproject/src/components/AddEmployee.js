import React, {useState} from "react";
import {useNavigate} from "react-router-dom";
import EmployeeService  from "../services/EmployeeService";
function AddEmployee(){
    const[employee,setEmployee]=useState({name:"", email:"",department:""});
    const navigate=useNavigate();
    const handleChange=(e)=>setEmployee({...employee,[e.target.name]:e.target.value});
    const handleSubmit=async (e)=>{
        e.preventDefault();
        await EmployeeService.createEmployee(employee);
        navigate("/");

    };
    return(
        <form onSubmit={handleSubmit} style={{padding:16}}>

            <h2>AddEmployee</h2>
            <input name="name" placeholder="Name" onChange={handleChange}/><br/>
            <input name="email" placeholder="Email" onChange={handleChange}/><br/>
            <input name="department" placeholder="Department" onChange={handleChange}/><br/>
             <button type="submit">Save</button> 
        </form>
    );  
}
export default AddEmployee;      
