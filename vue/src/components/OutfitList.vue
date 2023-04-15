<template>
  <div id="whole-component">
    <div>
      <h1>My Outfits</h1>
    </div>
    <div class="all-outfits">
      <div
        
        v-for="outfit in outfits"
        v-bind:key="outfit.id"
      >
        <router-link
          v-bind:to="{
            name: 'outfit-detail',
            params: {
              id: outfit.outfitId,
            },
          }"
        >
        <div class="outfit-container">
            <img
              v-for="item in outfit.itemList"
              v-bind:key="item.id"
              v-bind:src="item.imgUrl"
            />
            </div>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script>
import OutfitService from "../services/OutfitService";
export default {
  data() {
    return {
      outfits: [],
    };
  },
  methods: {
    getAllOutfits() {
      OutfitService.getOutfits()
        .then((response) => {
          if (response.status === 200) {
            this.outfits = response.data;
          }
        })
        .catch((err) => console.error(err));
    },
  },
  created() {
    this.getAllOutfits();
  },
};
</script>

<style>
#whole-component {
  display: flex;
  flex-direction: column;
  align-items: center;
}
img {
  margin: 3px;
}
.outfit-container {
  margin: 20px;
  padding: 20px;
  display: flex;
  border: solid #1b3536;
  border-radius: 8px;
  width: fit-content;
  block-size: fit-content;
}
.all-outfits {
  display: flex;
  flex-direction: column;
}

</style>