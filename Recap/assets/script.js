async function registrati() {
    let email = document.getElementById('email')
    let password = document.getElementById('password')
    if (email.value.trim() == "") {
        alert("Devi inserire una email valida")
        return;
    }
    if (password.value.trim() == "" || password.value.length < 5) {
        alert("Devi inserire una password valida")
        return;
    }
    try {
        const myHeaders = new Headers();
        myHeaders.append("Content-Type", "application/json");
        let result = await fetch("http://localhost:8080/auth/register", {
            body: JSON.stringify({
                email: email.value,
                password: password.value
            }),
            headers: myHeaders,
            method: 'POST'
        })
        result = await result.json()
        console.log(result)
        alert(result)
    } catch(error) {
        console.log(error)
        console.error('C\'è stato un errore')
    }
}

async function login() {
    let email = document.getElementById('email')
    let password = document.getElementById('password')
    if (email.value.trim() == "") {
        alert("Devi inserire una email valida")
        return;
    }
    if (password.value.trim() == "") {
        alert("Devi inserire una password valida")
        return;
    }
    try {
        const myHeaders = new Headers();
        myHeaders.append("Content-Type", "application/json");
        console.log(email.value, password.value)
        let result = await fetch("http://localhost:8080/auth/login", {
            body: JSON.stringify({
                email: email.value,
                password: password.value
            }),
            headers: myHeaders,
            method: 'POST'
        })
        result.text().then((value) => {
            console.log(value)
            localStorage.setItem('token', value)

        })
    } catch(error) {
        console.log(error)
        console.error('C\'è stato un errore')
    }
}

async function getCataloghi() {
    try {
        let result = await fetch("http://localhost:8080/cataloghi", {
            headers: {
                Authorization: "Bearer "+localStorage.getItem('token')
            }
        })
        result = await result.json()
        console.log(result)
    } catch(error) {
        console.log(error)
    }
}

async function inserisci() {
    let codiceISBN = document.getElementById('codiceISBN')
    let titolo = document.getElementById('titolo')
    let annoPubblicazione = document.getElementById('annoPubblicazione')
    let numeroPagine = document.getElementById('numeroPagine')
    let autore = document.getElementById('autore')
    let genere = document.getElementById('genere')
    if (codiceISBN.value.trim() == "" || titolo.value.trim() == "" || annoPubblicazione.value.length == 0 || numeroPagine.value.length == 0 || autore.value.trim() == "" || genere.value.trim() == "") {
        alert("Devi inserire i dati correttamente")
        return;
    }
    try {
        const myHeaders = new Headers();
        myHeaders.append("Content-Type", "application/json");
        myHeaders.append("Authorization", "Bearer "+localStorage.getItem('token'))
        console.log(email.value, password.value)
        let result = await fetch("http://localhost:8080/cataloghi", {
            body: JSON.stringify({
                codiceISBN: codiceISBN.value,
                titolo: titolo.value,
                annoPubblicazione: annoPubblicazione.value,
                numeroPagine: numeroPagine.value,
                autore: autore.value,
                genere: genere.value
            }),
            headers: myHeaders,
            method: 'POST'
        })
        result.text().then((value) => {
            console.log(value)
            alert(value)

        })
    } catch(error) {
        console.log(error)
        console.error('C\'è stato un errore')
    }
}