import React from 'react';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Login from './Pages/loginPage/LoginPage';
import Register from './Pages/registerPage/RegisterPage';
import Home from './Pages/homePage/HomePage';
import FormPage from './Components/addSensorComponent/AddSensor'

const App = () => {

  return (
    <BrowserRouter>
      <div>
        <Routes>
          <Route path="/login" element={<Login />} />
          <Route path="/register" element={<Register />} />
          <Route path="/addSensor" element={<FormPage user="daneto" />} />
          <Route path="/" element={<Home />} />
        </Routes>
      </div>
    </BrowserRouter>
  );
};

export default App;
