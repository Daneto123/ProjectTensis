// import React from 'react';
// import { render, fireEvent, screen } from '@testing-library/react';
// import Login from './Login';

// test('renders the login component', () => {
//   render(<Login />);
  
//   const usernameInput = screen.getByLabelText('Username:');
//   const passwordInput = screen.getByLabelText('Password:');
//   const loginButton = screen.getByText('Login');

//   expect(usernameInput).toBeInTheDocument();
//   expect(passwordInput).toBeInTheDocument();
//   expect(loginButton).toBeInTheDocument();
// });

// test('logs in a user when the login button is clicked', () => {
//   const mockLoginFunction = jest.fn();
//   render(<Login onLogin={mockLoginFunction} />);
  
//   const usernameInput = screen.getByLabelText('Username:');
//   const passwordInput = screen.getByLabelText('Password:');
//   const loginButton = screen.getByText('Login');

//   // Simulate user input
//   fireEvent.change(usernameInput, { target: { value: 'testUser' } });
//   fireEvent.change(passwordInput, { target: { value: 'testPassword' } });

//   // Click the login button
//   fireEvent.click(loginButton);

//   // Assert that the login function was called with the correct arguments
//   expect(mockLoginFunction).toHaveBeenCalledWith({
//     username: 'testUser',
//     password: 'testPassword',
//   });
// });
