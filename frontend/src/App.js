import React, { useState } from 'react';
import axios from 'axios';

function App() {
  const [formData, setFormData] = useState({
    name: '',
    address: '',
    birthdate: '',
    phoneNumber: '',
    email: '',
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post('http://localhost:8080/registration', formData, {
        headers: {
          'Content-Type': 'application/json',
        }
      });console.log('Response:', response.data);
      alert('Form submitted successfully!');
    } catch (error) {
      console.error('Error submitting form:', error);
      alert('Failed to submit form.');
    }
  };

  return (
  <div style={{ padding: '20px', maxWidth: '400px', margin: 'auto', backgroundColor: 'lightgreen' }}>
    <h2>Submit Your Details</h2>
    <form onSubmit={handleSubmit}>
      <div style={{ marginBottom: '10px' }}>
        <label style={{ display: 'block', marginBottom: '5px' }}>Name</label>
        <input
          type="text"
          name="name"
          value={formData.name}
          onChange={handleChange}
          style={{ width: '100%', padding: '8px' }}
          required
        />
      </div>
      <div style={{ marginBottom: '10px' }}>
        <label style={{ display: 'block', marginBottom: '5px' }}>Address</label>
        <input
          type="text"
          name="address"
          value={formData.address}
          onChange={handleChange}
          style={{ width: '100%', padding: '8px' }}
          required
        />
      </div>
      <div style={{ marginBottom: '10px' }}>
        <label style={{ display: 'block', marginBottom: '5px' }}>Birthdate</label>
        <input
          type="date"
          name="birthdate"
          value={formData.birthdate}
          onChange={handleChange}
          style={{ width: '100%', padding: '8px' }}
          required
        />
      </div>
      <div style={{ marginBottom: '10px' }}>
        <label style={{ display: 'block', marginBottom: '5px' }}>Phone Number</label>
        <input
          type="text"
          name="phoneNumber"
          value={formData.phoneNumber}
          onChange={handleChange}
          style={{ width: '100%', padding: '8px' }}
          required
        />
      </div>
      <div style={{ marginBottom: '10px' }}>
        <label style={{ display: 'block', marginBottom: '5px' }}>Email ID</label>
        <input
          type="email"
          name="email"
          value={formData.emailId}
          onChange={handleChange}
          style={{ width: '100%', padding: '8px' }}
          required
        />
      </div>
      <button type="submit" style={{ padding: '10px 20px', marginTop: '10px' }}>
        Submit
      </button>
    </form>
  </div>
);

}

export default App;
