const HtmlWebPackPlugin = require("html-webpack-plugin");
const ModuleFederationPlugin = require("webpack/lib/container/ModuleFederationPlugin");
const deps = require("./package.json").dependencies;
module.exports = {
 mode: "development",
 devServer: {
   port: 3001,
   historyApiFallback: true,
   headers: {
     "Access-Control-Allow-Origin": "*"
   }
 },
 output: {
   publicPath: "http://localhost:3001/",
 },
 resolve: {
   extensions: [".js", ".jsx", ".json"],
 },
 module: {
   rules: [
     {
       test: /\.jsx?$/,
       exclude: /node_modules/,
       use: {
         loader: "babel-loader",
       },
     },
     {
       test: /\.css$/i,
       use: ["style-loader", "css-loader"],
     },
   ],
 },
 plugins: [ 
   new ModuleFederationPlugin({
     name: "product",
     filename: "remoteEntry.js",
     exposes: {
       "./Cart": "./src/components/Cart",    
     },
     shared: {
       ...deps,
       react: {
         singleton: true,
         requiredVersion: deps.react,
       },
       "react-dom": {
         singleton: true,
         requiredVersion: deps["react-dom"],
       },
     },
   }),
   new HtmlWebPackPlugin({  
     template: "./public/index.html",
   }), 
 ],
}; 




// const {ModuleFederationPlugin}=require("webpack").container;
// module.exports={
//     plugins:[
//         new ModuleFederationPlugin({
//             name:"cart",
//             filename:"remoteEntry.js",
//             exposes:{
//                 "./Cart":"./src/Cart"
//             }
//         })
//     ]
// };    