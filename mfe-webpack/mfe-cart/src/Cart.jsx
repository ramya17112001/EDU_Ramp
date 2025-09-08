import React from "react";

export default function Cart({ items = [], removeFromCart }) {
  return (
    <div>
      <h2>🛒 Cart</h2>
      {items.length === 0 ? (
        <p>No items in cart</p>
      ) : (
        <ul className="cart-list">
          {items.map((item, index) => (
            <li key={index} className="cart-item">
              <span>{item.name}</span> - <span>₹{item.price}</span>
              <button className="remove-btn" onClick={() => removeFromCart(index)}>
                Remove
              </button>
            </li>
          ))}
        </ul>
      )}
    </div>
  );
}
 