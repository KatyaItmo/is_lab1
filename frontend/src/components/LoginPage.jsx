import {useState} from "react";

import '../css/LoginPage.css'

function LoginPage() {
    const [isRegistering, setIsRegistering] = useState(false);

    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');

    return (
        <div className="container" id="login-container">
            <h2>{isRegistering ? 'регистрация' : 'вход'}</h2>

            <form className="login-form">
                <input
                    className="login-input"
                    type="text"
                    placeholder="логин"
                    value={username}
                    onChange={(e) => setUsername(e.target.value)}
                />

                <input
                    className="login-input"
                    type="password"
                    placeholder="пароль"
                    value={password}
                    onChange={(e) => setPassword(e.target.value)}
                />

                <button
                    className="submit-but"
                >
                    {isRegistering ? 'зарегистрироваться' : 'войти'}
                </button>
            </form>

            <button
                className="login-mode-but"
                onClick={() => setIsRegistering(!isRegistering)}
            >
                {isRegistering ? 'уже есть аккаунт? войти' : 'нет аккаунта? зарегистрироваться'}
            </button>
        </div>
    );
}

export default LoginPage;