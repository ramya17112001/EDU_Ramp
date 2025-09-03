import React, { useState, useEffect } from "react";

const Cart = () => {
  const [cart, setCart] = useState([]);

  const fetchCart = async () => {
    try {
      const res = await fetch("http://localhost:4000/cart");
      const data = await res.json();
      setCart(data);
    } catch (err) {
      console.error("Error fetching cart:", err);
    }
  };

  useEffect(() => { 
    fetchCart();
 
   
    const interval = setInterval(fetchCart, 2000);
    return () => clearInterval(interval);
  }, []);

  return (
    <div className="cart-container">
      <h2>Cart</h2>
      {cart.length === 0 ? (
        <p>Your cart is empty</p>
      ) : (
        <ul>
          {cart.map((item) => (
            <li key={item.id}>
              {item.name} - ₹{item.price} x {item.qty}
            </li>
          ))}
        </ul>
      )}
    </div>
  );
};

export default Cart;
