async function fetchAndSaveCities() {
    const response = await fetch('/20210331_OB_573060_UZSZ.xml');
    const xmlText = await response.text();
    const parser = new DOMParser();
    const xml = parser.parseFromString(xmlText, 'text/xml');

    const cities = xml.getElementsByTagName('vf:Obec');

    for (let i = 0; i < cities.length; i++) {
        const city = cities[i];
        const id = city.getElementsByTagName('obi:Kod')[0].textContent;
        const name = city.getElementsByTagName('obi:Nazev')[0].textContent;

        const data = {
            id: parseInt(id),
            name: name
        };
        await sendCityDataToBackend(data);
    }
}

async function sendCityDataToBackend(data) {
    const url = '/city/saveCities';
    const options = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    };

    try {
        const response = await fetch(url, options);
        const result = await response.json();
        console.log('Result from backend:', result);
    } catch (error) {
        console.error('Error sending data to the backend:', error);
    }
}
async function fetchAndSaveCityParts() {
    const response = await fetch('/20210331_OB_573060_UZSZ.xml');
    const xmlText = await response.text();
    const parser = new DOMParser();
    const xml = parser.parseFromString(xmlText, 'text/xml');

    const cityParts = xml.getElementsByTagName('vf:CastObce');

    for (let i = 0; i < cityParts.length; i++) {
        const part = cityParts[i];
        const id = part.getElementsByTagName('coi:Kod')[0].textContent;
        const name = part.getElementsByTagName('coi:Nazev')[0].textContent;
        const cityId = part.getElementsByTagName('coi:Obec')[0].getElementsByTagName('obi:Kod')[0].textContent;

        const data = {
            id: parseInt(id),
            name: name,
            city: {
                id: parseInt(cityId)
            }
        };

        await sendCityPartsDataToBackend(data);
    }
}

async function sendCityPartsDataToBackend(data) {
    const url = '/cityParts/saveCityParts';
    const options = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    };

    try {
        const response = await fetch(url, options);
        const result = await response.json();
        console.log('Result from backend:', result);
    } catch (error) {
        console.error('Error sending data to the backend:', error);
    }
}
async function fetchAndSaveData() {
    await fetchAndSaveCities();
    await fetchAndSaveCityParts();
}
