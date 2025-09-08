import React from "react";
import { createBrowserRouter} from "react-router-dom";
import EmployeeList from "./components/EmployeeList";
import AddEmployee from "./components/AddEmployee";
import UpdateEmployee from "./components/UpdateEmployee";
const router=createBrowserRouter([
    {path:"/",element:<EmployeeList/>},
    {path:"/add",element:<AddEmployee/>},
    {path:"/update/:id",element:<UpdateEmployee/>}, 
]);
export default router;
 