// import React from 'react';
// import { render, fireEvent } from '@testing-library/react';
// import Register from '../Pages/registerPage/RegisterPage';

// test('renders the register component', () => {
//     const { getByLabelText, getByText } = render(<Register />);
    
//     const usernameInput = getByLabelText('Username:');
//     const passwordInput = getByLabelText('Password:');
//     const registerButton = getByText('Register');
  
//     expect(usernameInput).toBeInTheDocument();
//     expect(passwordInput).toBeInTheDocument();
//     expect(registerButton).toBeInTheDocument();
//   });
  
//   test('registers a user when the register button is clicked', () => {
//     const mockRegisterFunction = jest.fn();
//     const { getByLabelText, getByText } = render(<Register onRegister={mockRegisterFunction} />);
    
//     const usernameInput = getByLabelText('Username:');
//     const passwordInput = getByLabelText('Password:');
//     const registerButton = getByText('Register');
  
//     // Simulate user input
//     fireEvent.change(usernameInput, { target: { value: 'testUser' } });
//     fireEvent.change(passwordInput, { target: { value: 'testPassword' } });
  
//     // Click the register button
//     fireEvent.click(registerButton);
  
//     // Assert that the registration function was called with the correct arguments
//     expect(mockRegisterFunction).toHaveBeenCalledWith({
//       username: 'testUser',
//       password: 'testPassword',
//     });
//   });