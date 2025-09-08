import React from "react";
import Laptop from "./assets/laptop.jpg";
import Iphone from "./assets/iphone.jpg";
import Headphones from "./assets/headphones.jpg";
import Charger from "./assets/charger.jpg";
import TV from "./assets/tv.jpg";
import "./styles.css";

const productList = [
  { id: 1, name: "Laptop", price: 50000, img: Laptop },
  { id: 2, name: "Iphone", price: 20000, img: Iphone },
  { id: 3, name: "Headphones", price: 3000, img: Headphones },
  { id: 4, name: "Charger", price: 10000, img: Charger },
  { id: 5, name: "T.V", price: 50000, img: TV },
];

export default function Products() {
  return (
    <div>
      <h2>Products</h2>
      <div className="products-grid">
        {productList.map(p => (
          <div key={p.id} className="product-card">
            <img src={p.img} alt={p.name} />
            <h3>{p.name}</h3>
            <p>₹{p.price}</p>
          </div>
        ))}
      </div>
    </div>
  );
}
  