import React from 'react';
import { Routes, Route } from 'react-router-dom';
import AuthPage from './pages/AuthPage';
import ProtectedPage from './pages/ProtectedPage';

const App = () => {
    return (
        <div className="flex flex-col h-screen">
            <div className="flex-grow pt-16 overflow-hidden">
                <Routes>
                    <Route path="/" element={<AuthPage />} />
                    <Route path="/protected" element={<ProtectedPage />} />
                </Routes>
            </div>
        </div>
    );
};

export default App;