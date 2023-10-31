function downloadXML() {
    fetch("/fileHandler/download")
        .then(response => response)
        .then(data => data).catch(error => console.error('Error:', error.message));
}