import React, { Suspense, useState, lazy } from "react";
import {
  BrowserRouter as Router,
  Routes,
  Route,
  NavLink,
  Navigate,
} from "react-router-dom";

// Lazy load remote microfrontends exposed modules
const Products = lazy(() => import("mfeProducts/Products"));
const Cart = lazy(() => import("mfeCart/Cart"));

const activeStyle = {
  fontWeight: "bold",
  borderBottom: "3px solid #4caf50",
  color: "#4caf50",
};

export default function App() {
  const [cartItems, setCartItems] = useState([]);

  const addToCart = (product) => setCartItems((prev) => [...prev, product]);

  const removeFromCart = (index) =>
    setCartItems((prev) => prev.filter((_, i) => i !== index));

  return (
    <Router>
      <header className="header">
        <h1>🛍️ My Shop</h1>
        <nav>
          <NavLink to="/products" style={({ isActive }) => (isActive ? activeStyle : undefined)}>
            Products
          </NavLink>
          <NavLink to="/cart" style={({ isActive }) => (isActive ? activeStyle : undefined)}>
            Cart ({cartItems.length})
          </NavLink>
        </nav>
      </header>

      <main>
        <Suspense fallback={<div>Loading...</div>}>
          <Routes>
            <Route path="/" element={<Navigate to="/products" replace />} />
            <Route path="/products" element={<Products addToCart={addToCart} />} />
            <Route path="/cart" element={<Cart items={cartItems} removeFromCart={removeFromCart} />} />
            <Route path="*" element={<div>Page Not Found</div>} />
          </Routes>
        </Suspense>
      </main>
    </Router>
  );
} 
 