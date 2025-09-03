import React, { useState } from "react";
import "./App.css";

import Laptop from "./assets/laptop.jpg";
import Iphone from "./assets/iphone.jpg";
import Headphones from "./assets/headphones.jpg";
import Charger from "./assets/charger.jpg";
import TV from "./assets/tv.jpg";

const App = () => { 
  const [message, setMessage] = useState("");

  const productList = [
    { id: 1, name: "Laptop", price: 50000, img: Laptop },
    { id: 2, name: "Iphone", price: 20000, img: Iphone },
    { id: 3, name: "Headphones", price: 3000, img: Headphones },
    { id: 4, name: "Charger", price: 10000, img: Charger },
    { id: 5, name: "T.V", price: 50000, img: TV },
  ];

  const handleAdd = async (product) => {
  try {
    
    const res = await fetch("http://localhost:4000/cart", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(product),
    });
    const updatedCart = await res.json();
    console.log("Cart updated:", updatedCart);

    setMessage(`${product.name} added to cart!`);
    setTimeout(() => setMessage(""), 2000);
  } catch (err) {
    console.error("Error adding product:", err);
  }
};

  return (
    <div className="products-container">
      <h2>Products</h2>
      {message && <p className="message">{message}</p>}
      <div className="products-grid">
        {productList.map((product) => (
          <div key={product.id} className="product-card">
            <img src={product.img} alt={product.name} />
            <h3>{product.name}</h3>
            <p className="price">₹{product.price}</p>
            <button onClick={(e) => handleAdd(product, e)}>Add to Cart</button>
                  
          </div>  
        ))} 
      </div>
    </div>
  );
}; 

export default App; 

