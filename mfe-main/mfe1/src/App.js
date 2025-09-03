

import React, { useState, Suspense } from "react";

import RemoteApp from "app2/App";  
import Cart from "app3/App";        

const App = () => {
  const [activePage, setActivePage] = useState("home");     

  const renderPage = () => {
    switch (activePage) {
      case "products":
        return (
          <section className="section-container">
            <h2>Products</h2>
            <Suspense fallback={<div>Loading Products...</div>}>
              <RemoteApp />
            </Suspense>
          </section>
        );
      case "cart":
        return (
          <section className="section-container">
            <h2>Cart</h2>
            <Suspense fallback={<div>Loading Cart...</div>}>
              <Cart />
            </Suspense>
          </section>
        );
      default:
        return (
          <section className="section-container home">
            <h2>Welcome to My Shopping MFE</h2>
            <p>Click on Products to see available items or Cart to view your cart.</p>
          </section>
        );
    }
  };

  return (
    <div>
      {/* Navbar */}
      <header className="navbar">
        <h1>My Shopping MFE</h1>
        <nav>
          <button onClick={() => setActivePage("home")}>Home</button>
          <button onClick={() => setActivePage("products")}>Products</button>
          <button onClick={() => setActivePage("cart")}>Cart</button>
        </nav>
      </header>

      {/* Render active page */}
      {renderPage()}

      <footer className="footer">
        <p>© 2025 My MFE Shopping Site</p>
      </footer>
    </div>
  );
}; 

export default App;
   





  


// import React, {Suspense} from "react";
// // const RemoteApp = React.lazy(() => import("app2/App"));
// import RemoteApp from 'app2/App'
// import Cart from 'app3/App'

// const App = () => {
//   return (
//     <div> 
//       <div style={{ 
//         margin:"10px",
//         padding:"10px",
//         textAlign:"center",
//         backgroundColor:"greenyellow"
//       }}>
//         <h1>Product Listing</h1>
//       </div>
//       {/* <Suspense fallback={"loading..."}> */}
//         <RemoteApp/>
//         <Cart/>
//       {/* </Suspense> */}
//     </div>) 
// }


    

// export default App;