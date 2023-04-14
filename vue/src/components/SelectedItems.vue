<template>
  <div>
      <p>Selected Items</p>
      <div class="selectedItemsDiv" v-for="type in types" :key="type.id">
        <SelectedItem :type="type"/>
        </div>
      <i class="fa fa-save" title="Save" style="font-size:24px;" v-on:click.prevent="saveOutfits"></i>
      <button @click="randomGenerator">Randomize Outfit</button> 
  </div>
</template>

<script>
import OutfitService from '../services/OutfitService'
import ClosetService from '../services/ClosetService'
import SelectedItem from '../components/SelectedItem.vue'
export default {
    components: {
        SelectedItem
    },
    data() {
        return {
        types: []
        }
    },
    computed: {
        clothingList() {
            return this.$store.state.myCloset;
        },
        cleanedUpList() {
            return this.$store.state.selectedItems.filter((item) => {
                return item.id
            });
        }
    },
    methods: {
        saveOutfits(){
            OutfitService.addOutfit(this.cleanedUpList);
            this.$store.commit('CLEAR_SELECTION');
        },
        randomGenerator() {
            this.types.forEach(type => {
                let allClothesOfType = this.clothingList.filter(cloth => {
                    return cloth.type == type;
                })
                if(allClothesOfType.length > 0) {
                let randomIndex = Math.floor(Math.random() * allClothesOfType.length);
                this.$store.commit('SELECT_ITEM', allClothesOfType[randomIndex]);
                }
            });

        }
    },
    created() {
        ClosetService.getTypes().then(response => {
            this.types = response.data;
        }).catch(err => console.error(err));
    }
}
</script>
<style>

.selectedImages {
    display: flex;
    flex-direction: column;
    height: auto;
    width: 100px;
}

.selectedItemsDiv {
   border: 0;
}



</style>