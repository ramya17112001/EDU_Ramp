import React from "react";

function MemberCard({name,role}){
console.log(name,role)

    return(
        <div>  
            <h6>Name:{name}</h6>
            <h6>Role:{role}</h6>  
              
        </div>  
    )      
}       
export default MemberCard; 