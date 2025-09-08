// const HtmlWebpackPlugin = require("html-webpack-plugin");

// module.exports = {
//   entry: "./src/index.js",
//   mode: "development",
//   devServer: { 
//     port: 3001,
//     historyApiFallback: true,
//   },
//   output: {
//     publicPath: "auto",
//   },
//   resolve: {
//     extensions: [".js", ".jsx"],
//   },  
//   module: {
//     rules: [
//       { test: /\.(js|jsx)$/, exclude: /node_modules/, use: "babel-loader" },
//       { test: /\.css$/i, use: ["style-loader", "css-loader"] },
//       { test: /\.(png|jpg|jpeg|gif)$/i, type: "asset/resource" }
//     ],
//   },  
//   plugins: [
//     new HtmlWebpackPlugin({
//       template: "./public/index.html",
//     }),
//   ],
// };


const path = require('path'); 
const HtmlWebpackPlugin = require('html-webpack-plugin');
const { ModuleFederationPlugin } = require('webpack').container;

module.exports = {
  entry: './src/index.js', // Use .js extension for React 18 entry
  mode: 'development',
  devServer: {
    static: {
      directory: path.join(__dirname, 'public'),
    },
    port: 3002,
    historyApiFallback: true,
  },
  output: {
    publicPath: 'auto',
    clean: true,
  },
  resolve: {
    extensions: ['.js', '.jsx'],
  },
  module: {
    rules: [
      {
        test: /\.(js|jsx)$/,
        loader: 'babel-loader',
        exclude: /node_modules/,
        options: {
          presets: ['@babel/preset-react'],
        },
      },
      { test: /\.css$/i, use: ['style-loader', 'css-loader'] },
      {
        test: /\.(png|jpe?g|gif|svg)$/i,
        type: 'asset/resource',
      },
    ],
  },
  plugins: [
   new ModuleFederationPlugin({
  name: "mfe-products",
  filename: "remoteEntry.js",
  exposes: {
    "./App": "./src/App",
  },
  shared: {
    react: { singleton: true, requiredVersion: "^18.3.1", eager: false },
    "react-dom": { singleton: true, requiredVersion: "^18.3.1", eager: false },
  },


    }),
    new HtmlWebpackPlugin({
      template: './public/index.html',
    }),
  ],
};
