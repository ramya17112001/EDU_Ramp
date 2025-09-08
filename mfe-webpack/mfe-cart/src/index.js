import React from "react";
import { createRoot } from "react-dom/client";
import Cart from "./Cart.jsx";
import "./styles.css";

const root = createRoot(document.getElementById("root"));
root.render(<Cart items={[]} removeFromCart={() => {}} />);
 