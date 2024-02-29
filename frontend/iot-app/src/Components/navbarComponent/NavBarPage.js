import React, { useState, useEffect } from 'react';
import { NavLink } from 'react-router-dom';
import axios from 'axios';
import './styles.css'

const Navbar = ({ user, onLogout }) => {
  const [showUserInfo, setShowUserInfo] = useState(false);

  const handleUserInfoClick = () => {
    setShowUserInfo(!showUserInfo);
  };

  const [data, setData] = useState(null);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await axios.get('http://localhost:3001/api/login');
        setData(response.data);
        //user.email = data.email;
        //user.username = data.username;
      } catch (error) {
        console.error('Error fetching data:', error);
      }
    };

    fetchData();
  });


  return (
    <nav>
      <NavLink to="/">Home</NavLink>
      {user ? (
        <div>
          <span onClick={handleUserInfoClick}>{data.username}</span>
          {showUserInfo && (
            <div>
              <p>Email: {data.email}</p>
              <button onClick={onLogout}>Logout</button>
            </div>
          )}
        </div>
      ) : (
        <div>
          <NavLink to="/login">Login</NavLink>
          <NavLink to="/register">Register</NavLink>
          <NavLink to="#">See graph</NavLink>
        </div>
      )}
      <NavLink to="/addSensor">Add Sensor</NavLink>
    </nav>
  );
};

export default Navbar;
