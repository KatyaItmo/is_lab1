import {useEffect, useState} from "react";

function NewAddress({ showMessage }) {
    const [street, setStreet] = useState('');
    const [selectedLocationId, setSelectedLocationId] = useState('');

    const [locations, setLocations] = useState([]);

    useEffect(() => {
        fetch('/api/location')
            .then(res => res.json())
            .then(data => setLocations(data))
            .catch(err => showMessage('не удолось загрузить список locations', 'error'));
    }, []);

    const submitAddress = async () => {
        if (street === '') {
            showMessage('заполните все поля', 'error');
            return;
        }

        const addressData = {
            street: street,
            town: selectedLocationId ? { id: Number(selectedLocationId) } : null
        }

        try {
            const response = await fetch('/api/address', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                    'Accept': 'application/json'
                },
                body: JSON.stringify(addressData)
            });

            const createdAddress = await response.json();

            showMessage('address успешно создан (id=' + createdAddress.id + ')', 'text');

            setStreet('');
            setSelectedLocationId('');

        } catch (error) {
            console.error('Ошибка при создании адреса:', error);
        }
    }

    return (
        <div className="container" id="new-address-container">
            <h2>новый address</h2>

            <form className="form-add">
                <div className="input-group">
                    <label>street:</label>
                    <input
                        className="add-input"
                        placeholder="введите улицу"
                        value={street}
                        onChange={(e) => setStreet(e.target.value)}
                    />
                </div>

                <div className="select-group">
                    <label>location (id):</label>
                    <select
                        value={selectedLocationId}
                        onChange={(e) => setSelectedLocationId(e.target.value)}
                    >
                        <option value=''>(не указано)</option>
                        {locations.map((loc) =>(
                            <option key={loc.id} value={loc.id}>
                                id: {loc.id} (x: {loc.x}, y: {loc.y})
                            </option>
                        ))}
                    </select>
                </div>

                <button
                    className="submit-but"
                    type="button"
                    onClick={submitAddress}
                >
                    создать
                </button>

            </form>
        </div>
    );
}

export default NewAddress;