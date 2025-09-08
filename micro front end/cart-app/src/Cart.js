import React,{useState,useEffect}from 'react';
function Cart(){
    const [items,setItems]=useState([]);
    useEffect(()=>{
        const addToCartHandler=(e)=>{
            setItems(prev=>[...prev,e.detail]);
        };
        window.addEventListener('add-to-cart',addToCartHandler);
        return ()=>
            window.removeEventListener('add-to-cart',addToCartHandler);
    },[]);
    return (
        <div>
            <h2>Cart</h2>
            {items.length === 0 && <p>Cart is empty</p>}
            <ul>
                {items.map((item,idx)=>(
                    <li key={idx}>{item.name}-{item.price}</li>

                ))}
            </ul>
        </div>
    );
    }
export default Cart;  