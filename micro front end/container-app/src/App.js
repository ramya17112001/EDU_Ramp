import logo from './logo.svg';
import './App.css';
import React, {Suspense}from 'react';
const ProductList=React.lazy(()=>
import('product/ProductList'));
const Cart=React.lazy(()=>import('cart/Cart'));

function App(){  
  return (
    <div> 
<h1>  
  Shopping Micro Frontend
</h1>
<Suspense fallback={<div>Loading Products...</div>}>
<ProductList/>
</Suspense>
<Suspense fallback={<div>Loading Cart...</div>}>
<Cart/>
</Suspense>
</div>
  );
} 
export default App;    
{/* <ProductList addToCart={(product)=>{
  window.dispatchEvent(new CustomEvent('add-to-cart',{detail:product}));
}
}/>
</Suspense>
<Suspense fallback={<div>Loading Cart...</div>}>
<Cart/>
</Suspense>
</div>   */}
  
// export default App; 
   

  



{/* //     <div className="App">
//       <header className="App-header">
//         <img src={logo} className="App-logo" alt="logo" />
//         <p>
//           Edit <code>src/App.js</code> and save to reload.
//         </p>
//         
//           className="App-link"
//           href="https://reactjs.org"
//           target="_blank"
//           rel="noopener noreferrer"
//         >
//           Learn React
//         </a>
//       </header>
//     </div> */}
//   );
// }

// export default App;
