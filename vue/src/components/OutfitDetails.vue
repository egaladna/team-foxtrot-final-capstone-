<template>
  <div>
    <div>
      <div id="div-image" v-for="item in outfit.itemList" v-bind:key="item.id">
        <img v-bind:src="item.imgUrl" />
      </div>
    </div>
  </div>
</template>

<script>
import OutfitService from "../services/OutfitService";

export default {
  data() {
    return {
      outfit: {},
    };
  },
  created() {
    OutfitService.getOutfitById(this.$route.params.id)
      .then((response) => {
        if (response.status == 200) {
          this.outfit = response.data;
        }
      })
      .catch((err) => console.error(err));
  },
};
</script>

<style scoped>
img {
  width: 33.33%;
  padding: 5px;
  float: left;
  height: auto;
}
</style>