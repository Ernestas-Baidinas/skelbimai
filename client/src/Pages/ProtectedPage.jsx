import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';

const ProtectedPage = () => {
    const [data, setData] = useState(null);
    const [error, setError] = useState(null);
    const navigate = useNavigate();

    useEffect(() => {
        const token = localStorage.getItem('token');
        if (!token) {
            navigate('/login');
        } else {
            fetchProtectedData(token);
        }
    }, [navigate]);

    const fetchProtectedData = async (token) => {
        try {
            const response = await fetch('http://localhost:8080/api/protected', {
                headers: {
                    'Authorization': `Bearer ${token}`
                }
            });

            if (!response.ok) {
                throw new Error('Error fetching protected');
            }

            const result = await response.json();
            setData(result);
        } catch (err) {
            setError('Error fetching protected');
        }
    };

    if (error) {
        return <p>{error}</p>;
    }

    if (!data) {
        return <p>Loading...</p>;
    }

    return (
        <div>
            <h1>You successfully login</h1>
            <pre>{JSON.stringify(data, null, 2)}</pre>
        </div>
    );
};

export default ProtectedPage;