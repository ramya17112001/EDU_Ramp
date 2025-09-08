import React, {useEffect, useState}from "react";
import {Link} from "react-router-dom";
import EmployeeService from "../services/EmployeeService";
function EmployeeList(){
    const[employees,setEmployees]=useState([]);
    const loadEmployees=async()=>{
        try{

        
        const res=await EmployeeService.getEmployees();
       setEmployees(res.data);
        }catch(error){
            console.error("Error fetching employees:",error);

        } 

    };
    useEffect(()=>{
    loadEmployees();
    },[]);

    const deleteEmployee=async(id)=>{
        try{
    
        
        await EmployeeService.deleteEmployee(id);
        loadEmployees();
        }catch(error){
            console.error("Error deleting employees:",error)
        } 
    };
    return (
        <div style={{padding:"16px"}}>
           <h2>Employee List</h2>
            <Link to="/add">AddEmployee</Link>
            <table border="1" cellPadding="8" style={{marginTop:"12px",width:"100%"}}>

                <thread> 
                    <tr>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Department</th>
                        <th>Actions</th>

                    </tr>
                </thread>
                <tbody>
                    {employees.length>0?(

                    
                    employees.map((emp)=>(
                        <tr key={emp.id}>
                            <td>{emp.name}</td>
                            <td>{emp.email}</td>
                            <td>{emp.department}</td>
                            <td>
                            <Link to={`/update/${emp.id}`} >Edit</Link>
                                <button onClick={()=>deleteEmployee(emp.id)}>Delete</button>
                    
                            </td> 
                        </tr>
                    ))
                ) : (
                  <tr>
                    <td colSpan="4" align="center">No employees yet</td>
                    </tr>
                 )}
                </tbody>
            </table>
        </div>   
    );
    
   
} 
 export default EmployeeList;    
 