document.getElementById('fetchData').addEventListener('click', function() {
    fetch('/api/data')
        .then(response => response.json())
        .then(data => {
            document.getElementById('data').innerText = JSON.stringify(data);
        })
        .catch(error => console.error('Error fetching data:', error));
});