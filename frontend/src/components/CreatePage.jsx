import '../css/CreatePage.css'

function CreatePage({ setCurrentPage }) {
    return (
        <div className="container" id="create-container">
            <h2>добавление объектов</h2>

            <button
                className="add-but"
                onClick={() => setCurrentPage('create/worker')}
            >
                + worker
            </button>

            <button
                className="add-but"
                onClick={() => setCurrentPage('create/coordinates')}
            >
                + coordinates
            </button>

            <button
                className="add-but"
                onClick={() => setCurrentPage('create/organization')}
            >
                + organization
            </button>

            <button
                className="add-but"
                onClick={() => setCurrentPage('create/person')}
            >
                + person
            </button>

            <button
                className="add-but"
                onClick={() => setCurrentPage('create/address')}
            >
                + address
            </button>

            <button
                className="add-but"
                onClick={() => setCurrentPage('create/location')}
            >
                + location
            </button>
        </div>
    );
}

export default CreatePage;