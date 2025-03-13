const API_URL = 'http://localhost:8080/api/auth';

export const loginUser = async (credentials) => {
    const response = await fetch(`${API_URL}/login`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        credentials: 'include',
        body: JSON.stringify(credentials),
    });

    if (!response.ok) {
        throw new Error('Login failed: ' + response.statusText);
    }

    return await response.json();
};

export const registerUser = async (credentials) => {
    const response = await fetch(`${API_URL}/register`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        credentials: 'include',
        body: JSON.stringify(credentials),
    });

    if (!response.ok) {
        throw new Error('Registration error: ' + response.statusText);
    }

    return await response.json();
};