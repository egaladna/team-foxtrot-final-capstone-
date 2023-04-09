<template>
  <div>
      <img v-bind:src="cloth.imgUrl">
  </div>
</template>

<script>

export default {
    name: 'clothing-item',
    props: ['cloth']
}
</script>

<style>


</style>