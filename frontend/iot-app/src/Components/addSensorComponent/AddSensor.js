import React, { useState } from 'react';
import NavBar from '../../Components/navbarComponent/NavBarPage';
import Footer from '../../Components/footerComponent/FooterPage';
import "./styles.css"

const FormPage = ({ user }) => {
  const [idSensor, setId] = useState('');
  const [roomType, setRoomType] = useState('');
  const [selectedOption, setSelectedOption] = useState('');

  const roomTypes = ['Single', 'Double', 'Suite', 'Apartment'];

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log('Submitted:', { idSensor, roomType, selectedOption });
  };

  const sendDataToExpress = async (idSensor, roomType, selectedOption) => {
    try {
      const response = await fetch('http://localhost:3001/api/addNewSensor', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({
          idSensor: idSensor,
          roomType: roomType,
          selectedOption: selectedOption
        }),
      });
      const data = await response.json();
      console.log('Response from server:', data);
    } catch (error) {
      console.error('Error sending data to Express.js:', error);
    }
  };

  return (
    <div>
      <form onSubmit={handleSubmit}>
        <label>
          Sensor ID:
          <input
            type="text"
            value={idSensor}
            onChange={(e) => setId(e.target.value)}
          />
        </label>
        <br />
        <label>
          Type of Room:
          <input
            type="text"
            value={roomType}
            onChange={(e) => setRoomType(e.target.value)}
          />
        </label>
        <br />
        <label>
          Select Type of Room:
          <select
            value={selectedOption}
            onChange={(e) => setSelectedOption(e.target.value)}
          >
            <option value="" disabled>
              Select a room type
            </option>
            {roomTypes.map((type) => (
              <option key={type} value={type}>
                {type}
              </option>
            ))}
          </select>
        </label>
        <br />
        <button onClick={sendDataToExpress(idSensor, roomType, selectedOption)}>Submit</button>
      </form>
    </div>
  );
};

export default FormPage;
