<template>
  <div>
    <span v-if="selectedForType">
    <img v-if="selectedForType" :src="selectedForType.imgUrl" />
    </span>
  </div>
</template>

<script>
export default {
  props: ["type"],

  computed: {
    selectedForType() {
      return this.$store.state.selectedItems.find((cloth) => {
        return this.type === cloth.type && cloth.imgUrl;
      });
    },
  },
};
</script>

<style>

</style>