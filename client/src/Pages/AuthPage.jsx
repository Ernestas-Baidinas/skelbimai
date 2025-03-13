import React, { useState } from 'react';
import LoginForm from '../components/LoginForm';
import RegisterForm from '../components/RegisterForm';

const AuthPage = () => {
    const [isLogin, setIsLogin] = useState(true);

    const toggleForm = () => {
        setIsLogin(!isLogin);
    };

    return (
        <div className="min-h-screen flex justify-center items-center bg-gray-100">
            <div className="max-w-sm mx-auto p-4 bg-white shadow-md rounded-md">
                {isLogin ? (
                    <>
                        <LoginForm />
                        <button
                            onClick={toggleForm}
                            className="text-blue-500 hover:underline mt-4 w-full py-2 bg-gray-200 rounded"
                        >
                            Register
                        </button>
                    </>
                ) : (
                    <>
                        <RegisterForm />
                        <button
                            onClick={toggleForm}
                            className="text-blue-500 hover:underline mt-4 w-full py-2 bg-gray-200 rounded"
                        >
                            Login
                        </button>
                    </>
                )}
            </div>
        </div>
    );
};

export default AuthPage;