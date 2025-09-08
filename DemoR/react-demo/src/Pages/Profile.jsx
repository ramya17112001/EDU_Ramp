import React from "react";
import { useParams } from "react-router-dom";
function Profile(){
    const {name}=useParams();
    return(
        <h1>{name},  Profiles</h1>
    ) 
}
export default Profile;