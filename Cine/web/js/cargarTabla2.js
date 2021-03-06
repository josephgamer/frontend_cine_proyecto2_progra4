/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var t = new tablero(8, 8); // backbean

function init2() {

    console.log(t);

    /*document.getElementById('fecha').textContent =
     dayjs().format('YYYY-MM-DD, HH:mm:ss');*/

    construirTablero(t);
    //actualizar();

    console.log('Aplicación inicializada..');
}

function construirTablero(t) {
    var refSeccion = document.getElementById('pop-up');
    if (refSeccion) {
        var tabla = document.createElement('TABLE');
        tabla.setAttribute('class', 'tablero');
        var button = document.createElement('BUTTON');
        tabla.appendChild(document.createElement('THEAD'));
        var contenido = document.createElement('TBODY');
        contenido.setAttribute("id", "bolitas");
        var fila;
        for (let i = 0; i < t.m(); i++) {
            fila = document.createElement('TR');
            var celda;
            for (let j = 0; j < t.n(); j++) {
                celda = document.createElement('TD');
                var btn = document.createElement('BUTTON');
                btn.setAttribute('type', 'button');
                btn.setAttribute('class', 'btnTablero');
                btn.setAttribute('name', 'posicion');
                btn.setAttribute('valor_fila', i);
                btn.setAttribute('valor_columna', j);

                btn.addEventListener('click', (evt) => {
                    var f = evt.currentTarget.getAttribute('valor_fila');
                    var c = evt.currentTarget.getAttribute('valor_columna');
                    cambiarEstado(f, c);
                    actualizar();
                    cambiarColor(f, c);
                    console.log({f: f, c: c});
                });

                var img = document.createElement('IMG');
                img.setAttribute('id', 'bola');
                img.setAttribute('src', 'images/silla3.jpg');
                btn.appendChild(img);

                celda.appendChild(btn);
                fila.appendChild(celda);
            }
            contenido.appendChild(fila);
        }
        fila = document.createElement('TR');
        button.setAttribute('type','button');
        button.innerHTML = "Comprar";
        tabla.appendChild(contenido);
        tabla.appendChild(button);
        refSeccion.appendChild(tabla);
    }
}

function cambiarEstado(i, j) {
    //var cambiarBola = document.getElementById('bola');
    t.estado[i][j] = !t.estado[i][j];
    if (t.estado[i][j]) {
        t.k++;
        //cambiarBola.setAttribute('src', 'css/images/silver-red-ball (sm).png');
    } /*else {
     t.k--;
     //cambiarBola.setAttribute('src', 'css/images/silver-ball (sm).png');
     }*/

}

function actualizar() {
    mostrarDatos(t);
}

function redireccionTiquete(){
location.href='AgregarTiquete';
}

function mostrarDatos(t) {
    var refDatos = document.getElementById('datos');
    if (refDatos) {
        while (refDatos.firstChild) {
            refDatos.removeChild(refDatos.firstChild);
        }

        var m = String.fromCharCode(215);
        var p;
        p = document.createElement('P');
        p.textContent = `${t.m()} ${m} ${t.n()}; k = ${t.k}`;
        refDatos.appendChild(p);

        for (let i = 0; i < t.m(); i++) {
            p = document.createElement('P');
            var linea = "";
            for (let j = 0; j < t.n(); j++) {
                linea += t.estado[i][j] + ', ';
            }
            p.textContent = linea;
            refDatos.appendChild(p);
        }
    }
}

function cambiarColor(f, c) {
    var tabla = document.getElementById('bolitas');
    if (t.estado[f][c]) {
        var celda = tabla.rows[f].cells[c];
        var boton = celda.firstChild;
        var imagen = boton.firstChild;
        imagen.setAttribute('src', 'images/silla2.jpg');
    } /*else {
     var celda = tabla.rows[f].cells[c];
     var boton = celda.firstChild;
     var imagen = boton.firstChild;
     imagen.setAttribute('src', 'images/silver-ball (sm).png');
     }*/
}



function reiniciar() {
    t.reiniciar();
}

