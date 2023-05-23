import axios from 'axios';


export default class AutosService {

    url = "http://localhost:3001/api/autos/";

    generarAutomoviles(num) {
        return axios.get(this.url +"generar/"+ num);
    }

    filtrarPorPrecio(precio,opcionFiltro) {
        return axios.post(this.url +"filtrar/"+opcionFiltro+"/"+ precio);
    }

    eliminarAutos() {
        return axios.post(this.url +"eliminar");
    }
}