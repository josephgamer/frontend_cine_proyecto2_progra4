
function fetchJSON(callback, url, obj) {
    fetch(url).then((resultados) => {
        return resultados.json();
    }).then((datosJSON) => {
        callback(obj, datosJSON);
    });
}

function loadJSON(callback, url, obj) {
    var xobj = new XMLHttpRequest();
    xobj.overrideMimeType("application/json");

    xobj.open('GET', url, true);

    xobj.onreadystatechange = function () {
        if (xobj.readyState === 4 && xobj.status === 200) {
            callback(obj, JSON.parse(xobj.responseText));
        }
    };
    xobj.send(null);
}
