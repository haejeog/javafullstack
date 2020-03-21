'use strict';

/**
 * Apartado 1
 * Crea una función que reciba 2 cadenas por parámetro. Dicha función imprimirá por consola qué cadena
 * tiene mayor longitud. Si el tipo de algún parámetro no es string (typeof param !== "string"),
 * debes imprimir un error.
 * Llama a la función 3 veces con diferentes parámetros. En una de esas llamadas pásale por parámetro un valor que no sea string.
 */

console.log('--------------- APARTADO 1 -----------------');
function apart1(cad1, cad2) {
    if (typeof cad1 !== "string" || typeof cad2 !== "string") {
        console.log("Error");
    } else {
        if (cad1 > cad2) {
            console.log(cad1);
        } else {
            console.log(cad2);
        }
    }
}
apart1("HOLA MUNDO", "HOLA");
apart1("Luis", "Ronaldo");
apart1("HOLA MUNDO", 3);

/**
 * Apartado 2
 * Crea una función que reciba 2 números por parámetro, el primer número indicará cuantas veces debemos imprimir el segundo
 * por pantalla, pero en cada iteración muéstra el valor anterior multiplicado por 2.
 * Ejemplo: Si recibimos 4 y 6 imprimiremos: 6 12 24 48
 * Llama a la función varias veces.
 */

console.log('--------------- APARTADO 2 -----------------');
function apart2(n1, n2) {
    for (let index = 0; index < n1; index++) {

        console.log(n2);
        n2 = n2 * 2;
    }
}
apart2(4, 6);
apart2(10, 100);
apart2(10, 1);

/**
 * Apartado 3
 * Crea una función que reciba 2 parámetros. El primero será una cadena y el segundo otra cadena que contendrá un caracter.
 * Convierte ambos parámetros a cadena y comprueba que efectivamente, el segundo parámetro tiene una longitud de 1.
 * Debes mostrar cuantas veces aparece el caracter recibido en la cadena.
 * Ejemple: Si recibimos "carcasa" y "a", debemos indicar que aparece 3 veces dicha letra en la cadena.
 * Llama a la función varias veces.
 */

console.log('--------------- APARTADO 3 -----------------');
function apart3(n1, n2) {
    let s1 = String(n1);
    let s2 = String(n2);
    let veces = 0;
    let pos = s1.indexOf(s2);

    while (pos != -1) {
        veces++;
        pos = s1.indexOf(s2, pos + 1);
    }
    console.log(veces);
}

apart3("carcasa", "a");
apart3("Luis tiene bachiller", "i");
apart3("Luis tiene bachiller", "a");
/**
 * Apartado 4
 * Crea una función que reciba 3 parámetros (nombre de producto, precio e impuesto en porcentaje sobre 100).
 * Dicha función hará lo siguiente:
 * - Los parámetros deberán tener un valor por defecto por si no los recibe que deben ser: "Producto genérico", 100 y 21.
 * - Convierte el nombre de producto a string (por si acaso) y los otros 2 a número. Si el precio o el impuesto no son
 *   numéros válidos (NaN) muestra un error. Si son válidos, muestra por consola el nombre del producto y el precio final contando impuestos.
 * - Llama a la función varias veces, omitiendo parámetros, con todos los parámetros, y pasándo algún valor no númerico en el precio o impuesto.
 */

console.log('--------------- APARTADO 4 -----------------');
let num = (nombreProducto = "Producto Genérico", precio = 100, impuesto = 21) => {
    let nombre = String(nombreProducto);
    let precioDouble = Number(precio);
    let impuestoDouble = Number(impuesto);
    if (Number.isNaN(precioDouble) || Number.isNaN(impuestoDouble)) {
        return "Error";
    } else {
        return nombre + " Precio final es: " + (precioDouble + impuestoDouble);
    }
}
console.log(num());
console.log(num("Fresa"));
console.log(num("Fresa", "fresa"));
console.log(num("Fresa", 20, 1.0));

/**
 * Apartado 5
 * Crea una función de tipo flecha (arrow function) que reciba 2 parámetros. Una cadena completa y un trozo de cadena a buscar.
 * La función debe comprobar si el trozo de cadena de búsqueda se encuentra dentro de la cadena completa e imprimir
 * por consola un mensaje indicando si ha encontrado coincidencia o no.
 * La búsqueda no debe ser sensible a mayúsculas o minúsculas, por lo que debes comparar ambas cadenas previa transformación
 * a minúsculas (o a mayúsculas). Ej: La cadena "Santiago de Compostela" contiene la cadena de búsqueda "COMPO".
 * Llama a la función varias veces.
 */

console.log('--------------- APARTADO 5 -----------------');
let cadena = (cadenaComp, cadenaTrozo) => {
    let comp = String(cadenaComp).toLocaleUpperCase();
    let trozo = String(cadenaTrozo).toLocaleUpperCase();
    let cont = comp.indexOf(trozo);
    if (cont != -1) {
        console.log('La cadena "' + cadenaComp + '" contiene la cadena de búsqueda "' + cadenaTrozo + '"');
    } else {
        console.log('La cadena "' + cadenaComp + '" no contiene la cadena de búsqueda "' + cadenaTrozo + '"');
    }
}
cadena("fresa saborosa", "sd");
cadena("fresa saborosa", "bo");
cadena("fresa saborosa", "sa");
cadena("Los booleanos se representan dentro de comillas simples", "de");