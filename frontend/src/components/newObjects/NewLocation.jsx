import '../../css/AddForms.css'
import {useState} from "react";

function NewLocation({ showMessage }) {
    const [x, setX] = useState('');
    const [y, setY] = useState('');
    const [z, setZ] = useState('');

    const handleX = (e) => {
        const value = e.target.value;
        if (value === '' || value === '-' || /^-?\d*$/.test(value)) {
            setX(value);
        }
    }

    const handleY = (e) => {
        const value = e.target.value;
        if (value === '' || value === '-' || /^-?\d*$/.test(value)) {
            setY(value);
        }
    }

    const handleZ = (e) => {
        const value = e.target.value;
        if (value === '' || value === '-' || /^-?\d*$/.test(value)) {
            setZ(value);
        }
    }

    const submitLocation = async () => {
        if (x === '' || x === '-' || y === '' || y === '-' || z === '' || z === '-') {
            showMessage('заполните все поля корректно', 'error');
            return;
        }

        const parsedX = parseInt(x, 10);
        const parsedY = parseInt(y, 10);
        const parsedZ = parseInt(x, 10);

        const locationData = {
            x: parsedX,
            y: parsedY,
            z: parsedZ
        };

        try {
            const response = await fetch('/api/location', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                    'Accept': 'application/json'
                },
                body: JSON.stringify(locationData)
            });

            const createdLocation = await response.json();

            showMessage('location успешно создана (id=' + createdLocation.id + ')', 'text');

            setX('');
            setY('');
            setZ('');

        } catch (err) {
            showMessage('не удалось сохранить location', 'error');
        }
    }

    return (
        <div className="container" id="new-location-container">
            <h2>новый location</h2>

            <form className="form-add">
                <div className="input-group">
                    <label>координата x:</label>
                    <input
                        className="add-input"
                        placeholder="формат целое"
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

                <div className="input-group">
                    <label>координата z:</label>
                    <input
                        className="add-input"
                        placeholder="формат целое"
                        value={z}
                        onChange={(e) => handleZ(e)}
                    />
                </div>

                <button
                    className="submit-but"
                    type="button"
                    onClick={submitLocation}
                >
                    создать
                </button>
            </form>
        </div>
    );
}

export default NewLocation;