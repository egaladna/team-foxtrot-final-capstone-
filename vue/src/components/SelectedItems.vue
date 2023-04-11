<template>
  <div>
      <p>Selected Items</p>
       <img class="selectedImages" v-for="item in validItems" v-bind:key="item.id" v-bind:src="item.imgUrl"> 
      <button v-on:click.prevent="saveOutfits">Save Outfit</button> 
  </div>
</template>

<script>
import OutfitService from '../services/OutfitService'
export default {
    props: ["type"],
    computed: {
        validItems() {
            return this.$store.state.selectedItems.filter(item => {
                return item.imgUrl;
            });
        },
        selectedForType() {
            return this.$store.state.selectedItems.find(cloth => {
                return this.type === cloth.type;
            });
        }
    },
    methods: {
        saveOutfits(){
            const cleanedUpList = this.$store.state.selectedItems.filter((item) => {
                return item.id
            }); 
            OutfitService.addOutfit(cleanedUpList);
        }
    }
}
</script>

<style>
#main{
    display: flex;


}
.selectedImages {
    display: flex;
    height: auto;
    width: 100px;
}

</style>