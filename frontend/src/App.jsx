import React, {useState} from 'react';
import './App.css';
import './css/Message.css'
import Footer from "./components/Footer.jsx";
import Header from "./components/Header.jsx";
import LoginPage from "./components/LoginPage.jsx";
import HomePage from "./components/HomePage.jsx";
import CreatePage from "./components/CreatePage.jsx";
import EmptyPage from "./components/EmptyPage.jsx";
import NewCoordinates from "./components/newObjects/NewCoordinates.jsx";
import NewLocation from "./components/newObjects/NewLocation.jsx";
import NewAddress from "./components/newObjects/NewAddress.jsx";

function App() {
    const [currentPage, setCurrentPage] = useState('home');
    const [isLoggedIn, setIsLoggedIn] = useState(false);

    const [message, setMessage] = useState({text: '', type: ''});

    const showMessage = (text, type) => {
        setMessage({text, type});
        setTimeout(() => {
            setMessage({text: '', type: ''});
        }, 4000);
    };

    return (
        <div className="app-container">
            {message.text && (
                <div className={`message ${message.type}`}>
                    {message.text}
                </div>
            )}

            <Header setCurrentPage={setCurrentPage} isLoggedIn={isLoggedIn} />

            <main>
                {currentPage === 'login' ? (
                    <LoginPage />
                ) : currentPage === 'create' ? (
                    <CreatePage setCurrentPage={setCurrentPage} />
                ) : currentPage === 'create/coordinates' ? (
                    <NewCoordinates showMessage={showMessage} />
                ) : currentPage === 'create/location' ? (
                    <NewLocation showMessage={showMessage} />
                ) : currentPage === 'create/address' ? (
                    <NewAddress showMessage={showMessage} />
                ) : currentPage === 'empty' ? (
                    <EmptyPage />
                ) : (
                    <HomePage />
                )}
            </main>

            <Footer />
        </div>
    );
}

export default App;