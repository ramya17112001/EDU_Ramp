import React from 'react';
function ProductList({addToCart}){
    const products=[
        {id:1,name:'T-shirt',price:250},
        {id:2,name:'jeans',price:600},
        {id:3,name:'tops',price:300}
    ];
    return (
        <div>
            <h2>Products</h2>
            <ul>
            {products.map(prod=>{
                <li key={prod.id}>
                    {prod.name}-{prod.price}
                    <button onClick={()=>
                        addToCart(prod)}>addToCart</button>
                           
                </li>  

            })}
            </ul>
        </div>
    );
}
export default ProductList;     