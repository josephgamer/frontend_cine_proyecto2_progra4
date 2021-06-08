/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function redireccionLogin(){
location.href='ServicioLogin';
}

function init() {

    // Se solicitan los datos al servlet usando cacda uno de los
    // diferentes métodos.
    // Las funciones están definidas en sus respectivos archivos.

    solicitarDatos("VerSalas", "tabla1", fetchJSON, cargarTabla);

    console.log("Aplicación inicializada..");
}

function solicitarDatos(url, tabla, fn, callback) {
    fn(callback, url, tabla);
}

function cargarTabla(idTabla, datosJSON) {
    var refTabla = document.getElementById(idTabla);
    if (refTabla) {
        var lista = datosJSON.salas;
        lista.forEach((v, i, a) => {
            var nuevaFila = refTabla.insertRow(-1);
            var nuevaCelda;

            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.innerText = v.numSala;
            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.innerText = v.tipo;
            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.innerText = v.precio;
        });
    }
}