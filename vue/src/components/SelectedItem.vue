<template>
  <div>
    <img v-if="selectedForType" :src="selectedForType.imgUrl" />
  </div>
</template>

<script>
export default {
  props: ["type"],

  computed: {
    selectedForType() {
      return this.$store.state.selectedItems.find((cloth) => {
        return this.type === cloth.type;
      });
    },
  },
};
</script>

<style>
img {
  display: flex;
  height: auto;
  width: 100px;
  
}
</style>