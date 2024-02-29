const sendDataToExpress = async () => {
    try {
      const response = await fetch('http://localhost:3001/api/login', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({
          username: 'daneto',
          password: 'daneto123',
        }),
      });
      const data = await response.json();
      console.log('Response from server:', data);
      // You can handle the response as needed.
    } catch (error) {
      console.error('Error sending data to Express.js:', error);
    }
  };
  
  // Call the function when needed.
  sendDataToExpress();
  