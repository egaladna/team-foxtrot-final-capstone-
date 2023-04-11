<template>
  <div id="all-outfits" >
      <div>
           <h1>My Outfits</h1>
      </div>
     
    <div class="outfit-container" v-for="outfit in outfits" v-bind:key="outfit.id">
        <img v-for="item in outfit.itemList" v-bind:key="item.id" v-bind:src="item.imgUrl"/>
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
  created(){
      this.getAllOutfits();
  }
};
</script>

<style>
#all-outfits{
    display: flex;
    flex-direction: column;
}

</style>