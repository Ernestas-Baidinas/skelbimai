import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { registerUser } from '../api/auth';

const RegisterForm = () => {
    const [login, setLogin] = useState('');
    const [password, setPassword] = useState('');
    const [error, setError] = useState('');
    const navigate = useNavigate();

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            await registerUser({ login, password });
            navigate('/login');
        } catch (err) {
            setError('Error with registration');
        }
    };

    return (
        <form onSubmit={handleSubmit} className="max-w-sm mx-auto p-4 bg-white shadow-md rounded-md">
            <h2 className="text-xl mb-4">Registration</h2>
            {error && <p className="text-red-500 mb-2">{error}</p>}
            <input
                type="text"
                placeholder="Username"
                value={login}
                onChange={(e) => setLogin(e.target.value)}
                className="mb-4 p-2 border border-gray-300 rounded w-full"
            />
            <input
                type="password"
                placeholder="Password"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
                className="mb-4 p-2 border border-gray-300 rounded w-full"
            />
            <button type="submit" className="w-full p-2 bg-blue-500 text-white rounded">Register</button>
        </form>
    );
};

export default RegisterForm;