document.addEventListener('DOMContentLoaded', () => {
    const btn = document.getElementById('helloBtn');
    const responseDiv = document.getElementById('response');

    btn.addEventListener('click', async () => {
        responseDiv.textContent = 'Loading...';
        try {
            const res = await fetch('/hello');
            const text = await res.text();
            responseDiv.textContent = text;
        } catch (err) {
            responseDiv.textContent = 'Error fetching message';
        }
    });
});
