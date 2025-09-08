import React, {useEffect,useState} from "react";
import {useNavigate,useParams} from "react-router-dom";
import EmployeeService  from "../services/EmployeeService";
 function UpdateEmployee(){
    const{id}=useParams();
    const[employee, setEmployee]=useState({name:"",email:"",department:""});
    const navigate=useNavigate();
    useEffect(()=>{
        (async()=>{
            const res=await EmployeeService.getEmployeeById(id);
    
        setEmployee(res.data);
        })();
    },[id]); 
    const handleChange=(e)=>setEmployee({...employee,[e.target.name]:e.target.value});
    const handleSumbit=async(e)=>{
     e.preventDefault();
        await EmployeeService.updateEmployee(id,employee);
        navigate("/");

    }; 
    return (
        <form onSubmit={handleSumbit} style={{padding:16}}>
            <h2>Update Employee</h2>
            <input name="name" value={employee.name|| ""} onChange={handleChange}/><br/>
            <input name="email" value={employee.email||""} onChange={handleChange}/><br/>

            <input name="department" value={employee.department||""} onChange={handleChange}/><br/>
            <button type="sumbit">Update</button>


        </form>     
    );    
}    
 export default UpdateEmployee;   