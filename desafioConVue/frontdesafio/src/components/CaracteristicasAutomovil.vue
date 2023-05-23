<template>
  <div>
    <h1>Características del Auto</h1>
    <p>Marca: {{ automovil.marca }}</p>
    <p>Año: {{ automovil.año }}</p>
    <p>Color: {{ automovil.color }}</p>
    <p>Precio: {{ automovil.precio }}</p>
    <p>Turbo: {{ automovil.turbo }}</p>
    <p>Tipo: {{ automovil.tipo }}</p>
    <p>Motor: {{ automovil.motor }}</p>
    <p>popularidad: {{ automovil.popularidad }}</p>
    <p v-if="automovil.tipo === 'camioneta'">Cabinas: {{ automovil.cabinas }}</p>
    <p v-if="automovil.tipo === 'SUV'">Sunroof: {{ automovil.sunroof }}</p>
  </div>
</template>

<script>
export default {
  props: {
    automovil: Object,
  },
};
</script>