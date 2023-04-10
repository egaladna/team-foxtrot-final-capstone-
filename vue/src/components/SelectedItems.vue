<template>
  <div>
      <p>Selected Items</p>
      <img v-bind:src="selectedForType.imgUrl">
  </div>
</template>

<script>
export default {
    props: [
        "item", 
        "type",
        ],
    computed: {
        selectedForType() {
            return this.item.find(cloth => {
                return this.type === cloth.type;
            });
        }
    }
}
</script>

<style>

</style>