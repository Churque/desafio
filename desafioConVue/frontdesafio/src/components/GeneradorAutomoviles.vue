<template>
  <div>
    <h1>Generador de Automóviles</h1>
    <div>
      <label for="cantidad">Cantidad de automóviles:</label>
      <input type="number" id="cantidad" v-model="cantidad" />
      <button @click="generarAutomoviles">Generar</button>
      <button @click="eliminarAutos">Eliminar Todos los Autos Generados</button>
    </div>

    <BuscadorAutomoviles @filtrar="filtrarAutomoviles" />

    <ListaAutomoviles
      :automoviles="automoviles"
      @verCaracteristicas="verCaracteristicas"
    />

    <CaracteristicasAutomovil
      v-if="automovilSeleccionado"
      :automovil="automovilSeleccionado"
    />
  </div>
</template>

<script>
import AutoService from "../axios";
import BuscadorAutomoviles from "./BuscadorAutomoviles.vue";
import ListaAutomoviles from "./ListaAutomoviles.vue";
import CaracteristicasAutomovil from "./CaracteristicasAutomovil.vue";

export default {
  components: {
    BuscadorAutomoviles,
    ListaAutomoviles,
    CaracteristicasAutomovil,
  },
  data() {
    return {
      automoviles: [],
      automovilSeleccionado: null,
    };
  },
  methods: {
    generarAutomoviles() {
      if (this.cantidad > 0) {
        const autosService = new AutoService();
        autosService.generarAutomoviles(this.cantidad).then((response) => {
          this.automoviles = response.data;
        });
      }
    },
    eliminarAutos() {
      if (this.automoviles.length > 0) {
        const autosService = new AutoService();
        autosService.eliminarAutos().then((response) => {
          this.automoviles = response.data;
        });
      }
    },
    verCaracteristicas(automovil) {
      this.automovilSeleccionado = automovil;
    },
    filtrarAutomoviles(automovilesFiltrados) {
      this.automoviles = automovilesFiltrados;
    },
  },
};
</script>
