<template>
  <div>
      <p>Selected Items</p>
      <img v-bind:src="selectedForType.imgUrl">
  </div>
</template>

<script>
export default {
    props: ["type"],
    computed: {
        selectedForType() {
            return this.$store.state.selectedItems.find(cloth => {
                return this.type === cloth.type;
            });
        }
    }
}
</script>

<style>

</style>