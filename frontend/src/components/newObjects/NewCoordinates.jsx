import {useState} from "react";

import '../../css/AddForms.css'

function NewCoordinates({ showMessage }) {
    const [x, setX] = useState('');
    const [y, setY] = useState('');

    const handleX = (e) => {
        const value = e.target.value;
        if (value === '' || value === '-' || /^-?\d*[.,]?\d{0,3}$/.test(value)) {
            setX(value);
        }
    }

    const handleY = (e) => {
        const value = e.target.value;
        if (value === '' || value === '-' || /^-?\d*$/.test(value)) {
            setY(value);
        }
    }

    const submitCoordinates = async () => {
        if (x === '' || x === '-' || y === '' || y === '-') {
            showMessage('заполните все поля корректно', 'error');
            return;
        }

        const parsedX = parseFloat(x.replace(',', '.'));
        const parsedY = parseInt(y, 10);

        const coordinateData = {
            x: parsedX,
            y: parsedY
        };

        try {
            const response = await fetch('/api/coordinates', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                    'Accept': 'application/json'
                },
                body: JSON.stringify(coordinateData)
            });

            const createdCoordinate = await response.json();

            showMessage('coordinates успешно созданы (id=' + createdCoordinate.id + ')', 'text');

            setX('');
            setY('');

        } catch (err) {
            showMessage('не удалось сохранить coordinates', 'error');
        }
    }

    return (
        <div className="container" id="new-coordinates-container">
            <h2>новый coordinates</h2>

            <form className="form-add">
                <div className="input-group">
                    <label>координата x:</label>
                    <input
                        className="add-input"
                        placeholder="формат дробное"
                        value={x}
                        onChange={(e) => handleX(e)}
                    />
                </div>

                <div className="input-group">
                    <label>координата y:</label>
                    <input
                        className="add-input"
                        placeholder="формат целое"
                        value={y}
                        onChange={(e) => handleY(e)}
                    />
                </div>

                <button
                    className="submit-but"
                    type="button"
                    onClick={submitCoordinates}
                >
                    создать
                </button>
            </form>
        </div>
    );
}

export default NewCoordinates;