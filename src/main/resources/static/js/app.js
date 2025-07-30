document.addEventListener('DOMContentLoaded', () => {
    const btn = document.getElementById('helloBtn');
    const responseDiv = document.getElementById('response');
    const startGameBtn = document.getElementById('startGameBtn');
    const gameStatus = document.getElementById('gameStatus');
    const guessArea = document.getElementById('guessArea');
    const guessBtn = document.getElementById('guessBtn');
    const guessInput = document.getElementById('guessInput');

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

    startGameBtn.addEventListener('click', async () => {
        gameStatus.textContent = 'Starting game...';
        try {
            const res = await fetch('/game/start');
            const text = await res.text();
            gameStatus.textContent = text;
            guessArea.style.display = 'block';
        } catch (err) {
            gameStatus.textContent = 'Error starting game';
        }
    });

    guessBtn.addEventListener('click', async () => {
        const number = guessInput.value;
        if (!number) return;
        gameStatus.textContent = 'Checking...';
        try {
            const res = await fetch(`/game/guess?number=${number}`);
            const text = await res.text();
            gameStatus.textContent = text;
            if (text.startsWith('Congratulations')) {
                guessArea.style.display = 'none';
            }
        } catch (err) {
            gameStatus.textContent = 'Error sending guess';
        }
    });
});
