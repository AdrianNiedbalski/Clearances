document.addEventListener("DOMContentLoaded", () => {
    fetch("/customs/data?ts=" + Date.now())
        .then(res => res.json())
        .then(data => {
            const list = document.getElementById("customsList");
            list.innerHTML = data.map((c, i) => `
                <div class="customs-entry">
                    <div class="customs-number-container">
                        <div class="customs-number">${i + 1}</div>
                        <a href="/customs/details/${c.id}" class="customs-info">ℹ️</a>
                    </div>
                    <div class="customs-box">
                        <div class="customs-row-labels">Rodzaj</div>
                        <div class="customs-row-labels">Eksporter</div>
                        <div class="customs-row-labels">Importer</div>
                        <div class="customs-row-labels">Agent</div>
                        <div class="customs-row-labels">Status</div>
                        <div class="customs-row-labels">Data</div>

                        <div class="customs-row-values">${c.customsType.customsType}</div>
                        <div class="customs-row-values">${c.exporter.name}</div>
                        <div class="customs-row-values">${c.importer.name}</div>
                        <div class="customs-row-values">${c.agent.person.firstName} ${c.agent.person.lastName}</div>
                        <div class="customs-row-values">${c.status}</div>
                        <div class="customs-row-values">${c.createdAt}</div>
                    </div>
                </div>
            `).join("");
        });
});
