const express = require("express");
const cors = require("cors");

const app = express();
app.use(cors());
app.use(express.json()); // parse JSON requests

let cart = []; // store cart in memory for simplicity

// Get current cart
app.get("/cart", (req, res) => { 
  res.json(cart);
});

// Add product to cart
app.post("/cart", (req, res) => {
  const product = req.body;

  // Check if product already exists
  const index = cart.findIndex(item => item.id === product.id);
  if (index >= 0) {
    cart[index].qty += product.qty || 1;
  } else {
    cart.push({ ...product, qty: product.qty || 1 });
  }
     
  res.json(cart);
});

const PORT = 4000;
app.listen(PORT, () => console.log(`Products API running at http://localhost:${PORT}`));
