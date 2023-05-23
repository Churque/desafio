<template>
  <div>
    <h1>Buscador por filtros</h1>
    <label for="precio">Precio:</label>
    <input type="number" id="precio" v-model="filtroPrecio" />
    <select v-model="opcionFiltro">
      <option value="menor">Menor</option>
      <option value="mayor">Mayor</option>
    </select>
    <button @click="filtrar">Filtrar</button>
    <button @click="resetear">Resetear</button>
  </div>
</template>

<script>
import AutoService from "../axios";

export default {
  data() {
    return {
      filtroPrecio: null,
      opcionFiltro: "menor",
    };
  },
  methods: {
    filtrar() {
      if (this.filtroPrecio !== null && this.opcionFiltro !== null) {
        const autosService = new AutoService();
        autosService.filtrarPorPrecio(this.filtroPrecio, this.opcionFiltro)
          .then(response => {
            this.$emit("filtrar", response.data);
          });
      }
    },
    resetear() {
      this.filtroPrecio = null;
      this.opcionFiltro = "menor";
      this.$emit("resetear");
    },
  },
};
</script>