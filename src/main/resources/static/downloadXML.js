function downloadXML() {
    fetch("/fileHandler/download")
        .then(response => {
            if (response.ok) {
                document.getElementById('message').innerText = "XML file downloaded successfully.";
            } else {
                throw new Error('Network response was not ok.');
            }
        })
        .catch(error => console.error('Error:', error.message));
}