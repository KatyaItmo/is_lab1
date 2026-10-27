import '../css/Header.css'

function Header({ setCurrentPage, isLoggedIn }) {
    return (
        <header>
            <h1>лабораторная работа №1</h1>

            <div className="tabs-container">
                <button
                    className="page-link"
                    onClick={() => setCurrentPage('home')}
                >
                    список
                </button>

                <button
                    className="page-link"
                    onClick={() => setCurrentPage('create')}
                >
                    создать
                </button>

                <button
                    className="page-link"
                    onClick={() => setCurrentPage('info')}
                >
                    найти
                </button>

                <button
                    className="page-link"
                    onClick={() => setCurrentPage('change')}
                >
                    изменить
                </button>

                <button
                    className="page-link"
                    onClick={() => setCurrentPage('delete')}
                >
                    удалить
                </button>

                <button
                    className="page-link"
                    onClick={() => setCurrentPage('empty')}
                >
                    посмотреть на кота
                </button>
            </div>

            <div className="login-but-container">
                {isLoggedIn ? (
                    <button
                        className="login-but"
                    >
                        выйти
                    </button>
                ) : (
                    <button
                        className="login-but"
                        onClick={() => setCurrentPage('login')}
                    >
                        войти
                    </button>
                )}
            </div>
        </header>
    );
}

export default Header;