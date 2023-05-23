<template>
  <div>
    <h1>Automóviles Generados</h1>
    <ul>
      <li v-for="automovil in automoviles" :key="automovil.id">
        {{ automovil.marca }} - {{ automovil.color }} ({{ automovil.año }})
        <button @click="verCaracteristicas(automovil)"> Ver características </button>
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  props: {
    automoviles: Array,
  },
  methods: {
    verCaracteristicas(automovil) {
      this.$emit("verCaracteristicas", automovil);
    },
  },
};
</script>