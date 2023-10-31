async function fetchAndDisplayCities() {
    const response = await fetch('/city/getCities');
    const data = await response.json();
    displayCitiesInTable(data);
}

function displayCitiesInTable(cities) {
    const table = document.getElementById('citiesTable');

    // Clear the existing table rows
    while (table.rows.length > 1) {
        table.deleteRow(1);
    }

    for (const city of cities) {
        const row = table.insertRow();
        const idCell = row.insertCell(0);
        const nameCell = row.insertCell(1);
        const cityPartsCell = row.insertCell(2);

        idCell.innerHTML = city.id;
        nameCell.innerHTML = city.name;

        let cityPartsString = '';
        for (const cityPart of city.cityParts) {
            cityPartsString += cityPart.name + ', ';
        }
        cityPartsString = cityPartsString.slice(0, -2);
        cityPartsCell.innerHTML = cityPartsString;
    }
}