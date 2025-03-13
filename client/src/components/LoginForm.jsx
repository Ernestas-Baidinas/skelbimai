import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { loginUser } from '../api/auth';

const LoginForm = () => {
    const [login, setLogin] = useState('');
    const [password, setPassword] = useState('');
    const [error, setError] = useState('');
    const navigate = useNavigate();

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const data = await loginUser({ login, password });
            localStorage.setItem('token', data.token);
            navigate('/dashboard');
        } catch (err) {
            setError('Wrong account or password');
        }
    };

    return (
        <form onSubmit={handleSubmit} className="max-w-sm mx-auto p-4 bg-white shadow-md rounded-md">
            <h2 className="text-xl mb-4">Login</h2>
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
            <button type="submit" className="w-full p-2 bg-blue-500 text-white rounded">Login</button>
        </form>
    );
};

export default LoginForm;