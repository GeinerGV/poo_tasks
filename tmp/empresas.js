// https://www.americaeconomia.com/negocios-industrias/conozca-las-500-empresas-mas-grandes-del-peru-2018

(function () {
	window.nombres_semana8 = [];
	window.getNombres_semana8 = function(init, end) {
		nombres = [];
		init = typeof init !== "undefined" ? init : 0;
		end = typeof end !== "undefined" ? (end>init ? end : init) : init + 25;
		try {
			for (let i=init; i<end; i++) {
				nombres_semana8.push(document.querySelector(`#awesomeTable > tbody:nth-child(3) > [data-target="${i}"]`).children[1].innerText);
			}
		}
		catch(error) {
			console.warn("Hubo un error en el index: " + (init+nombres_semana8.length));
		}
	}
	window.nombresToListString_semana8 = function () {
		let result = "";
		nombres_semana8.forEach(function(nombre) {
			result += `"${nombre}", `;
		});
		console.log(result.slice(0,-2));
	}
	window.getNombres_semana8();
	window.nombresToListString_semana8();
})()

// "PETROPERÚ", "CREDICORP", "REFINERÍA LA PAMPILLA S.A.A.", "FALABELLA PERÚ", "SOCIEDAD MINERA CERRO VERDE", "CÍA. MINERA ANTAMINA", "ESSALUD", "MINERA LAS BAMBAS", "TELEFÓNICA DEL PERÚ", "INRETAIL PERÚ CORP. y SUB.", "BANCO DE CRÉDITO DEL PERÚ", "SOUTHERN PERU COPPER CORP. / DEL GRUPO MÉXICO", "PRIMAX", "ALICORP", "GRAÑA Y MONTERO", "AMÉRICA MÓVIL PERÚ - CLARO", "CENCOSUD", "FERREYCORP", "SUPERMERCADOS PERUANOS", "TRAFIGURA PERÚ", "BBVA BANCO CONTINENTAL", "UCP BACKUS Y JOHNSTON", "INTERCORP PERÚ", "GLENCORE", "CÍA. DE MINAS BUENAVENTURA y SUB."
