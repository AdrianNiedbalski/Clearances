document.addEventListener("DOMContentLoaded", () => {
    const dateFields = document.querySelectorAll('input[type="date"]');

    const today = new Date().toISOString().split("T")[0];

    dateFields.forEach(input => {
        if (!input.value) {
            input.value = today;
        }
    });
});
