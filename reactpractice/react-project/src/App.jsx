import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import MemberCard from './Components/TeamMemberCard'
import { team } from './Data/Data'
 
function App() {
  const [count, setCount] = useState(0)
 
  return ( 
    <>
    <h1>React</h1>
    {
      team.map(member=>{     
           return   <MemberCard name={member.name} role={member.role}/>    
     
        //console.log('Line 16:',member);      
      })     
    }
    {/* <MemberCard name="sravan" role="developer"/>   
    <MemberCard name="anand" role="tester"/> 
    <MemberCard name="manoj" role="support"/>  */}
   </>    
         
  )  
} 
export default App
