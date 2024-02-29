import React, { useState, useEffect } from 'react';
import axios from 'axios';
import "./styles.css"

const GrafanaDashboard = () => {

  const [data, setData] = useState(null);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await axios.get('http://localhost:3001/api/graph');
        setData(response.url);
      } catch (error) {
        console.error('Error fetching data:', error);
      }
    };

    fetchData();
  });

  return (
    <div id="window">
      <h1>Data of name sensor</h1>
      <img src={data} alt="iot"></img>
    </div>
  );
};

export default GrafanaDashboard;
