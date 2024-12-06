const sessionType = document.getElementById('session-type');
const startBtn = document.getElementById('start-btn');
const resetBtn = document.getElementById('reset-btn');
const timerHand = document.getElementById('timer-hand');

const WORK_DURATION = 5; // 5 seconds for testing
let timeLeft = WORK_DURATION;
let isRunning = false;
let intervalId;

function startTimer() {
    if (isRunning) return; // Prevent starting multiple timers

    isRunning = true;
    startBtn.disabled = true;
    timeLeft = WORK_DURATION;

    // Start the smooth animation
    timerHand.style.animation = 'none';
    timerHand.offsetHeight; // Trigger reflow
    timerHand.style.animation = `rotate ${WORK_DURATION}s linear`;

    intervalId = setInterval(() => {
        if (timeLeft > 0) {
            timeLeft--;
        } else {
            clearInterval(intervalId);
            isRunning = false;
            resetTimer();
        }
    }, 1000);
}

function resetTimer() {
    clearInterval(intervalId);
    isRunning = false;
    startBtn.disabled = false;
    timeLeft = WORK_DURATION;
    timerHand.style.animation = 'none';
    sessionType.textContent = 'Pomogranate';
}

startBtn.addEventListener('click', startTimer);
resetBtn.addEventListener('click', resetTimer);

// Initialize the timer
resetTimer();
