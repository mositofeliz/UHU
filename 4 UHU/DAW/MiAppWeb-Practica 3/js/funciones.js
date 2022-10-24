
//esto es para quitar los acentos al generar el .html
/*
const removeAccents = (str) => {
    return str.normalize("NFD").replace(/[\u0300-\u036f]/g, "");
}


let menu = ["HOME", "Categorias", "Articulos", "Formulario"];

let m = document.getElementById("menu");

let ul = document.createElement("ul");
for(let o in menu){
    let li = document.createElement("li");
    let a = document.createElement("a");
    let ta = document.createTextNode(menu[o]);
    a.href = menu[o].toLowerCase() + "html";
    li.appendChild(tli);
    li.appendChild(a);
    ul.appendChild(li);
}

m.appendChild(ul);
*/